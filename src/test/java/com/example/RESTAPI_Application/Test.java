package com.example.RESTAPI_Application;
import com.example.RESTAPI_Application.Repository.CourseRepository;
import com.example.RESTAPI_Application.Repository.DepartmentRepository;
import com.example.RESTAPI_Application.Repository.UserRepository;

public class Test {

    private static UserRepository user;
    private static CourseRepository course;
    private static DepartmentRepository departmentRepository;

    public static void main(String[] args)
    {

//        System.out.println(user.findByDepartment_Id(1L));
        System.out.println(departmentRepository.findById(0L));
        System.out.println(course.findById(1L));

    }

}
