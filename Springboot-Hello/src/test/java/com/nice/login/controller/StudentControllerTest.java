package com.nice.login.controller;

import com.nice.login.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {
    @Resource
    StudentController studentController;
    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

    }

    @Test
    public void getStudentTest ()throws Exception{
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.GET, "/student/1");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }


    @Test
    public void queryByConditionLimitTest() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .request(HttpMethod.GET,"/student/queryByConditionLimit" )
                .param("pageSize","10")
                .param("pageNo","1");
//        Map<String,Object> requestttributes = new HashMap<>();
//        requestttributes.put("pageSize", 10);
//        requestttributes.put("pageNo", 1);
      // builder.sessionAttrs(requestttributes);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void queryByConditionLimitPageHelperTest() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .request(HttpMethod.GET,"/student/queryByConditionLimitPageHelper" )
                .param("pageSize","10")
                .param("pageNo","1");
//        Map<String,Object> requestttributes = new HashMap<>();
//        requestttributes.put("pageSize", 10);
//        requestttributes.put("pageNo", 1);
        // builder.sessionAttrs(requestttributes);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }


}
