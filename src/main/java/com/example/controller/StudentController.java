package com.example.controller;

import com.example.RedisEntity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class StudentController {

  @Autowired
  public StudentService studentService;


  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public Object get(HttpServletRequest req, HttpServletResponse res,
      @RequestParam("id") String id){
   return studentService.findById(id);

  }
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public Object save(HttpServletRequest req, HttpServletResponse res,
      @RequestBody Student student){
    return studentService.save(student);

  }
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public Object update(HttpServletRequest req, HttpServletResponse res,
      @RequestBody Student student){
    return studentService.save(student);

  }
}
