/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
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
public class ControladorUsuario {

    public ControladorUsuario() {
    }
    
    public void AgregarUsuario(Usuario user)
    {
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         em.persist(user);
         em.getTransaction().commit();}
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
    public int CountUsers()
    {
        int id=-1;
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         Query q = em.createQuery("SELECT COUNT(u.usuIdUsuario) FROM Usuario u");
         Object s = q.getSingleResult();
         id=Integer.parseInt(s.toString());
        }catch(Exception e)
                {
                e.getMessage();
                }
        return id;
    }
    public ArrayList<Usuario> ListaUsuarios()
    {
        
        ArrayList<Usuario> usuarios = new ArrayList();
        try{
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();
         List<Usuario> us = em.createNamedQuery("Usuario.findAll").getResultList();
         for(Usuario u : us)
         {
             usuarios.add(u);
         }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return usuarios;
    }
    public Usuario BuscarPorId(int id)
    {
        Usuario user = new Usuario();
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        user = em.find(Usuario.class, id);
        return user;
    }
    
    public void EditarUsuario(Usuario u)
    {
        Usuario user = new Usuario();
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("com.mycompany_AppDreamGifts_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        user = em.find(Usuario.class, u.getUsuIdUsuario());
        user = u;
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
}
