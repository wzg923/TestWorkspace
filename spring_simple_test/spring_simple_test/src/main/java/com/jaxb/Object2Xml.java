package com.jaxb;

import java.io.File;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author guang
 *Jaxb:Object converted to Xml
 */
public class Object2Xml {
	/**
	 * @param object
	 * @param outputStream
	 * @throws JAXBException 
	 */
	public static void run(Object object, OutputStream outputStream) throws JAXBException {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(object.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(object, outputStream);
			jaxbMarshaller.marshal(object, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * @param object
	 * @param file
	 * @throws JAXBException 
	 */
	public static void run(Object object, File file) throws JAXBException {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(object.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(object, file);
			jaxbMarshaller.marshal(object, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
