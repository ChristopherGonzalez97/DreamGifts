/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Proveedor;
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
public class ControladorProveedor {
    
    public void AgregarProveedor(Proveedor proveedor)
    {
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(proveedor);
         em.getTransaction().commit();}
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
    public int CountProveedor()
    {
        int id=-1;
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         Query q = em.createQuery("SELECT COUNT(p.proIdProveedor) FROM Proveedor p");
         Object s = q.getSingleResult();
         id=Integer.parseInt(s.toString());
        }catch(Exception e)
                {
                e.getMessage();
                }
        return id+1;
    }
    public ArrayList<Proveedor> ListaProveedor()
    {
        
        ArrayList<Proveedor> listaProveedores = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Proveedor> proveedores = em.createNamedQuery("Proveedor.findAll").getResultList();
         for(Proveedor pro : proveedores)
         {
             listaProveedores.add(pro);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaProveedores;
    }
    public Proveedor BuscarPorId(int id)
    {
        Proveedor pro = new Proveedor();
         try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         pro =  em.find(Proveedor.class, id);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return pro;
    }
    
    public void EditarProveedor(Proveedor c)
    {
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.merge(c);
         em.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }        
    
}
