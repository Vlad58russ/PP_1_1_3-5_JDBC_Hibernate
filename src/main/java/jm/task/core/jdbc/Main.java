package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = Util.getSessionFactory().openSession();
        UserDao userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Name1", "LastName1", (byte) 3);
        userDaoHibernate.saveUser("Name2", "LastName2", (byte) 5);
        userDaoHibernate.saveUser("Name3", "LastName3", (byte) 7);
        userDaoHibernate.saveUser("Name4", "LastName4", (byte) 9);
        userDaoHibernate.removeUserById(1);
        userDaoHibernate.getAllUsers();
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();
    }
}
