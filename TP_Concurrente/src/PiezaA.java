public class PiezaA {
	
	private String id;
	private int piezas;
	

	public PiezaA() { //A B o C
		id="A";
		piezas=0;
	}

	public void generar(){
		
		while(true)
		{piezas++;
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	

	}

	public boolean getPiezas() {
		
		if(piezas>0){return true;}
		else {return false;}
		
	}

	public void setId(String id) {
		this.id = id;
		
	}
	
	
	

}
