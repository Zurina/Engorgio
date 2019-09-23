var express = require('express')
var mysql = require('mysql')
var bodyParser = require('body-parser')

const app = express();
const PORT = 3000;

var conn = mysql.createConnection({
    host     : 'localhost',
    user     : 'root',
    password : 'root',
    database : 'students'
});

app.use(bodyParser.json())

conn.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
});

app.get('/people', (req, res) => {
    conn.query('SELECT * from people', function (error, results, fields) {
        if (error) throw error;
        console.log('The retrieved data is: ', results);
        res.send(JSON.stringify(results))
    });
});

app.get('/messages', (req, res) => {
    conn.query('SELECT * from messages', function (error, results, fields) {
        if (error) throw error;
        console.log('The retrieved data is: ', results);
        res.send(JSON.stringify(results))
    });
});

app.get('/comments', (req, res) => {
    conn.query('SELECT * from comments', function (error, results, fields) {
        if (error) throw error;
        console.log('The retrieved data is: ', results);
        res.send(JSON.stringify(results))
    });
});

app.post('/people', (req, res) => {
    const { firstname, email } = req.body
    conn.query(`INSERT INTO people(firstname, email) VALUES('${firstname}','${email}');`, function (error, results, fields) {
        if (error) throw error;
        console.log('The retrieved data is: ', results);
        res.send(JSON.stringify(results))
    });
});

app.listen(PORT, () => {
  console.log(`server running on port ${PORT}`)
});