/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlick.examen1.dao;
import java.util.List;
import mx.educlick.examen1.UTIL.HibernateUtil;
import mx.educlick.tickets.vo.ProgCenter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HOUSE
 */
public class ProgCenterDAO {
       public static Long addPcenter(ProgCenter obj){
        
        Session sesion = null;
        Transaction transaction = null;
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();
            transaction = sesion.beginTransaction();
            sesion.saveOrUpdate(obj);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return obj.getId();
    }
    static public void  dropPcenter(Long id){

        Session sesion = null;
        Transaction transaction = null;

        try{
            sesion = HibernateUtil.getSessionFactory().openSession();
            transaction = sesion.beginTransaction();
            ProgCenter obj = (ProgCenter) sesion.get(ProgCenter.class,id);
            obj.setStatus(new Byte("0"));
            sesion.update(obj);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }                
    }
    public static ProgCenter getUser(Long id){
        Session sesion = null;
        Transaction transaction = null;
        ProgCenter obj = null;
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();            
            transaction = sesion.beginTransaction();
            obj = (ProgCenter) sesion.get(ProgCenter.class,id);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return obj;
    }
    public static List<ProgCenter> getUsers(String sql, Integer displaylength, Integer displaystart){
        Session sesion = null;
        Transaction transaction = null;
        List<ProgCenter> list = null;
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();            
            transaction = sesion.beginTransaction();
            Query query = sesion.createSQLQuery(sql).addEntity(ProgCenter.class);
            query.setMaxResults(displaylength);
            query.setFirstResult(displaystart);
            list = query.list(); 
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return list;
    }

        
    
    
}
