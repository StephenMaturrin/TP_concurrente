public class Maquina {
	
	private int id;
	private int puerto;
	private int plazasOcupadas;
	

	public Maquina(int id,int puerto) {
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


	private void procesar(){
		
		try {
			wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public synchronized boolean maquinaDisponible()
	{
		
		if(plazasOcupadas<2)
		{	plazasOcupadas++;
			return true;
		}
		
		else{return false;}
		
	}
	
	public synchronized boolean maquinaOn()
	{
		if(plazasOcupadas<2){
		procesar();
		plazasOcupadas--;
		System.out.println("maquina:"+this.id+"-> procesasndo ");
		return true;}	// el true siginifica que la maquina termino de procesar
		else {return false;}//si devuelve false la maquina nunca proceso...(no hay lugar)
							//maquina a su maxima capacidad, no hay lugar!!
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}




}
