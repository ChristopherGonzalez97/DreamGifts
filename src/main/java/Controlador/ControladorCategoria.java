/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CategoriaPack;
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
public class ControladorCategoria {
    public void AgregarCategoriaPack(CategoriaPack cPack)
    {
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(cPack);
         em.getTransaction().commit();}
        catch(Exception e)
        {
            e.getMessage();
        }
    }
     public void EditarCategoriaPack(CategoriaPack cPack)
    {
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.merge(cPack);
         em.getTransaction().commit();}
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    public int CountCategoriasPack()
    {
        int id=-1;
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         Query q = em.createQuery("SELECT COUNT(c.idCATEGORIAPACK) FROM CategoriaPack c");
         Object s = q.getSingleResult();
         id=Integer.parseInt(s.toString());
        }catch(Exception e)
                {
                e.getMessage();
                }
        return id+1;
    }
    
    public ArrayList<CategoriaPack> ListarCategorias()
    {
        ArrayList<CategoriaPack> listaCategoria = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<CategoriaPack> categorias = em.createNamedQuery("CategoriaPack.findAll").getResultList();
         for(CategoriaPack cat : categorias)
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
    
    public CategoriaPack BuscarPorId(int id)
    {
        CategoriaPack cPack = new CategoriaPack();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         cPack= em.find(CategoriaPack.class, id);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return cPack;
    }
    
    public CategoriaPack BuscarPorNombre(String nombre)
    {
        CategoriaPack categoria = new CategoriaPack();
        
         try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         categoria = (CategoriaPack) em.createNamedQuery("CategoriaPack.findByNombre").setParameter("nombre", nombre).getSingleResult();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
        return categoria;
    }
}
