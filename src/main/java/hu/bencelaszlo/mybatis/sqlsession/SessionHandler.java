package hu.bencelaszlo.mybatis.sqlsession;

import hu.bencelaszlo.mybatis.entity.Car;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


/**
 * Handles SQL sessions and operations.
 */
public class SessionHandler {
    private SessionFactory sessionFactory;
    private SqlSession session;

    /**
     * Instantiates a new SQL-session handler.
     */
    public SessionHandler() {
        sessionFactory = new SessionFactory();
    }

    /**
     * Runs an insert statement.
     *
     * @param <parameterType> the type parameter
     * @param statementId     the SQL statement id
     * @param parameter       the parameter
     * @param parameterType   the parameter type
     */
    public <parameterType> void insert(String statementId, Object parameter, Class parameterType) {
        getSession().insert(statementId, (parameterType)parameter);
        commitSession();
        closeSession();
    }

    /**
     * Runs an update statement.
     *
     * @param <parameterType> the type parameter
     * @param statementId     the SQL statement id
     * @param parameter       the parameter
     * @param parameterType   the parameter type
     */
    public <parameterType> void update(String statementId, Object parameter, Class parameterType) {
        getSession().insert(statementId, (parameterType)parameter);
        commitSession();
        closeSession();
    }

    /**
     * Runs a delete statement.
     *
     * @param statementId the SQL statement id
     */
    public void delete(String statementId) {
        getSession().delete(statementId);
        commitSession();
        closeSession();
    }

    /**
     * Runs a delete statement.
     *
     * @param <parameterType> the type parameter
     * @param statementId     the statement id
     * @param parameter       the parameter
     * @param parameterType   the parameter type
     */
    public <parameterType> void delete(String statementId, Object parameter, Class parameterType) {
        getSession().delete(statementId, (parameterType)parameter);
        commitSession();
        closeSession();
    }

    /**
     * Runs a select statement. Returns a Car.
     *
     * @param <parameterType> the type parameter
     * @param statementId     the SQL statement id
     * @param parameter       the parameter
     * @param parameterType   the parameter type
     * @return the car
     */
    public <parameterType> Car select(String statementId, Object parameter, Class parameterType) {
        Car car = getSession().selectOne(statementId, (parameterType)parameter);
        closeSession();

        return car;
    }

    /**
     * Runs a select statement. Returns a List<Car>.
     *
     * @param statementId the SQL statement id
     * @return the list
     */
    public List<Car> select(String statementId) {
        List<Car> cars = getSession().selectList(statementId);
        closeSession();

        return cars;
    }

    /**
     * Gets an SQL session.
     * @return an SqlSession session.
     */
    private SqlSession getSession() {
        this.session = sessionFactory.getSqlSessionFactory().openSession();
        return this.session;
    }

    /**
     * Commits a session.
     */
    private void commitSession() {
        this.session.commit();
    }

    /**
     * Closes a session.
     */
    private void closeSession() {
        this.session.close();
    }
}
