package my.jes.web.vo;

import my.jes.web.util.MyException;

public class MemberVO {
private String id,pw,name, email, gender;
private Integer age, weight, height;
	
	

	public MemberVO(String id, String pw, String name, String email, Integer age, Integer weight, Integer height, String gender) throws MyException {
		this(id,pw);
		setName(name);
		setEmail(email);
		setAge(age);
		setWeight(weight);
		setHeight(height);
		setGender(gender);
	}

	public MemberVO(String id, String pw) throws MyException {
		super();
		setId(id);
		setPw(pw);
	}

	public MemberVO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws MyException {
		if(id!=null) {
			this.id = id;
		}else {
			throw new MyException("id가 입력되지 않았습니다");
		}
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) throws MyException {
		if(pw!=null) {
			this.pw = pw;
		}else {
			throw new MyException("pw가 입력되지 않았습니다");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws MyException {
		if(name!=null) {
			this.name = name;
		}else {
			throw new MyException("name가 입력되지 않았습니다");
		}
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws MyException {
		if(email!=null) {
			this.email = email;
		}else {
			throw new MyException("email가 입력되지 않았습니다");
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) throws MyException {
		if(gender!=null) {
			this.gender = gender;
		}else {
			throw new MyException("gender가 입력되지 않았습니다");
		}
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) throws MyException {
		if(age!=null) {
			this.age = age;
		}else {
			throw new MyException("age가 입력되지 않았습니다");
		}
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) throws MyException {
		if(weight!=null) {
			this.weight = weight;
		}else {
			throw new MyException("weight가 입력되지 않았습니다");
		}
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) throws MyException {
		if(height!=null) {
			this.height = height;
		}else {
			throw new MyException("height가 입력되지 않았습니다");
		}
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", gender=" + gender + ", age="
				+ age + ", weight=" + weight + ", height=" + height + "]";
	}

	
}
