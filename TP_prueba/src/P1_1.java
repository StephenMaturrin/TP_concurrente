
public class P1_1 implements Runnable {

	private Maquina maquina1;
	private Robot	robot1;
	private Monitor monitor;

	
	public P1_1(Maquina maquina,Robot robots,Monitor monitor) {
		this.maquina1=maquina;
		this.robot1=robots;		
		this.monitor=monitor;
		
	}

	public void run() {
		
		int i=0;
		while(true)
		{
			
			monitor.transicionPrimera(0, 1);
			System.out.print("llevando R1 a M1"+"pieza: "+ i++);
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			
			
			
		
			
			
		
		
		}
		
		
		}
	}
}

