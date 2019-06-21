const path = require('path');

module.exports = {
	entry: path.resolve(__dirname, 'index.js'),
	output: {
		path: path.resolve(__dirname, 'public'),
		filename: 'app.js',
	},
	mode:'development',
	devServer: {
		contentBase: path.join(__dirname, 'public'),
		compress: true,
		port: 9092
	},
	module: {
		rules: [
			{
				test: /\.js?$/,
				loader: 'babel-loader',
				exclude: /node_modules/,
			}
		]
	}
};