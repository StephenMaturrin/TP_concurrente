
public class main {


	
	public static void main(String[] args) {
		
		 Robot robot1 = new Robot(1,2000);
		 Maquina maquina1= new Maquina(1, 2000);
		 PiezaA piezaA=new PiezaA();
		 P1_1 p1_1= new P1_1(maquina1, robot1, piezaA);
		
		Thread hilo1 = new Thread(p1_1);
		hilo1.start();
		System.out.println("llegue");

		
		
	}

}
