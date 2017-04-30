package ssh.service;

import java.util.List;

import ssh.entity.Department;
import ssh.entity.PageBean;

/*
 * 部门业务接口
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
