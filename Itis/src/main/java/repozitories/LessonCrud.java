package repozitories;

import entities.Lesson;
import entities.User;

public interface LessonCrud extends  Crud<Lesson> {
    void saveLessonOfUser(User user, Long lessonId);
}
