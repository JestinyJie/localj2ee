package ssh.dao;

import java.util.List;

import ssh.entity.Employee;

/**
 * 员工管理dao接口
 * @author Jestiny
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	boolean usernameIsAvailable(String username);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
