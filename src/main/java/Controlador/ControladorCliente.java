/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
public class ControladorCliente {
    
    public void AgregarCliente(Cliente cliente)
    {
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(cliente);
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
         Query q = em.createQuery("SELECT COUNT(c.cliIdCliente) FROM Cliente c");
         Object s = q.getSingleResult();
         id=Integer.parseInt(s.toString());
        }catch(Exception e)
                {
                e.getMessage();
                }
        return id+1;
    }
    public ArrayList<Cliente> ListaClientes()
    {
        ArrayList<Cliente> listaClientes = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Cliente> clientes = em.createNamedQuery("Cliente.findAll").getResultList();
         for(Cliente cli : clientes)
         {
             listaClientes.add(cli);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaClientes;
    }
    public Cliente BuscarPorId(int id)
    {
        Cliente cli = new Cliente();
         try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         cli =  em.find(Cliente.class, id);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return cli;
    }
    
    public void EditarCliente(Cliente c)
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
