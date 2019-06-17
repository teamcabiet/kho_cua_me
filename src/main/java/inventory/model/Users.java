package inventory.model;
// Generated Jun 17, 2019 6:47:01 AM by Hibernate Tools 5.4.2.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users implements java.io.Serializable {

	private Integer id;
	private String userName;
	private String password;
	private String email;
	private String name;
	private int activeLag;
	private Date createDate;
	private Date updateDate;
	private Set userRoles = new HashSet(0);

	public Users() {
	}

	public Users(String userName, String password, String name, int activeLag, Date createDate, Date updateDate) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.activeLag = activeLag;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Users(String userName, String password, String email, String name, int activeLag, Date createDate,
			Date updateDate, Set userRoles) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.name = name;
		this.activeLag = activeLag;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userRoles = userRoles;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActiveLag() {
		return this.activeLag;
	}

	public void setActiveLag(int activeLag) {
		this.activeLag = activeLag;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

}