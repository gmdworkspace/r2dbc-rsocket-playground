const path = require('path');
const CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
	entry: path.resolve(__dirname, 'js', 'index.js'),
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
	resolve: {
		extensions: ['.js', '.jsx', '.scss', '.sass']
	},
	module: {
		rules: [
			{
				test: /\.jsx?$/,
				loader: 'babel-loader',
				exclude: /node_modules/,
			}
		]
	},
	plugins: [
		new CopyWebpackPlugin([{
			from: path.resolve(__dirname, 'index.html'),
			to: path.resolve(__dirname, 'public')
		}, {
			from: path.resolve(__dirname, 'images', '404.png'),
			to: path.resolve(__dirname, 'public', '404.png')
		}])
	]
};