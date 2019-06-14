/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "mutante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mutante.findAll", query = "SELECT m FROM Mutante m")
    , @NamedQuery(name = "Mutante.findByMutanteId", query = "SELECT m FROM Mutante m WHERE m.mutanteId = :mutanteId")
    , @NamedQuery(name = "Mutante.findByNome", query = "SELECT m FROM Mutante m WHERE m.nome = :nome")})
public class Mutante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mutante_id")
    private Integer mutanteId;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @JoinColumn(name = "hability_id", referencedColumnName = "hability_id")
    @ManyToOne
    private Habilidade habilityId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Usuario userId;

    public Mutante() {
    }

    public Mutante(Integer mutanteId) {
        this.mutanteId = mutanteId;
    }

    public Integer getMutanteId() {
        return mutanteId;
    }

    public void setMutanteId(Integer mutanteId) {
        this.mutanteId = mutanteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Habilidade getHabilityId() {
        return habilityId;
    }

    public void setHabilityId(Habilidade habilityId) {
        this.habilityId = habilityId;
    }

    public Usuario getUserId() {
        return userId;
    }

    public void setUserId(Usuario userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mutanteId != null ? mutanteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mutante)) {
            return false;
        }
        Mutante other = (Mutante) object;
        if ((this.mutanteId == null && other.mutanteId != null) || (this.mutanteId != null && !this.mutanteId.equals(other.mutanteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mb.Mutante[ mutanteId=" + mutanteId + " ]";
    }
    
}
