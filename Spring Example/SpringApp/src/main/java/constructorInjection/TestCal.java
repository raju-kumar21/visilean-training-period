package constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context =new ClassPathXmlApplicationContext("constructorInjection/Constconfig.xml");
		
		Calc ob=(Calc)context.getBean("cal");
		
		ob.doSum();
		
		
	}

}
