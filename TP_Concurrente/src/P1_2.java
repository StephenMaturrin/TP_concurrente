public class P1_2 implements Runnable {

	private Maquina maquina2;
	private Robot	robot2;
	private PiezaA	piezaA;

	
	public P1_2(Maquina maquina,Robot robot,PiezaA piezaA) {
		this.maquina2=maquina;
		this.robot2=robot;		
		this.piezaA=piezaA;
	}

	public void run() {
		
		
		while(true)
		{
		if(maquina2.maquinaDisponible()&&robot2.robotDisponible()&&piezaA.getPiezas())
		{robot2.robotOn();maquina2.maquinaOn();
		
		}
		
		
		}
		
	
		
	}

}