package repozitories;

import entities.Lesson;
import entities.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LessonRepoImpl implements LessonCrud{
    private Connection connection;

    private static final String SQL_SELECT_ALL_LESSONS = "SELECT * FROM semester.lessons;";

    private static final String SQL_INSERT_LESSON_OF_USER = "INSERT INTO semester.user_lesson(id_user, id_lesson) VALUES (?,?);";

    private static final String SQL_SELECT_ONE_ID = "SELECT * FROM semester.lessons WHERE lessons_id = ?;";

    private static final String SQL_INSERT_LESSON = "INSERT * INTO semester.lessons(name, time, date, trainer) VALUES (?, ?, ?, ?);";

    private static final String SQL_DELETE_LESSON = "DELETE FROM semester.lessons WHERE lessons_id = ?;";

    public LessonRepoImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    @SneakyThrows
    public Lesson findOne(Long id) {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ONE_ID);
        ResultSet result = statement.getResultSet();
        Lesson lesson = new Lesson();
        while (result.next()){
            lesson.setId(result.getLong("lessons_id"));
            lesson.setName(result.getString("name"));
            lesson.setTime(result.getString("time"));
            lesson.setDate(result.getString("date"));
            lesson.setTrainer(result.getString("trainer"));
        }
        return lesson;
    }

    @Override
    @SneakyThrows
    public List<Lesson> findAll() {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_LESSONS);
        statement.execute();
        ResultSet result = statement.getResultSet();
        List<Lesson> lessons = new ArrayList<>();
        while(result.next()){
            Lesson lesson = new Lesson();
            lesson.setId(result.getLong("lessons_id"));
            lesson.setName(result.getString("name"));
            lesson.setTime(result.getString("time"));
            lesson.setDate(result.getString("date"));
            lesson.setTrainer(result.getString("trainer"));

            lessons.add(lesson);
        }
        return lessons;
    }

    @Override
    @SneakyThrows
    public void save(Lesson model) {
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_LESSON);
        statement.setString(1, model.getName());
        statement.setString(2, model.getTime());
        statement.setString(3,model.getDate());
        statement.setString(4, model.getTime());
        statement.executeUpdate();
    }

    @Override
    @SneakyThrows
    public void saveLessonOfUser(User user, Long lessonId){
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_LESSON_OF_USER);
        statement.setLong(1, user.getId());
        statement.setLong(2, lessonId);
        statement.executeUpdate();
    }

    @Override
    @SneakyThrows
    public void delete(Long id) {
        PreparedStatement statement = connection.prepareStatement(SQL_DELETE_LESSON);
        statement.setLong(1, id);
        statement.executeUpdate();
    }
}
