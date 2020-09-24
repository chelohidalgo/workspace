const express = require('express');
const router = express.Router();
const authCtrl = require('../controllers/authController')

router.use((req, res, next) => {
    console.log('HIZO');
    next();
});

router.post('/login', (req, res, next) => {
    authCtrl.login(req, res);
});

router.post('/register', (req, res, next) => {
    authCtrl.register(req, res);
});

module.exports = router;