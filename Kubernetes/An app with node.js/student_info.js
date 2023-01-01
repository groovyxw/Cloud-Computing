const os = require ( 'os' );
var http = require('http');
//console.log( "Kubia server starting..." );

function parseStudentInfo(id) {
  if (id == "11111")
    return {"id": 11111, "name":"Bruce Lee", "score":84}
  else if (id == "22222")
    return {"id": 22222, "name":"Jackie Chen", "score":93}
  else if (id == "33333")
    return {"id": 33333, "name":"Jet Li", "score":88}
  else
    return {}
}
http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/json'});
  let myURL = req.url;
  const urlArray = myURL.split("=");
  let stdId = urlArray[1];
  let stdInfo = parseStudentInfo(stdId);
  res.write(JSON.stringify(stdInfo));
  res.end("\nYou've hit " + os.hostname() + "\n");
}).listen(8000);
