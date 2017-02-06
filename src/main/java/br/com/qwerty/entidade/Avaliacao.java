package br.com.qwerty.entidade;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.xml.bind.CycleRecoverable;

@XmlRootElement
@Entity
@Table(name = "avaliacao")
public class Avaliacao implements Serializable, CycleRecoverable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@JoinColumn(name = "cliente")
    @ManyToOne(optional = false)
	private Cliente cliente;
	
	@JoinColumn(name = "bar", insertable = false, updatable = false)
    @ManyToOne(optional = false)
	private Bar bar;
	
	@Basic(optional = false)
    @Column(name = "avaliacao")
	private int avaliacao;
	
	@Basic(optional = false)
    @Column(name = "comentario", length=255)
	private String comentario;
	
	@Basic(optional = false)
    @Column(name = "status")
	private String status;
	
	public Avaliacao() {}

	public Avaliacao(Integer id, Cliente cliente, Bar bar, int avaliacao, String comentario, String status) {
		this.id = id;
		this.cliente = cliente;
		this.bar = bar;
		this.avaliacao = avaliacao;
		this.comentario = comentario;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlTransient
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@XmlTransient
	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}
	
	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public Object onCycleDetected(Context arg0) {
		Avaliacao a = new Avaliacao();
		a.setId(this.id);
		return a;
	}

}
