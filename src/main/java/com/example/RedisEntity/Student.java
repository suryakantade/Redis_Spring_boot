package com.example.RedisEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

@RedisHash("student")
public class Student implements Serializable {
  String id;
  String name;
  @JsonFormat(pattern = "yyyy-MM-dd")
  Date age;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getAge() {
    return age;
  }

  public void setAge(Date age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects
        .equals(age, student.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age);
  }
}
