# P1-SopaLetras-DayleenMartinez-SamuelOlaya-AnaOrozco
Proyecto uno de Estructura de Datos, en equipo de tres. Universidad Metropolitana 2324-3
Proyecto 1: Sopa de letras.
Contexto preliminar
En el siguiente proyecto, usted tendrá que realizar una investigación documental que le permita obtener información sobre el contexto del problema. En tal sentido, se sugiere que comience por realizar la siguiente lectura relativa a grafos, pero tome en cuenta que es solo un recurso inicial que debe ser complementado con la búsqueda autónoma de información por parte de los integrantes del equipo de trabajo:
https://drive.google.com/file/d/1Q65Rh-Tx6qwJODUlsmWVfw_-bzqttwiI/view?usp=sharing
Problema
Su equipo de trabajo ha sido contratado para desarrollar un programa que sea capaz de resolver una sopas de letras. Es decir, el programa deberá poder verificar que una lista de palabras se encuentra en un tablero de letras de 4x4. Las reglas para la formación de una palabra válida son muy sencillas:
La palabra encontrada debe estar compuesta por una secuencia de elementos adyacentes en el tablero. Dos elementos del tablero son adyacentes si están uno al lado del otro en el tablero, tanto horizontal como vertical o diagonalmente. 
Solo se puede utilizar una vez cada elemento (letra) del tablero para la formación de una palabra válida. Es decir, no se puede volver a utilizar un elemento del tablero para la formación de la misma palabra. 
Una palabra válida debe tener al menos 3 letras.
Una palabra válida debe existir en un diccionario.
No todas las palabras del diccionario se encontrarán en el tablero.
Las palabras no llevan acento.
	La siguiente figura muestra un ejemplo de palabras válidas (GEEKS, QUIZ) en dicho tablero.
Requerimientos funcionales
Cargar archivo:   El usuario puede seleccionar a través de JFileChooser un archivo txt (archivo de texto plano) para ser cargado en el sistema, el cual contará con la información necesaria para la creación tanto del tablero como del diccionario. El programa deberá mostrar el tablero y el diccionario.
Buscar palabras: el usuario dará la orden al programa para que busque las palabras contenidas en el diccionario. El programa deberá indicar cuáles palabras se encuentran en el tablero. Además, deberá mostrar el tiempo que tarda en encontrar todas las palabras en milisegundos.
Buscar una palabra en específico: el usuario podrá indicar una palabra en específico a ser buscada. Puede ser una palabra que no está contenida en el diccionario inicial. 
Seleccionar método de búsqueda: El usuario podrá seleccionar entre dos métodos de búsqueda: DFS  (Depth First Search) o BFS (Breadth First Search). Lo anterior solo cuando se utilice la función que responde al requerimiento B.
Mostrar árbol de recorrido BFS: El sistema deberá mostrar una representación visual del árbol de recorrido BFS del grafo al buscar solo una palabra (requerimiento C). El árbol deberá tener como raíz la primera letra de la palabra buscada. Nota: Puede hacer uso de librerías para dicha representación.
Guardar Diccionario: El usuario podrá solicitar al programa que actualice el archivo con los datos del diccionario cargado en memoria.



Requerimientos técnicos
La solución debe ser implementada (específicamente el denominado tablero) con base en un grafo no dirigido, que a su vez puede ser implementado mediante una matriz de adyacencia o una lista de adyacencia.
Puede utilizar cualquier otra estructura auxiliar de ser necesario para mejorar los tiempos de respuesta del programa. Sin embargo, NO podrá utilizar librerías para la implementación del tipo de dato abstracto, solo podrá utilizar librerías para lo relativo a la representación gráfica del grafo (árbol de recorrido referido en el requerimiento E).
La aplicación debe ofrecer una interfaz gráfica al usuario. No se permite la entrada ni la salida de información por consola.
El programa debe poder cargar un archivo de texto para la lectura de datos. Para ello, es requerido el uso del componente JFileChooser.
Debe documentar el proyecto con Javadoc.
Junto al programa, cada equipo deberá presentar un Diagrama de clases (arquitectura detallada) que explique la solución obtenida.  
Archivo de texto
El programa debe poder leer un archivo de texto en donde las palabras del diccionario se encuentran separadas por saltos de línea y encerradas entre las etiquetas “dic” y “/dic” y las 16 letras que conforman el tablero 4x4 se encuentran encerradas entre las etiquetas “tab” y “/tab”.
Puede tomar el siguiente ejemplo como referencia en lo relativo a la estructura del archivo a utilizar. Tome en cuenta que el archivo de prueba tendrá la misma estructura pero no los mismos datos:
dic
CHAO
OTRA
PATA
ORO
RATA
/dic
tab
C,H,A,O,X,A,T,M,P,R,R,A,A,O,R,O
/tab
Consideraciones
Los proyectos podrán ser sometidos a defensa, es decir, el facilitador convocará al equipo para una revisión.
Los equipos de trabajo deberán utilizar GitHub para el control de versiones y facilitar el trabajo en equipo de manera remota. De esta forma, podrán comenzar a crear su portafolio de trabajos, elemento que puede ser importante a la hora de buscar trabajo. En el registro se deberá reflejar la participación activa y significativa de los integrantes. 
Los proyectos que no estén debidamente documentados no serán aceptados y se les asignará 0 (cero) puntos.
 Los proyectos que no tengan interfaz gráfica, serán calificados con 0 (cero).
Los proyectos que sean iguales o parecidos, serán calificados con 0 (cero).
Los programas que “no corran”, serán calificados con 0 (cero).
Los equipos pueden tener como máximo 3 personas.
Criterios de evaluación
Funcionalidad: Capacidad para proporcionar las funcionalidades que satisfacen las necesidades explícitas e implícitas bajo unas ciertas condiciones. (60%)
Adecuación: El programa ofrece todas funcionalidades que respondan a las necesidades, tanto explícitas (contenidas en el documento descriptivo del proyecto) como implícitas; entendiendo como necesidades implícitas, aquellas que, no estando descritas en el documento, surgen como resultado de un concienzudo análisis del problema planteado y que aseguran el correcto funcionamiento del programa.
Exactitud: El programa genera los resultados o efectos correctos o acordados, con el grado necesario de precisión.
Fiabilidad: Capacidad para mantener un nivel especificado de prestaciones cuando se usa bajo ciertas condiciones.
Madurez: El programa no presenta fallas originadas por errores de programación, análisis o diseño. (10%)
Tolerancia a fallos: El programa responde adecuadamente al manejo inadecuado del usuario; es decir, mantiene su correcto funcionamiento aun cuando el usuario introduzca datos erróneos o manipule inadecuadamente las interfaces de usuario. (10%)
Usabilidad: Capacidad del proyecto para ser entendido, aprendido, usado y al mismo tiempo, ser atractivo para el usuario, cuando se usa bajo condiciones específicas.
Comprensibilidad: El programa ofrece una interfaz de fácil comprensión, facilitando su aprendizaje y correcta utilización. El programa emite mensajes de alerta cuando se introducen valores erróneos. Existen elementos informativos que indican al usuario como operar el programa. (5%)
Capacidad de ser atractivo: El diseño de la interfaz de usuario, esto es: disposición de controles, esquema de colores, utilización de cajas de diálogo y demás elementos gráficos; es atractivo para el usuario. (5%)
Eficiencia: Capacidad para proporcionar prestaciones apropiadas, relativas a la cantidad de recursos utilizados, bajo condiciones determinadas.
Estructuras de datos: Utiliza eficientemente las estructuras de datos para la solución del problema. (10%)
