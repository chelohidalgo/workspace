const express = require('express')
const router = express.Router()
const usersCtrl = require('../controllers/usersCtrl')
const csrf = require('csurf')
const csrfProtection = csrf({ cookie: true })

router.get('/', async (req, res, next) => {
  var users = await usersCtrl.list()
  res.render('users', { title: '', users: users })
});

router.get('/new', csrfProtection, (req, res, next) => {
  res.render('new', { title: 'New user', csrfToken: req.csrfToken() })
});

router.all('/:id/:op?', async (req, res, next) => {
  req.user = await usersCtrl.find(req.params.id)
  next()
});

router.get('/:id/edit', csrfProtection, (req, res, next) => {
  res.render('edit', { title: 'User', user: req.user, csrfToken: req.csrfToken() })
});

router.get('/:id/view', (req, res, next) => {
  res.render('user', { title: 'User', user: req.user })
});

router.get('/:id/remove', async (req, res, next) => {
  await usersCtrl.delete(req.params.id)
  res.redirect('/users')
});

router.post('/', csrfProtection, async (req, res, next) => {
  await usersCtrl.create(req.body)
  res.redirect('/users')
});

router.post('/edit', csrfProtection, async (req, res, next) => {
  await usersCtrl.update(req.body)
  res.redirect('/users')
});

module.exports = router;
