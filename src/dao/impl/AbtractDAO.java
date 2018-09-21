/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.entity.AbstractEntity;
import model.enu.StateEnum;
import util.DateUtil;

/**
 *
 * @author HP 240 G6
 * @param <T>
 */
public class AbtractDAO<T extends AbstractEntity> {
    
    private EntityManager entityManager;
    private DateUtil dateUtil;
    
    public AbtractDAO(){
        entityManager = Persistence
                .createEntityManagerFactory("GenericCRUDPU").createEntityManager();
        dateUtil = DateUtil.getInstance();
    }
    
    public void create(T entity){
        entityManager.getTransaction( ).begin( );
        entity.setState(StateEnum.ACTIVE);
        entity.setCreatedDate(dateUtil.getCurrentDate());
        entity.setUpdatedDate(dateUtil.getCurrentDate());
        entityManager.persist(entity);
        entityManager.getTransaction( ).commit( );
        entityManager.close( );
    }
    
    public void update(T entity){
        entityManager.getTransaction( ).begin( );
        entity.setUpdatedDate(dateUtil.getCurrentDate());
        entityManager.merge(entity);
        entityManager.getTransaction( ).commit( );
        entityManager.close( );
    }
    
    public void remove(T entity){
        entityManager.getTransaction( ).begin( );
        entityManager.remove(entity);
        entityManager.getTransaction( ).commit( );
        entityManager.close( );
    }
}
