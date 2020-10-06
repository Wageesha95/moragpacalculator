package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Students")
public class Student {

    @Id
    private String id;

    private UserProfile userProfile;

    private StudentCategory studentCategory;

    private Enrollement enrollement;

    public Student(String id, UserProfile userProfile, StudentCategory studentCategory) {
        this.id = id;
        this.userProfile = userProfile;
        this.studentCategory = studentCategory;
    }

    public Student(String id, UserProfile userProfile, StudentCategory studentCategory, Enrollement enrollement) {
        this.id = id;
        this.userProfile = userProfile;
        this.studentCategory = studentCategory;
        this.enrollement = enrollement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public StudentCategory getStudentCategory() {
        return studentCategory;
    }

    public void setStudentCategory(StudentCategory studentCategory) {
        this.studentCategory = studentCategory;
    }

    public Enrollement getEnrollement() {
        return enrollement;
    }

    public void setEnrollement(Enrollement enrollement) {
        this.enrollement = enrollement;
    }
}


//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="student_id")
//    private Long id;
//
//    @Column(name="name")
//    private String name;
//
//    @Column(name="email")
//    private String email;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}
