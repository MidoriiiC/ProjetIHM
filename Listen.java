import javax.swing.*;
import java.awt.event.*;

public class Listen implements ActionListener {
    Connexion con = new Connexion();
    String text1=null;
    String text2=null;
    String text3=null;
    JTextField id;
    JTextField nom;
    JTextField prenom;
    Fenetre f=null;
    static JComboBox box;
    static JComboBox bot;
    static Client c;
    static String i="";
    String boite=null;

    public Listen(Fenetre fe,JTextField i,JTextField n,JTextField p) {
	this.f=fe;
	this.id=i;
	this.nom =n;
	this.prenom =p;
    }
    public Listen(JComboBox a) {
	box= new JComboBox();
	box=a;
	
    }
    public Listen(JComboBox b,int i ) {
	this.bot=b;
	
    }
    public Listen(String c){
	this.i=c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("Client")) {
	    if(id.getText().isEmpty()) {
		text1="";
	    }
	    else {
		text1= id.getText();
	    }
	    if(nom.getText().isEmpty()) {
		text2="";
	    }
	    else {
		text2= nom.getText();
	    }
	    if(prenom.getText().isEmpty()) {
		text3="";
	    }
	    else {
		text3= prenom.getText();
	    }
	    this.c = new Client(con,f,text1,text2,text3);
	}	
	if(e.getActionCommand().equals("bobox")) {
	    System.out.println("test "+box.getSelectedItem().toString());
	    this.c.reservation_Client(box);
	    f.changerVersChoixReserv(c);
	}
	if(e.getActionCommand().equals("reserver")) {
	    System.out.println("bouton changer");
	    boite=bot.getSelectedItem().toString();
	    this.c.categorie_Chambre(boite);
	}

	if(e.getActionCommand().equals("Changer")) {
	    //Chambre c = new Chambre()
		//String[][] tab=new ;
	    //tab=c.getChambre
	    //changerVersChoixChambre(tab[]);
	}
		
	if(e.getActionCommand().equals("new")) {   // c bon!
	    f.changerVersDebut();
	}
	if(e.getActionCommand().equals("Finir")) {  //ca marche
	    System.out.println("fin");
	    Chambre ch = new Chambre();
	    System.out.println(i);
	    ch.prend_Chambre(i);
	    
	    //close(con);
	    f.changerVersFin();
	}
	if(e.getActionCommand().equals("quitter")) {  //ca marche
	    //close(con);
	    System.exit(0);
	}
	    /*
	if(e.getActionCommand().equals("SelecPeriode")) {
	    gfenetre.changeEnSelecPeriode();
	}

	if(e.getActionCommand().equals("SelecJour")) {
	    gfenetre.changeEnSelecJour();
	}
	if(e.getActionCommand().equals("valider")) {    
	}

	---------------------------*/
    }
}
