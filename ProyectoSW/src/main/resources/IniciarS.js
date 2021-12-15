//PARA INICIAR SESIÓN
var btnBuscar= document.getElementById("buscar")
btnBuscar.addEventListener("click", function () {
    axios.post("https://uv-forms.herokuapp.com/usuarioB", {
        email : document.getElementById("email").value,
        password : document.getElementById("password").value
    })
})