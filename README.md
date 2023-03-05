
# Ejercicio Refactor - Stock de mercaderías

[![build](https://github.com/uqbar-project/eg-stock-refactor-kotlin/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/uqbar-project/eg-stock-refactor-kotlin/actions/workflows/build.yml) [![codecov](https://codecov.io/gh/uqbar-project/eg-stock-refactor-kotlin/branch/master/graph/badge.svg?token=X2bL63CJuZ)](https://codecov.io/gh/uqbar-project/eg-stock-refactor-kotlin)

## Enunciado

Queremos modelar las entradas y salidas de mercadería de una empresa que tiene un único depósito, para lo cual sabemos que

- cada producto (o mercadería, a partir de aquí lo trabajaremos en forma indistinta) tiene una cantidad de existencia en su depósito y un tamaño, lo que define el espacio de almacenamiento
- algunos productos delicados necesitan el doble de espacio de almacenamiento
- otros productos especiales tienen una cantidad mínima que necesitan mantener en el depósito, de manera que cuando nos queda esa cantidad no se permite la salida de dicha mercadería (ej: si para el pirufio tenemos un mínimo de 5, cuando llegamos a 5 no podemos sacar esa mercadería)

Queremos modelar dos operaciones:

- la compra de una mercadería, que debe registrar su ingreso al depósito
- la venta de una mercadería, que debe validar que haya suficiente stock de dicho producto y en ese caso registrar la salida (descuenta stock)
- queremos saber qué productos de un depósito tienen más de 100 m2 ocupados en almacenamiento

Fijate la solución en [este archivo](./src/main/kotlin/ar/edu/unsam/algo2/stock/Stock.kt) y los tests que tienen buena cobertura en [este archivo de test para el stock](./src/test/kotlin/ar/edu/unsam/algo2/stock/TestStock.kt) y [este otro para el reporter](./src/test/kotlin/ar/edu/unsam/algo2/stock/TestReporter.kt).

## Qué se pide

1. ¿Qué ideas de diseño te hacen ruido? ¿Por qué?
2. Proponer alternativas para cada una de las ideas discutidas en el punto anterior.

## Material relacionado

- [Apunte de Manejo del Cambio: Expansión y Refactoring](https://docs.google.com/document/d/1cAje0qwy3Cus_ob0r-tatbcT01sDFeLt3MmSVmLeSxk/edit)
- [Sitio Web de Refactoring](https://sourcemaking.com/refactoring)

## Para el docente

Acordate que la solución está en un repo privado del usuario fdodino (guiño, guiño) y se llama `eg-stock-refactor-kotlin-resuelto`
