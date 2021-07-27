/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comuna;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MADICAP
 */
public class ControladorComuna {
    public ArrayList<Comuna> ListarComunas()
    {
        
         ArrayList<Comuna> listaComuna = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Comuna> comunas = em.createNamedQuery("Comuna.findAll").getResultList();
         for(Comuna comuna : comunas)
         {
             listaComuna.add(comuna);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaComuna;
    }
            
}
