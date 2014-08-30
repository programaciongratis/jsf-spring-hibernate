package com.programaciongratis.dao;

import com.programaciongratis.objetos.Clima;

public interface ClimaDAO {
	
	void guardarClima(Clima clima);
	
	void borrarClima(Clima clima);
	
}
