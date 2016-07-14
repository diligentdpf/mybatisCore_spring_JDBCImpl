package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Emp;

public interface EmpDao {
    public void save(Emp emp);
    public void delete(int no);
    public void update(Emp emp);
    public Emp findByNo(int no);
    public List<Emp> findAll();
}
