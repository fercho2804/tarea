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
@Table(name="ejemplo")
public class Data implements Serializable {
   private int id;

    @Column(name="id")
    @Id
   
   
   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    
}
