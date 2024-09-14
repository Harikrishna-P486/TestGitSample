
public class Test_A {

	//	final int a = 10 ;
	int b=20;

	public  void display() {
		System.out.println("thi is parent diaplay method...");
	}
	public static void tm1() {
		System.out.println("this is static parent TM1");
	}
	public final void tm2() {
		System.out.println("this is final parent TM2");
	}
	public static void main(String[] args) {
		final int a  =30;
		System.out.println(a);
		Test_A obj = new Test_A();
		obj.display();
		tm1();
		obj.tm2();
		
	}
}
