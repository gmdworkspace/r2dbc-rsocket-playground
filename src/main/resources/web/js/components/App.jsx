import React from 'react';
import {rsocketClient} from '../helpers/rsocket-client';
import Tiles from './Tiles';
import Button from './Button';

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			data: [],
		};
	}

	componentDidMount() {
		rsocketClient.connect().subscribe({
			onComplete: socket => {
				socket.requestStream({
					data: 'peace',
					metadata: null,
				}).subscribe({
					onComplete: () => console.log('Complete'),
					onError: error => console.error(error),
					onNext: payload => {
						// console.log(payload.data);
						const newData = this.state.data;
						newData.push(payload.data);
						this.setState({data: newData});
					},
					onSubscribe: subscription => {
						this.setState({subscription});
						subscription.request(15);
					},
				});
			},
			onError: error => console.error(error)
		});
	}

	render() {
		return (
			<React.Fragment>
				<div style={{display: 'flex', flexWrap: 'wrap', justifyContent: 'space-around'}}>
					<Tiles movies={this.state.data}/>
				</div>
				<Button onClick={() => this.state.subscription.request(20)}></Button>
			</React.Fragment>
		)
	}

}

export default App;
