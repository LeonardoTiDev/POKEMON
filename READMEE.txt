Primeros pasos…
1.- Primero que nada, debemos verificar la versión e Java instalada en nuestra computadora, la cual se puede verificar en la consola, mediante el comando java -version, tenemos que tener instalada la versión 8 en dado caso que no se tenga instalado https://www.youtube.com/watch?v=nxx1uwxBCs4 .

2.-Debemos descargar o clonar el proyecto desde el repositorio https://github.com/LeonardoTiDev/POKEMON.git

3.-Una vez descargado procedemos a abrir el proyecto con el IDE de preferencia se recomienda intellij idea ya que es un IDE que reconoce automáticamente el proyecto Maven, ya abierto el proyecto debemos compilarlo y correrlo mediante “Run” de la clase principal .

4.-Posteriormente podemos probar los Ítems asignado en el TEST JAVA EndCom.
Apoyado de una herramienta como POSTMAN podemos probar los servicios REST mediante las siquientes URL:

http://localhost:9091/api/servicesPokemon/help

NOTA: Podemos cambiar el puesto de servidor en el archivo  application.properties.
ESTATUS (90% DE LO REQUERIDO)
•	http://localhost:9091/api/servicesPokemon/pokeApiComplet?extract=30

Esta liga hace referencia al primer servicio requerido se sugiere que se consuma de esta forma ya que las Api anidadas para realizar el servicio .


ESTATUS (100% DE LO REQUERIDO)
•	http://localhost:9091/api/servicesPokemon/pokeApiRangos?rango1=50&rango2=80

Esta liga hace referencia al segundo servicio requerido cabe mencionar que el parámetro rango1 siempre deberá ser menor al rango2 para poder obtener datos.






ESTATUS (100% DE LO REQUERIDO)
•	http://localhost:9091/api/servicesPokemon/pokeApiFinByPokemonOrNum?para=50 

•	http://localhost:9091/api/servicesPokemon/pokeApiFinByPokemonOrNum?para=diglett

Podemos consultar el tercer servicio con cualquiera de estas ligas ya que la única variante es el parámetro puede ser un numero o nombre un pokemon siempre y cuando existan devolverá datos.


ESTATUS (100% DE LO REQUERIDO)
•	http://localhost:9091/api/servicesPokemon/guardar

Esta liga hace referencia al cuarto servicio el cual consiste en guardar un pokemon en nuestra base de datos H2, debemos recordar que el tipo de petición debe ser de tipo POST
Y podemos mandar el cuerpo de un objeto como este:


 {
   "apodo":"pikachduu",
   "especie":"elec",
   "ataque":null,
   "defensa":null,
   "salud":null
}

Los  atributos ataque, defensa y salud deberán ser null ya que es sistema se encargara de llenarlos automáticamente para poder insertar con éxito no debemos insertar un registro con un apodo que ya exista en la base de datos.


ESTATUS (100% DE LO REQUERIDO)
•	http://localhost:9091/api/servicesPokemon/findByApodo?apodo=pikachuudd

Podemos consultar el quinto servicio requerido en el TEST mediante la liga definida solo debemos cambiar el apodo por uno que si exista en la base de datos, podemos apoyarnos a verificar que pokemones hay en la base datos de este servicio extra:

•	http://localhost:9091/api/servicesPokemon/obtenerPokemonesH2

ESTATUS (100% DE LO REQUERIDO)
•	http://localhost:9091/api/servicesPokemon/pokeApiFinByPokemonOrNum?para=50 

•	http://localhost:9091/api/servicesPokemon/pokeApiFinByPokemonOrNum?para=diglett

Podemos consultar el tercer servicio con cualquiera de estas ligas ya que la única variante es el parámetro puede ser un numero o nombre un pokemon siempre y cuando existan devolverá datos.


ESTATUS (100% DE LO REQUERIDO)
•	http://localhost:9091/api/servicesPokemon/findAllByEspecie?especie=elec


Podemos consultar el  sexto servicio con la liga definida anteriormente cabe mencionar que deberán existir pokemones con esa especie para poder obtener datos.





PRESENTACION
•	http://localhost:9091/pages/presentacionLeonardo


Debemos pegar la liga en Google Chrome de preferencia.

















