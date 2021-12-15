function agregarPregutaC() {
    var tipoPregunta = document.getElementById('tipoPregunta').value;
    var contedorPri = document.getElementById('segundoNivelPre');
    var contedorSec = document.createElement('div');
    var cerrada = "cerrada";
    if (tipoPregunta == cerrada) {
        contedorSec.className = 'w-full';
        contedorSec.innerHTML = '<div class="w-full" id="respuestaOpti">'+
                                    '<div class="flex flex-wrap w-full">'+
                                        '<div class="w-2/3 m-auto text-center">'+
                                            '<input type="text" name="respuestas" id="respuesta2" value="" placeholder=" Respuesta:" class="w-5/6 border">'+
                                        '</div>'+
                                        '<div class="w-1/3 m-auto text-center">'+
                                            '<button class="bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded" onclick="insertarRadio();">Añadir</button>'+
                                        '</div>'+
                                    '</div>'+
                                    '<div class="m-auto w-1/2" id="contenRespu">'+
                                    
                                    '</div>'+
                                '</div>';

        contedorPri.appendChild(contedorSec);
    }
}

function agregarRespuestaCHtml(){
    const contendorPri = document.getElementById('contenRespu');
    const contenedorSec = document.createElement('select');
    const respuOption = document.createElement('option');
    var bandSelect = !!document.getElementById('respuCerradas');
    if (bandSelect == true) {
        //Crear solo el option (ayuda de Ángel)
    }else if (bandSelect == false) {
        //Crear el select y un opcion como minimo (ayuda de Ángel)
        contenedorSec.name = 'respuCerradas';
        contenedorSec.id = 'respuCerradas';
    }
}

function mostrarPregunta(){
    var pregunta = document.getElementById('pregunta').value;
    var tipoPreg = document.getElementById('tipoPregunta').value;
    var video = document.getElementById('video');
    var guardarVideo = '';
    $(document).ready(function(){
        $(document).on('change', 'input[type=file]', function(e){
            tmpPath = URL.createObjectURL(e.target.files[0]);
            guardarVideo = tmpPath;
        });
    });

    const contenedorPri = document.getElementById('contedirPreguntas');
    const contenrdorSec = document.createElement('div');
    contenrdorSec.className = 'w-3/6 m-auto border py-4';
    contenrdorSec.innerHTML = '<div class="flex flex-wrap w-full m-auto">'+
                                    '<div class="w-2/3 px-4 m-auto">'+
                                        '<input type="text" name="pregunta" id="pregunta" placeholder="'+pregunta+'" class="w-4/5 border" desabled>'+
                                    '</div>'+
                                    '<div class="w-1/3 pl-2 pr-8">'+
                                        '<label for="" class="w-40">'+tipoPreg+'</label>'+
                                    '</div>'+
                                '</div>'+
                                '<div class="w-auto mt-4 p-2 text-center">'+
                                    '<div class="w-full py-2">'+
                                        '<video src="'+guardarVideo+'" controls></video>'+
                                    '</div>'+
                                '<div class="w-full mt-4 ml-56 mb-4">'+
                                    '<button class="bg-green-500 hover:bg-green-400 text-white font-bold py-2 px-4 border-b-4 border-green-700 hover:border-green-500 rounded" id="agregar" desabled> Agregar </button>'+
                                '</div>'+
                            '</div>';
    contenedorPri.appendChild(contenrdorSec);
}