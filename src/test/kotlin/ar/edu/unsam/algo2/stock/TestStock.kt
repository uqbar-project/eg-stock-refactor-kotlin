package ar.edu.unsam.algo2.stock

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TestStock : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("salida de un producto") {
        describe("si es normal") {
            val producto = Producto().apply {
                tamanio = 50
                cantidadEnExistencia = 40
            }
            it("deja como espacio de almacenamiento el tamaño de la existencia") {
                producto.salida(10)
                producto.espacioDeAlmacenamiento shouldBe 1500
            }
            it("descuenta el stock cuando se hace una salida por la misma cantidad") {
                producto.salida(10)
                producto.cantidadEnExistencia shouldBe 30
            }
            it("no permite realizar una salida mayor que la existencia en stock") {
                shouldThrow<BusinessException> { producto.salida(41)}
            }
        }

        describe("si es un producto delicado") {
            val productoDelicado = Producto().apply {
                tamanio = 50
                cantidadEnExistencia = 40
                esProductoDelicado = true
            }
            productoDelicado.salida(10)
            it("deja como espacio de almacenamiento el doble del tamaño de la existencia") {
                productoDelicado.espacioDeAlmacenamiento shouldBe 3000
            }
        }

        describe("si es un producto especial") {
            val productoEspecial = Producto().apply {
                tamanio = 50
                cantidadEnExistencia = 40
                cantidadMinima = 20
                esProductoEspecial = true
            }
            it("no permite que salga mercadería si queda por debajo del mínimo establecido") {
                shouldThrow<BusinessException> { productoEspecial.salida(21)}
            }
        }

        describe("ingreso de un producto") {
            describe("si es normal") {
                val producto = Producto().apply {
                    tamanio = 50
                    cantidadEnExistencia = 40
                }
                it("deja como espacio de almacenamiento el tamaño de la existencia") {
                    producto.entrada(10)
                    producto.espacioDeAlmacenamiento shouldBe 2500
                }
                it("aumenta el stock cuando se hace una entrada por la misma cantidad") {
                    producto.entrada(10)
                    producto.cantidadEnExistencia shouldBe 50
                }
            }

            describe("si es un producto delicado") {
                val productoDelicado = Producto().apply {
                    tamanio = 50
                    cantidadEnExistencia = 40
                    esProductoDelicado = true
                }
                productoDelicado.entrada(10)
                it("deja como espacio de almacenamiento el doble del tamaño de la existencia") {
                    productoDelicado.espacioDeAlmacenamiento shouldBe 5000
                }
            }
        }
    }

})