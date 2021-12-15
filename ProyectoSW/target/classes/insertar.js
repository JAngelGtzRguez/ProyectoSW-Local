var btnAgregar = document.getElementById("agregar");
btnAgregar.addEventListener("click", function () {
    axios.post("http://localhost:4567/pregunta", {
        pregunta : document.getElementById("pregunta").value,
        tipo : document.getElementById("tipoPregunta").value
    })
    .then(function (response) {
        alert("mensaje: Pregunta creada "+response.data.status+" con id: "+response.data.id);
        ID = response.data.id;
        estado=response.data.status;
    })
    .catch(function (error) {
        console.log(error);
    })
})