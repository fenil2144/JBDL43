
	abstract class Bank{
		abstract int getROI();
		abstract void deposit();
		abstract void withdrawl();
		
		
	}
	
	class SBI extends Bank{

		@Override
		int getROI() {
			return 6;
		}

		@Override
		void deposit() {
			// TODO Auto-generated method stub
			
		}

		@Override
		void withdrawl() {
			// TODO Auto-generated method stub
			
		}
		 
	}
	
	class PNB extends Bank{

		@Override
		int getROI() {
			return 7;
		}

		@Override
		void deposit() {
			// TODO Auto-generated method stub
			
		}

		@Override
		void withdrawl() {
			// TODO Auto-generated method stub
			
		}
		
	}

	
	public class AbstractionExample{
		public static void main(String args[]) {
			
			Bank b;
			
			b = new SBI();
			System.out.print(b.getROI());
			
			b = new PNB();
			System.out.println(b.getROI());
		}
	}

