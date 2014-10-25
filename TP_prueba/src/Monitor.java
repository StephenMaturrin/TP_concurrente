

import java.util.concurrent.Semaphore;

public class Monitor
{
	//Atributos
	private int [] estado_actual={2, 10, 1,0,0};
	int [][] matriz_incidencia = {{-1,0,1}, {-1,0,0}, {-1,1,0}, {1,-1,0},{0,1,-1}};
	private boolean estado_valido;
	
//Exclusion mutua monitor
	Semaphore mutex = new Semaphore(1, true);
// El true es para darle equidad al semaforo, es decir que si vienen 
//dos hilos a pedir el recurso el semaforo solamente se lo da al primero que se lo pidio
// y luego al segundo, de lo contrario, si no pusieramos el true el semaforo podria 
//entregar los recurso de forma desordenada y sin priordad.
	
	
//Cola condicion antigua.
	Semaphore colaantiguos= new Semaphore(0, true);
	
//Cola entrada monitor primera vez
	Semaphore mutex1 = new Semaphore(0, true);
	
//Cola condicion inicial.
	Semaphore colainicial = new Semaphore(0, true);
	

   
//Constructor
public Monitor() 
{
    
    
}

//Ejecutar la RED DE PETRI inicio
public void transicionPrimera(int a, int disparo)
{

    //Solicitar la exclusion mutua del monitor al semaforo de la cola de entrada
	while(mutex.hasQueuedThreads())
	{
	mutex1.acquireUninterruptibly();//el hilo pide un recurso de este semaforo y se bloquea hasta que alguno este
									//disponible
	//Preguntamos si algun hilo ya adquirio la exlusion mutia y si esto es verdadero
	//el proximo hilo se bloquea en la cola del montitor
	
	}
	
	transicion(a,disparo);
}

//Ejecutar la RED DE PETRI
public void transicion(int a,int disparo)
{
    //Solicitar la exclusion mutua del monitor al semaforo de la cola de entrada
	mutex.acquireUninterruptibly();
	estado_valido=false;
	
		
	int[] disparos;
	disparos = new int[matriz_incidencia.length];
	
	for(int i=0; i<matriz_incidencia.length; i++)
	{
		disparos[i]=0;    		
	}
	
	disparos[disparo-1]=1;
	
	int [] vector_aux;
	int [] pruebaestado = null;	
	
	while(!estado_valido)
	{
		boolean negativo=false;
	//EJECUTAR ECUACION
		vector_aux = producto_matriz_vector(matriz_incidencia, disparos);	
		pruebaestado = suma_vectores(estado_actual, vector_aux);
	
	//Comprobar el este vector de estado de prueba, buscando alguna posicion negativa.
		for (int k=0;k<pruebaestado.length;k++)
		{
			if (pruebaestado[k]<0)
			{
				negativo = true;
			}
		}
		
		if(negativo==false)
		{
			estado_valido=true;
		}
		else
		{
			

			if(a==0){
				mutex.release();
				colainicial.acquireUninterruptibly();  
				mutex.acquireUninterruptibly();
			}
			else if(a==1){
				mutex.release();
				colaantiguos.acquireUninterruptibly();  
				mutex.acquireUninterruptibly();
			}
		}

	}
		
		if(estado_valido==true)
		{   //Actualizar el estado
				estado_actual = pruebaestado;
				estado_valido=false;
				
								
				//Despertar a alguien y devolver el permiso para ejecutar
				//Consultar cola de viejos
				
				if(colaantiguos.hasQueuedThreads())
				{
					colaantiguos.release();
				}
				else
				{
					colainicial.release();
				}
				
				if(!mutex.hasQueuedThreads())
				{
					mutex.release();
					mutex1.release();
				}
				else
				{
					mutex.release();    						
				}
				
				return;   		 		
		}		
				
		
		return;
}


//Sumar dos vectores
private int[] suma_vectores(int A[], int B[])
{
    int [] resultado = new int [A.length];

    if ((A.length == B.length))
    {
        for (int i = 0; i<A.length; i++)
        {	resultado [i] = A[i] + B[i];	}
        return resultado;
    }
    else
    {	return null;	}
}//Fin del metodo sumar dos vectores

//Multiplicar una matriz por un vector
private int [] producto_matriz_vector(int matriz[][], int vector[])
{
    int resultado[] = new int [matriz.length]; 
    int suma = 0;
 
        for(int i = 0; i <matriz.length; i++)
        {
            suma = 0;
            for (int j = 0; j < matriz[0].length; j++ )
            {	 suma = suma + matriz[i][j] * vector[j];	}
            resultado[i] = suma;
        }
        return resultado;
}//Fin del metodo multiplicar matriz por vector
    
public int [] estadoactual()
{
	return estado_actual;		
}


}//Fin de la clase monitor