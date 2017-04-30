package ssh.dao;

import java.util.List;

import ssh.entity.Department;

/**
 * 部门管理dao接口
 * @author Jestiny
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
