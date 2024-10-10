/**
 * 
 */

const http = require('http');
const fs = require('fs');

const dadosReq = (req,res) => {
	    res.writeHead(200, {"Content-Type":"text/html"});
		res.write('recebido');
	    res.end();
};

const app = http.createServer(dadosReq);



app.listen(8080);
