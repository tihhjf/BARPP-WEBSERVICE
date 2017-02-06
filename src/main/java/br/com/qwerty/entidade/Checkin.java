package br.com.qwerty.entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.xml.bind.CycleRecoverable;

@XmlRootElement
@Entity
@Table(name = "checkin")
public class Checkin implements Serializable, CycleRecoverable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    
    @Basic(optional = false)
    @Column(name = "mesa")
    private String mesa;
    
    @JoinColumn(name = "cliente")
    @ManyToOne(optional = false)
    private Cliente cliente;
    
    @JoinColumn(name = "bar")
    @ManyToOne(optional = false)
    private Bar bar;
    
    @JoinColumn(name = "colaborador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Colaborador colaborador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkin", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkin", fetch = FetchType.LAZY)
    private List<Checkout> checkoutList;

    public Checkin() {
    }

    public Checkin(Integer id) {
        this.id = id;
    }

    public Checkin(Integer id, Date data, String status, String mesa) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.mesa = mesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
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
    
    @XmlTransient
    public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Checkin)) {
            return false;
        }
        Checkin other = (Checkin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Checkin[ id=" + id + " ]";
    }

	@Override
	public Object onCycleDetected(Context arg0) {
		Checkin c = new Checkin();
		c.setId(this.id);
		return c;
	}
    
}
