const authController = {};

authController.login = (req, res) => {

    //req.headers.Authorization;

    //debug.User.findOne()
    res.send('Login');
 };

authController.register = (req, res) => {
    res.send('Register');
 };

 module.exports = authController;