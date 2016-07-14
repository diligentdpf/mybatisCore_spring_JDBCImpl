package com.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.EmpDao;
import com.tarena.entity.Emp;

public class TestCase {
    @Test
    public void test1(){
        String conf="spring.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
        EmpDao empDao=ac.getBean("jdbcEmpDaoI",EmpDao.class);
        List<Emp> empList=empDao.findAll();
        for(Emp e:empList){
            System.out.println(e);
        }
    }
}
 