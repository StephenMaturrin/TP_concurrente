
public class main {


	
	public static void main(String[] args) {
		
		 Robot robot1 = new Robot(1,2000);
		 Maquina maquina1= new Maquina(1, 2000);
		 PiezaA piezaA=new PiezaA();
		 Robot robot2 = new Robot(2,3000);
		 Maquina maquina2= new Maquina(2, 3000);
		 P1_1 p1_1= new P1_1(maquina1, robot1, piezaA);
		 P1_2 p1_2= new P1_2(maquina2, robot2, piezaA);
		Thread hilo1 = new Thread(p1_1);
		hilo1.start();
		
		System.out.println("llegue hilo 1");
		
		Thread hilo2 = new Thread(p1_2);
		hilo2.start();
		System.out.println("llegue hilo 2");

		
		
	}

}
