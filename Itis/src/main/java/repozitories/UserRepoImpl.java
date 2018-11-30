package repozitories;

import entities.User;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserCrud {
    private Connection connection;
    private List<User> list;
    private User oneUser;

    private static final String SQL_INSERT_INTO =
            "INSERT into semester.users(first_name, last_name, login, password, date)" +
            "VALUES (?, ?, ?, ?, ?);";

    private static final String SQL_SELECT_ID = "SELECT * FROM semester.users WHERE users_id = ?;";

    private static final String SQL_SELECT_LGN = "SELECT * FROM semester.users WHERE login = ?;";

    private static final String SQL_SELECT_ALL = "SELECT * FROM semester.users;";

    private static final String SQL_DELETE_ID = "DELETE FROM semester.users WHERE users_id = ?;";

    private static final String SQL_UPDATE_USER = "UPDATE semester.users SET first_name=?, last_name=?, login=?, password=?, date=? WHERE users_id=?;";

    public UserRepoImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    @SneakyThrows
    public User findOne(Long id) {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ID);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            String first_name = result.getString("first_name");
            String last_name = result.getString("last_name");
            oneUser = new User();
            oneUser.setFirst_name(first_name);
            oneUser.setLast_name(last_name);
        }
        return oneUser;
    }

    @Override
    @SneakyThrows
    public List<User> findAll() {
        list = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            String first_name = result.getString("first_name");
            String last_name = result.getString("last_name");
            oneUser = new User();
            oneUser.setFirst_name(first_name);
            oneUser.setLast_name(last_name);
            list.add(oneUser);
        }
        return list;
    }

    @Override
    @SneakyThrows
    public void save(User model){
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_INTO);
        statement.setString(1, model.getFirst_name());
        statement.setString(2, model.getLast_name());
        statement.setString(3, model.getLogin());
        statement.setString(4, model.getPassword());
        statement.setDate(5, Date.valueOf(model.getDate_birth()));
        statement.executeUpdate();
    }

    @Override
    @SneakyThrows
    public void delete(Long id) {
        PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ID);
        statement.setLong(1, id);
    }

    @Override
    @SneakyThrows
    public User findOneByEmail(String email) {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_LGN);
        statement.setString(1, email);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        if(resultSet.next()){
            User user = new User();
            user.setLast_name(resultSet.getString("last_name"));
            user.setFirst_name(resultSet.getString("first_name"));
            user.setPassword(resultSet.getString("password"));
            user.setLogin(resultSet.getString("login"));
            user.setDate_birth(resultSet.getDate("date").toLocalDate());
            return user;
        }
        else{
            return null;
        }
    }

    @Override
    @SneakyThrows
    public void update(String new_fisrt_name, String new_last_name, String new_login, String new_password, LocalDate new_date_birth, Long users_id) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd mm yyyy");
//        String formattedString = date_birth.format(formatter);
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER);
        statement.setString(1,new_fisrt_name);
        statement.setString(2,new_last_name);
        statement.setString(3,new_login);
        statement.setString(4,new_password);
        statement.setDate(5,Date.valueOf(new_date_birth));
        statement.setLong(6,users_id);
        statement.executeUpdate();
    }
}
