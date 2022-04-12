package dao;

public interface DaoFacturaProducto {
	
	// Traer las facturas del producto más vendido
	/*
	 * CREATE VIEW sumas_productos AS
	 * SELECT
	 * 	COUNT(factura_producto.idProducto)*(producto.valor) as recaudacion_total,
	 * 	factura_producto.idProducto as idProducto
	 * FROM factura_producto
	 * INNER JOIN producto ON (factura_producto.idProducto = producto.idProducto)
	 * GROUP BY(factura_producto.idProducto);
	 * */

}