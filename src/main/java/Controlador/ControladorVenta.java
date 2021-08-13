/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Venta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author MADICAP
 */
public class ControladorVenta {
    public void AgregarVenta(Venta venta)
    {
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(venta);
         em.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    public void EditarVenta(Venta venta)
    {
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.merge(venta);
         em.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
    public int CountPack(){
        int id=0;
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         Query q = em.createQuery("SELECT COUNT(v.vtaIdVenta) FROM Venta v");
         Object s = q.getSingleResult();
         id=Integer.parseInt(s.toString());
        }catch(Exception e)
                {
                e.getMessage();
                }
        return id+1;
    }
    public ArrayList<Venta> ListarVentas()
    {
        ArrayList<Venta> listaVentas = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Venta> ventas = em.createNamedQuery("Venta.findAll").getResultList();
         for(Venta venta: ventas)
         {
             listaVentas.add(venta);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaVentas;
    }
     public ArrayList<Venta> ListarVentasSinPagar()
    {
        ArrayList<Venta> listaVentas = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Venta> ventas = em.createNamedQuery("Venta.findAll").getResultList();
         for(Venta venta: ventas)
         {
             if(venta.getBanIdBanco()==null)
             {
                 listaVentas.add(venta);
             }
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaVentas;
    }
    
     public ArrayList<Venta> ListarVentasADespachar()
    {
        ArrayList<Venta> listaVentas = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Venta> ventas = em.createNamedQuery("Venta.findAll").getResultList();
         for(Venta venta: ventas)
         {
             if(venta.getBanIdBanco()!=null)
             {
                 listaVentas.add(venta);
             }
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaVentas;
    }
    
    public Venta BuscarPorId(int id)
    {
        Venta venta = new Venta();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         venta =  em.find(Venta.class, id);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return venta;
    }
    
    public ArrayList<Venta> BuscarPorFechas(Date desde, Date hasta)
    {
        ArrayList<Venta> ventas = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         Query q = em.createNamedQuery("Venta.findBetweenFechas");
         q.setParameter("fechaInicial", desde);
         q.setParameter("fechaFinal", hasta);
         List<Venta> venta = q.getResultList();
         for(Venta v: venta)
         {
             ventas.add(v);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return ventas;
        
    }
    
    public ArrayList<Venta> BuscarVentaPorRut(String rut)
    {
        ArrayList<Venta> ventas = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         Cliente cli = (Cliente) em.createNamedQuery("Cliente.findByCliRut").setParameter("cliRut", rut).getSingleResult();
         List<Venta> venta = cli.getVentaList();
         for(Venta v: venta)
         {
             ventas.add(v);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return ventas;
        
    }
    
    public ArrayList<Venta> ListarVentasCanceladas()
    {
        ArrayList<Venta> listaVentas = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Venta> ventas = em.createNamedQuery("Venta.findAll").getResultList();
         for(Venta venta: ventas)
         {
             if(venta.getEstadoVentaIdEstado().getIdEstado()==4)
             {
                 listaVentas.add(venta);
             }
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaVentas;
    }
    public ArrayList<Venta> BuscarPorFechasCanceladas(Date desde, Date hasta)
    {
        ArrayList<Venta> ventas = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         Query q = em.createNamedQuery("Venta.findBetweenFechas");
         q.setParameter("fechaInicial", desde);
         q.setParameter("fechaFinal", hasta);
         List<Venta> venta = q.getResultList();
         for(Venta v: venta)
         {
             if(v.getEstadoVentaIdEstado().getIdEstado()==4)
             {
                 ventas.add(v);
             }
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return ventas;
        
    }
}
