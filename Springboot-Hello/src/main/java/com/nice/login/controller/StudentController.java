package com.nice.login.controller;

import com.alibaba.fastjson.JSON;
import com.nice.common.JsonResult;
import com.nice.common.Pager;
import com.nice.config.Constant;
import com.nice.login.domain.Student;
import com.nice.login.domain.StudentVO;
import com.nice.login.service.StudentService;
import com.nice.util.Randomutil;
import javafx.scene.input.ClipboardContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    Constant constant;
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "hello",method =RequestMethod.GET )
    public String index(){
        //TODO DiscoveryClient无法注入
        //ServiceInstance instance = client.get
        return "";
    }

    @RequestMapping("/{id}")
    public JsonResult getStudent(@PathVariable(value = "id",required = true)int id){
        JsonResult result = new JsonResult();
        Student student = studentService.getStudentById(id);
        result.setMsg("查询成功");

        result.setInfo(student);

        result.setResult(1);
        return result;


    }

    @RequestMapping("/list")
    public JsonResult getStudentList(){
        JsonResult result = new JsonResult();
        List<Student> students = studentService.getStudentList();
        result.setMsg("查询成功");
        result.setInfo(students);
        result.setResult(1);
        return result;


    }

    @RequestMapping(value = "/create")
    public JsonResult insert(){
        JsonResult result = new JsonResult();
        Student student = new Student();
        student.setAge(12);
        student.setBirthday(new Date());
        student.setClassmate("5");
        student.setId_card("410881128273645383");
        student.setGrade("四");
        int id = studentService.insert(student);
        result.setMsg("保存成功");
        result.setInfo(id);
        result.setResult(1);
        return result;


    }

    @RequestMapping(value = "/batchCreate")
    public JsonResult batchInsert(){
        JsonResult result = new JsonResult();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i <100000 ; i++) {
            Student student = new Student();
            student.setName("和妖男"+i);
            student.setAge(i);
            student.setBirthday(new Date());
            student.setClassmate(String.valueOf(i+1));
            student.setId_card(Randomutil.getNBitRandomDigit(18));
            student.setGrade(""+i);
            list.add(student);
        }
        studentService.batchInsert(list);
        result.setMsg("保存成功");
        result.setResult(1);
        return result;
    }
    @RequestMapping("/queryByCondition")
    public JsonResult queryByCondition(){
        JsonResult result = new JsonResult();
        try {
            StudentVO vo = new StudentVO();
            vo.setName("和");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            vo.setFirstDate(sdf.parse("1920-09-12 12:12:12"));
            vo.setLastDate(sdf.parse("2019-05-07 22:12:12"));
            List<Student> students = studentService.queryByCondition(vo);
            result.setInfo(students);
            result.setResult(1);
        }catch (Exception e ){
            e.printStackTrace();
            result.setResult(0);
            result.setMsg(e.getMessage());
        }
        return result;

    }

    @RequestMapping("/queryByConditionLimit")
    public JsonResult queryByConditionLimit(@RequestParam(value = "pageSize") int pageSize,@RequestParam(value = "pageNo") int pageNo){
        JsonResult result = new JsonResult();
        try {
            StudentVO vo = new StudentVO();
            vo.setName("和");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            vo.setFirstDate(sdf.parse("1920-09-12 12:12:12"));
            vo.setLastDate(sdf.parse("2019-05-08 22:12:12"));
            Pager pa= studentService.queryByConditionLimit(vo, pageNo, pageSize,0);
            result.setInfo(pa);
            result.setResult(1);
        }catch (Exception e ){
            e.printStackTrace();
            result.setResult(0);
            result.setMsg(e.getMessage());
        }
        return result;

    }

    @RequestMapping("/queryByConditionLimitPageHelper")
    public JsonResult queryByConditionLimitPageHelper(@RequestParam(value = "pageSize") int pageSize,@RequestParam(value = "pageNo") int pageNo){
        JsonResult result = new JsonResult();
        try {
            StudentVO vo = new StudentVO();
            vo.setName("和");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            vo.setFirstDate(sdf.parse("1920-09-12 12:12:12"));
            vo.setLastDate(sdf.parse("2019-05-08 22:12:12"));
            Pager pa= studentService.queryByConditionLimitPageHelper(vo, pageNo, pageSize,0);
            result.setInfo(pa);
            result.setResult(1);
        }catch (Exception e ){
            e.printStackTrace();
            result.setResult(0);
            result.setMsg(e.getMessage());
        }
        return result;

    }
}
