package com.programaciongratis.businessobjects;

import com.programaciongratis.dao.ClimaDAO;
import com.programaciongratis.objetos.Clima;

public class ClimaBoImpl implements ClimaBo{
	
	private ClimaDAO climaDao;

	@Override
	public void guardarClima(Clima clima) {

		if (clima != null) {
			getClimaDao().guardarClima(clima);
		}
	}

	@Override
	public void borrarClima(Clima clima) {
		
		if (clima != null) {
			getClimaDao().borrarClima(clima);
		}
		
	}

	public ClimaDAO getClimaDao() {
		return climaDao;
	}

	public void setClimaDao(ClimaDAO climaDAO) {
		this.climaDao = climaDAO;
	}

}
