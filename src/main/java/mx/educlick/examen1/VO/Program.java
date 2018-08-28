/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlick.examen1.VO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Fercho
 */
@Entity
@Table(name="Programs")
public class Program implements Serializable {
   private Long id;
   private Long code;
   private String shortname;
   private String name;
   private String revoe;
   private Byte status;
   private Long Idcenter;
   private Long idlevel;
 //  private Level idlevel;
   

  
   
    @Column(name="idProgram")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        @Column(name="code")
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
        @Column(name="shortname")
    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
        @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        @Column(name="revoe")
    public String getRevoe() {
        return revoe;
    }

    public void setRevoe(String revoe) {
        this.revoe = revoe;
    }
        @Column(name="status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    
    
    @Column(name="idCenter")
    public Long getIdcenter() {
        return Idcenter;
    }

    public void setIdcenter(Long Idcenter) {
        this.Idcenter = Idcenter;
    }

    @Column(name="idLevel")
    public Long getIdlevel() {
        return idlevel;
    }

    public void setIdlevel(Long idlevel) {
        this.idlevel = idlevel;
    }
    
}
