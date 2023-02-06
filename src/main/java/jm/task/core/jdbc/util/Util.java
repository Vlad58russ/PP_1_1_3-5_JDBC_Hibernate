package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String userName = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/usertest";
    private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_Driver);
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection ERROR");
            e.printStackTrace();
        }
        return connection;
    }

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/usertest?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");

                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "");

                Configuration configuration = new Configuration()
                        .setProperties(settings)
                        .addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException he) {
                he.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.getCurrentSession();
    }
}

