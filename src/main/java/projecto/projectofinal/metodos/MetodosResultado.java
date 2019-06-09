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
import projecto.projectofinal.datamodel.entities.Enparejamiento;
import projecto.projectofinal.datamodel.entities.Fase;
import projecto.projectofinal.datamodel.entities.Participante;
import projecto.projectofinal.datamodel.entities.Resultado;
import projecto.projectofinal.datamodel.entities.Torneo;

/**
 *
 * @author administrador
 */
public class MetodosResultado extends HttpServlet{
    
    public static List<Torneo> buscarTorneos(){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Torneo t where t.estado = :estado order by t.idTorneo asc");
        query.setParameter("estado", "En proceso");
        
        List<Torneo> torneo = query.list();
        
        if(torneo.isEmpty()){
            
            return null;
            
        }else{
            
            return torneo;
            
        }
        
    }
    
    public static Fase buscarFase(Torneo torneo){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Fase f where f.torneo = :torneo order by f.idFase desc");
        query.setParameter("torneo", torneo);
        
        List<Fase> fase = query.list();
        
        if(fase.isEmpty()){
            
            return null;
            
        }else{
            
            return fase.get(0);
            
        }
        
    }
    
    public static List<Enparejamiento> buscarEmparejamiento(Fase fase){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Enparejamiento e where e.fase = :fase order by e.idEnparejamiento asc");
        query.setParameter("fase", fase);
        
        List<Enparejamiento> em = query.list();
        
        if(em.isEmpty()){
            
            return null;
            
        }else{
            
            return em;
            
        }
        
    }
    
    public static List<Torneo> torneoEscogido(String nombre){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Torneo t where t.nombreTorneo = :nombre");
        query.setParameter("nombre", nombre);
        
        List<Torneo> torneo = query.list();
        
        if(torneo.isEmpty()){
            
            return null;
            
        }else{
            
            return torneo;
            
        }
        
    }
    
    public static Fase faseEscogida(String fase, Torneo torneo){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Fase f where f.nombreFase = :fase and f.torneo = :torneo");
        query.setParameter("fase", fase);
        query.setParameter("torneo", torneo);
        
        List<Fase> fa = query.list();
        
        if(fa.isEmpty()){
            
            return null;
            
        }else{
            
            return fa.get(0);
            
        }
        
    }
    
    public static void insertResultado(List<Participante> part, Fase fase){
        
        for(Participante p : part){
            
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Resultado res = new Resultado();

            res.setIdPganador(p.getIdParticipante());
            res.setNombreGanador(p.getNombre());
            res.setApellidosGanador(p.getApellidos());
            res.setFase(fase);

            session.save(res);
            session.getTransaction().commit();
            session.close();
            
        }
        
    }
    
    public static List<Resultado> recogerResultado(Fase ultimaFase){
        
         SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Resultado r where r.fase = :ultimaFase order by idResultado asc");
        query.setParameter("ultimaFase", ultimaFase);
        
        List<Resultado> res = query.list();
        
        if(res.isEmpty()){
            
            return null;
            
        }else{
            
            return res;
            
        }
        
    }
    
    public static boolean existeGanador(Fase fase){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Resultado r where r.fase = :fase");
        query.setParameter("fase", fase);
        
        List<Resultado> res = query.list();
        
        if(res.isEmpty()){
            
            return false;
            
        }else{
            
            return true;
            
        }
        
    }
    
    public static void borrarResultado(Fase fase){
        
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Query query = session.createQuery("DELETE FROM Resultado r where r.fase = :fase");
            query.setParameter("fase", fase);

            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        
    }
    
}
