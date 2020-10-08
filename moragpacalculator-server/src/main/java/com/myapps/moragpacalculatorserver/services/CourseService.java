package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.Course;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;

public interface CourseService {
    Course createCourse(String userId, StudentCategory studentCategory);
}
