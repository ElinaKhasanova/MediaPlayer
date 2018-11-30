package services;

import entities.Lesson;
import entities.User;

import java.util.List;

public interface LessonService {
    List<Lesson> getAllLessons();
    void saveLessonOfUser(User user, Long lessonId);
}
