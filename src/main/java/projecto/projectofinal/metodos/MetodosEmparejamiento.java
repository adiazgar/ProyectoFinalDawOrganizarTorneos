/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.projectofinal.metodos;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServlet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import projecto.projectofinal.datamodel.HibernateUtil;
import projecto.projectofinal.datamodel.entities.Enparejamiento;
import projecto.projectofinal.datamodel.entities.Fase;
import projecto.projectofinal.datamodel.entities.Participante;
import projecto.projectofinal.datamodel.entities.Torneo;

/**
 *
 * @author administrador
 */
public class MetodosEmparejamiento extends HttpServlet{
    
    public static List<Participante> recogerParticipante(Torneo idTorneo){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Participante p where p.torneo = :idTorneo order by p.torneo asc");
        query.setParameter("idTorneo", idTorneo);
        
        List<Participante> part = query.list();
        
        if(part.isEmpty()){
            
            return null;
            
        }else{
            
            return part;
            
        }
        
    }
    
    public static List<Participante> mezclarParticipante(List<Participante> part){
        
        Collections.shuffle(part);
        
        return part;
        
    }
    
    public static void insertEmparejamiento(List<Participante> part ,Fase fase){
        int[] num ={1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8};
        String partido = "Emparejamiento";
        
        for(int t = 0; t < part.size(); t = t + 2){
            
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Enparejamiento em = new Enparejamiento();

            em.setIdP1(part.get(t).getIdParticipante());
            em.setNombreP1(part.get(t).getNombre());
            em.setApellidosP1(part.get(t).getApellidos());
            em.setIdP2(part.get(t + 1).getIdParticipante());
            em.setNombreP2(part.get(t + 1).getNombre());
            em.setApellidosP2(part.get(t + 1).getApellidos());
            em.setNombreEmparejamiento(partido + " " + num[t]);
            em.setFase(fase);

            session.save(em);
            session.getTransaction().commit();
            session.close();
            
        }
        
    }
    
    public static List<Enparejamiento> recogerEmparejamiento(Fase fase){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Enparejamiento e where e.fase = :idFase");
        query.setParameter("idFase", fase);
        
        List<Enparejamiento> em = query.list();
        
        if(em.isEmpty()){
            
            return null;
            
        }else{
            
            return em;
            
        }
        
    }
    
    public static Participante participantesNuevoEmparejamiento( String idParticipante){
        
        Participante p;
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Participante p where p.idParticipante = :idParticipante order by p.idParticipante asc");
        query.setParameter("idParticipante", Integer.parseInt(idParticipante));
        
        p = (Participante) query.uniqueResult();
        
        if(p == null){
            
            return null;
            
        }else{
            
            return p;
            
        }
        
    }
    
    public static void borrarEmparejamiento(Fase fase){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Query query = session.createQuery("DELETE FROM Enparejamiento e where e.fase = :fase");
            query.setParameter("fase", fase);

            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        
    }
    
    
}
