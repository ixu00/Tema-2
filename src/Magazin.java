import java.lang.reflect.Method;
import java.util.*;

@SuppressWarnings("unused")
public class Magazin extends Thread {
   private Casa casa[];// un array in care salvam numarul de case 
   private int nCase;// numarul de case din magazin
   static int id; 
   private int cumparaturi;
   private int clienti; // numarul de clienti care viziteaza magazinul
   private int orar, TimpDeschis; //cate ore functioneaza casele
   private Vector<Client> coadaC;
   int p=0;
   long Medie;

   public Magazin(int numarCase,int numarClienti,int orar, String nume ) {
	   this.nCase=numarCase;
	   this.clienti=numarClienti;
	   this.orar=orar;
	   setName(nume);
	      }
   
Magazin() {}

public synchronized  Client genClienti(int q){
	coadaC = new Vector<Client>();
	id=0;
	for (int i=0; i<=clienti-1;i++){
	Random numar = new Random();  
	cumparaturi = numar.nextInt(3)+1;// atribuim  un numar random de cumparaturi
	 Client o=new Client(id++,new Date(), new Date(), cumparaturi );
	 
	 coadaC.addElement(o);

	 }
	 return coadaC.elementAt(q);
};
//public sync
public synchronized void deschideCasa(){
	 double g=0;
	 int k=-1;
	 Info DetaliiC = new Info();
	try 
			
	{	
		 Casa casa[]= new Casa[nCase];
		  for (int i=0; i<nCase;i++)
		  casa[i]=new Casa(i); //Se face intializarea caselor
		  
	for (g=clienti*1.0/nCase; g>0.0; g--){ 
		  //verificam cea mai scurta coada
		  long min=casa[0].lungimeCoada();
		  for(int j=0; j < nCase ; j++)
			  if (casa[j].lungimeCoada()<=min) {
				  if(k<clienti-1){
			 	k++; //un contor in care tinem evidenta numarului de clienti
				  casa[j].ClientNou(genClienti(k));
				  String A="DetaliiClienti";
				DetaliiC.Scriere(A,genClienti(k).toString());//scriem detaliile in fisier
				  min=casa[j].lungimeCoada();
				  }
				if  (!casa[j].isAlive()) //Verificam daca casa nu a fost inca deschisa
					casa[j].start();    //Se porneste casa 	   
			  }
	}
	int aux=0;
	for(int j=0; j < nCase ; j++){
		casa[j].maxim();
	 aux=(aux + casa[j].lungimeCoada());
	}
	int medie=aux/nCase;
	String B="Media numarului de clienti per casa este de:"+ medie+"  clienti";
	String A="MediaNumaruluiDeClientiPerCasa";
	DetaliiC.Scriere(A,B);//scriem detaliile in fisier
}
	  catch (Exception e) {
		  System.out.println("Eroare la case");
		  System.out.println(e.toString());
	                       }
}

  public void run() {
	  
	  try {
		//  if(TimpDeschis <= orar*10000 ) {
	//	  long TimpDeschis = (System.currentTimeMillis()) ;
		  deschideCasa();	
	//	  TimpDeschis=TimpDeschis+1000;
	//	  }
	  }	  
	  catch (Exception e) {
		  System.out.println("Eroare");
		  System.out.println(e.toString());
	                       }
	  }
public void InchideMagazinul (){
	// Kill all threads
    for (int i=0; i<nCase; i++) {
    	casa[i].shutdown();
    	notifyAll();
    }
}
	 
}

