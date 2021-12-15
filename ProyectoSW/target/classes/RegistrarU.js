var btnRegistrar = document.getElementById("registrar")
btnRegistrar.addEventListener("click", function () {
    axios.post("https://uv-forms.herokuapp.com/usuario", {
        email : document.getElementById("email").value,
        password : document.getElementById("password").value
    })
    .then(function (response) {
        alert("mensaje: usuario creado "+response.data.status+" con id: "+response.data.id);
        ID = response.data.id;
        estado=response.data.status;
    })
    .catch(function (error) {
        console.log(error);
    })
})