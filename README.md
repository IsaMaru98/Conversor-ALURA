# Conversor-ALURA

¿Qué necesitamos? 
API KEY de Exchannge Rate 
Gson

Este conversor funciona específicamente entre las siguientes monedas: 

 1 - Convertir de Dolares Americanos a Coronas Sueca 2 - Convertir de Pesos Colombianos a Coronas Suecas 
                    3 - Convertir de Coronas Suecas a Dolares Americanos
                    4 - Convertir de Coronas Suecas a Pesos Colombianos
                    5 - Converir de Euros a Coronas Suecas 
                    6 - Convertir de Coronas Suecas a Euros 

Pero si quieres cambiarlos puedes hacerlo modificando lo metodo en Principal.java 

Con la clase ConsultaTasas.java hacemos un request a la API, solicitando todas las tasas de cambio relacionadas a una moneda base. Además, convertimos el JSON obtenido 
en una objeto de la clase MonedaDatos.java (Record) 

usando una instancia de la clase MonedaDatos, obtenemos la tasa de conversión que nos interesa específicamente y esta la usamos para hacer la conversión 
