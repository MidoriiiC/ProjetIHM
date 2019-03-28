import java.awt.*;
import javax.swing.*;

public class Client {
    Connexion con=null;
    Fenetre f=null;
    int nb=0;
    String nom;
    String prenom;
    String ident;
    String info[][] = new String[4][10];
    String reservation[][]=new String[4][10];
     JComboBox box;
    public Client(Connexion c,Fenetre fe,String id, String nom, String prenom) {
	this.con=c;
	this.f=fe;
	//les 3 champs sont vide
	if(id.equals("") && nom.equals("") && prenom.equals("")) {
	    //System.out.println("vide");
	    f.champ_vide();
	}
	//les 3 champs sont pleins
	if(id!="" && nom!="" && prenom!="") {
	    //System.out.println("les 3");
	    nb=1;
	    info=con.getClient(id,nom,prenom,nb);
	}
	//id et nom remplie mais pas prenom
	if(id!="" && nom!="" && prenom.equals("")) {
	    //System.out.println("id et nom");
	    nb=2;
	    info=con.getClient(id,nom,prenom,nb);
	}
	//id et prenom remplie mais pas nom
	if(id!="" && nom.equals("") && prenom!="") {
	    //System.out.println("id et prenom");
	    nb=3;
	    info=con.getClient(id,nom,prenom,nb);
	}
	//nom et prenom remplie mais pas id
	if(id.equals("") && nom!="" && prenom!="") {
	    //System.out.println("nom et prenom");
	    nb=4;
	    info=con.getClient(id,nom,prenom,nb);
	}
	//juste id est remplie
	if(id!="" && nom.equals("") && prenom.equals("")) {
	    //System.out.println("Juste id");
	    nb=5;
	    info=con.getClient(id,nom,prenom,nb);
	}
	//juste nom est remplie
	if(id.equals("") && nom!="" && prenom.equals("")) {
	    System.out.println("Juste nom");
	    nb=6;
	    info=con.getClient(id,nom,prenom,nb);
	}
	//juste prenom remplie
	if(id.equals("") && nom.equals("") && prenom!="") {
	    //System.out.println("Juste prenom");
	    nb=7;
	    info=con.getClient(id,nom,prenom,nb);
	}
	f.Choix_Client(info);
	
    }

   
    public void reservation_Client(JComboBox a) {
    	this.box=a;
    	reservation=f.getInfo_box();
	int i=0;
	String client="";
	String boite="";
	int x=0;
	while(x==0) {
	    //on refet la même concaténation pour obtenir une similarité parfait 
	    client=reservation[0][i]+" ";
	    client=client+reservation[1][i];
	    client=client+" ";
	    client=client+reservation[2][i];
	    //je ne fait pas de gros if pour une meilleur lisibilité de ce que contient les éléments en cas de problème
	    boite=box.getSelectedItem().toString();
	    if(boite.equals(client)) {
		x=1;
		ident = reservation[0][i];
		nom=reservation[1][i];
		prenom=reservation[2][i];
		info=con.getReservation(ident);
	    }
	    i++;
	}
	f.Choix_Reservation(info);
    }
    
    String id1[][] = new String[2][50];


    
    public void categorie_Chambre(String boite) {
	reservation=f.getReservation_box();
	int i=0;
	String rst="";
	int x=0;
	String chambre_at="";
	while(x==0) {
	    rst=reservation[0][i]+" ";
	    rst=rst+reservation[1][i];
	    rst=rst+" ";
	    rst=rst+reservation[2][i];
	    if(boite.equals(rst)) {
		x=1;
		String cat= reservation[2][i];
		Chambre chambre = new Chambre();
		id1=chambre.attribute_chambre(cat);
		chambre_at=id1[0][0];
		f.proposer_chambre(chambre_at);
	    }
		    
	
	      
	
	}
    }
}
