package br.com.qwerty.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.xml.bind.CycleRecoverable;

@XmlRootElement
@Entity
@Table(name = "produto")
public class Produto implements Serializable, CycleRecoverable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "preco")
    private BigDecimal preco;
    
    @Basic(optional = false)
    @Column(name = "medida")
    private String medida;
    
    @Lob
    @Column(name = "descricao")
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto", fetch = FetchType.LAZY)
    private List<PromocaoProduto> promocaoProdutoList;
    
    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private List<PedidoProduto> pedidoProdutoList;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, String nome, BigDecimal preco, String medida) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.medida = medida;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<PromocaoProduto> getPromocaoProdutoList() {
        return promocaoProdutoList;
    }

    public void setPromocaoProdutoList(List<PromocaoProduto> promocaoProdutoList) {
        this.promocaoProdutoList = promocaoProdutoList;
    }
    
    @XmlTransient
    public List<PedidoProduto> getPedidoProdutoList() {
        return pedidoProdutoList;
    }

    public void setPedidoProdutoList(List<PedidoProduto> pedidoProdutoList) {
        this.pedidoProdutoList = pedidoProdutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ id=" + id + " ]";
    }

	@Override
	public Object onCycleDetected(Context arg0) {
		Produto p = new Produto();
		p.setId(this.id);
		return p;
	}
    
}
