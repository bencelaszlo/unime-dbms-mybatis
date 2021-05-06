package hu.bencelaszlo.mybatis.sqlsession;

import hu.bencelaszlo.mybatis.utils.Constants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * Singleton SQL-session factory class.
 */
public class SessionFactory {
    private SqlSessionFactory sqlSessionFactory;

    /**
     * Gets SQL-session factory. If it does not exist yet it instantiates one.
     *
     * @return the sql session factory
     */
    public SqlSessionFactory getSqlSessionFactory() {
        if (this.sqlSessionFactory == null) {
            try {
                InputStream inputStream = Resources.getResourceAsStream(Constants.MYBATIS_CONFIG_FILE);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        return this.sqlSessionFactory;
    }
}
