package ssh.service;

import ssh.entity.Employee;
import ssh.entity.PageBean;

/*
 * 员工业务接口
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	boolean usernameIsAvailable(String username);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
