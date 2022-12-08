package constructorInjection;

public class Calc {
	private int a,b;

	public Calc(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		System.out.println("Constructor : int ,int call");
		
	}
	
	public Calc(double a,double b)
	{
		this.a=(int)a;
		this.b=(int)b;
		System.out.println("Constructor : double , double call");
	}
	
	public Calc(String a,String b)
	{

		this.a=Integer.parseInt(a);
		this.b=Integer.parseInt(b);
		System.out.println("Constructor : String , String call");

	}
	
	public void doSum()
	{
		System.out.println("Sum is = "+(this.a+this.b));
	}
	
	
	
}
