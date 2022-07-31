package com.IBFS.AdminIBFS.modelo.dao;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.modelo.entidades.Categoria;

public interface CategoriaDao {
	public HashMap<String, Object> insertarCategoria(Categoria nuevoCategoria);
	public void actualizarCategoria(Categoria actualizarCategoria);
	public void borrarCategoria(Categoria borrarCategoria);
	public List<Categoria> listarCategoria();
	public List<Categoria> buscarCategoriaPorNombre(String cat_nombre);
}
