import org.testng.annotations.BeforeMethod;

public class PS {
	
	@BeforeMethod
	public void beforeRun() {
		
		System.out.println("Run me first");
	}

	public void doThis() {
		
		System.out.println("I am here");
	}

}
