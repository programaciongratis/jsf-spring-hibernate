package com.programaciongratis.utilidades;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum HibernateUtils {
	INSTANCE
	;
	public SessionFactory getSessionFactory () {
		
		return new Configuration().configure().buildSessionFactory();
		
	}
	
	public void cerrarSessionFactory() {
		getSessionFactory().close();
	}

}
