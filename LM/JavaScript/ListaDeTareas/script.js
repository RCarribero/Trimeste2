const inputTarea = document.getElementById("tarea_input");
const btnAgregar = document.getElementById("btn_agregar");
const listaTarea = document.getElementById("listaTarea");
const btn_vaciar = document.getElementById("btn_vaciar");
function agregarNuevaTarea() {
    const textoTarea=inputTarea.value.trim();
    if (textoTarea==="") {
        alert ("Porfavor, escribe una tarea");
        return;
    }
    const nuevaTarea = document.createElement("li");
    const texto= document.createTextNode(textoTarea);
    const btnEliminar = document.createElement("button");
    btnEliminar.textContent="Eliminar";  
    btnEliminar.classList.add("btn-eliminar");
    btnEliminar.addEventListener("click",()=>{
        listaTarea.removeChild(nuevaTarea);
    });
    nuevaTarea.appendChild(texto);
    nuevaTarea.appendChild(btnEliminar);
    listaTarea.appendChild(nuevaTarea);
    inputTarea.value="";
}
function vaciarLista(){
    if (listaTarea.children.length===0) {
        alert("La lista ya esta vacia");
        return;
    }
    while (listaTarea.firstChild) {
        listaTarea.removeChild(listaTarea.firstChild)
    }
}
btnAgregar.addEventListener("click",agregarNuevaTarea);
btn_vaciar.addEventListener("click",vaciarLista);