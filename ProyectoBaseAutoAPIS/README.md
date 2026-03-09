# Evaluación Capacitacion APIs - Petstore
Proyecto desarrollado en Java + Serenity + Cucumber.
## Pruebas implementadas
Se desarrollaron 5 escenarios:
### Positivos
1. Crear pet correctamente (200)
2. Consultar pet por id (200)
3. Consultar inventario (200)
### Negativos
4. Consultar pet inexistente (404)
5. Crear pet con JSON mal formado (400)
## Tecnologías usadas
- Java 11
- RestAssured
- Serenity BDD
- Cucumber
## Cómo ejecutar
Ejecutar clase:
baseTest.java
O por Maven:
mvn clean verify