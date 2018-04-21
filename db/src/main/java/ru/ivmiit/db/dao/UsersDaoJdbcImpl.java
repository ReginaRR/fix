package ru.ivmiit.db.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.ivmiit.db.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Регина on 11.04.2018.
 */
public class UsersDaoJdbcImpl implements UsersDao {
    private JdbcTemplate template;

    //language=SQL
    private final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM user_1 WHERE login = ?";
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM user_1";
    //language=SQL
    private final String SQL_SELECT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM user_1 WHERE login = ? and password = ?";
    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO user_1(name, login, password) VALUES (?, ?, ?)";
    //private Connection connection;

    public UsersDaoJdbcImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

   private RowMapper<User> userRowMapper
               = (ResultSet resultSet, int i) -> {
        return new User(
        resultSet.getInt("id"),
        resultSet.getString("name"),
        resultSet.getString("login"),
        resultSet.getString("password"));
   };

   /*private static String hashPassword(String password) {
       return BCrypt.hashpw(password, BCrypt.gensalt());
   }


   private static boolean checkPassword(String password, String hash) {
       return BCrypt.checkpw(password, hash);
   } */

   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public User find(String login, String password) {
        /*try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID_AND_PASSWORD);
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_BY_ID_AND_PASSWORD);
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("first_name");
                String login1 = resultSet.getString("last_name");
                String password1 = resultSet.getString("password");
                User user = new User(id, name, login1, password1);
                return user;
            }

    } catch (SQLException e)
    {
        throw new IllegalStateException(e);
    } */
    return null;
}

    public void save(User user) {
        template.update(SQL_INSERT_USER, user.getName(), user.getLogin(), passwordEncoder.encode(user.getPassword()));

        /*try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            System.out.println(SQL_INSERT_USER);
            statement.execute();
        } catch (SQLException e)
        {
            throw new IllegalStateException(e);
        }  */

    }

    public void update(User model) {

    }

    public void delete(Integer id) {

    }

    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL, userRowMapper) ;
        /*try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            List<User> users = new ArrayList<User>();
            while (resultSet.next())
            {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("first_name");
                String login = resultSet.getString("last_name");
                String password = resultSet.getString("password");
                User user = new User(id, name, login, password);
                users.add(user);
            }
            return users;
        } catch (SQLException e)
        {
            throw new IllegalStateException(e);
        } */
    }

    public List<User> findAllByLogin(String login) {
        return null;
    }

    @Override
    public boolean IsExist(String login, String password) {
        List<User> user = template.query(SQL_FIND_USER_BY_LOGIN, userRowMapper, login);
        if (!user.isEmpty()) {
            User u = user.get(0);
            if (passwordEncoder.matches(password, u.getPassword()))
                return true;
        }
        //List<User> user = template.query(SQL_SELECT_BY_LOGIN_AND_PASSWORD, userRowMapper, login, password);
        return false;
    }

    public User find(Integer id)
    {return null;}
}
