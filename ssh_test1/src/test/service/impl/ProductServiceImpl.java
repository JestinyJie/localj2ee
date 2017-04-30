package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.bean.Product;
import test.dao.ProductDao;
import test.service.ProductService;
/**
 * 商品服务实现类
 * @author Jestiny
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
	}
}
