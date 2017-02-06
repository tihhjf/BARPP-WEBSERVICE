package br.com.qwerty.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.qwerty.business.BusinessCode;

@XmlRootElement
public class BasicResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int status;
	private String mensagemRetorno;

	public BasicResponseDTO() { }
	
	public BasicResponseDTO(int status, String mensagemRetorno) {
		super();
		this.status = status;
		this.mensagemRetorno = mensagemRetorno;
	}
	
	public BasicResponseDTO(BusinessCode businessCode) {
		super();
		this.status = businessCode.getCodigo();
		this.mensagemRetorno = businessCode.getMensagem();
	}
	
	public static BasicResponseDTO createResponse(BusinessCode businessCode){
		return new BasicResponseDTO(businessCode);
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensagemRetorno() {
		return mensagemRetorno;
	}

	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}

}
