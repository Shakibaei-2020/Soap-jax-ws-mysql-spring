package collabrateur.web.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "collaborateur")
public class Collaborateur {

	@Id
	@GeneratedValue
	private int id_collaborateur;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@OneToMany(mappedBy="collaborateur",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Frais> listFrais;
	
	public Collaborateur() {}

	
	public Collaborateur(String name) {
		this.name = name;
	}


	public int getId() {
		return id_collaborateur;
	}


	public void setId(int id) {
		this.id_collaborateur = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Frais> getFrais() {
		return listFrais;
	}


	public void setFrais(List<Frais> frais) {
		this.listFrais = frais;
	}


	public void add(Frais frais) {
		
		if (listFrais == null) {
			listFrais = new ArrayList<>();
		}
		
		listFrais.add(frais);
	}
}
