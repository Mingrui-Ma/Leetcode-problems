

class MultithreadNums extends Thread	{
	int divisor;
	int max;
	
	MultithreadNums(int d, int m)	{
		this.divisor = d; 
		this.max = m;
	}
	
	public void run() 	{
	//	try	{
		for(int i=1;i<=max;i++)	{
			if(i%divisor==0)	{
				System.out.println(i + " is divisible by " + divisor + ".");
			//Thread.sleep(10);
			}
		}
//	}	catch(InterruptedException e)	{
//		System.out.println("Thread Interrupted.");
//	}
	}
}



class NumThreads	{
	public static void main(String[] args) {
		MultithreadNums three = new MultithreadNums(3, 10);
		MultithreadNums five = new MultithreadNums(5, 10);
		
		three.start();
		five.start();
		
		
		try	{
			three.join();
			five.join();
			
		}	catch(InterruptedException e)	{
			System.out.println("Thread interrupted.");
		}	
	}
}
