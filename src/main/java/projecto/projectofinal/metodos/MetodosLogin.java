/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.projectofinal.metodos;
import projecto.projectofinal.datamodel.HibernateUtil;
import java.util.List;
import javax.servlet.http.HttpServlet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import projecto.projectofinal.datamodel.entities.Organizador;


/**
 *
 * @author administrador
 */
public class MetodosLogin extends HttpServlet{
    
    public static Organizador Login(String nombre, String password){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM Organizador o where o.nombre = :nombre and o.password = :password");
        query.setParameter("nombre", nombre);
        query.setParameter("password", password);
        List<Organizador> login = query.list();
        
        if(login.isEmpty()){
            
            return null;
            
        }else{
            
            return login.get(0);
            
        }
        
    }
    
}
