package ssh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.entity.Department;
import ssh.entity.Employee;
import ssh.entity.PageBean;
import ssh.service.DepartmentService;
import ssh.service.EmployeeService;

/**
 * 员工管理action
 * @author Jestiny
 */
@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//模型驱动
	private Employee employee =new Employee();
	
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	/**
	 * action层登录方法
	 */
	public String login()
	{
		Employee existEmployee=employeeService.login(employee);
		if(null == existEmployee){
			//登录失败
			this.addActionError("用户名或密码错误！");
			return INPUT;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	/**
	 * action层分页查询方法
	 */
	public String findAll(){
		PageBean<Employee> pageBean=employeeService.findByPage(currPage);
		//集合用set 对象用push
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * action层增加员工方法
	 */
	public String saveUI(){
		//首先要找到所有部门
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	/**
	 * action层保存员工
	 */
	public String save(){
		//首先判空
		if(employee.getEname()==null || employee.getEname().trim().equals("")  
				|| employee.getSex()==null 
				|| employee.getBirthday()==null
				||employee.getJoinDate()==null
				||employee.getEno()==null || employee.getEno().trim().equals("")
				||employee.getUsername()==null || employee.getUsername().trim().equals("")
				||employee.getPassword()==null || employee.getPassword().trim().equals("")
				||employee.getDepartment().getDid()==null
				){
			ActionContext.getContext().put("errorMsg", "*号为必填项");
			return "saveFailure";
		}else if (!employeeService.usernameIsAvailable(employee.getUsername())){
			ActionContext.getContext().put("errorMsg", "帐号已被占用");
			return "saveFailure";
		}
		employeeService.save(employee);
		return "saveSuccess";
	}
	/*编辑员工*/
	public String edit(){
		//首先要找到所有部门
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		employee =employeeService.findById(employee.getEid());
		return "editSuccess";
	}
	/*更新员工*/
	public String update(){
		//首先判空
				if(employee.getEname()==null || employee.getEname().trim().equals("")  
						|| employee.getSex()==null 
						|| employee.getBirthday()==null
						||employee.getJoinDate()==null
						||employee.getEno()==null || employee.getEno().trim().equals("")
						||employee.getUsername()==null || employee.getUsername().trim().equals("")
						||employee.getPassword()==null || employee.getPassword().trim().equals("")
						||employee.getDepartment().getDid()==null
						){
					ActionContext.getContext().put("errorMsg", "*号为必填项");
					return "updateFailure";
				}
				employeeService.update(employee);
				return "updateSuccess";
	}
	
	/*删除员工*/
	public String delete(){
		employee =employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
	
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
}
