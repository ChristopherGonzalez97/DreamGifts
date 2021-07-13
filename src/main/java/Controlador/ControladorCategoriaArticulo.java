/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CategoriaArticulo;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MADICAP
 */
public class ControladorCategoriaArticulo {
    public ArrayList<CategoriaArticulo> ListarCategorias()
    {
        ArrayList<CategoriaArticulo> listaCategoria = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<CategoriaArticulo> categorias = em.createNamedQuery("CategoriaArticulo.findAll").getResultList();
         for(CategoriaArticulo cat : categorias)
         {
             listaCategoria.add(cat);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaCategoria;
    }
    public CategoriaArticulo BuscarPorNombre(String nombre)
    {
        CategoriaArticulo categoria = new CategoriaArticulo();
        
         try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         categoria = (CategoriaArticulo) em.createNamedQuery("CategoriaArticulo.findByCatNombre").setParameter("catNombre", nombre).getSingleResult();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        return categoria;
    }
}
