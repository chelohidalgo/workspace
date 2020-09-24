const express = require('express');
const router = express.Router();

router.use(function (req, res,next) {
    console.log('siempre hace');
    next();
});

router.get('/', function (req, res) {
    res.send('Hola get');
});

router.post('/', function (req, res) {
    res.send('Hola post');
});

module.exports = router;

