


var btnPreguntas = document.getElementById("buscar")
var txtTarea = document.getElementById("buscarId");
var listTareas = document.getElementById("tareas");


btnPreguntas.addEventListener("click", function () {
    axios.get("http://localhost:4567/preguntas")
    .then(function (response) {
        console.log(response.data);
        //usuarios(response.data);
    })
    .catch(function (error) {
        console.log(error);
    })
})

function agregar(){
    let tarea = document.createElement("li");
    tarea.textContent = txtTarea.value;
    listTareas.appendChild(tarea);
    console.log("Dentro de función" +  tarea);
}