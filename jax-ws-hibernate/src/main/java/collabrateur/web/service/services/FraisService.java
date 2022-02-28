package collabrateur.web.service.services;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import collabrateur.web.service.dto.FraisReponse;
import collabrateur.web.service.dto.FraisRequest;


@WebService(name = "FraisService")
public interface FraisService {

	public FraisReponse getFraisInfo(@XmlElement(required=true) FraisRequest request);
}
