package lk.ijse.thogakadejakartaeebackend.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T, ID, DBCP> extends SuperDAO {
    ArrayList<T> getAll(DBCP dbcp) throws SQLException, ClassNotFoundException;

    boolean save(T dto, DBCP dbcp) throws SQLException, ClassNotFoundException;

    boolean update(T dto, DBCP dbcp) throws SQLException, ClassNotFoundException;

    boolean exist(ID id, DBCP dbcp) throws SQLException, ClassNotFoundException;

    boolean delete(ID id, DBCP dbcp) throws SQLException, ClassNotFoundException;

    T search(ID id, DBCP dbcp) throws SQLException, ClassNotFoundException;
}
