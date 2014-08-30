package com.programaciongratis.traductores.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;




import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.programaciongratis.objetos.Clima;
import com.programaciongratis.servicios.ServicioClimaYahoo;

/**Esta clase va traducir el Xml conseguido
 * del serivico de clima de Yahoo.
 * 
 * @author lnoria
 *
 */
public class TraductorXmlClima {
	
	public Clima conseguirClima (String codigoPostal, boolean esCelsius, InputStream conexion) throws SAXException, IOException, ParserConfigurationException {
		
		Clima clima = null;
		
		Document documentoXml = crearDocument(conexion);
		
		documentoXml.getDocumentElement().normalize();
		
		System.out.println("root: " + documentoXml.getDocumentElement().getNodeName());
		
		NodeList list = documentoXml.getElementsByTagName("channel");
		System.out.println(list.getLength());
		
		for (int i = 0; i < list.getLength(); i++)  {
			
			Node node = list.item(i);
			
			if (Node.ELEMENT_NODE == node.getNodeType()) {
				
				Element element = (Element) node;
				
				System.out.println("element name:" + element.getNodeName());
				
				System.out.println("title: " + element.getElementsByTagName("title").item(0).getTextContent());
				
				NamedNodeMap locationMap = element.getElementsByTagName("yweather:location").item(0).getAttributes();
				
				System.out.println("city: " + locationMap.getNamedItem("city").getNodeValue());
				System.out.println("region:" + locationMap.getNamedItem("region").getNodeValue());
				System.out.println("country: " + locationMap.getNamedItem("country").getNodeName());
				
				NamedNodeMap vientoMap = element.getElementsByTagName("yweather:wind").item(0).getAttributes();
				
				System.out.println("chill: " + vientoMap.getNamedItem("chill").getNodeValue());
				System.out.println("direccion: " + vientoMap.getNamedItem("direction").getNodeValue());
				System.out.println("velocidad: " + vientoMap.getNamedItem("speed").getNodeValue());
				
				
				System.out.println(element.getElementsByTagName("item").item(0).getChildNodes().item(11).getNodeName());
				NamedNodeMap climaMap = element.getElementsByTagName("item").item(0).getChildNodes().item(11).getAttributes();
				
				System.out.println("descripcion: " + climaMap.getNamedItem("text").getNodeValue());
				System.out.println("codigo: " + climaMap.getNamedItem("code").getNodeValue());
				System.out.println("temperatura: " + climaMap.getNamedItem("temp").getNodeValue());
				
				// ahora que ya sabemos como conseguir la informacion solo asignamos valores a nuestro objeto clima.
				
				int temperatura = Integer.parseInt(climaMap.getNamedItem("temp").getNodeValue());
				double velocidadDelViento = Double.parseDouble(vientoMap.getNamedItem("speed").getNodeValue());
				
				int usuarioId = 0;
				
				clima = new Clima(usuarioId, temperatura, velocidadDelViento);
			}
			
		}
		
		return clima;
		
	}

	private Document crearDocument(InputStream conexion) throws SAXException, IOException, ParserConfigurationException {
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = fabrica.newDocumentBuilder();
		
		Document documento = constructor.parse(conexion);
		
		return documento;
	}
	
	// este solo es un metodo de prueba para ver si funciona
	public static void main (String[] args) throws SAXException, IOException, ParserConfigurationException, Exception {
		
		TraductorXmlClima test = new TraductorXmlClima();
		ServicioClimaYahoo servicio = new ServicioClimaYahoo();
		
		String codigoPostal = "14580";
		
		test.conseguirClima(codigoPostal, true, servicio.conseguirConexion(codigoPostal, true));
		
	}

}
