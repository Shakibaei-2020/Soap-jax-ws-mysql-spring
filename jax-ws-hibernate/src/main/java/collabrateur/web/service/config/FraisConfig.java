package collabrateur.web.service.config;


import javax.persistence.EntityManagerFactory;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import collabrateur.web.service.services.FraisServiceImpl;


@Configuration
public class FraisConfig {

	@Autowired
	private Bus bus;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new FraisServiceImpl(entityManagerFactory));
		endpoint.publish("/fraisservice");
		return endpoint;
	}
}
