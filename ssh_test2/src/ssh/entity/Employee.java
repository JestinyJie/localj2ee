package ssh.entity;

import java.util.Date;

/**
 * 员工实体类
 * @author Jestiny
 */
public class Employee {

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Integer eid, String ename, String sex, Date birthday, Date joinDate, String eno, String username,
			String password, Department department) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.joinDate = joinDate;
		this.eno = eno;
		this.username = username;
		this.password = password;
		this.department = department;
	}

	/*员工id*/
	private Integer eid;
	/*员工姓名*/
	private String ename;
	/*员工性别*/
	private String sex;
	/*员工生日*/
	private Date birthday;
	/*员工入职日期*/
	private Date joinDate;
	/*员工编号*/
	private String eno;
	/*员工帐号*/
	private String username;
	/*员工密码*/
	private String password;
	/*员工所属部门*/
	private Department department;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sex=" + sex + ", birthday=" + birthday + ", joinDate="
				+ joinDate + ", eno=" + eno + ", username=" + username + ", password=" + password + ", department="
				+ department + "]";
	}
	
	
}
