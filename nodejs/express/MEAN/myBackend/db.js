/*
const MongoClient = require('mongodb').MongoClient;
const dbName = 'test';
const url = 'mongodb://localhost:27017'
const db;

MongoClient.connect(url, { useUnifiedTopology: true }, (err, client) => {

    if (err) return console.log("Upps database disconnected o not found");
    console.log("database connected");
    db = client.db(dbName)
    console.log(`Connected MongoDB: ${url}`)
    console.log(`Database: ${dbName}`)
});
*/
const mongoose = require('mongoose')
const url = 'mongodb://localhost:27017/test'

mongoose.connect(url, { useNewUrlParser: true, useUnifiedTopology: true })

const db = mongoose.connection;
db.once('open', _ => {
    console.log('Database connected:', url)
});

db.on('error', err => {
    console.error('connection error:', err)
});

module.exports = db;
