package test;

import java.security.NoSuchAlgorithmException;

public class Invoker {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//    	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		B b = new B();
		System.out.println(b.aa(new A() {
			
//			 JSONObject json = JSONObject.fromObject(new ArrayList());
			@Override
			public int add() {
				// TODO Auto-generated method stub
				return 0;
			}
		}));
    	
	}
}
