import javax.swing.*;
import java.awt.event.*;

public class GListen implements ActionListener {
    GConnexion co;
    GFenetre gfenetre=null;

    public GListen(GFenetre f,GConnexion con) {
	this.co=con;
	this.gfenetre=f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	//GClient client=new GClient(co);
    	if(e.getActionCommand().equals("new")) {   // c bon!
	    gfenetre.changerVersDebut();
	    //Client c = new Client(con);
	}
	if(e.getActionCommand().equals("quitter")) {  //ca marche
	    co.fermer_Connexion();
	    System.exit(0);
	}
	if(e.getActionCommand().equals("SelecPeriode")) {
	    gfenetre.changeEnSelecPeriode();
	    //Client c = new Client(con);
	}

	if(e.getActionCommand().equals("SelecJour")) {
	    gfenetre.changeEnSelecJour();
	}
	if(e.getActionCommand().equals("valider")) {
	    String date=gfenetre.getDateJourO();
	    int pourc=co.Moyenne_Jour(date);
	    gfenetre.Camembert_DateJour(pourc); // pour gfenetre
	    // tester si fenetre est nul ou si c'est gfenetre

	    //bcp de if? ou rename dans fenetre pour chaque cas de validation?
	    //formulaire
	    //Client c = new Client(con);   
	}

	/*---------------------------*/
	if(e.getActionCommand().equals("valider")) {
	    //formulaire
	    //Client c = new Client(con);   
	}  
    }

}
