package com.nice.login.service;

import com.github.pagehelper.PageHelper;
import com.nice.common.Pager;
import com.nice.login.domain.Student;
import com.nice.login.domain.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
     Student getStudentById(int id);
     List<Student> getStudentList();
     int insert( Student student);
     void delete(int id);
     void update(Student student);
     void batchInsert(List<Student> list);
     List<Student> queryByCondition(StudentVO vo);
     Pager queryByConditionLimit(StudentVO vo,int pageNo,int pageSize,long total);
     Pager queryByConditionLimitPageHelper(StudentVO vo, int pageNo, int pageSize, long total);


}
