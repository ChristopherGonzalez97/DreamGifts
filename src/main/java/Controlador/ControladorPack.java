/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetallePack;
import Modelo.DetallePackPK;
import Modelo.Pack;
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
public class ControladorPack {
    public void AgregarPack(Pack pack)
    {
        List<DetallePack> dPacks = pack.getDetallePackList();
        
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(pack);
         for(DetallePack dpck:dPacks)
        {   
            DetallePackPK detallePackPK = new DetallePackPK();
            detallePackPK.setArtIdArticulo(dpck.getArticulo().getArtIdArticulo());
            detallePackPK.setPckIdPack(pack.getPckIdPack());
            dpck.setDetallePackPK(detallePackPK);
            em.persist(dpck);
        }
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
         Query q = em.createQuery("SELECT COUNT(p.pckIdPack) FROM Pack p");
         Object s = q.getSingleResult();
         id=Integer.parseInt(s.toString());
        }catch(Exception e)
                {
                e.getMessage();
                }
        return id+1;
    }
    public ArrayList<Pack> ListarPacks()
    {
        ArrayList<Pack> listaPacks = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Pack> packs = em.createNamedQuery("Pack.findAll").getResultList();
         for(Pack pack : packs)
         {
             listaPacks.add(pack);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return listaPacks;
    }
    
    public Pack BuscarPorID(int id)
    {
        Pack pack = new Pack();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         pack =  em.find(Pack.class, id);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return pack;
    }
    
    public void EditarPack(Pack pack)
    {
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.merge(pack);
         em.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        
    }
}
