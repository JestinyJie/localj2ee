package test.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import test.bean.Product;
import test.service.ProductService;

/**
 * 商品动作类
 * @author Jestiny
 */
@Controller
@Scope("prototype")
public class ProductAction extends ActionSupport implements ModelDriven<Product> {
	
	
	@Autowired
	private ProductService productService;

	private Product product = new Product();
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	
	/**
	 * 商品存储
	 * @return
	 */
	public String save(){
		productService.save(product);
		return NONE;
	}
}
