package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Vlad", "Schhennikov", (byte) 27);
        userService.saveUser("Lena", "Schhennikova", (byte) 19);
        userService.saveUser("Lexa", "Schhennikov", (byte) 34);
        userService.saveUser("Vova", "Schhennikov", (byte) 57);

        userService.removeUserById(1);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

        Util.closeConnection(Util.getConnection());
    }
}
