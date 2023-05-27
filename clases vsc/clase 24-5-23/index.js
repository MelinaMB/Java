//array/vector de objetos alumnos
const alumnos = [
    {
        curso: 'cac 23069',
        edad: 37,
        nombre: 'carlos',
        apellido: 'lopez',
        dni: 123456789
    },
    {
        curso: 'cac 23069',
        edad: 34,
        nombre: 'ana',
        apellido: 'espindola',
        dni: 345678911
    },
    {
        curso: 'cac 23069',
        edad: 59,
        nombre: 'enrique',
        apellido: 'torregiani',
        dni: 456789654
    }
];

/* 
 -buscar a la persona de menor edad
 -mayor edad
 -calcular el promedio de edad
*/
let auxMenor = alumnos[0].edad;
let auxMayor = alumnos[0].edad;
let suma = alumnos[0].edad;

for (let i = 1; i < alumnos.length; i++) {
    if (alumnos[i].edad < auxMenor) {
        //actualizo el menor
        auxMenor = alumnos[i].edad;
    }
    if (alumnos[i].edad > auxMayor) {
        //actualizo el mayor
        auxMayor = alumnos[i].edad;
    }

    suma = alumnos[i].edad + edad;
}



//al final tengo al mayor y al menor
console.log(auxMenor, auxMayor);
console.log(suma / alumnos.length);

//Gonza
// let auxMenor = alumnos[0].edad;
// let auxMayor = alumnos[0].edad;
// let suma = alumnos[0].edad;
// let promedio = 0;

// for(let i=1;i < alumnos.length;i++ ) {
//     if(alumnos[i].edad < auxMenor){
//         //actualizo el menor
//         auxMenor = alumnos[i].edad;
//     }
//     if(alumnos[i].edad > auxMayor){
//         //actualizo el mayor
//         auxMayor = alumnos[i].edad;
//     }
//     suma += alumnos[i].edad;
// }



//Ana
// let auxMenor = alumnos[0].edad;
// let auxMayor = alumnos[0].edad;
// let suma= alumnos[0].edad;
// for( let i=1; i<alumnos.length; i++){
//     if(alumnos[i].edad<auxMenor){
//         auxMenor=alumnos[i].edad;
//     }
//     if(alumnos[i].edad>auxMayor){
//         auxMayor=alumnos[i].edad;
//     }
//     suma = suma+alumnos[i].edad;
// }
// let promedio = suma/alumnos.length;
// console.log(auxMenor, auxMayor);
// console.log(promedio);

// promedio = suma / alumnos.length;
// console.log(auxMayor, auxMenor, promedio);




// const calcularPromedio = () =>{
//     let sumaEdades = 0;
//     alumnos.forEach(e => {
//         sumaEdades += e.edad;
//     }); 

//     return sumaEdades / alumnos.length;
// }
// alert(calcularPromedio());









//array/vector de objetos alumnos
// const alumnos =  [
//     {
//         curso:'cac 23069',
//         edad: 37,
//         nombre: 'carlos',
//         apellido: 'lopez',
//         dni: 123456789,
//         secundarioCompleto: true,
//     },
//     {
//         curso:'cac 23069',
//         edad: 34,
//         nombre: 'ana',
//         apellido: 'espindola',
//         dni: 345678911,
//         secundarioCompleto: false,
//     },
//     {
//         curso:'cac 23069',
//         edad: 59,
//         nombre: 'enrique',
//         apellido: 'torregiani',
//         dni: 456789654,
//         secundarioCompleto: true,
//     }
// ];

//.map
const apellidos = alumnos.map(x => x.apellido);
console.log(apellidos);

//.reduce()
// const suma = alumnos.reduce((prev,current) => prev + current.edad,0);
console.log(suma);

//apellidos separados por ,
const apellidosConcat =
    alumnos.reduce((prev, current) => prev + ',' + current.apellido, '');
console.log(apellidosConcat);

//filter()
const lista = [];
for (let i = 0; i < alumnos.length; i++) {
    if (alumnos[i].edad > 34) {
        lista.push(alumnos[i]);
    }
}
console.log(lista);

const lista2 = alumnos.filter(x => x.edad > 34);//que quiero!
console.log(lista2)

//filtrar los alumnos que tiene sec completo
const lista3 = alumnos.filter(x => x.secundarioCompleto);//que quiero!
console.log(lista3)

//mayores a 37 y con secundario completo
const lista4 = alumnos.filter(x => x.edad > 37 && x.secundarioCompleto);//que quiero!
console.log(lista4)

//findIndex
const idx59 = alumnos.findIndex(x => x.edad === 59);
console.log(idx59)

//find
const obj59 = alumnos.find(x => x.edad === 59);
console.log(obj59);

//Object.fromEntries
const arrays = [
    ['clave', 'valor'],
    ['clave2', 'valor2'],
    ['clave3', 'valor2'],
    ['clave4', 'valor2'],
    ['clave5', 'valor2'],
    ['clave6', 'valor2'],
]
const entries = Object.fromEntries(arrays);//[]
console.log(entries)


function buscar() {
    const id = document.getElementById('id').value;

    //consumir un api rest externo  usando el api fetch
    fetch(`https://reqres.in/api/users/${id}`)
        .then(response => response.json())//cuando vuelva la respuesta
        .then(data =>
            alert(JSON.stringify(data))
        )

}

document.getElementById('btnBuscar')
    .addEventListener('click', buscar);






function buscar() {
    const id = document.getElementById('id').value;

    //consumir un api rest externo  usando el api fetch
    fetch(`https://reqres.in/api/users/${id}`)//alt+96
        .then(response => response.json())//cuando vuelva la respuesta
        .then(data => dibujarCard(data))

}

const dibujarCard = (objJson) => {
    if (!objJson) {
        return
        ///ojo
    }
    const img = document.getElementById('img')//<img src="">
    const nombre = document.getElementById('nombre');
    const email = document.getElementById('email');

    img.src = objJson.data.avatar;
    nombre.innerText = objJson.data.first_name;
    email.innerText = objJson.data.email;
}

document.getElementById('btnBuscar')
    .addEventListener('click', buscar);