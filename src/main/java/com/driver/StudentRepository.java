package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentRepository {

    Map<String,Student> students = new HashMap<>();
    Map<String,Teacher> teachers = new HashMap<>();
    HashMap<String, List<String>> teacherstudentpair = new HashMap<>();

    public void addStudentsIntoRepo(Student st){
        students.put(st.getName(),st);
    }

    public void addTeachersIntoRepo(Teacher teacher){
        teachers.put(teacher.getName(), teacher);
    }

    public void addStudentsTeachersPairIntoRepo(String st,String teach){
        if(!teacherstudentpair.containsKey(teach)){
            List<String> list = new ArrayList<>();
            list.add(st);
            teacherstudentpair.put(teach,list);
        }else{
            teacherstudentpair.get(teach).add(st);
        }
    }

    public Student getStudentFromRepo(String st){
        if(students.containsKey(st)){
            return students.get(st);
        }else{
            return null;
        }
    }


    public Teacher getTeacherFromRepo(String teach){
        if(teachers.containsKey(teach)){
            return teachers.get(teach);
        }else{
            return null;
        }
    }

    public List<String> getStudentsForTeacherFromRepo(String teacher){
        if(teacherstudentpair.containsKey(teacher)){
            List<String> newList = teacherstudentpair.get(teacher);
            return newList;
        }else{
            return null;
        }
    }

    public List<String> getAllStudentsFromRepo(){
        List<String> st = new ArrayList<>();
        for(String val:students.keySet()){
            st.add(val);
        }
        return st;
    }

    public void deleteTeacherandStudentsFromRepo(String teachername){
        List<String> list = teacherstudentpair.get(teachername);
        teacherstudentpair.remove(teachername);
        teachers.remove(teachername);

        for(int i=0;i<list.size();i++){
            if(students.containsKey(list.get(i))){
                students.remove(list.get(i));
            }
        }
    }

    public void deleteAllTeachersFromRepo(){
        for(String name:teacherstudentpair.keySet()){
            deleteTeacherandStudentsFromRepo(name);
        }
    }













}
