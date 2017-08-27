/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.service.bd.amazon.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author juan_
 */
@Entity
@Table(name = "avaliacoes")
@XmlRootElement
public class Avaliacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_avaliacao")
    private Integer idAvaliacao;
    @Column(name = "nota_avaliacao")
    private Integer notaAvaliacao;
    @Size(max = 250)
    @Column(name = "comen_avaliacao")
    private String comenAvaliacao;
    @Column(name = "data_avaliacao")
    @Temporal(TemporalType.DATE)
    private Date dataAvaliacao;
    @JoinColumn(name = "eventos_id_evento", referencedColumnName = "id_evento")
    @ManyToOne(optional = false)
    private Eventos eventosIdEvento;
    @JoinColumn(name = "usuarios_id_ususario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios usuariosIdUsusario;

    public Avaliacoes() {
    }

    public Avaliacoes(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Integer getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(Integer notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public String getComenAvaliacao() {
        return comenAvaliacao;
    }

    public void setComenAvaliacao(String comenAvaliacao) {
        this.comenAvaliacao = comenAvaliacao;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Eventos getEventosIdEvento() {
        return eventosIdEvento;
    }

    public void setEventosIdEvento(Eventos eventosIdEvento) {
        this.eventosIdEvento = eventosIdEvento;
    }

    public Usuarios getUsuariosIdUsusario() {
        return usuariosIdUsusario;
    }

    public void setUsuariosIdUsusario(Usuarios usuariosIdUsusario) {
        this.usuariosIdUsusario = usuariosIdUsusario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvaliacao != null ? idAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacoes)) {
            return false;
        }
        Avaliacoes other = (Avaliacoes) object;
        if ((this.idAvaliacao == null && other.idAvaliacao != null) || (this.idAvaliacao != null && !this.idAvaliacao.equals(other.idAvaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avaliacoes{" +
                "idAvaliacao=" + idAvaliacao +
                ", notaAvaliacao=" + notaAvaliacao +
                ", comenAvaliacao='" + comenAvaliacao + '\'' +
                ", dataAvaliacao=" + dataAvaliacao +
                ", eventosIdEvento=" + eventosIdEvento +
                ", usuariosIdUsusario=" + usuariosIdUsusario +
                '}';
    }
}
