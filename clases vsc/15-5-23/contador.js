//function flecha
//function flecha
decrementar = () => {
    const valor = obtenerValor();
    const nuevoValor = valor - 1;
    //actualizamos el valor en el div
    //invocando/llamando/ejecutando a la funcion actualizarValor(..)
    actualizarValor(nuevoValor);
}

incrementar = () => {
    const valor = obtenerValor();
    const nuevoValor = valor + 1;
    actualizarValor(nuevoValor);
}
function actualizarValor(nuevoValor) {
    document.getElementById('valor').innerText = nuevoValor;
}
function obtenerValor() {
    const apuntaadorAlValor = document.getElementById('valor');
    const value = apuntaadorAlValor.innerHTML;//esta en string
    return  Number(value);
}