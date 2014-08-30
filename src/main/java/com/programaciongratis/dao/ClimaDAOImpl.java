package com.programaciongratis.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.programaciongratis.objetos.Clima;

public class ClimaDAOImpl extends HibernateDaoSupport implements ClimaDAO {

	@Override
	public void guardarClima(Clima clima) {
		getHibernateTemplate().save(clima);

	}

	@Override
	public void borrarClima(Clima clima) {
		getHibernateTemplate().delete(clima);

	}

}
