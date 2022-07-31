package com.IBFS.AdminIBFS.controlador.impl;

import java.util.HashMap;
import java.util.List;

import com.IBFS.AdminIBFS.controlador.CategoriaControlador;
import com.IBFS.AdminIBFS.modelo.dao.CategoriaDao;
import com.IBFS.AdminIBFS.modelo.dao.impl.CategoriaDaoImpl;
import com.IBFS.AdminIBFS.modelo.entidades.Categoria;

public class CategoriaControladorImpl implements CategoriaControlador{
	
	private CategoriaDao categoriaDao;

	public CategoriaControladorImpl() {
		categoriaDao = new CategoriaDaoImpl();
	}
	
	@Override
	public HashMap<String, Object> insertarCategoria(Categoria nuevoCategoria) {
		// TODO Auto-generated method stub
		return categoriaDao.insertarCategoria(nuevoCategoria);
	}

	@Override
	public void actualizarCategoria(Categoria actualizarCategoria) {
		// TODO Auto-generated method stub
		categoriaDao.actualizarCategoria(actualizarCategoria);
	}

	@Override
	public void borrarCategoria(Categoria borrarCategoria) {
		// TODO Auto-generated method stub
		categoriaDao.borrarCategoria(borrarCategoria);
	}

	@Override
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		return categoriaDao.listarCategoria();
	}

	@Override
	public List<Categoria> buscarCategoriaPorNombre(String cat_nombre) {
		// TODO Auto-generated method stub
		return categoriaDao.buscarCategoriaPorNombre(cat_nombre);
	}

}
