package testTaskJavaJunior.dao;

import testTaskJavaJunior.entitis.Department;
import testTaskJavaJunior.entitis.Lector;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface LectorDAO {
    public String globalSearch(String search) throws SQLException;
}
