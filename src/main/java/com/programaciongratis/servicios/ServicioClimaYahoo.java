package com.programaciongratis.servicios;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**Esta clase nos va permitir establecer una
 * conexion con el servicio de clima de Yahoo.
 * 
 * @author lnoria
 *
 */
public class ServicioClimaYahoo {
	
	/**Este metodo nos va permitir conseguir
	 * una conexion con el servicio de
	 * clima de Yahoo para el area especificada
	 * en el codigo postal.
	 * 
	 * @param codigoPostal String
	 * @return InputStream
	 * @throws Exception 
	 */
	public InputStream conseguirConexion (String codigoPostal, boolean esCelsius) throws Exception {
		
		String url = "http://weather.yahooapis.com/forecastrss?p=" + codigoPostal;
		
		if (esCelsius) {
			url += "&u=c";
		}
		
		URLConnection conexion = new URL(url).openConnection();
		return conexion.getInputStream();
		
	}

}
