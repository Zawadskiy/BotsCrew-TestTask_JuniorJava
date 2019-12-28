package testTaskJavaJunior.dao;

import testTaskJavaJunior.MyDegree;
import testTaskJavaJunior.entitis.Department;
import testTaskJavaJunior.entitis.Lector;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public interface DepartmentDAO {

    public String getDepartmentHead(String depName) throws SQLException;

    public String getDepartmentStatistic(String depName) throws SQLException;

    public String getAverageSalary(String depName) throws SQLException;

    public Integer showCountOfEmployee(String depName)throws SQLException;

}