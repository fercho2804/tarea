/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlick.tickets.vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HOUSE
 */
@Entity
@Table(name="ProgCenter")
public class ProgCenter implements Serializable{
    private Long id;
    private Integer code;
    private String shortName;
    private String name;
    private Byte status;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "idCenter")    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
@Column(name = "code")    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
@Column(name = "shortName")    
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
@Column(name = "name")    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@Column(name = "status")    
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
