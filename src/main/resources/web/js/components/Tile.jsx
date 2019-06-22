import React from 'react';

const titleStyle = {
	textAlign: 'center',
	borderradius: '10px',
	background: '#141414',
	color: 'white',
	fontSize: '1rem',
	width: '15rem',
	marginTop: '1.5rem',
	paddingTop: '1.5rem',
	borderRadius: '1.25rem'
};

const Title = ({movie}) => {
	let img = null;
	return (
		<div style={titleStyle}>
			<img ref={(image) => {
				img = image
			}}
					 onError={() => img.src = '404.png'}
					 src={`https://sinemecra.com/wp-content/uploads/movie/${movie.POSTER}`}
					 style={{width: '10rem', minHeight: '240px'}}/>
			<div>
				<p>{movie.TITLE}</p>
				<p>{movie.VOTE_AVG}/10</p>
			</div>
		</div>
	)
};

export default Title;