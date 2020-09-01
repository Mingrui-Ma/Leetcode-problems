/*
class foobarThread implements Runnable	{
	int num, fb;
	
	foobarThread(int i, int choose)	{
		this.num = i;
		this.fb = choose;
		
	}
	
	public synchronized void foo(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("foo");
			
		}
	}

	public static void bar(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("bar");
		}
	}
	
	public void run()	{
		try	{
		if(fb==1)	{
			for (int i=0; i<num; i++) {
				System.out.print("foo");
				notify();
				wait();
			}
		}
	}	catch(InterruptedException e)	{
		System.out.println("Thread Exception: " + e);
	}
	}
}	*/

class foobar 	{
	private boolean fRuns = true;
	
	public synchronized void foo() {
		if(!fRuns)	{
			try	{
			wait();
			}	catch(InterruptedException e)	{
				System.out.println("foo interrupted.");
			}
		}
		System.out.print("foo");
		fRuns = false;
		notify();
	}

	public synchronized void bar() {
		if(fRuns)	{
			try	{
			wait();
			}	catch(InterruptedException e)	{
				System.out.println("bar interrupted.");
			}
		}
		System.out.print("bar");
		fRuns = true;
		notify();
	}
}

class fooThread implements Runnable	{
	Thread t;
	private foobar fb;
	int n;
	
	fooThread(foobar fbCons, int num)	{
		t = new Thread(this, "foo thread");
		this.fb = fbCons;
		this.n = num;
		t.start();
	}
	
	public void run()	{
		for(int i=0;i<n;i++)	{
			try	{
			fb.foo();
			Thread.sleep(100);
			}	catch(InterruptedException e)	{
				System.out.println("foo thread interrupted.");
			}
		}
	}
}

class barThread implements Runnable	{
	Thread t;
	private foobar fb;
	int n;
	
	barThread(foobar fbCons, int num)	{
		t = new Thread(this, "bar thread");
		this.fb = fbCons;
		this.n = num;
		t.start();
	}
	
	public void run()	{
		for(int i=0;i<n;i++)	{
			try	{
			fb.bar();
			System.out.println();
			Thread.sleep(100);
			}	catch(InterruptedException e)	{
				System.out.println("bar thread interrupted.");
			}
		}
	}
}
		
public class PrintFooBarMultithread1115 {

	public static void main(String[] args) {
		foobar fb = new foobar();
		new fooThread(fb, 5);
		new barThread(fb, 5);
	}
}
