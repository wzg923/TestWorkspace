package com.jaxb;

import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * @author guang
 *Jaxb:Xml converted to Object
 */
public class Xml2Object {
	
	/**
	 * @param inputStream
	 * @param clazz
	 * @return
	 * @throws JAXBException 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T run(InputStream inputStream,Class<T> clazz) throws JAXBException {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (T)jaxbUnmarshaller.unmarshal(inputStream);			
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
		//return null;
	}
	
	/**
	 * @param file
	 * @param clazz
	 * @return
	 * @throws JAXBException 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T run(File file,Class<T> clazz) throws JAXBException {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (T)jaxbUnmarshaller.unmarshal(file);			
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
		//return null;
	}
	
	/**
	 * @param fileName
	 * @param clazz
	 * @return
	 * @throws JAXBException 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T run(String fileName,Class<T> clazz) throws JAXBException {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (T)jaxbUnmarshaller.unmarshal(new File(fileName));			
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
		//return null;
	}
}
