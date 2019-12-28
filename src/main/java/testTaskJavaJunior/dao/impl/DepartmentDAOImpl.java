package testTaskJavaJunior.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Formula;
import org.hibernate.cfg.Configuration;
import testTaskJavaJunior.MyDegree;
import testTaskJavaJunior.entitis.Department;
import testTaskJavaJunior.dao.DepartmentDAO;
import testTaskJavaJunior.entitis.Lector;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDAOImpl implements DepartmentDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public String getDepartmentHead(String depName) throws SQLException {
        try {
            Session session = sessionFactory.openSession();

            Query query = session.createQuery("FROM Department D WHERE D.department_name = :depName");
            query.setParameter("depName", depName);
            List<Department> department = query.list();
            Department department1 = department.get(0);
            session.close();
            return "Head of " + depName + " department is " + department1.getHead_of_department();

        } catch (Exception e) {
            System.out.println("Ex");
        }
        return("Head of "+ depName +" not found");
    }

    public String getDepartmentStatistic(String depName) throws SQLException {

        int professorCount = 0;
        int associate_professorCount = 0;
        int assistantCount = 0;

        try {
            Session session = sessionFactory.openSession();

            Query query = session.createQuery("FROM Department D WHERE D.department_name = :depName");
            query.setParameter("depName", depName);
            List<Department> department = query.list();
            Department department1 = department.get(0);

            final Long id = department1.getId();

            Query queryId = session.createQuery("SELECT l FROM Lector l JOIN l.departments d WHERE d.id = :depId");
            queryId.setParameter("depId", id);
            final List<Lector> list = queryId.list();

            for(Lector lec: list){
                if(lec.getDegree()==MyDegree.assistant) assistantCount++;
                else if (lec.getDegree()==MyDegree.associate_professor) associate_professorCount++;
                else professorCount++;
            }

            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "assistants - " + assistantCount + "\n" +
                "associate professors - "+ associate_professorCount + "\n" +
                "professors - " + professorCount;
    }

    public String getAverageSalary(String depName) throws SQLException {
        Integer result = 0;
        try {
            Session session = sessionFactory.openSession();

            Query query = session.createQuery("FROM Department D WHERE D.department_name = :depName");
            query.setParameter("depName", depName);
            List<Department> department = query.list();
            Department department1 = department.get(0);

            final Long id = department1.getId();

            Query queryId = session.createQuery("SELECT l FROM Lector l JOIN l.departments d WHERE d.id = :depId");
            queryId.setParameter("depId", id);
            final List<Lector> list = queryId.list();

            for(Lector lec: list){
               result+=lec.getSalary();
            }
            if(list.size()!=0) result = result/list.size();

            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "The average salary of " + depName + " is " + result
        ;
    }

    public Integer showCountOfEmployee(String depName) throws SQLException {
        try {
            Session session = sessionFactory.openSession();

            Query query = session.createQuery("FROM Department D WHERE D.department_name = :depName");
            query.setParameter("depName", depName);
            List<Department> department = query.list();
            Department department1 = department.get(0);

            final Long id = department1.getId();

            Query queryId = session.createQuery("SELECT l FROM Lector l JOIN l.departments d WHERE d.id = :depId");
            queryId.setParameter("depId", id);
            final List<Lector> list = queryId.list();
            session.close();

            return list.size();

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
