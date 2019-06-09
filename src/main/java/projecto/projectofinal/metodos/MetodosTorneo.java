/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.projectofinal.metodos;

import java.util.List;
import javax.servlet.http.HttpServlet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import projecto.projectofinal.datamodel.HibernateUtil;
import projecto.projectofinal.datamodel.entities.Torneo;


/**
 *
 * @author administrador
 */
public class MetodosTorneo extends HttpServlet{
    
    public static void crearTorneo(String nombre, String deporte, String estado, int numero){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        
        Torneo torneo = new Torneo();

        torneo.setNombreTorneo(nombre);
        torneo.setDeporte(deporte);
        torneo.setEstado(estado);
        torneo.setCantidaParticipantes(numero);

        session.save(torneo);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public static boolean existeTorneo(){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Torneo");
        
        List<Torneo> torneo = query.list();
        
        if(torneo.isEmpty()){
            
            return false;
            
        }else{
            
            return true;
            
        }
        
    }
    
    public static Torneo idTorneo(String nombre, String deporte, int numero){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Torneo t where t.nombreTorneo = :nombre and"
                + " t.deporte = :deporte and t.cantidaParticipantes =:numero");
        query.setParameter("nombre", nombre);
        query.setParameter("deporte", deporte);
        query.setParameter("numero", numero);
        List<Torneo> id = query.list();
        
        if(id.isEmpty()){
            
            return null;
            
        }else{
            
            return id.get(0);
            
        }
        
    }
    
    public static boolean existeNombreTorneo(String nombre){
    
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Torneo t where t.nombreTorneo = :nombre");
        query.setParameter("nombre", nombre);
        
        List<Torneo> torneo = query.list();
        
        if(torneo.isEmpty()){
            
            return false;
            
        }else{
            
            return true;
            
        }
    
    }
    
    public static void actualizarCantidadParticipanteTorneo(Torneo tor){
        
        int nuevacantidad = 0;
        
        switch (tor.getCantidaParticipantes()) {
            case 16:
                nuevacantidad = 8;
                break;
            case 8:
                nuevacantidad = 4;
                break;
            case 4:
                nuevacantidad = 2;
                break;
            default:
                nuevacantidad = 1;
                break;
        }
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();

        tor.setCantidaParticipantes(nuevacantidad);
        
        session.merge(tor);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public static void cambiarEstadoTorneo(Torneo torneo){
        
        String estado = "";
        
        if(torneo.getCantidaParticipantes() == 1){
          
            estado = "Terminado";

        }else{
        
            estado = "En proceso";

        }
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();

        torneo.setEstado(estado);
        
        session.merge(torneo);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public static List<Torneo> torneosActivos(){
        
        String estado = "En proceso";
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Torneo t where t.estado = :estado order by t.idTorneo asc");
        query.setParameter("estado", estado);
        
        List<Torneo> torneo = query.list();
        
        if(torneo.isEmpty()){
            
            return null;
            
        }else{
            
            return torneo;
            
        }
        
    }
    
    public static List<Torneo> torneosTerminados(){
        
        String estado = "Terminado";
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Torneo t where t.estado = :estado order by t.idTorneo asc");
        query.setParameter("estado", estado);
        
        List<Torneo> torneo = query.list();
        
        if(torneo.isEmpty()){
            
            return null;
            
        }else{
            
            return torneo;
            
        }
        
    }
    
    public static Torneo buscarTorneo(String nombreTorneo){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Torneo t where t.nombreTorneo = :nombreTorneo");
        query.setParameter("nombreTorneo", nombreTorneo);
        
        List<Torneo> torneo = query.list();
        
        if(torneo.isEmpty()){
            
            return null;
            
        }else{
            
            return torneo.get(0);
            
        }
        
    }
    
    public static void borrarTorneo(Torneo torneo){
        
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Query query = session.createQuery("DELETE FROM Torneo t where t.idTorneo = :torneo");
            query.setParameter("torneo", torneo.getIdTorneo());

            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        
    }
    
    public static List<Torneo> torneoAbierto(){
        
       String estado = "abierto";
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Torneo t where t.estado = :estado order by t.idTorneo asc");
        query.setParameter("estado", estado);
        
        List<Torneo> torneo = query.list();
        
        if(torneo.isEmpty()){
            
            return null;
            
        }else{
            
            return torneo;
            
        }
        
    }
    
}
