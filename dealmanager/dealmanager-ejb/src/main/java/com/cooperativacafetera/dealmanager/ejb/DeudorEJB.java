package com.cooperativacafetera.dealmanager.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.cooperativacafetera.dealmanager.implementacion.EJBGenerico;
import com.cooperativacafetera.dealmanager.modelo.Cliente;


@LocalBean
@Stateless
public class DeudorEJB extends EJBGenerico<Cliente>{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Cliente.class;
	}

	/**
	 * Metodo que crear un cliente de tipo deudor
	 */
	public void crear(Cliente cliente) {
		dao.crear(cliente);
	}

	/**
	 * Metodo que se utiliza para buscar un cliente
	 * 
	 * @param cedula, la cedula del cliente a buscar
	 * @return el cliente si lo encuentra
	 */
	public Cliente buscar(Object cedula) {
		return dao.buscar(cedula);
	}

}
