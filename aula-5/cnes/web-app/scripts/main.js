function getJson(path) {
	var fs = require('file-system');
    fs.readFile(path, 'utf8', function (err, data) {
          if (err) 
             console.log('Erro!');

          var obj = JSON.parse(data);
          return obj;
    });
}