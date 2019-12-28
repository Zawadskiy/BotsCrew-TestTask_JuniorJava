package testTaskJavaJunior.services;

import testTaskJavaJunior.dao.DepartmentDAO;
import testTaskJavaJunior.dao.LectorDAO;
import testTaskJavaJunior.dao.impl.DepartmentDAOImpl;
import testTaskJavaJunior.dao.impl.LectorDAOImpl;

import java.sql.SQLException;

public class DBService {
    DepartmentDAO departmentDAO =new DepartmentDAOImpl();
    LectorDAO lectorDAO = new LectorDAOImpl();


    public String getDepartmentHead(String depName) throws SQLException{
       return departmentDAO.getDepartmentHead(depName);
    }

    public String getDepartmentStatistic(String depName) throws SQLException{
        return departmentDAO.getDepartmentStatistic(depName);
    }

    public String getAverageSalary(String depName) throws SQLException{
        return departmentDAO.getAverageSalary(depName);
    }

    public Integer showCountOfEmployee(String depName)throws SQLException{
        return  departmentDAO.showCountOfEmployee(depName);
    }
    public String globalSearch(String search) throws SQLException{
        return lectorDAO.globalSearch(search);
    }
}
