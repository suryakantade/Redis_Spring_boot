package com.example.service;

import com.example.RedisEntity.Student;

public interface StudentService {
  public Student save(Student student);
  public Student findById(String id);
  public Student update(Student student);
}
