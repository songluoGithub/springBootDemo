package com.example.dao;

import com.example.proj.Department;
import com.example.proj.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/26 9:14   员工dao
 */
@Repository
public class EmployeeDao {
    // 模拟数据库初始化数据
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"AA","A276299929@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","B276299929@qq.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"VV","V276299929@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"CC","C276299929@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"AA","D276299929@qq.com",0,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initId = 1006;

    // 新增一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    // 查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    // 通过id删除员工
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }
}
