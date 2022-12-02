package com.company;

public class UsersService {
    private TableUsers tableUsers;

    public UsersService(TableUsers tableUsers) {
        this.tableUsers = tableUsers;
    }

    public boolean hasAccess(long userId) {
        User user = tableUsers.getUserById(userId);

        return user!=null && user.getName().equals("admin");
    }
}
