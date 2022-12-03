package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudents(Student st){
        studentRepository.addStudentsIntoRepo(st);
    }

    public void addTeachers(Teacher teacher){
        studentRepository.addTeachersIntoRepo(teacher);
    }

    public void addStudentsTeachersPair(String st,String teach){
        studentRepository.addStudentsTeachersPairIntoRepo(st,teach);
    }

    public Student getStudent(String name){
        return studentRepository.getStudentFromRepo(name);
    }

    public Teacher getTeacher(String name){
        return studentRepository.getTeacherFromRepo(name);
    }

    public List<String>  getStudentFromTeacher(String name){
        return studentRepository.getStudentsForTeacherFromRepo(name);
    }

    public List<String> getAllStudent(){
        return studentRepository.getAllStudentsFromRepo();
    }

    public void deleteTeacherandStudents(String name){
        studentRepository.deleteTeacherandStudentsFromRepo(name);
    }

    public void deleteAllTeacher(){
        studentRepository.deleteAllTeachersFromRepo();
    }










}
