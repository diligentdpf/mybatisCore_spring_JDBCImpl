package com.tarena.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpMapper implements RowMapper<Emp> {

    @Override
    public Emp mapRow(ResultSet rs, int rowIndex) throws SQLException {
        Emp emp=new Emp();
        emp.setDeptno(rs.getInt("DEPTNO"));
        emp.setEmpno(rs.getInt("EMPNO"));
        emp.setEname(rs.getString("ENAME"));
        emp.setJob(rs.getString("JOB"));
        emp.setMgr(rs.getInt("MGR"));
        emp.setHiredate(rs.getDate("HIREDATE"));
        emp.setSal(rs.getDouble("SAL"));
        return emp;
    }

}
