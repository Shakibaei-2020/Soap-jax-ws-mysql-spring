package collabrateur.web.service.bootstrap;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import collabrateur.web.service.entities.Collaborateur;
import collabrateur.web.service.entities.Frais;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private EntityManagerFactory entityManagerFactory;


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Collaborateur collaborateur = new Collaborateur("Patrick");
		
		Frais Frais1 = new Frais("Transport", "July 6, 2019", collaborateur);
		Frais Frais2 = new Frais("Déjeuner", "October 28, 2019", collaborateur);
		
		collaborateur.add(Frais1);
		collaborateur.add(Frais2);

		entityManager.persist(collaborateur);

		entityManager.getTransaction().commit();
		
	
		entityManager.getTransaction().begin();
		
		Collaborateur collaborateur2 = new Collaborateur("Jean");
		
		Frais Frais3 = new Frais("Transport", "September 12, 2019", collaborateur2);		
		Frais Frais4 = new Frais("Dejeuner", "November 25, 2019", collaborateur2);
		
		collaborateur2.add(Frais3);
		collaborateur2.add(Frais4);
		
		entityManager.persist(collaborateur2);
		
		entityManager.getTransaction().commit();
	}

}
