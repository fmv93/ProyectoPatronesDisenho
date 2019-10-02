/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author gracus
 * @param <E>
 */
public abstract class DAO<E> {
		
	public abstract List<E> leer();
	
	public abstract void escribir(List lista);

	public abstract boolean borrar();

	public abstract List<E> getLista();	
	
}