package kr.or.connect.TodoList.dto;

public class TodoDto {
	Long id;
	String title;
	String name;
	int sequence; //우선순위
	String type;
	String regDate;
	
	public TodoDto() {
		
	}
	
	
	//테이블에 저장된 튜플을 객체에 저장하기 위해 필요한 생성자 
	public TodoDto(Long id, String title, String name, int sequence, String type, String regDate) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.sequence = sequence;
		this.type = type;
		this.regDate = regDate;
	}
	
	public TodoDto(String title, String name, int sequence) {
		super(); 
		this.name = name;
		this.sequence = sequence;
		this.title = title;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSequence() {
		return sequence;
	}


	public void setSequence(int sequence) {
		this.sequence = sequence;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", title=" + title + ", name=" + name + ", sequence=" + sequence + ", type=" + type
				+ ", regDate=" + regDate + "]";
	}
	
	
	
}


