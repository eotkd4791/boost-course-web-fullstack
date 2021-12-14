
public class Role {
	private Integer roleId;
	private String description;
	
	public Role() {}
	public Role(Integer roleId, String description) {
		super();
		this.roleId = roleId;
		this.description = description;
	}
	
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDiscription() {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roldId + ", description=" + description + "]";
	}
}

