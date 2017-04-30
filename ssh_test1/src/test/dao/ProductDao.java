package test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import test.bean.Product;

@Repository
@Resource(name="sessionFactory")
public class ProductDao extends HibernateDaoSupport{

	/**
	 * 保存商品
	 */
	public void save(Product product) {
		// TODO Auto-generated method stub
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		session.save(product);
		session.close();
	}
	public void count(){
		List<Long> list = this.getHibernateTemplate().find("select count(*) from Product");
		if(list.size()>0){
			System.out.println(list.get(0).intValue());
		}
	}

}
