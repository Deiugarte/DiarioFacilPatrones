package edu.ulatina.diariofacil.idao;

import edu.ulatina.diariofacil.model.Producto;
import java.util.List;

public interface IProductoDAO {
    public List<Producto> obtenerProductosSinPromo();
    public void crear(Producto producto);
    public void borrar(int id);
    public Producto obtener(Producto producto);
    public void actualizar(Producto producto);
}
