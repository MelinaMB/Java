const edificioVacio = 0;
const edificio = ['matias', 'vero', 'brisa'];

// para recorrer un arrary se usa el for
for (let persona of edificio) {
    console.log(persona)
};

// para buscar un elemento en un array
const nombre = edificio.find(nombre => nombre === "jose");
// si encontro a la persona que estaba buscando y lo guardo en la variable jose

// pregunto si existe ese nombre para eso uso el if
// va a dar un valor true o false
if (nombre !== undefined) { 
    // si no es undefined quiere decir que jose vive en el edificio
    // mostramelo hago un console.log
    console.log('jose vive en el edificio', nombre);
} else {
    // si no aparece en el edificio
    console.log("jose no vive en el edificio", nombre)
};