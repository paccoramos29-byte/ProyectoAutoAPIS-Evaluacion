@EVALUACION
Feature: Trabajo de Capacitacion
  @CREARPET
  Scenario: Crear pet correctamente
    Given configuro petstore
    And creo pet valido
    When envio POST pet
    Then valido status 200
    And valido header content-type
    And valido nombre "Firulais"
  @CONSULTAPET
  Scenario: Consultar pet por id
    Given configuro petstore
    And creo pet valido
    When envio POST pet
    And envio GET pet por id
    Then valido status 200
    And valido header content-type
  @CONSULTAINVENTARIO
  Scenario: Consultar inventario
    Given configuro petstore
    When envio GET "/store/inventory"
    Then valido status 200
    And valido header content-type
  @CONSULTAPETINEXISTENTE
  Scenario: Consultar pet inexistente
    Given configuro petstore
    When envio GET pet inexistente
    Then valido status 404
    And valido header content-type
  @CREARPETINVALIDO
  Scenario: Crear pet invalido (JSON mal formado)
    Given configuro petstore
    When envio POST pet invalido raw
    Then valido status 400