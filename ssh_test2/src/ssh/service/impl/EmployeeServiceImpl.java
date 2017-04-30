package ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssh.dao.EmployeeDao;
import ssh.entity.Department;
import ssh.entity.Employee;
import ssh.entity.PageBean;
import ssh.service.EmployeeService;
/**
 * 员工业务接口实现类
 * @author Jestiny
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	/**
	 * 业务层登录方法
	 */
	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee=employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}
	/**
	 * 业务层分页查询方法
	 */
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean=new PageBean<Employee>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页记录数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double num = Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin=(currPage-1)*pageSize;
		List<Employee> list=employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	/*存储员工*/
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
	}
	/*判断帐号是否可用*/
	@Override
	public boolean usernameIsAvailable(String username) {
		// TODO Auto-generated method stub
		return employeeDao.usernameIsAvailable(username);
	}
	/*通过id查找*/
	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return employeeDao.findById(eid);
	}
	/*更新员工*/
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}
	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
}
