package collabrateur.web.service.dto;


import javax.xml.bind.annotation.XmlType;

import collabrateur.web.service.entities.Collaborateur;


@XmlType(name = "FraisReponse")
public class FraisReponse {

	private Collaborateur collaborateur;

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaboratuer(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
}
