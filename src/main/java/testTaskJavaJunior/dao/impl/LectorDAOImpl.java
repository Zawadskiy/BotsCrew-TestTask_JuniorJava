package testTaskJavaJunior.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import testTaskJavaJunior.MyDegree;
import testTaskJavaJunior.entitis.Department;
import testTaskJavaJunior.entitis.Lector;
import testTaskJavaJunior.dao.LectorDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;

public class LectorDAOImpl implements LectorDAO {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public String globalSearch(String search) throws SQLException {
        String result="";
        try {
            Session session = sessionFactory.openSession();

            Query query = session.createQuery("Select name FROM Lector l WHERE l.name like :search ");
            query.setParameter("search", "%" + search + "%");
            List<String> names = query.list();

            for (String name: names) {
                if(result=="")
                 result += name;
                else result += ", " +name ;

            }

            return result;
        }catch (Exception e){
            System.out.println(e);
        }
        throw new SQLException();
    }
}
