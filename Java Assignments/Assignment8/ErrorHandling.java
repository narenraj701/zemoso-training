/*Create three new types of exceptions.
 *  Write a class with a method that throws all three. 
 *  In main( ), call the method but only use a single catch clause that will catch all three types of exceptions.
 *  Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.*/
class Errors {
	public void method() {
		int arr[] = new int[2];
		String s=null;
		try {
			System.out.println(s.charAt(0));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			System.out.println("Finally Block executed");
		}
	}
}

public class ErrorHandling {
	public static void main(String[] args) {
		Errors error=new Errors();
		error.method();
	}
}

