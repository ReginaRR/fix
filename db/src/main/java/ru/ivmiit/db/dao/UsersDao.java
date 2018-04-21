package ru.ivmiit.db.dao;

import ru.ivmiit.db.models.User;

import java.util.List;

/**
 * Created by Регина on 11.04.2018.
 */
public interface UsersDao extends CrudDao<User> {
    List<User> findAllByLogin(String login);
    boolean IsExist(String login, String password);
}
