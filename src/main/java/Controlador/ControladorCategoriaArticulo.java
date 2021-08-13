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
import javax.persistence.Query;

/**
 *
 * @author MADICAP
 */
public class ControladorCategoriaArticulo {
    
    public void AgregarCategoria(CategoriaArticulo categoria)
    {
         try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(categoria);
         em.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
    public int CountCategoriasArticulos()
    {
        int id=-1;
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         Query q = em.createQuery("SELECT COUNT(c.categoriaArticulo) FROM CategoriaArticulo c");
         Object s = q.getSingleResult();
         id=Integer.parseInt(s.toString());
        }catch(Exception e)
                {
                e.getMessage();
                }
        return id+1;
    }
    
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
    public CategoriaArticulo BuscarPorId(int id)
    {
        CategoriaArticulo categoria = new CategoriaArticulo();
        
         try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         categoria = em.find(CategoriaArticulo.class, id);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        return categoria;
    }
    public void EditarCategoria(CategoriaArticulo categoria)
    {
         try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.merge(categoria);
         em.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
     public ArrayList<CategoriaArticulo> Busqueda(String buscar)
    {
        ArrayList<CategoriaArticulo> listaCategoria = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         buscar = buscar +"%";
         List<CategoriaArticulo> categorias = em.createNamedQuery("CategoriaArticulo.buscador").setParameter("buscar", buscar).getResultList();
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
}

