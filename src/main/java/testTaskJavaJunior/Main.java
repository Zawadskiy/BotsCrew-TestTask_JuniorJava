package testTaskJavaJunior;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import testTaskJavaJunior.dao.DepartmentDAO;
import testTaskJavaJunior.dao.LectorDAO;
import testTaskJavaJunior.dao.impl.DepartmentDAOImpl;
import testTaskJavaJunior.dao.impl.LectorDAOImpl;
import testTaskJavaJunior.entitis.Department;
import testTaskJavaJunior.entitis.Lector;
import testTaskJavaJunior.services.DBService;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class main {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        try {

            final String departmentHead = dbService.getDepartmentHead("dep1");
            System.out.println(departmentHead);

            final String statistic = dbService.getDepartmentStatistic("dep1");
            System.out.println(statistic);

            final String averageSalary = dbService.getAverageSalary("dep2");
            System.out.println(averageSalary);

            final Integer count = dbService.showCountOfEmployee("dep3");
            System.out.println(count);

            final String globalSearch = dbService.globalSearch("lec");
            System.out.println(globalSearch);

        }
        catch (Exception e){
            System.out.println("SQLException");
        }
    }
}