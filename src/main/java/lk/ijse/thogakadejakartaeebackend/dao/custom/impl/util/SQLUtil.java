package lk.ijse.thogakadejakartaeebackend.dao.custom.impl.util;

import jakarta.annotation.Resource;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static <T>T execute( DataSource pool,String sql, Object... args) throws SQLException, ClassNotFoundException {
        try(Connection connection = pool.getConnection()){
            PreparedStatement pstm = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstm.setObject((i+1),args[i]);
            }
            if (sql.startsWith("SELECT") || sql.startsWith("select")){
                return (T) pstm.executeQuery();
            }else{
                return (T)  new Boolean(pstm.executeUpdate()>0);
            }
        }
    }
}
