package ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssh.dao.DepartmentDao;
import ssh.dao.EmployeeDao;
import ssh.entity.Department;
import ssh.entity.PageBean;
import ssh.service.DepartmentService;
import ssh.service.EmployeeService;
/**
 * 部门业务接口实现类
 * @author Jestiny
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	//分页查询的方法
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean=new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页记录数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double num = Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin=(currPage-1)*pageSize;
		List<Department> list=departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/*添加部门方法*/
	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}
	/*通过id查找部门*/
	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}
	/*更新部门*/
	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}
	/*删除部门*/
	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}
	/*查询所有部门*/
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
}
