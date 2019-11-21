package com.nice.login.dao;

import com.nice.login.domain.Student;
import com.nice.login.domain.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface StudentMapper {
    /**
    获取所有学生信息
    */
    List<Student> getStudentList();
    /**
    插入学生信息
     @param student
     */
    int insert(@Param("student") Student student);
    /**
    根据id删除学生
    @param  id
     */
    void delete(int id);
    /**
     * 更新学生信息
    @param student
     */
    void update(Student student);
    /**
     * 根据id获取指定用户信息
     */
    Student getStudent(int id);

    /**
     * 批量插入数据
     * @param students
     */
    void batchInsert( List<Student> students);

    /**
     * 条件查询数据
     * @param studentVO
     * @return
     */

    List<Student> selectByCondition(@Param("student") StudentVO studentVO);

    /**
     * 条件查询数据,分页
     * @param vo
     * @param start
     * @param pageSize
     * @return
     */

    List<Student> selectByConditionLimit(@Param("student") StudentVO vo,@Param("start") long start,@Param("pageSize") int pageSize);




}
