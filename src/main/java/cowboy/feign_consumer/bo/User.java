package cowboy.feign_consumer.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//路径可以不同
//忽略没有的字段
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	private String name;
	
	private Integer age;
	
//	private String sex;
	
	public User(){
		//需要注意： 这里必须要有默认构造函数，不然，Feign 根据JSON字符串转User对象时会抛出异常
	}
	
	public User(String name,Integer age){
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString(){
		return "name="+name+",age="+age;
	}

}
