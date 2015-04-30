import java.util.*;
public class Casa extends  Thread{
	
    protected Vector<Client>    coada; //luam o coada de tip vector
    protected int       clienti; //nrClienti la casa
    protected String    	numeCasa; //numele casei
    protected boolean running;//starea casei
    Info CasaR = new Info();
    public Casa(int nume) {
        coada = new Vector<Client>();
        numeCasa= Integer.toString(nume);
        clienti = 0;
        running= false;
        
    }
    // Get an item from the vector.  Wait if no items available
    public synchronized Client Proceseaza() {
    	
        // If no items available, drop into wait() call
        if (coada.size() == 0) {
            try {
            	System.out.format("Casa %s intra in standby..",numeCasa);
            	System.out.println();
                wait();
            } catch (InterruptedException e) {
               System.out.println(numeCasa + ": Eroare la casa");
            }
        }
        // Get first item from vector, remove it and decrement item count.
        Client persoana = (Client)coada.firstElement();
        coada.removeElement(persoana);
        try {
			wait(persoana.getCantitate()*1000);//se asteapta in fuctie de cantitatea de produse
			String A="Clientul  "+persoana.getNumar()+" a fost procesat in: "+persoana.getStat()+" min, de casa "+this.numeCasa;
			String B="RaportdeCasa";
			CasaR.Scriere(B,A);
			System.out.format("Clientul %d a fost procesat in %d minute",persoana.getNumar(),persoana.getStat());
			System.out.println();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.format("Eroare la casa");
			System.out.println();
		}
        clienti--;
     
        // Send it back
        return persoana;
    }
    // Place an item onto vector. Signal threads that an item is available.
    public synchronized void ClientNou(Client o) {
    	running=true;
    	
        System.out.format("clientul %d a sosit la casa : %d",o.getNumar(),Integer.valueOf(numeCasa)+1);
        System.out.println();
        clienti++;
        coada.addElement(o);
        notifyAll();
    }
   public synchronized int lungimeCoada() {
       notifyAll();
	   return coada.size();
    } 
   public synchronized int maxim(){
	   int max=0;
	   if (coada.size()>max)
		   max=coada.size();
	   	String A="Numarul maxim de clienti inregistrati la casa"+(Integer.valueOf(numeCasa)+1) + " a fost : "+max;
		String B="MunarulMaximDeClientiLaCasa";
		CasaR.Scriere(B,A);
	   return max;
   }
   
    public void run(){
		try{
		while(running=true){
			Proceseaza();
			sleep((int)(Math.random()*50000));
			
		}}
		catch(Exception e) {
			System.out.println("Exceptie");
		
	}  
		shutdown();
		}
    public void shutdown() {
        running = false;
        notifyAll();
    }
}


