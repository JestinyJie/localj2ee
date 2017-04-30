package ssh.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体类
 * @author Jestiny
 */
public class Department {

	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Department(Integer did, String dname, String ddesc) {
		this.did = did;
		this.dname = dname;
		this.ddesc = ddesc;
	}


	/*部门id*/
	private Integer did;
	/*部门名称*/
	private String dname;
	/*部门描述*/
	private String ddesc;
	/*员工集合*/
	private Set<Employee> employees= new HashSet<Employee>();
	
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	
	
	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", ddesc=" + ddesc + "]";
	}
	
	
}
