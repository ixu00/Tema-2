import java.util.*;

public class Client {
 private int numar; // ID client;
 private Date sosit; // data si ora la care clientul a intrat la coada de la casa;
 private Date plecat; // data si ora la care clientul a iesit de la coda de la casa;
 private int cantitate;// stabilim cantitatea de cumparaturi 1- maruntisuri, 2-cantitate medie, 3 cantitate mare
 
 
 Client(int numar,Date sosit, Date plecat, int cantitate){
	 this.numar=numar;
	 this.sosit=sosit;
	 this.plecat=plecat;
	 this.cantitate=cantitate;
 }
 int getNumar(){
	 return numar+1;
 }
long getVenit() {
	int	nr= (int)(Math.random()*10);
	long y=(sosit.getTime()/1000000/60/60/60)+nr;
	 return y ;
 }
long getPlecare() {
int	nr=(int)(Math.random() * 11 + 10);
long x=(plecat.getTime()/1000000/60/60/60)+nr+getCantitate();
	 return x;
}
 int getCantitate(){
	 return cantitate;
 }
 long getStat(){
	 long l1 = getVenit();
	 long l2 = getPlecare();
	 long diff = l2 - l1; ///aflam timplul in functie de volumul de cumparaturi 

	 return diff;
 }

 public String toString() {
	 String s="Clientul cu id'ul \t" + numar + "\t a intrat in magazin de: \t "+ getVenit()+ "\t min,  si  a plecat dupa \t"+ getPlecare() + "\t min; a stat la coada \t"+ getStat()+"\t min si a cumparat o cantitate:\t" +getCantitate();
	 return s; 
 }
}
