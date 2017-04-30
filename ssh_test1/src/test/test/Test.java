package test.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.action.ProductAction;
import test.bean.Product;
import test.dao.ProductDao;
import test.service.ProductService;
import test.service.impl.ProductServiceImpl;

public class Test {

	@org.junit.Test
	public void test(){
		ApplicationContext ac =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Product product=new Product(1, "8", 12);
		ProductDao pd=(ProductDao) ac.getBean("productDao");
//		pd.save(product);
		pd.count();
	}
}
