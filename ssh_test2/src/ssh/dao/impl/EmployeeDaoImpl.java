package ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import ssh.dao.EmployeeDao;
import ssh.entity.Department;
import ssh.entity.Employee;

/**
 * 员工dao实现类
 * @author Jestiny
 */
@Repository
@Resource(name = "sessionFactory")
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{
	/*登录验证*/
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql="from Employee where username=? and password=?";
		List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(null != list && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/*查询总人数*/
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/*分页查询方法*/
	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria=DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	/*存储员工*/
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(employee);
	}
	/*判断帐号是否可用*/
	@Override
	public boolean usernameIsAvailable(String username) {
		// TODO Auto-generated method stub
		String hql="from Employee where username =?";
		List list = this.getHibernateTemplate().find(hql,username);
		if(list!=null && list.size()>0){
			return false;
		}
		return true;
	}
	/*通过id查找*/
	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Employee.class, eid);
	}
	/*更新员工*/
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(employee);
	}
	/*删除员工*/
	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}
	
}
