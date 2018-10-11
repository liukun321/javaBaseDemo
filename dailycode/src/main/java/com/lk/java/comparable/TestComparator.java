package com.lk.java.comparable;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lk.java.clientapi.versionone.ZookeeperConfig;
@Slf4j
public class TestComparator {
	private final static Logger log = LoggerFactory.getLogger(TestComparator.class);
    public static void main(String[] args) {
        Student student1=new Student(1,"student1");
        Student student2=new Student(2,"student2");
        Student student3=new Student(3,"student3");
        List<Student> list=new ArrayList<>();
        list.add(student2);
        list.add(student1);
        list.add(student3);
        Collections.sort(list, new MyComparator());
        for (Student student : list) {
            log.info(student.getName());
        }
    }
}
