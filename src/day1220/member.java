package day1220;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class member implements Externalizable,Serializable {

	String name=null;
	String id=null;
	String pw=null;
	int age=0;
	boolean gender=true;
	
	public member() {
		// TODO Auto-generated constructor stub
	}

	
	public member(String name, String id, String pw, int age, boolean gender) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeObject(id);
		out.writeObject(pw);
		out.writeObject(age);
		out.writeObject(gender);

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		id = (String) in.readObject();
		pw = (String) in.readObject();
		age = (int) in.readObject();
		gender = (boolean) in.readObject();
	}

	@Override
	public String toString() {
		String temp = name + id + pw + age;
		
		if (gender == true) {
			temp += "남자";
		} else {
			temp += "여자";
		}

		return temp;
	}
}
