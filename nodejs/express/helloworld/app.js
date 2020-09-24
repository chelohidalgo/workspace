const express = require('express');
const app = express();
const homeRoutes = require('./home')
const testRoutes = require('./routes')

/*
app.get('/', (req, res) => {
    res.send('Hola mundo');
});

app.post('/', function(req, res){
    res.send('Hola mundo with post');
});

*/

/*
app.use(function (req, res, next) {
    console.log('Time:', Date.now())
    next()
  });
*/

app.use('/', homeRoutes);
app.use('/test', testRoutes);

app.listen(8080);