console.log("UNIDOS");
const URL_GUARDAR_HOTEL = "hoteles";

document.addEventListener("DOMContentLoaded", ()=>{agregarEventos()});

function agregarEventos(){
    document.getElementById("btnEnviar").addEventListener("click",
        ()=> {
            enviarFormulario()
        });
}

async function requestGET(url){
    const respuesta = await fetch(url);
    const json = respuesta.json();
    return json;
}

async function requestPOST(url,data){
    const respuesta = await fetch(url,{
        method:"POST",
        headers: {
            "Content-Type": "application/json",
        },
        body:JSON.stringify(data)
    });
    const json = respuesta.json();
    return json;
}

function enviarFormulario(){
    let data={
        nombre: null,
        informacion: null,
        ubicacion: null,
        estrellas: null
    };
    data.nombre = document.getElementById("nombre").value;
    data.informacion = document.getElementById("informacion").value;
    data.ubicacion = document.getElementById("ubicacion").value;
    if(data.ubicacion && data.nombre && data.informacion){
        return requestPOST(URL_GUARDAR_HOTEL,data);
    }else{
        document.getElementById("mensaje").textContent="Todos los datos son necesarios";
    }

}