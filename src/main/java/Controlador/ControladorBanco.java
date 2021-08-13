/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Banco;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MADICAP
 */
public class ControladorBanco {
        public ArrayList<Banco> ListarBancos()
    {
        ArrayList<Banco> listaBanco = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Banco> bancos = em.createNamedQuery("Banco.findAll").getResultList();
         for(Banco banco : bancos)
         {
             listaBanco.add(banco);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaBanco;
    }
        
        public Banco BuscarBancoPorNombre(String nombre)
        {
            Banco banco= new Banco();
        
         try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         banco= (Banco) em.createNamedQuery("Banco.findByBanNombre").setParameter("banNombre", nombre).getSingleResult();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        return banco;
        }
}



