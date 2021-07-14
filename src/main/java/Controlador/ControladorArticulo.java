/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulo;
import Modelo.CategoriaArticulo;
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
public class ControladorArticulo {
    public void AgregarArticulo(Articulo articulo)
    {
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(articulo);
         em.getTransaction().commit();}
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
    public int CountClientes()
    {
        int id=-1;
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         Query q = em.createQuery("SELECT COUNT(a.artIdArticulo) FROM Articulo a");
         Object s = q.getSingleResult();
         id=Integer.parseInt(s.toString());
        }catch(Exception e)
                {
                e.getMessage();
                }
        return id+1;
    }
    
    public ArrayList<Articulo> ListarArticulos()
    {
        ArrayList<Articulo> listaArticulo = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Articulo> articulos = em.createNamedQuery("Articulo.findAll").getResultList();
         for(Articulo art : articulos)
         {
             listaArticulo.add(art);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        return listaArticulo;
    }
    
    public Articulo BuscarPorId(int id)
    {
        Articulo art = new Articulo();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         art =  em.find(Articulo.class, id);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return art;
    }
    
    public void EditarArticulo(Articulo articulo)
    {
         try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.merge(articulo);
         em.getTransaction().commit();}
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    public ArrayList<Articulo> Busqueda(String buscar)
    {
         ArrayList<Articulo> listaArticulo = new ArrayList();
        try{
        EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         buscar = buscar+"%";
         List<Articulo> articulos = em.createNamedQuery("Articulo.buscador").setParameter("buscar", buscar).getResultList();
         for(Articulo art : articulos)
         {
             listaArticulo.add(art);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        return listaArticulo;
    }
}
