package services;

import entities.Lesson;
import entities.User;
import repozitories.LessonRepoImpl;

import java.util.List;

public class LessonServiceImpl implements LessonService {

    private LessonRepoImpl lessonRepo;

    public LessonServiceImpl(LessonRepoImpl lessonRepo){
        this.lessonRepo = lessonRepo;
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepo.findAll();
    }

    @Override
    public void saveLessonOfUser(User user, Long lessonId) {
        lessonRepo.saveLessonOfUser(user, lessonId);
    }
}
