
public class P1_1 implements Runnable {

	private Maquina maquina1;
	private Robot	robot1;
	private PiezaA	piezaA;

	
	public P1_1(Maquina maquina,Robot robot,PiezaA piezaA) {
		this.maquina1=maquina;
		this.robot1=robot;		
		this.piezaA=piezaA;
	}

	public void run() {
		
		while(true)
		{
		if(maquina1.maquinaDisponible()&&robot1.robotDisponible()&&piezaA.getPiezas())
		{robot1.robotOn();maquina1.maquinaOn();}
		}
		
	
		
	}

}
