package kr.or.dgit.phonebookv02.dto;

public class Phone {
	private String name;
	private String addr;
	private String Tel;
	
	public Phone(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Phone(String name, String addr, String tel) {
		this.name = name;
		Tel = tel;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return String.format("%s %s", name, Tel);
	}
	
	public Object[] toArray(){
		return new Object[]{name, addr, Tel};
	}
}
