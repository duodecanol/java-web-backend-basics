package kr.or.connect.guestbook.dao;

public class GuestbookDaoSqls {
	public static final String SELECT_PAGING = "SELECT id, name, content, regdate FROM visitorbook ORDER BY id DESC LIMIT :start, :limit";
	public static final String SELECT_COUNT = "SELECT COUNT(*) FROM visitorbook;";
	public static final String DELETE_BY_ID = "DELETE FROM visitorbook WHERE id = :id";
}
