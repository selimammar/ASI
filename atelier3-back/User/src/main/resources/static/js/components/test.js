async function RegisterUser() {
    // appel de la création d'un user
    var firstname = document.getElementById("firstname").value;
    var lastname = document.getElementById("lastname").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var sold = 0;


    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "email": email,
        "name": lastname,
        "surname": firstname,
        "password": password,
        "sold": sold,
        
    });

    // var requestOptions = {
    // method: 'POST',
    // headers: myHeaders,
    // body: raw,
    // redirect: 'follow'
    // };

let response = await fetch('http://localhost:8082/auth/register', { method: 'POST', headers: { 'Content-Type': 'application/json;charset=utf-8' }, body: raw });
let result = await response.json(); alert(result.message);


//     fetch("http://localhost:8082/auth/register", requestOptions)
//     .then(response => response.text())
//     .then(function(response){
//         console.log(response);
//     })
//     .then(result => console.log(result))
//     .catch(error => console.log('error', error));
//     console.log("Register d'un user");
// }

function LoginUser(){
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "email": email,
        "password": password,
        
    });

    var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
    };

    fetch("http://localhost:8082/auth/login", requestOptions)
    .then(response => response.text())
    .then(function(response){
        console.log(response);
    })
    .then(result => console.log(result))
    .catch(error => console.log('error', error));
    console.log("Login d'un user");
}


function getUser() {
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };
        
    fetch("http://localhost:8082/auth/current", requestOptions)
    .then(response => response.text())
    .then(function(response){
        console.log(response);
    })
}

function backToIndex(){
    window.location.href='../../Lot1/Index.html';
}