package com.example.service.Impl;

import com.example.RedisEntity.Student;
import com.example.Repository.RedisUtilRepo;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class StudentServiceImpl implements StudentService {

  @Autowired
  RedisUtilRepo redisUtilRepo;

  @Override
  public Student save(Student student) {
    return redisUtilRepo.save("STUDENT",student);
  }

  @Override
  public Student findById(String id) {
    return redisUtilRepo.findById("STUDENT",id);
  }

  @Override
  public Student update(Student student) {
    return redisUtilRepo.update("STUDENT",student);
  }
}
