package com.programaciongratis.objetos;

public class Clima {
	
	private int usuario_id;
	private int temperatura;
	private double viento;
	
	public Clima (int usuario_id, int temperatura, double viento) {
		this.usuario_id = usuario_id;
		this.temperatura = temperatura;
		this.viento = viento;
	}
	
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
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

}
