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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.xml.bind.CycleRecoverable;

@XmlRootElement
@Entity
@Table(name = "imagem")
public class Imagem implements Serializable, CycleRecoverable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "link")
    private String link;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imagem", fetch = FetchType.LAZY)
    private List<Bar> bares;

    public Imagem() {
    }

    public Imagem(Integer id) {
        this.id = id;
    }

    public Imagem(Integer id, String link) {
        this.id = id;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @XmlTransient
    public List<Bar> getBarList() {
        return bares;
    }

    public void setBarList(List<Bar> barList) {
        this.bares = barList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Imagem)) {
            return false;
        }
        Imagem other = (Imagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Imagem[ id=" + id + " ]";
    }

	@Override
	public Object onCycleDetected(Context arg0) {
		Imagem i = new Imagem();
		i.setId(this.id);
		return i;
	}
    
}
