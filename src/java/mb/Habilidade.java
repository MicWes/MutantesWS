/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "habilidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habilidade.findAll", query = "SELECT h FROM Habilidade h")
    , @NamedQuery(name = "Habilidade.findByHabilityId", query = "SELECT h FROM Habilidade h WHERE h.habilityId = :habilityId")
    , @NamedQuery(name = "Habilidade.findByDescription", query = "SELECT h FROM Habilidade h WHERE h.description = :description")})
public class Habilidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hability_id")
    private Integer habilityId;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "habilityId")
    private Collection<Mutante> mutanteCollection;

    public Habilidade() {
    }
    
    public Habilidade(Integer habilityId, String description){
        this.habilityId = habilityId;
        this.description = description;
    }

    public Habilidade(Integer habilityId) {
        this.habilityId = habilityId;
    }

    public Integer getHabilityId() {
        return habilityId;
    }

    public void setHabilityId(Integer habilityId) {
        this.habilityId = habilityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Mutante> getMutanteCollection() {
        return mutanteCollection;
    }

    public void setMutanteCollection(Collection<Mutante> mutanteCollection) {
        this.mutanteCollection = mutanteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (habilityId != null ? habilityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habilidade)) {
            return false;
        }
        Habilidade other = (Habilidade) object;
        if ((this.habilityId == null && other.habilityId != null) || (this.habilityId != null && !this.habilityId.equals(other.habilityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mb.Habilidade[ habilityId=" + habilityId + " ]";
    }
    
}
