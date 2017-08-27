/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.service.bd.amazon.entities;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByNomeUsusario", query = "SELECT u FROM Usuarios u WHERE u.nomeUsusario = :nomeUsusario")
    , @NamedQuery(name = "Usuarios.findByEmailUsusario", query = "SELECT u FROM Usuarios u WHERE u.emailUsusario = :emailUsusario")
    , @NamedQuery(name = "Usuarios.findBySenhaUsusario", query = "SELECT u FROM Usuarios u WHERE u.senhaUsusario = :senhaUsusario")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    @GenericGenerator(name = "seqUsuarios", strategy = "org.hibernate.id.IncrementGenerator")
    @GeneratedValue(generator = "seqUsuarios")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_ususario")
    private String nomeUsusario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email_ususario")
    private String emailUsusario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "senha_ususario")
    private String senhaUsusario;
    @Lob
    @Column(name = "foto_ususario")
    private byte[] fotoUsusario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsusario")
    private List<Avaliacoes> avaliacoesList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String nomeUsusario, String emailUsusario, String senhaUsusario) {
        this.idUsuario = idUsuario;
        this.nomeUsusario = nomeUsusario;
        this.emailUsusario = emailUsusario;
        this.senhaUsusario = senhaUsusario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsusario() {
        return nomeUsusario;
    }

    public void setNomeUsusario(String nomeUsusario) {
        this.nomeUsusario = nomeUsusario;
    }

    public String getEmailUsusario() {
        return emailUsusario;
    }

    public void setEmailUsusario(String emailUsusario) {
        this.emailUsusario = emailUsusario;
    }

    public String getSenhaUsusario() {
        return senhaUsusario;
    }

    public void setSenhaUsusario(String senhaUsusario) {
        this.senhaUsusario = senhaUsusario;
    }

    public byte[] getFotoUsusario() {
        return fotoUsusario;
    }

    public void setFotoUsusario(byte[] fotoUsusario) {
        this.fotoUsusario = fotoUsusario;
    }

    @XmlTransient
    public List<Avaliacoes> getAvaliacoesList() {
        return avaliacoesList;
    }

    public void setAvaliacoesList(List<Avaliacoes> avaliacoesList) {
        this.avaliacoesList = avaliacoesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.previtale.service.bd.amazon.entities.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
