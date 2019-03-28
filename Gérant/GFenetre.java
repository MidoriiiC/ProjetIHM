import java.awt.*;
import javax.swing.*;

public class GFenetre extends JFrame {
    //JFrame fenetre = new JFrame();
    final static String menu="menu";
    final static String choixJour="jour";
    final static String choixPer="Periode";
    final static String err="message";
    JPanel cards;
    JPanel pmenu;
    JPanel pchoixJ;
    JPanel pErr;
    JPanel pchoixP;

    JTextField dateJourO;

    boolean estTauxOccupJ=true;
    GConnexion connexion = new GConnexion();
    public GFenetre() {
	this.addWindowListener(new java.awt.event.WindowAdapter() {
		public void windowClosing(java.awt.event.WindowEvent evt) { 
		    connexion.fermer_Connexion();
		}
	    });
	this.setSize(800,400);
	this.setLocation(300,150);
	this.setTitle("Interface du gérant");
	
	cards = new JPanel();
	pmenu = new JPanel();
	pchoixJ = new JPanel();
	pErr = new JPanel();
	pchoixP = new JPanel();

	GListen l = new GListen(this,connexion);
	
	pmenu.setLayout(new GridBagLayout());
	pchoixJ.setLayout(new GridBagLayout());
	pErr.setLayout(new GridBagLayout());
	pchoixP.setLayout(new GridBagLayout());
    
	cards.setLayout(new CardLayout());

	
	/***************Création des boutons****************/
	JButton tauxOccupJour1 = new Bouton("taux d'occup pr 1 jour",l,"SelecJour");
	JButton tauxOccupPeriode1 = new Bouton("taux d'occup période",l,"SelecPeriode");
	JButton tauxNonPresJour1 = new Bouton("taux nonPres d'un jour",l,"SelecJour");
	JButton sortie1 = new Bouton("Quitter",l,"quitter");

	JButton tauxOccupJour2 =new Bouton("taux d'occup pr 1 jour",l,"SelecJour");
	JButton tauxOccupPeriode2 = new Bouton("taux d'occup période",l,"SelecPeriode");
	JButton tauxNonPresJour2 = new Bouton("taux nonPres d'un jour",l,"SelecJour");
	JButton sortie2 = new Bouton("Quitter",l,"quitter");

	JButton tauxOccupJour3 = new Bouton("taux d'occup pr 1 jour",l,"SelecJour");
	JButton tauxOccupPeriode3 = new Bouton("taux d'occup période",l,"SelecPeriode");
	JButton tauxNonPresJour3 =new Bouton("taux nonPres d'un jour",l,"SelecJour");
	JButton sortie3 = new Bouton("Quitter",l,"quitter");

	JButton tauxOccupJour4 = new Bouton("taux d'occup pr 1 jour",l,"SelecJour");
	JButton tauxOccupPeriode4 = new Bouton("taux d'occup période",l,"SelecPeriode");
	JButton tauxNonPresJour4 = new Bouton("taux nonPres d'un jour",l,"SelecJour");
	JButton sortie4 = new Bouton("Quitter",l,"quitter");

	JButton valider1= new Bouton("Valider",l,"valider");
	JButton valider2= new Bouton("Valider",l,"valider");

	
	
	/* --------------------- */
	JLabel dateJourOccup= new JLabel("Jour d'occupation:"); //ortho???
	/*JLabel*/ dateJourO=new JTextField();

	JLabel dateDebut= new JLabel("de:");
	JTextField dateD= new JTextField("JJ/MM/AAAA");
	JLabel dateFin= new JLabel("à:");
	JTextField dateF= new JTextField("JJ/MM/AAAA");
	
	
	dateJourO.setPreferredSize(new Dimension(160, 25));
	dateD.setPreferredSize(new Dimension(160, 25));
	dateF.setPreferredSize(new Dimension(160, 25));
	
	/**************zone des add des recherche client************/
	GridBagConstraints contraintes= new GridBagConstraints();
	contraintes.gridx=0;
	contraintes.gridy=0;
	contraintes.gridwidth=1;  //colonnes
	contraintes.gridheight=1;  // lignes
	contraintes.fill=GridBagConstraints.BOTH;
	contraintes.ipady = contraintes.anchor = GridBagConstraints.LINE_START;
	contraintes.insets=new Insets(0,0,0,0);
	contraintes.weightx=0.0f;
	contraintes.weighty=1.0f;
	
	pmenu.add(tauxOccupJour1,contraintes);
	pchoixJ.add(tauxOccupJour2,contraintes);
	pchoixP.add(tauxOccupJour3,contraintes);
	pErr.add(tauxOccupJour4,contraintes);
	contraintes.gridx = 1;
	contraintes.gridy = 1;
	
	//test
	contraintes.weightx=1.0f;
	pmenu.add(new JLabel(),contraintes);
	pchoixJ.add(new JLabel(),contraintes);
	// JLabel a mettre au début pour messages.
	pchoixP.add(new JLabel(),contraintes);
	pErr.add(new JLabel(),contraintes);
	contraintes.weightx=0.0f;
	contraintes.gridx = 0;
	contraintes.gridy = 1;

	pmenu.add(tauxOccupPeriode1,contraintes);
	pchoixJ.add(tauxOccupPeriode2,contraintes);
	pchoixP.add(tauxOccupPeriode3,contraintes);
	pErr.add(tauxOccupPeriode4,contraintes);
	contraintes.gridx = 0;
	contraintes.gridy = 2;
	pmenu.add(tauxNonPresJour1,contraintes);
	pchoixJ.add(tauxNonPresJour2,contraintes);
	pchoixP.add(tauxNonPresJour3,contraintes);
	pErr.add(tauxNonPresJour4,contraintes);

	contraintes.gridx = 6;
	contraintes.gridy = 0;
	contraintes.insets = new Insets(10,0,0,0);  
	contraintes.anchor = GridBagConstraints.LINE_END;
	contraintes.fill = GridBagConstraints.NONE;
	contraintes.weightx=1.0f;
	pmenu.add(sortie1,contraintes);
	pchoixJ.add(sortie2,contraintes);
	pchoixP.add(sortie3,contraintes);
	pErr.add(sortie4,contraintes);

	contraintes.gridx = 6;
	contraintes.gridy = 2;
	pchoixJ.add(valider1,contraintes);
	pchoixP.add(valider2,contraintes);

	
	contraintes.gridx=1;
	contraintes.gridy=0;
	pchoixJ.add(dateJourOccup,contraintes);
	pchoixP.add(dateDebut,contraintes);
	contraintes.gridx=2;
	pchoixJ.add(dateJourO,contraintes);
	pchoixP.add(dateD,contraintes);
	contraintes.gridx=3;
	pchoixP.add(dateFin,contraintes);
	contraintes.gridx=4;
	pchoixP.add(dateF,contraintes);
	
	cards.add(menu,pmenu);
	cards.add(choixJour,pchoixJ);
	cards.add(choixPer,pchoixP);
	cards.add(err,pErr);
	
	this.add(cards);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Camembert_DateJour(int pourc) {
    	//je me permet de faire un calcule dans la vue car il me parait peu économe en ressource de créé une fonction juste pour c'est 2 là dans une nouvelle classe
    	pourc=pourc*360;
    	pourc=pourc/100;
    	Camembert cam = new Camembert(pourc);
    	JPanel bleu = new JPanel();
    	JLabel occuper = new JLabel("occuper");
    	bleu.add(occuper);
    	JPanel rouge = new JPanel();
    	JLabel inoccuper = new JLabel("inoccuper");
    	rouge.add(inoccuper);
    	//il n'y a plus qu'à les rendre visible juste au dessus du camembert

    }

    public String getDateJourO() {
	String date;
	date=dateJourO.getText();
	return date;
	
    }

    public void changerVersDebut(){   //1
	//setInitialisation();
	((CardLayout) cards.getLayout()).show(cards,menu);
    }

    
    public void changeEnSelecPeriode(){
	((CardLayout) cards.getLayout()).show(cards,choixPer);
    }

    public void changeEnSelecJour(){
	//if(estTauxOccupJ==true){  //???
	((CardLayout) cards.getLayout()).show(cards,choixJour);
    }
    public void changeEnMessage(){
	((CardLayout) cards.getLayout()).show(cards,err);
    }
    public void changeBoolean(){
	if(estTauxOccupJ==true) estTauxOccupJ=false;
	else estTauxOccupJ=true;
    }	
}
