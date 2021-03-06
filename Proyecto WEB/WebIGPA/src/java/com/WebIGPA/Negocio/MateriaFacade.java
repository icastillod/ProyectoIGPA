/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebIGPA.Negocio;

import com.WebIGPA.Entitys.Materia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yerard
 */
@Stateless
public class MateriaFacade extends AbstractFacade<Materia> {

    @PersistenceContext(unitName = "WebIGPAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaFacade() {
        super(Materia.class);
    }
    
}
