package com.example.controller;

import com.example.dao.DepartmentDao;
import com.example.dao.EmployeeDao;
import com.example.proj.Department;
import com.example.proj.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author luosong
 * @version 1.0
 * @date 2020/9/26 12:09
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 获取员工列表
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "/emp/list";
    }

    /**
     * 跳转新增员工页面
     * @param model
     * @return
     */
    @RequestMapping("/toAdd")
    public String emps(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "/emp/add";
    }

    /**
     * 新增员工
     * @param employee
     * @return
     */
    @PostMapping("/toAdd")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:emps";
    }

    /**
     * rest方式，修改员工信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/emp/{id}")
    public String updateEmpPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "/emp/update";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @RequestMapping("/empUpdate/{id}")
    public String deleteEmpPage(@PathVariable("id") Integer id){
        employeeDao.deleteEmployeeById(id);

        return "redirect:/emps";
    }
}
