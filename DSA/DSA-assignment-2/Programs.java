package GETA2021.DSA.DSAAssignment2;

public class Programs {
	String name;
	int capacity;
	
	Programs(String name,int capacity){
		if("".equals(name)) {
			throw new IllegalArgumentException();
		}
		this.name=name;
		this.capacity=capacity;
	}

	@Override
	public String toString() {
		return "Programs [name=" + name + ", capacity=" + capacity + "]";
	}
	
	
}
