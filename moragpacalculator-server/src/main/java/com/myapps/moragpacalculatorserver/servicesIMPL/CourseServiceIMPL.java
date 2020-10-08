package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.*;
import com.myapps.moragpacalculatorserver.repositories.CourseDefinitionRepository;
import com.myapps.moragpacalculatorserver.repositories.CourseRepository;
import com.myapps.moragpacalculatorserver.services.CourseService;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import com.myapps.moragpacalculatorserver.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CourseServiceIMPL implements CourseService {

    @Autowired
    private SemesterService semesterService;

    @Autowired
    private CourseDefinitionRepository courseDefinitionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    public Course createCourse(String userId, StudentCategory studentCategory) {
        try {
            ArrayList<SemesterDefinition> semesterDefinitionArrayList = new ArrayList<>();

            CourseDefinition courseDefinition = courseDefinitionRepository.findCourseDefinitionByCourseName(studentCategory.getCourse());
            courseDefinition.getCourseContentDefinition().forEach(semesterDefinitionArrayList::add);

            ArrayList<Semester> allSemestersArrayList = semesterService.createSemesters(userId, studentCategory, semesterDefinitionArrayList);

            Course course = new Course();
            course.setUserId(userId);
            course.setCourseName(courseDefinition.getCourseName());
            HashMap<String, Semester> courseContent = new HashMap<>();
            for (Semester semester : allSemestersArrayList) {
                courseContent.put("semester" + semester.getSemesterNo(), semester);
                course.setCourseContent(courseContent);
            }
            courseRepository.save(course);
            return course;
        } catch (Exception e) {
            throw e;
        }
    }
}
