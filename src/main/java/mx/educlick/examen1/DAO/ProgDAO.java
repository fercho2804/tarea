/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlick.examen1.DAO;

import java.util.List;
import mx.educlick.examen1.UTIL.HibernateUtil;
import mx.educlick.examen1.VO.Data;
import mx.educlick.examen1.VO.Program;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fercho
 */
public class ProgDAO {
    
    static public List<Program> getAccounts(String sql, Integer displaylength, Integer displaystart){
        Session sesion = null;
        Transaction transaction = null;
        List<Program> list = null;
        try{
            sesion =HibernateUtil.getSessionFactory().getCurrentSession();
            transaction =sesion.beginTransaction();
            Query query = sesion.createSQLQuery(sql).addEntity(Program.class);
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
    
    static public Program getProgram(Long id){
    Session sesion = null;
    Transaction transaction = null;
    Program obj = null;
    try{
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = sesion.beginTransaction();
        obj = (Program) sesion.get(Program.class, id);
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
    
    
    static public void dropProgram(Long id){
    Session sesion = null;
    Transaction transaction = null;
    try{
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = sesion.beginTransaction();
        Program obj = (Program) sesion.get(Program.class, id);
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
    
    static public int addData(Data obj){
        Session sesion = null;
        Transaction transaction = null;
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
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
    
    
    static public List<Program> getProgram(String sql, Integer displaylength, Integer displaystart){
        Session sesion = null;
        Transaction transaction = null;
        List<Program> list = null;
        try{
            sesion =HibernateUtil.getSessionFactory().getCurrentSession();
            transaction =sesion.beginTransaction();
            Query query = sesion.createSQLQuery(sql).addEntity(Program.class);
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
