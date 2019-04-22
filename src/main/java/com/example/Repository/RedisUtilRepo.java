package com.example.Repository;

import com.example.RedisEntity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface RedisUtilRepo {
  public Student save(String KEY,Student student);
  public Student findById(String KEY,String id);
  public Student update(String KEY,Student student);
}
