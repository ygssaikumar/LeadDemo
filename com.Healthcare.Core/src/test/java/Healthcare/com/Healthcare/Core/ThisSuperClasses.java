package Healthcare.com.Healthcare.Core;

public class ThisSuperClasses {
	int i=10;
	public void Student() {
		int i=20;
		System.out.println(this.i);
		System.out.println(i);
	}

	public static void main(String[] args) {
		ThisSuperClasses t =new ThisSuperClasses();
		t.Student();
		// TODO Auto-generated method stub

	}

}
