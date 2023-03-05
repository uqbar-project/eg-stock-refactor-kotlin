package ar.edu.unsam.algo2.stock

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TestReporter : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("reporte de productos con más de 100m2 de almacenamiento") {
        EmpresaDeStock.productos.clear()
        EmpresaDeStock.productos.addAll(
            mutableListOf(
                Producto().apply {
                    cantidadEnExistencia = 10
                    nombre = "Tornillo"
                    tamanio = 1
                    salida(0)
                },
                Producto().apply {
                    cantidadEnExistencia = 500
                    nombre = "Tornillo phillips"
                    tamanio = 2
                    salida(0)
                },
                Producto().apply {
                    cantidadEnExistencia = 2
                    nombre = "Destornillador"
                    tamanio = 7
                    salida(0)
                },
                Producto().apply {
                    cantidadEnExistencia = 25
                    nombre = "Bastidor"
                    tamanio = 30
                    salida(0)
                },
            )
        )
        it("trae los productos correctamente") {
            Reporter.productosConMasDe100M2DeAlmacenamiento().map { it.nombre } shouldBe listOf("Tornillo phillips", "Bastidor")
        }
    }
})