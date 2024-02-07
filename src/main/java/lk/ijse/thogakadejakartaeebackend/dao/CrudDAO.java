package lk.ijse.thogakadejakartaeebackend.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T, ID, P> extends SuperDAO {
    ArrayList<T> getAll(P pool) throws SQLException, ClassNotFoundException;

    boolean save(T dto,P pool) throws SQLException, ClassNotFoundException;

    boolean update(T dto,P pool) throws SQLException, ClassNotFoundException;

    boolean exist(ID id,P pool) throws SQLException, ClassNotFoundException;

    boolean delete(ID id,P pool) throws SQLException, ClassNotFoundException;

    T search(ID id,P pool) throws SQLException, ClassNotFoundException;
}
