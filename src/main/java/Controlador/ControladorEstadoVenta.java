/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EstadoVenta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MADICAP
 */
public class ControladorEstadoVenta {
     public EstadoVenta BuscarPorID(int id)
    {
        EstadoVenta estadoVenta = new EstadoVenta();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         estadoVenta =  em.find(EstadoVenta.class, id);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return estadoVenta;
    }
}
