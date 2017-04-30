package ssh.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssh.dao.DepartmentDao;
import ssh.dao.EmployeeDao;
import ssh.entity.Department;
import ssh.entity.Employee;
import ssh.entity.PageBean;
import ssh.service.DepartmentService;

public class Test {

	@org.junit.Test
	public void test(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		EmployeeDao ed = (EmployeeDao) ac.getBean("employeeDaoImpl");
		Employee employee=new Employee();
		employee.setEname("123");
		employee.setEno("123");
		ed.save(employee);
	}
}
