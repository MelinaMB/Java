
//asi se crea una funcion
//no tiene parametros de entrada
function sumar() {
     // apunto al lugar que quiero que me muestre
    //obtener la referencia al input con id="valor1" e input con id="valor2 "
    //usando el D.O.M
    const apuntadorAValor1 = document.getElementById('valor1');
    const apuntadorAValor2 = document.getElementById('valor2');

    //ahora obtengo el valor de cada apuntados
     // apunto al valor que quiero que me muestre
    //y lo guarda en una  variable
    const v1 = toNumber(apuntadorAValor1.value);
    const v2 = toNumber(apuntadorAValor2.value);

    //update del div con la suma de v1+v2
    //o sea calculo la suma +
    const suma = v1 + v2;

    const apuntadorAlResultado = document.getElementById('resultado');
    //en los div no existe value (como el input) existe innerHTML
    apuntadorAlResultado.innerHTML = suma;
}
function sumarv2() {
    const suma = toNumber(document.getElementById('valor1').value) + toNumber(document.getElementById('valor2').value);
    document.getElementById('resultado').innerHTML = suma;
}
function toNumber (valor) {
    //lógica de la función
    const valorNumerico = Number(valor);
    // para devolver el valor que estoy pidiendo 
    return valorNumerico;
 }