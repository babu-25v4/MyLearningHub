package javapractice;

import java.net.InetAddress;

public class test1 {

	public String s;
	public test1 t;
	
	public static void main(String[] args) 
			throws Exception {
		test1 t = new test1();
				
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("Local HostAddress:  "+addr.getHostAddress());
		System.out.println("test :  "+addr.isAnyLocalAddress());
		String hostname = addr.getHostName();
		System.out.println("Local host name: "+hostname);

		t.test();
	}
	
	public void test(){
		t.length(s);
	}

	public void length(String s){
		System.out.println("length: "+s.length());
	}

}
