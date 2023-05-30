const listaCompras = [];

function calcularPrecioTotal() {

    let nombreUsur = document.getElementById("nombre").value;
    let apellidoUsur = document.getElementById("apellido").value;
    let cantEnt = document.getElementById("cantEntradas").value;
    let porcDesc = document.getElementById("porcDescuento").value;

    let descuento = (cantEnt * 200) * porcDesc / 100;
    
    let precioFin = (cantEnt * 200) - descuento;
    
    document.getElementById("precrioFinalTotal").innerHTML = `Precio Total: $ ${precioFin}`
   

    comprasACargar = {
        id: Math.random(),
        Nombre: nombreUsur,
        Apellido: apellidoUsur,
        Cantidad: cantEnt,
        Descuento: descuento,
        Precio: precioFin,
    }

    listaCompras.push(comprasACargar)
    localStorage.setItem('Compras', JSON.stringify(listaCompras))

    cargarDesdeLocal();
}


mostrarResultado = (mostrarCompra) => {
    document.getElementById('comprar').innerHTML = mostrarCompra;
}

cargarDesdeLocal = () => {
    const datoEnLocal = localStorage.getItem('Compras');
    const datosParseados = JSON.parse(datoEnLocal);
    const tabla = mostrarCompra(datosParseados);

    mostrarResultado(tabla);
}

mostrarCompra = (lista) => {
    let compra =
        `<table>
            <tr>
                <th>Nombre </th>
                <th>Apellido </th>
                <th>Cantidad de entradas </th>
                <th>Descuento </th>
                <th>Precio Total </th> 
            </tr>
        `;
    for (let dato of lista) {
        compra += '<tr>'
        compra += `<td>${dato.Nombre}</td>`
        compra += `<td>${dato.Apellido}</td>`
        compra += `<td>${dato.Cantidad}</td>`
        compra += `<td>$${dato.Descuento}</td>`
        compra += `<td>$${dato.Precio}</td>`
        compra += `<td>
        <button onclick="eliminar(${dato.id})">X</button>
        </td>`
        
        compra += '</tr>'
    }
    compra += '</table>'
    return compra;
}
eliminar = (id) => {
    const eliminarCompra = listaCompras.filter((x) => x.id !== id  );
    alert(id);
    
    mostrarCompra(eliminarCompra);
}