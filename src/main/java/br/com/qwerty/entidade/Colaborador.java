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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.xml.bind.CycleRecoverable;

@XmlRootElement
@Entity
@Table(name = "colaborador")
public class Colaborador implements Serializable, CycleRecoverable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Usuario usuario;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "colaborador", fetch = FetchType.LAZY)
    private Bar bar;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<Checkin> checkinList;
    
    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<Checkout> checkoutList;

    public Colaborador() {
    }

    public Colaborador(Integer id) {
        this.id = id;
    }

    public Colaborador(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @XmlTransient
    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    @XmlTransient
    public List<Checkin> getCheckinList() {
        return checkinList;
    }

    public void setCheckinList(List<Checkin> checkinList) {
        this.checkinList = checkinList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @XmlTransient
    public List<Checkout> getCheckoutList() {
        return checkoutList;
    }

    public void setCheckoutList(List<Checkout> checkoutList) {
        this.checkoutList = checkoutList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Colaborador[ id=" + id + " ]";
    }

	@Override
	public Object onCycleDetected(Context arg0) {
		Colaborador c = new Colaborador();
		c.setId(this.id);
		return c;
	}
    
}
