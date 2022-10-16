const path = require("path")
const {VueLoaderPlugin} = require("vue-loader")
 
 
module.exports = {
    mode:"development",
    entry:{
        app:path.resolve(__dirname,"jd-shopcarts/main.js")
    },
    output:{
        path:path.resolve(__dirname,"jd-shopcarts/dist"),
        filename:"[name].bundle.js"
    },
    resolve:{
        extensions:[".js",".css",".vue"]
    },
    module:{
        rules:[
            {test:/\.css$/,loader:"style-loader!css-loader"},
            {test:/\.vue$/,loader:"vue-loader"},
            {test:/\.(jpg|png|jpeg|gif)$/,loader:"url-loader"}
        ]
    },
    plugins:[
       new VueLoaderPlugin()
    ]
}