const db = require('../db');
const usersCtrl = {};
//var users = [];
const usersCollection = db.collection('users')
/*
const users = [
    {
        name: 'Marcelo',
        lastName: 'Hidalgo',
        age: '32'
    },
    {
        name: 'Gerardo',
        lastName: 'Moran',
        age: '70'
    },
    {
        name: 'Luisa',
        lastName: 'Rodriguez',
        age: '15'
    }
];
*/
usersCtrl.list = async () => {
    users = await usersCollection.find().toArray();
    return users;
}

usersCtrl.find = (id) => {
    return usersCollection.findOne({ id: id }, {});
}

usersCtrl.delete = (id) => {
    return usersCollection.deleteOne({ id: id }, {});
}

usersCtrl.create = (data) => {
    return usersCollection.insertOne(data);
}

usersCtrl.update = (data) => {
    return usersCollection.findOneAndUpdate( 
        { id: data.id },
        { 
            $set: { name: data.name, lastname: data.lastname, age: data.age }
        },
        { upsert: true }
    );
}

module.exports = usersCtrl;