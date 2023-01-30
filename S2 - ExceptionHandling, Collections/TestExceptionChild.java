import java.io.IOException;

class Parent1{
	void msg() throws IOException {
		
	}
}

public class TestExceptionChild extends Parent1{
	
	@Override
	void msg() throws IOException{
		
	}

}
