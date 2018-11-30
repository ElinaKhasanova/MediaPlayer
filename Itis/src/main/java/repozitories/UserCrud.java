package repozitories;

import entities.User;

import java.time.LocalDate;

public interface UserCrud extends  Crud<User> {
    User findOneByEmail(String email);
    void update(String fisrt_name, String last_name, String login, String password, LocalDate date_birth, Long users_id);
}