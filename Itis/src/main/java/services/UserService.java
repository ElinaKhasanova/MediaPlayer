package services;

import entities.User;

import java.time.LocalDate;

public interface UserService {
    void signUp(String first_name, String last_name, String login, String password, LocalDate date_birth);
    User signIn(String login, String password);
    void update(String fisrt_name, String last_name, String login, String password, LocalDate date_birth, Long users_id);
}
