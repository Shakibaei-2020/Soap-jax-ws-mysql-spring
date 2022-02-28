package collabrateur.web.service.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "FraisRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class FraisRequest {

	@XmlElement(required = true)
	private String collaborateurName;

	public String getCollaborateurName() {
		return collaborateurName;
	}

	public void setCollaborateurName(String collaborateurName) {
		this.collaborateurName = collaborateurName;
	}
}
