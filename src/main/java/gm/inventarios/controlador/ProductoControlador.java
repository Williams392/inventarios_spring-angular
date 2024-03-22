package gm.inventarios.controlador;

import gm.inventarios.modelo.Producto;
import gm.inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

//localhost://8080/inventario-app
@RequestMapping("inventario-app")

@CrossOrigin(value = "http://localhost:4200") // Para peticiones desde el frontend

public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class); // los 2 Logger -> org.slf4j

    @Autowired
    private ProductoServicio productoServicio; // Para tener info de la BD

    //localhost://8080/inventario-app/pruductos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoServicio.listarProductos(); // Obtener los objetos de tipo entidad
        logger.info("Productos obtenidos:");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

}
