package com.example.Repository;

import com.example.RedisEntity.Student;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
@Component
public class RedisUtilRepoImpl implements RedisUtilRepo {


  @Autowired
  RedisTemplate<String,Object> redisTemplate;

  private HashOperations hashOperations;

  @PostConstruct
  private void init(){
    hashOperations = redisTemplate.opsForHash();
  }

  @Override
  public Student save(String KEY, Student student) {
    hashOperations.put(KEY,student.getId(),student);
    return student;
  }

  @Override
  public Student findById(String KEY, String id) {
    return (Student) hashOperations.get(KEY,id);
  }

  @Override
  public Student update(String KEY,Student student) {
    hashOperations.put(KEY,student.getId(),student);
    return student;
  }
}
