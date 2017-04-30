package ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import ssh.dao.DepartmentDao;
import ssh.entity.Department;

/**
 * 部门dao实现类
 * @author Jestiny
 */
@Repository
@Resource(name = "sessionFactory")
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	/*查询记录总数*/
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	/*分页查询*/
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		//分页查询的一种简单方法
		DetachedCriteria criteria=DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	/*添加部门*/
	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}
	/*根据id查找部门*/
	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, did);
	}
	/*更新部门*/
	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(department);
	}
	/*删除部门*/
	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(department);
	}
	/*查询所有部门*/
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Department");
	}
}
