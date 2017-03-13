/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.habitaciones.persistence;

import co.edu.uniandes.csw.habitaciones.entities.HabitacionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author l.maya10
 * @generated
 */
@Stateless
public class HabitacionPersistence {
    
    @PersistenceContext(unitName="habitacionPU")
     protected EntityManager em;
    
    public HabitacionEntity find(Long id)
    {
        return em.find(HabitacionEntity.class, id);
    }
    
    public List<HabitacionEntity> findAll() {
       
        Query q = em.createQuery("select u from HabitacionEntity u");
        return q.getResultList();
    }
    
    public HabitacionEntity create(HabitacionEntity entity) {
      
        em.persist(entity);
        
        return entity;
    }
    
    public HabitacionEntity update(HabitacionEntity entity) {
       
        return em.merge(entity);
    }
    
    public void delete(Long id) {
        
       HabitacionEntity entity = em.find(HabitacionEntity.class, id);
        em.remove(entity);
    }
}