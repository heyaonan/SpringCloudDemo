package com.nice.login.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.common.Pager;
import com.nice.login.dao.StudentMapper;
import com.nice.login.domain.Student;
import com.nice.login.domain.StudentVO;
import com.nice.login.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;
    @Override
    public Student getStudentById(int id) {
       return studentMapper.getStudent(id);

    }

    @Override
    public List<Student> getStudentList() {
       return studentMapper.getStudentList();
    }

    @Override
    public int insert(Student student) {
        studentMapper.insert(student);
        return student.getId();
    }

    @Override
    public void delete(int id) {
        studentMapper.delete(id);
    }

    @Override
    public void update(Student student) {
        Student student1 = studentMapper.getStudent(student.getId());
        BeanUtils.copyProperties(student, student1);
        studentMapper.update(student1);
    }

    @Override
    public void batchInsert(List<Student> list) {
        studentMapper.batchInsert(list);
    }

    @Override
    public List<Student> queryByCondition(StudentVO vo) {
        return studentMapper.selectByCondition(vo);
    }

    @Override
    public Pager queryByConditionLimit(StudentVO vo, int pageNo, int pageSize,long totalCount) {
        long start = Pager.getStartOfPage(pageNo, pageSize);
        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        Vector<String> strings = new Vector<String>();
        TreeMap<String, String> stringStringTreeMap = new TreeMap<>();

        if (totalCount ==0){
            totalCount = studentMapper.selectByCondition(vo).size();
        }
        List<Student> list =  studentMapper.selectByConditionLimit(vo,start,pageSize);
        Pager pager = new Pager(totalCount, pageSize, start, list);
        return pager;
    }

    @Override
    public Pager queryByConditionLimitPageHelper(StudentVO vo, int pageNo, int pageSize, long totalCount) {
        long start = Pager.getStartOfPage(pageNo, pageSize);
        if (totalCount ==0){
            totalCount = studentMapper.selectByCondition(vo).size();
        }
        PageHelper.startPage(pageNo, pageSize);
        List<Student> list =  studentMapper.selectByCondition(vo);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        Pager pager = new Pager(totalCount, pageSize, start, pageInfo.getList());
        return pager;
    }
}
