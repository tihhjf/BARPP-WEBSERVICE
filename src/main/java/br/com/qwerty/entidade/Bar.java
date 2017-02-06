package br.com.qwerty.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.xml.bind.CycleRecoverable;

@XmlRootElement
@Entity
@Table(name = "bar")
public class Bar implements Serializable, CycleRecoverable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "adiministrador")
    private int adiministrador;
    
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bar", fetch = FetchType.LAZY)
    private List<Promocao> promocaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bar", fetch = FetchType.LAZY)
    private List<Avaliacao> avaliacoes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bar", fetch = FetchType.LAZY)
    private List<Checkin> CheckinList;
    
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Colaborador colaborador;
    
    @JoinColumn(name = "endereco", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Endereco endereco;
    
    @JoinColumn(name = "imagem", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Imagem imagem;
    
    @Basic(optional = true)
    @Column(name = "status")
    private String status;

    public Bar() {
    }

    public Bar(Integer id) {
        this.id = id;
    }

    public Bar(Integer id, int adiministrador, String nome, List<Promocao> promocaoList, List<Avaliacao> avaliacoes,
			Colaborador colaborador, Endereco endereco, Imagem imagem, String status) {
		this.id = id;
		this.adiministrador = adiministrador;
		this.nome = nome;
		this.promocaoList = promocaoList;
		this.avaliacoes = avaliacoes;
		this.colaborador = colaborador;
		this.endereco = endereco;
		this.imagem = imagem;
		this.status = status;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAdiministrador() {
        return adiministrador;
    }

    public void setAdiministrador(int adiministrador) {
        this.adiministrador = adiministrador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Promocao> getPromocaoList() {
        return promocaoList;
    }

    public void setPromocaoList(List<Promocao> promocaoList) {
        this.promocaoList = promocaoList;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }
    
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@XmlTransient
	public List<Checkin> getCheckinList() {
		return CheckinList;
	}

	public void setCheckinList(List<Checkin> checkinList) {
		CheckinList = checkinList;
	}

	@XmlTransient
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Bar)) {
            return false;
        }
        Bar other = (Bar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bar[ id=" + id + " ]";
    }

	@Override
	public Object onCycleDetected(Context arg0) {
		Bar bar = new Bar();
		bar.setId(this.id);
		return bar;
	}
    
}
