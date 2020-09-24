const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
    res.send('Hola mundo con get');
});

router.post('/', function (req, res) {
    res.send('Hola mundo with post');
});

router.get('/user/:id', function (req, res, next) {
    // if the user ID is 0, skip to the next route
    if (req.params.id === '0') next('route')
    // otherwise pass the control to the next middleware function in this stack
    else next()
}, function (req, res, next) {
    // send a regular response
    res.send('regular')
});

// handler for the /user/:id path, which sends a special response
router.get('/user/:id', function (req, res, next) {
    res.send('special')
});


function logOriginalUrl(req, res, next) {
    console.log('Request URL:', req.originalUrl)
    next()
}

function logMethod(req, res, next) {
    console.log('Request Type:', req.method)
    next()
}

var logStuff = [logOriginalUrl, logMethod]
router.get('/log/:id', logStuff, function (req, res, next) {
    res.send('User Info')
})


module.exports = router;