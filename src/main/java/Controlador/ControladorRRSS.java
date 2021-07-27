/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Rrss;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MADICAP
 */
public class ControladorRRSS {
    
    public ArrayList<Rrss> ListarRRSS()
    {
         ArrayList<Rrss> listaRrss = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Rrss> rrsss = em.createNamedQuery("Rrss.findAll").getResultList();
         for(Rrss rrss : rrsss)
         {
             listaRrss.add(rrss);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaRrss;
    }
}
