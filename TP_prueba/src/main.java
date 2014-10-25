public class main {


	
	public static void main(String[] args) {
		
		 Monitor monitor = new Monitor();
		 Robot robot1 = new Robot(1,2000);
		 Maquina maquina1= new Maquina(1, 2000);
		 Robot robot2 = new Robot(2,3000);
		 Maquina maquina2= new Maquina(2, 3000);
		 
		 P1_1 p1_1= new P1_1(maquina1, robot1,monitor);
		 P1_2 p1_2= new P1_2(maquina2, robot2,monitor);
		 P1_3 p1_3= new P1_3(maquina2, robot2,monitor);
		
		Thread hilo1 = new Thread(p1_1);
		Thread hilo2 = new Thread(p1_2);
		Thread hilo3 = new Thread(p1_3);
		
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		
		
		
	}

}
