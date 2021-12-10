package kr.or.connect.guestbook.dto;

import java.sql.Timestamp;
import java.util.Date;

public class Guestbook {
	
	private Long id;
	private String name;
	private String content;
	private Date regdate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		Timestamp sqlDate = new Timestamp(regdate.getTime());
		this.regdate = sqlDate;
	}
	@Override
	public String toString() {
		return "Guestbook [id=" + id + ", \nname=" + name + ", \ncontent=" + content + ", \nregdate=" + regdate + "]";
	}
	
}

