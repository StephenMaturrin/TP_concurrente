public class Robot {
	
	private int id;
	private int puerto;
	private int plazasOcupadas;
	

	public Robot(int id,int puerto) {
		this.id=id;
		this.puerto=puerto;		
		plazasOcupadas=0;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}


	private void llevar(){
		
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		notifyAll();
	}

	public synchronized boolean robotDisponible()
	{
		
		if(plazasOcupadas<1)
		{	plazasOcupadas++;
			return true;
		}
		
		else{return false;}
	}
	
	
	
	public synchronized boolean robotOn()
	{
		

		
		llevar();
		plazasOcupadas--;
		System.out.println("robot:"+this.id+"-> llevando ");
		return true;}	// el true siginifica que la maquina termino de procesar
		//si devuelve false la maquina nunca proceso...(no hay lugar)
							//maquina a su maxima capacidad, no hay lugar!!

}
