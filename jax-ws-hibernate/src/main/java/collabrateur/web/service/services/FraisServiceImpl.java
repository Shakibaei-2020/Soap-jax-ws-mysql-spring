package collabrateur.web.service.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Service;



import collabrateur.web.service.dto.FraisReponse;
import collabrateur.web.service.dto.FraisRequest;
import collabrateur.web.service.entities.Collaborateur;


@Service
public class FraisServiceImpl implements FraisService {

	private EntityManagerFactory entityManagerFactory;

	public FraisServiceImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public FraisReponse getFraisInfo(FraisRequest request) {	
		String name = request.getCollaborateurName();

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select a from Collaborateur a where a.name = :name");
		query.setParameter("name", name);
		Collaborateur collaborateur = (Collaborateur) query.getSingleResult();
		entityManager.getTransaction().commit();
		
		FraisReponse response = new FraisReponse();	
		response.setCollaboratuer(collaborateur);
		return response;
	}


}
