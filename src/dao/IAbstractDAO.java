/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.entity.AbstractEntity;

/**
 *
 * @author HP 240 G6
 * @param <T>
 */
public interface IAbstractDAO<T extends AbstractEntity> {
    
    void create(T entity);
    void update(T entity);
    void remove(T entity);
    
}
