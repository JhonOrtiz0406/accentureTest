# accentureTest
Prueba de la empresa Accenture

la prueba fue realice sin crear un sistema de inventario osea que solo podras trabajar con un solo producto a la vez, en el 
otro txt de "Datos Utilizados para Pruebas en Postman" coloque algunos de los productos que podrias utilizar.

Nombre de la base de datos: accentureTest
Nombre del programa para testing: Postman
Nombre del IDE utilizado para la prueba: VS Code 
Nombre del framework implementado: Spring (Spring Boot)d

Historia de Usuario 1: Completada de Manera Exitosa.

Historia de Usuario 2: Completada a Medias debido a que no logre separar una variable que me guardara el valor antiguo
			del total de la factura...ya que cada vez que hacia un update me agarraba todos los datos de la
			clase, y no logre sacar ello para comprararlo con la primera parte de la segunda HU.
			
			En cuanto a lo demas si lo logre hacer. al momento de actualizar el carrito de compras despues 
			de haber pasado mas de 5h, en el terminal muestra un mensaje de que no es posible hacerlo; y en su
			defecto, si a transcurrido menos de 5h si lo permite hacer.

			En cuanto al Actualizar es colocar el id del producto a actualizar y variar la cantidad de unidades
			que vaya a llevar del producto. Aqui coloco un ejemplo:

{  
    "id" : 1,
    "horaCompra":0,
    "cantidad": 3,
    "domicilio" :0,
    "subTotal": 0.0,
    "iva": 0.0,
    "total": 0,
    "totalAntiguo": 0,
    "productos": {
        "id": 1,
        "nombre": "Tendon",
        "valor": 30000,
        "descripcion": "Tendon wagyu"
    },
    "cliente": {
        "id": 1,
        "nombre": "Jhon",
        "apellido": "Ortiz",
        "celular": 20120,
        "identificacion": "19019",
        "direccion": "Cra 5 #3-56",
        "barrio": "Santa Elena"
    },
    "domicilios": {
        "id": 1,
        "barrio": "Santa Elena",
        "valor": 2000
    }
}

Historia de Usuario 3: En cuanto a la Historia de usuario si me permitio colococar el aviso de que despues de haber transcurrido
			las 12 horas, si lo deja eliminar y le cobra un 10% extra; pero...lasimosamente no entiendo porque no me 
			trae el valor total del carrito, pero en cuanto a la formula e instanciacion si estan bien.
