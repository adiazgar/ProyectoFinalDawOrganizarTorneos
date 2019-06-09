/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.projectofinal.metodos;

import javax.servlet.http.HttpServlet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import projecto.projectofinal.datamodel.HibernateUtil;
import projecto.projectofinal.datamodel.entities.Participante;
import projecto.projectofinal.datamodel.entities.Torneo;

/**
 *
 * @author administrador
 */
public class MetodosParticipante extends HttpServlet{
    
    public static void insertParticipante(String[] nombre, String[] apellidos, String[] edad, Torneo idTorneo){
        
        for(int i = 0; i < nombre.length; i++){
            
            int e = Integer.parseInt(edad[i]);
        
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Participante part = new Participante();

            part.setNombre(nombre[i]);
            part.setApellidos(apellidos[i]);
            part.setEdad(e);
            part.setTorneo(idTorneo);

            session.save(part);
            session.getTransaction().commit();
            session.close();
        
        }
        
    }
    
    public static void borrarParticipante(Torneo torneo){
        
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Query query = session.createQuery("DELETE FROM Participante p where p.torneo = :torneo");
            query.setParameter("torneo", torneo);

            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        
    }
    
    public static boolean esNumero(String edad) {

        boolean resultado;

        try {
            
            Integer.parseInt(edad);
            
            resultado = true;
            
        } catch (NumberFormatException excepcion) {
            
            resultado = false;
            
        }

        return resultado;
    }
    
}
