package repozitories;

import entities.Lesson;
import entities.Service;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepoImpl implements ServiceCrud {
    private Connection connection;

    private static final String SQL_SELECT_ALL_SERVICES = "SELECT * FROM semester.services;";

    private static final String SQL_INSERT_SERVICE= "INSERT INTO semester.services(name, description, price) VALUES (?,?,?);";

    private static final String SQL_SELECT_ONE_ID = "SELECT * FROM semester.services WHERE services_id = ?;";

    private static final String SQL_DELETE_LESSON = "DELETE FROM semester.services WHERE lessons_id = ?;";

    public ServiceRepoImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    @SneakyThrows
    public Service findOne(Long id) {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ONE_ID);
        ResultSet result = statement.getResultSet();
        Service service = new Service();
        while (result.next()){
            service.setName(result.getString("name"));
            service.setDescription(result.getString("description"));
            service.setPrice(result.getDouble("price"));
        }
        return service;
    }

    @Override
    @SneakyThrows
    public List<Service> findAll() {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_SERVICES);
        statement.execute();
        ResultSet result = statement.getResultSet();
        List<Service> services = new ArrayList<>();
        while(result.next()){
            Service service = new Service();
            service.setName(result.getString("name"));
            service.setDescription(result.getString("description"));
            service.setPrice(result.getDouble("price"));
            services.add(service);
        }
        return services;
    }

    @Override
    @SneakyThrows
    public void save(Service model) {
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_SERVICE);
        statement.setString(1, model.getName());
        statement.setString(2, model.getDescription());
        statement.setDouble(3,model.getPrice());
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
