package day1219;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class member implements Externalizable {

	String name;
	String id;
	String pw;
	int age;
	boolean gender;

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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(name);
		out.writeObject(id);
		out.writeObject(pw);
		out.writeObject(age);
		out.writeObject(gender);

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		name = (String) in.readObject();
	
		id = (String) in.readObject();
		pw = (String) in.readObject();
		age = (int) in.readObject();
		gender = (boolean) in.readObject();
	}

	@Override
	public String toString() {
		String result=null;
		
		result = name+"\t"+id+"\t"+pw+"\t"+age+"\t";
		
		if(gender){
			result +="남자";
		} else{
			result +="여자";
		}
		
		return result;
	}

	
	
}
