package br.com.qwerty.entidade;

import java.io.Serializable;
import java.math.BigDecimal;

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

import com.sun.xml.bind.CycleRecoverable;

@XmlRootElement
@Entity
@Table(name = "promocao_produto")
public class PromocaoProduto implements Serializable, CycleRecoverable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "preco")
    private BigDecimal preco;
    
    @JoinColumn(name = "produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produto produto;
    
    @JoinColumn(name = "promocao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Promocao promocao;

    public PromocaoProduto() {
    }

    public PromocaoProduto(Integer id) {
        this.id = id;
    }

    public PromocaoProduto(Integer id, BigDecimal preco) {
        this.id = id;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PromocaoProduto)) {
            return false;
        }
        PromocaoProduto other = (PromocaoProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PromocaoProduto[ id=" + id + " ]";
    }

	@Override
	public Object onCycleDetected(Context arg0) {
		PromocaoProduto pp = new PromocaoProduto();
		pp.setId(this.id);
		return pp;
	}
    
}
