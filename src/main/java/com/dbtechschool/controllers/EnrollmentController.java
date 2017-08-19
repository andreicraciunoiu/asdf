package com.dbtechschool.controllers;

import com.dbtechschool.models.Enrollment;
import com.dbtechschool.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nicoleta on 8/19/2017.
 */
@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentService courseService;

    @RequestMapping("/enrollment")
    public List<Enrollment> listAllCourses() {
        return courseService.findAllEnrollments();
    }
}
