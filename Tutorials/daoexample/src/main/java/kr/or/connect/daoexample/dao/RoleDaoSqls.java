package kr.or.connect.daoexample.dao;


/**
 * @author Administrator
 * @apiNote Query strings for RDBMS CRUD operations
 */
public class RoleDaoSqls {
	// readonly string
	public static final String SELECT_ALL = "SELECT role_id, description FROM role order by role_id";
	public static final String UPDATE = "UPDATE role SET description = :description WHERE role_id = :roleId";
	public static final String SELECT_BY_ROLE_ID = "SELECT role_id, description FROM role WHERE role_id = :roleId";
	public static final String DELETE_BY_ROLE_ID = "DELETE FROM role WHERE role_id = :roleId";
	
}
