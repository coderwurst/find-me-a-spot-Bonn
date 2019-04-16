const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: [
        './src/js/index.js',
        '@babel/polyfill'
    ],

    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'js/bundle.js'
    },

    mode: 'development',

    devServer: {
        contentBase: './dist'
    },

    plugins: [
        new HtmlWebpackPlugin( {
            filename: 'index.html',
            template: './src/index.html'
        })
    ],

    module: {
        rules: [
                    {
                        test: /\.js$/,
                        exclude: /node_modules/,
                        use: {
                            loader: 'babel-loader'
                        }
                    }
                ]
        }
        
}