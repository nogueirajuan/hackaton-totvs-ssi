/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.service.bd.amazon.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByRg", query = "SELECT u FROM User u WHERE u.rg = :rg")
    , @NamedQuery(name = "User.findByNome", query = "SELECT u FROM User u WHERE u.nome = :nome")
    , @NamedQuery(name = "User.findBySexo", query = "SELECT u FROM User u WHERE u.sexo = :sexo")
    , @NamedQuery(name = "User.findByNascimento", query = "SELECT u FROM User u WHERE u.nascimento = :nascimento")
    , @NamedQuery(name = "User.findByCpf", query = "SELECT u FROM User u WHERE u.cpf = :cpf")
    , @NamedQuery(name = "User.findByEDiretor", query = "SELECT u FROM User u WHERE u.eDiretor = :eDiretor")
    , @NamedQuery(name = "User.findByETecnico", query = "SELECT u FROM User u WHERE u.eTecnico = :eTecnico")
    , @NamedQuery(name = "User.findByEAluno", query = "SELECT u FROM User u WHERE u.eAluno = :eAluno")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rg")
    private Integer rg;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "nascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nascimento;
    @Size(max = 45)
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "e_diretor")
    private Short eDiretor;
    @Column(name = "e_tecnico")
    private Short eTecnico;
    @Column(name = "e_aluno")
    private Short eAluno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Aluno> alunoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<DiretorModalidade> diretorModalidadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TelefoneUser> telefoneUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Tecnico> tecnicoList;

    public User() {
    }

    public User(Integer rg) {
        this.rg = rg;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Short getEDiretor() {
        return eDiretor;
    }

    public void setEDiretor(Short eDiretor) {
        this.eDiretor = eDiretor;
    }

    public Short getETecnico() {
        return eTecnico;
    }

    public void setETecnico(Short eTecnico) {
        this.eTecnico = eTecnico;
    }

    public Short getEAluno() {
        return eAluno;
    }

    public void setEAluno(Short eAluno) {
        this.eAluno = eAluno;
    }

    @XmlTransient
    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    @XmlTransient
    public List<DiretorModalidade> getDiretorModalidadeList() {
        return diretorModalidadeList;
    }

    public void setDiretorModalidadeList(List<DiretorModalidade> diretorModalidadeList) {
        this.diretorModalidadeList = diretorModalidadeList;
    }

    @XmlTransient
    public List<TelefoneUser> getTelefoneUserList() {
        return telefoneUserList;
    }

    public void setTelefoneUserList(List<TelefoneUser> telefoneUserList) {
        this.telefoneUserList = telefoneUserList;
    }

    @XmlTransient
    public List<Tecnico> getTecnicoList() {
        return tecnicoList;
    }

    public void setTecnicoList(List<Tecnico> tecnicoList) {
        this.tecnicoList = tecnicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rg != null ? rg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.rg == null && other.rg != null) || (this.rg != null && !this.rg.equals(other.rg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.previtale.service.bd.amazon.entities.User[ rg=" + rg + " ]";
    }
    
}
