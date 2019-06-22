import RSocketWebSocketClient from 'rsocket-websocket-client';
import {
	RSocketClient,
	Utf8Encoders,
	JsonSerializers
} from 'rsocket-core';

const url = 'ws://localhost:9091/ws';

export const rsocketClient = new RSocketClient({
	serializers: JsonSerializers,
	setup: {
		keepAlive: 60000,
		lifetime: 180000,
		dataMimeType: 'application/json',
		metadataMimeType: 'application/json',
	},
	transport: new RSocketWebSocketClient({
		url,
		debug: true,
	}, Utf8Encoders),
});

