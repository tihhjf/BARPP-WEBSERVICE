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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.xml.bind.CycleRecoverable;

@XmlRootElement
@Entity
@Table(name = "promocao")
public class Promocao implements Serializable, CycleRecoverable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    
    @JoinColumn(name = "bar", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bar bar;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promocao", fetch = FetchType.LAZY)
    private List<PromocaoProduto> promocaoProdutoList;

    public Promocao() {
    }

    public Promocao(Integer id) {
        this.id = id;
    }

    public Promocao(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }
    
    @XmlTransient
    public List<PromocaoProduto> getPromocaoProdutoList() {
        return promocaoProdutoList;
    }

    public void setPromocaoProdutoList(List<PromocaoProduto> promocaoProdutoList) {
        this.promocaoProdutoList = promocaoProdutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Promocao)) {
            return false;
        }
        Promocao other = (Promocao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Promocao[ id=" + id + " ]";
    }

	@Override
	public Object onCycleDetected(Context arg0) {
		Promocao p = new Promocao();
		p.setId(this.id);
		return p;
	}
    
}
