package com.programaciongratis.aplicacion;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.SAXException;

import com.programaciongratis.businessobjects.ClimaBo;
import com.programaciongratis.objetos.Clima;
import com.programaciongratis.servicios.ServicioClimaYahoo;
import com.programaciongratis.traductores.xml.TraductorXmlClima;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SAXException, IOException, ParserConfigurationException, Exception
    {
    	/*Session session = HibernateUtils.INSTANCE.getSessionFactory().openSession();

        session.beginTransaction();
        Clima climaDeLima = new Clima(002, 15, 25);

        session.save(climaDeLima);
        session.getTransaction().commit();
        
        System.out.println("Great! Clima was saved");
        
        HibernateUtils.INSTANCE.cerrarSessionFactory();
        System.out.println("Cerrando la session...");*/
    	
    	TraductorXmlClima test = new TraductorXmlClima();
		ServicioClimaYahoo servicio = new ServicioClimaYahoo();
		
		String codigoPostal = "14580";
		
    	Clima climaDePrueva = test.conseguirClima(codigoPostal, true, servicio.conseguirConexion(codigoPostal, true));
    	
    	// no olvidemos que como es un ejemplo, tenemos que poner un usuario_id de prueba.
    	climaDePrueva.setUsuario_id(004); //escogi 004 porque ya probe con 001, 002, y 003 :D
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("beanLocations.xml");
    	
    	//asi es como le decimos a Srping que nos de un objeto climaBo 
    	//con todas sus dependencias definidas en beanClima.xml
    	ClimaBo climaBusinessObject = (ClimaBo) context.getBean("climaBo");
    	
    	System.out.println("Guardando un clima de prueva...");
    	climaBusinessObject.guardarClima(climaDePrueva);
    	
    	System.out.println("Terminando de guardar un clima de prueva...");
    }
}
