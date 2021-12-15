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

