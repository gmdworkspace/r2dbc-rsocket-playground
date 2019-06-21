const {
	RSocketClient,
	Utf8Encoders,
	MAX_STREAM_ID //Use this if you want to display all the streams on page load
} = require('rsocket-core');
const RSocketWebSocketClient = require('rsocket-websocket-client').default;

function addMessage(message) {
	const ol = document.getElementById("messages");
	const li = document.createElement("li");
	li.appendChild(document.createTextNode(message));
	ol.appendChild(li);
}

let rSocketSubscription;

function main() {
	const url = 'ws://localhost:9091/ws';

	// Create an instance of a client
	const client = new RSocketClient({
		setup: {
			keepAlive: 60000,
			lifetime: 180000,
			dataMimeType: 'binary',
			metadataMimeType: 'binary',
		},
		transport: new RSocketWebSocketClient({
			url,
			debug: true,
		}, Utf8Encoders),
	});

	client.connect().subscribe({
		onComplete: socket => {

			socket.requestStream({
				data: 'peace',
				metadata: null,
			}).subscribe({
				onComplete: () => console.log('complete'),
				onError: error => console.error(error),
				onNext: payload => {
					console.log(payload.data);
					addMessage(payload.data);
				},
				onSubscribe: subscription => {
					rSocketSubscription = subscription;
					//Inital page load data
					subscription.request(30);
				},
			});
		},
		onError: error => console.error(error),
		onSubscribe: cancel => {/* call cancel() to abort */
		}
	});
}

document.addEventListener('DOMContentLoaded', main);
document.getElementById('get-more').addEventListener('click', () => {
	rSocketSubscription.request(100)
});