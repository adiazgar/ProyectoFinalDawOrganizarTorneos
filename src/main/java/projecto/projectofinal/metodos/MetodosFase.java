/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.projectofinal.metodos;

import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServlet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import projecto.projectofinal.datamodel.HibernateUtil;
import projecto.projectofinal.datamodel.entities.Fase;
import projecto.projectofinal.datamodel.entities.Torneo;

/**
 *
 * @author administrador
 */
public class MetodosFase extends HttpServlet{
    
    public static void crearFase(Torneo torneo){
        
       final String fin = "Final";
       final String semi = "Semifinal";
       final String cuartos = "Cuartos de final";
       final String octavos = "Octavos de final";
       String tipo = "";
       
        switch (torneo.getCantidaParticipantes()) {
            case 2:
                tipo = fin;
                break;
            case 4:
                tipo = semi;
                break;
            case 8:
                tipo = cuartos;
                break;
            default:
                tipo = octavos;
                break;
        }
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        
        Fase fase = new Fase();

        fase.setNombreFase(tipo);
        fase.setTorneo(torneo);

        session.save(fase);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public static Fase recogerFase(Torneo idTorneo){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Fase f where f.torneo = :idTorneo order by f.idFase desc");
        query.setParameter("idTorneo", idTorneo);
        
        List<Fase> fase = query.list();
        
        if(fase.isEmpty()){
            
            return null;
            
        }else{
            
            return fase.get(0);
            
        }
        
    }
    
    public static List<Fase> buscarFase(Torneo torneo){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Fase f where f.torneo = :torneo order by f.idFase asc");
        query.setParameter("torneo", torneo);
        
        List<Fase> fase = query.list();
        
        if(fase.isEmpty()){
            
            return null;
            
        }else{
            
            return fase;
            
        }
        
    }
    
    public static long numeroFase(Torneo torneo){
        
        long num = 0;
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("Select count(*) FROM Fase f where f.torneo = :torneo");
        query.setParameter("torneo", torneo);
        
        for(Iterator it = query.iterate();it.hasNext();){
            
            num = (Long) it.next();
   
            }
        
        if(num == 0){
            
            return 0;
            
        }else{
            
            return num;
            
        }
        
    }
    
    public static void borrarFase(Torneo torneo){
        
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Query query = session.createQuery("DELETE FROM Fase f where f.torneo = :torneo");
            query.setParameter("torneo", torneo);
            
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        
    }
    
}
