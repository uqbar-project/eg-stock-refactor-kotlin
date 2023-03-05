package ar.edu.unsam.algo2.stock

class BusinessException(message: String) : RuntimeException(message)

object EmpresaDeStock {

    val productos = mutableListOf<Producto>()

    fun retirar(producto: Producto, cantidad: Int) {
        producto.salida(cantidad)
    }

    fun ingresar(producto: Producto, cantidad: Int) {
        producto.entrada(cantidad)
    }

}

// Define una interfaz para el producto
open class AbstractProducto {

}

interface Mercaderia {
    fun salida(cantidad: Int)
    fun entrada(cantidad: Int)
}

class Producto : AbstractProducto(), Mercaderia {
    var nombre: String = ""

    var cantidadEnExistencia = 0
    var tamanio = 0

    var espacioDeAlmacenamiento = 0

    var esProductoDelicado = false
    var esProductoEspecial = false

    var cantidadMinima = 0

    override fun salida(cantidad: Int) {
        val cantidadNecesaria = if (esProductoEspecial) cantidadMinima else cantidadEnExistencia
        if (cantidad > cantidadNecesaria) {
            throw BusinessException("No es posible retirar más de $cantidadNecesaria")
        }

        cantidadEnExistencia = cantidadEnExistencia - cantidad

        // recalculo el espacio de almacenamiento
        espacioDeAlmacenamiento = tamanio * (if (esProductoDelicado) cantidadEnExistencia * 2 else cantidadEnExistencia)
    }

    override fun entrada(cantidad: Int) {
        cantidadEnExistencia = cantidadEnExistencia + cantidad

        espacioDeAlmacenamiento = tamanio * (if (esProductoDelicado) cantidadEnExistencia * 2 else cantidadEnExistencia)
    }
}

object Reporter {

    fun productosConMasDe100M2DeAlmacenamiento(): MutableList<Producto> {
        val productos = EmpresaDeStock.productos

        val productosConMasDe100M2 = mutableListOf<Producto>()

        productos.forEach { producto ->
            if (producto.espacioDeAlmacenamiento > 100) {
                productosConMasDe100M2.add(producto)
            }
        }

        return productosConMasDe100M2
    }
}
