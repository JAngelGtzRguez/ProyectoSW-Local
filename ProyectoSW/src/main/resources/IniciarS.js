//PARA INICIAR SESIÓN
var btnBuscar= document.getElementById("buscar")
btnBuscar.addEventListener("click", function () {
    axios.post("http://localhost:4567/usuarioB", {
        email : document.getElementById("email").value,
        password : document.getElementById("password").value
    })
})