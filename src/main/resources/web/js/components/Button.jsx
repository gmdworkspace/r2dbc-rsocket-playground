import React from 'react';

const buttonStyle = {
	color: '#FFF',
	backgroundColor: '#141414',
	width: '14rem',
	height: '5rem',
	borderRadius: '15px',
	display: 'block',
	marginLeft: 'calc(50% - 7rem)',
	marginTop: '2rem',
	fontSize: '1.25rem'
};

const Button = ({onClick}) => <button onClick={onClick} style={buttonStyle}>Show More</button>;

export default Button;