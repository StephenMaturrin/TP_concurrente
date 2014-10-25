
public class P1_3 implements Runnable {

	private Maquina maquina1;
	private Robot	robot1;
	private Monitor monitor;

	
	public P1_3(Maquina maquina,Robot robots,Monitor monitor) {
		this.maquina1=maquina;
		this.robot1=robots;		
		this.monitor=monitor;
		
	}

	public void run() {
		
		while(true)
		{
			monitor.transicionPrimera(0, 3);
			System.out.print("Procesando M1");
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

		
	
		
