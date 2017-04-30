package ssh.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.entity.Department;
import ssh.entity.PageBean;
import ssh.service.DepartmentService;

/**
 * 部门管理action
 * @author Jestiny
 */
@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	//模型驱动
	private Department department=new Department();
		
	@Autowired
	private DepartmentService departmentService;
		
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	
	private Integer currPage=1;
	//从页面接收当前页数，以便查询
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//查询方法
	public String findAll(){
		PageBean<Department> pageBean=departmentService.findByPage(currPage);
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//跳转到添加页面
	public String saveUI(){
		return "saveUI";
	}
	public String save(){
		if(department.getDname().trim().equals("") || department.getDname()==null){
			this.addActionError("部门名称不能为空！");
			return "saveFailure";
		}
		departmentService.save(department);
		return "savaSuccess";
	}
	//编辑部门
	public String edit(){
		department=departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//更新部门
	public String update(){
		if(department.getDname().trim().equals("") || department.getDname()==null){
			this.addActionError("部门名称不能为空！");
			return "updateFailure";
		}
		departmentService.update(department);
		return "updateSuccess";
	}
	//删除部门
	public String delete(){
		//先查询可以保证级联删除即删除某部门时顺带删除该部门下的人
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
	
}
