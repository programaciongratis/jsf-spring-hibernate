package com.programaciongratis.beans;

import java.io.InputStream;
import java.io.Serializable;

import com.programaciongratis.businessobjects.ClimaBo;
import com.programaciongratis.objetos.Clima;
import com.programaciongratis.servicios.ServicioClimaYahoo;
import com.programaciongratis.traductores.xml.TraductorXmlClima;

public class ClimaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ClimaBo climaBo;
	
	private int usuarioId;
	private int temperatura;
	private double viento;
	
	private String codigoPostal;
	
	private Clima clima;
	
	public void conseguirTemperatura() {
		
		if ((!getCodigoPostal().isEmpty())
				&& (getUsuarioId() != 0)) {
			
			InputStream conexion = null;
			TraductorXmlClima traductorClima = new TraductorXmlClima();
			
			try {
				conexion = new ServicioClimaYahoo().conseguirConexion(getCodigoPostal(), true);
				setClima(traductorClima.conseguirClima(getCodigoPostal(), true, conexion));
				
				getClima().setUsuario_id(getUsuarioId());
				
				setTemperatura(clima.getTemperatura());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public String guardarClima() {
		
		conseguirTemperatura();
		
		if (clima != null) {
			climaBo.guardarClima(getClima());
		}
		
		return "";
	}
	
	
	public ClimaBo getClimaBo() {
		return climaBo;
	}
	public void setClimaBo(ClimaBo climaBo) {
		this.climaBo = climaBo;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public double getViento() {
		return viento;
	}
	public void setViento(double viento) {
		this.viento = viento;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Clima getClima() {
		return clima;
	}

	public void setClima(Clima clima) {
		this.clima = clima;
	}
	
	
	
}
