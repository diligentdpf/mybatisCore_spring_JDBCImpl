package com.tarena.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.tarena.entity.Emp;
import com.tarena.entity.EmpMapper;

public class JdbcEmpDaoI extends JdbcDaoSupport implements EmpDao {

    @Override
    public void save(Emp emp) {
        String sql =
                "insert into emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,DEPTNO) values(?,?,?,?,?,?,?)";
        Object[] params =
                {emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(),
                        emp.getSal(), emp.getDeptno()};
        //调用父类的getJdbcTemplate()方法得到JdbcTemplate对象，然后执行模板的自有方法update
        super.getJdbcTemplate().update(sql,params);

    }

    @Override
    public void delete(int no) {
        String sql = "delete from emp where EMPNO=?";
        Object[] params = {no};
        //调用父类的getJdbcTemplate()方法得到JdbcTemplate对象，然后执行模板的自有方法update
        super.getJdbcTemplate().update(sql,params);
    }

    @Override
    public void update(Emp emp) {
        String sql="update emp set ENAME=?,JOB=?,MGR=?,HIREDATE=?,SAL=?,DEPTNO=? where  EMPNO=?";
        Object[] params ={emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(),
                          emp.getSal(), emp.getDeptno()};
        super.getJdbcTemplate().update(sql,params);
    }

    @Override
    public Emp findByNo(int no) {
        String sql ="select * from emp where empno=?";
        Object[] params={no};
        RowMapper<Emp> mapper=new EmpMapper();
        //调用spring的自带方法queryForObject()还要把结果映射类对象传入
        Emp emp=super.getJdbcTemplate().queryForObject(sql, params,mapper);
        return emp;
    }

    @Override
    public List<Emp> findAll() {
        String sql="select * from emp";
        RowMapper<Emp> mapper=new EmpMapper();
        List<Emp> list=super.getJdbcTemplate().query(sql, mapper);
        return list;
    }

}
