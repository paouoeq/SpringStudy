package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("ExDTO")
public class ExDTO {
	int no;
	String name;
	String loc;
	public ExDTO() {
		// TODO Auto-generated constructor stub
	}
	public ExDTO(int no, String name, String loc) {
		this.no = no;
		this.name = name;
		this.loc = loc;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "exDTO [no=" + no + ", name=" + name + ", loc=" + loc + "]";
	}
	
	
}
