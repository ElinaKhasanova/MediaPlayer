package services;

import entities.User;

import repozitories.UserRepoImpl;

import java.time.LocalDate;

public class UserServiceImpl implements UserService {
    private UserRepoImpl userRepo;

    public UserServiceImpl(UserRepoImpl userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void signUp(String first_name, String last_name, String login, String password, LocalDate date_birth) {
        User user = new User();
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setLogin(login);
        user.setPassword(password);
        user.setDate_birth(date_birth);
        userRepo.save(user);
    }

    @Override
    public User signIn(String login, String password) {
        User user = userRepo.findOneByEmail(login);
        if(user != null){
            if (!user.getPassword().equals(password)) throw new IllegalArgumentException("Вы ввели неправильные данные.");
            else return user;
        }
        else{
            throw new IllegalArgumentException("Такого пользователя не существует.");
        }
    }

    @Override
    public void update(String new_fisrt_name, String new_last_name, String new_login, String new_password, LocalDate new_date_birth, Long users_id) {
        User user = userRepo.findOne(users_id);
        user.setFirst_name(new_fisrt_name);
        user.setLast_name(new_last_name);
        user.setLogin(new_login);
        user.setPassword(new_password);
        user.setDate_birth(new_date_birth);
    }
}
