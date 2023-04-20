package by.karnilovich.db.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionManager.class);
    private static final String DATA_SOURCE_PROP_FILE = "datasource.properties";

    private static volatile DataSource dataSource;


    private ConnectionManager() {
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            synchronized (ConnectionManager.class) {
                // firstly try to use JNDI resource
                try {
                    InitialContext initialContext = new InitialContext();
                    dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/rc_DB_link");
                } catch (Exception e) {
                    LOGGER.error(e);
                }

                // if JNDI resource not found use properties file from resources, mostly unit tests
                if (dataSource == null) {
                    try {
                        InputStream inputStream = ClassLoader.getSystemResourceAsStream(DATA_SOURCE_PROP_FILE);
                        Properties properties = new Properties();
                        properties.load(inputStream);

                        HikariConfig config = new HikariConfig(properties);
                        dataSource = new HikariDataSource(config);
//                        Connection connection = DriverManager.getConnection("", "", "");
                    } catch (Exception e) {
                        LOGGER.error(e);
                    }
                }
            }
        }
        if (dataSource == null) {
            throw new SQLException("Unable to establish connection with database");
        }
        return dataSource.getConnection();
    }
}
