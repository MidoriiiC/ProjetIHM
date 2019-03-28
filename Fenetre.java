import java.awt.*;
import javax.swing.*;

// ne pas oublier la javadoc

public class Fenetre extends JFrame {
    Connexion con;
    final static String menu= "menu";
    final static String choixRes= "choixReserv";
    final static String err= "erreur";
    final static String choixCh= "choixChambre";
    final static String validCh= "valideChambre";
    final static String fini= "finDeProcedure";
    JPanel cards;
    JPanel pmenu;         //1
    JPanel pchoixRes;     //2
    JPanel perr;          //3
    JPanel pchoixCh;      //4
    JPanel pvalidCh;      //5
    JPanel pFini;         //6

    JComboBox liste1;
    JComboBox liste2;
    
    JPanel hotel;
    Listen l;
    GridBagConstraints c;
    
    JLabel infoClient1;
    JLabel infoClient2;
    JLabel infoClient3;
    JLabel infoClient4;
    JLabel infoClient5;
    JLabel infoClient6;
        
    JLabel infoReserv1;
    JLabel infoReserv2;
    JLabel infoReserv3;
    JLabel infoReserv4;
    JLabel infoReserv5;
    JLabel infoReserv6;

    JTextField idReservField;
    JTextField nomCliField;
    JTextField prenomCliField;
    
    

    Bouton valider1;
    /**
     * Le constructeur de Fenetre, il demande un objet Connexion et sert de View pour l'application côté Employ&eacute;.
     *
     * @param e Connexion co.
     **/
    public Fenetre(Connexion co) {
	this.con=co;
	this.addWindowListener(new java.awt.event.WindowAdapter() {
		public void windowClosing(java.awt.event.WindowEvent evt) { 
		    con.fermer_Connexion();
		}
	    });
	this.setSize(1000,650);
	this.setLocation(100,50);
	this.setTitle("Interface des employés");


	/****************  pour le choix client  *************/
	idReservField = new JTextField();
	JLabel idReservText = new JLabel("ID réservation :");
	nomCliField = new JTextField();
	JLabel nomCliText = new JLabel("Nom client :");
	prenomCliField = new JTextField();
	JLabel prenomCliText = new JLabel("Prénom client :");

	liste1 = new JComboBox();
	/***************  pour le choix de la réservation  *************/
        liste2 = new JComboBox();
	/***************  pour le message d'erreur  *************/
	JLabel message=new JLabel();
	/***************  pour le choix de chambre  *************/
        hotel=new JPanel();
	/***************  pour la validation de la chambre  *************/
	JButton changerCh=new Bouton("Changer",l,"changerCh");
	/***************  pour la finalisation  *************/
	JLabel validation=new JLabel();

	this.l = new Listen(this,idReservField,nomCliField,prenomCliField);

       	/*********************** Zone de Création ***********************/
	
	
	JButton newRequete1 = new Bouton("nouvelle requête",l,"new");
	JButton newRequete2= new Bouton("nouvelle requête",l,"new");
	JButton newRequete3 = new Bouton("nouvelle requête",l,"new");
	JButton newRequete4 = new Bouton("nouvelle requête",l,"new");
	JButton newRequete5 = new Bouton("nouvelle requête",l,"new");
	JButton newRequete6 = new Bouton("nouvelle requête",l,"new");
	
	infoClient1 = new JLabel("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
	infoClient2 = new JLabel("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
	infoClient3 = new JLabel("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
	infoClient4 = new JLabel("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
	infoClient5 = new JLabel("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
	infoClient6 = new JLabel("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
	
	infoReserv1 = new JLabel("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
	infoReserv2 = new JLabel("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
	infoReserv3 = new JLabel("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
	infoReserv4 = new JLabel("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
	infoReserv5 = new JLabel("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
	infoReserv6 = new JLabel("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
	
	
	JButton sortie1= new Bouton("Quitter",l,"quitter");
	JButton sortie2= new Bouton("Quitter",l,"quitter");
	JButton sortie3= new Bouton("Quitter",l,"quitter");
	JButton sortie4= new Bouton("Quitter",l,"quitter");
	JButton sortie5= new Bouton("Quitter",l,"quitter");
	JButton sortie6= new Bouton("Quitter",l,"quitter");

        valider1 = new Bouton("Valider",l,"Client");
	JButton valider2 = new Bouton("Valider",l,"reserver");
	JButton valider4 = new Bouton("Valider",l,"Finir");
	JButton valider5 = new Bouton("Valider",l,"Finir");

	/********** Préférences des designs des créations *****************/

	//Color a= new Color(0x91BACF);
	infoClient1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoReserv1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoClient2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoReserv2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoClient3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoReserv3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoClient4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoReserv4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoClient5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoReserv5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoClient6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	infoReserv6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	
	idReservField.setPreferredSize(new Dimension(250, 25));
	idReservField.setForeground(Color.BLACK);
	nomCliField.setPreferredSize(new Dimension(250, 25));
	nomCliField.setForeground(Color.BLACK);
	prenomCliField.setPreferredSize(new Dimension(250, 25));
	prenomCliField.setForeground(Color.BLACK);

	/************** Zone de positionnement ************/

	cards = new JPanel();
	pmenu = new JPanel();
	pchoixRes = new JPanel();
        perr = new JPanel();
	pchoixCh = new JPanel();
	pvalidCh = new JPanel();
	pFini = new JPanel();

	pmenu.setLayout(new GridBagLayout());
	pchoixRes.setLayout(new GridBagLayout());
	perr.setLayout(new GridBagLayout());
	pchoixCh.setLayout(new GridBagLayout());
	pvalidCh.setLayout(new GridBagLayout());
	pFini.setLayout(new GridBagLayout());
	cards.setLayout(new CardLayout());

        c= new GridBagConstraints();
	c.gridx=0;
	c.gridy=0;
	c.gridwidth=1;  //colonnes
	c.gridheight=1;  // lignes
	c.fill=GridBagConstraints.BOTH;
	c.ipady = c.anchor = GridBagConstraints.LINE_START;
	c.insets=new Insets(0,0,0,0);
	c.weightx=1.0f;
	c.weighty=1.0f;
	pmenu.add(newRequete1,c);  // 1 ere info
	pchoixRes.add(newRequete2,c);
	perr.add(newRequete3,c);
	pchoixCh.add(newRequete4,c);
	pvalidCh.add(newRequete5,c);
	pFini.add(newRequete6,c);

	c.gridheight=2;
	c.gridx = 0;
	c.gridy = 1;
        pmenu.add(infoClient1,c);  // 2 eme info
	pchoixRes.add(infoClient2,c);
	perr.add(infoClient3,c);
	pchoixCh.add(infoClient4,c);
	pvalidCh.add(infoClient5,c);
	pFini.add(infoClient6,c);

	c.gridheight=2;
	c.gridx = 0;
	c.gridy = 3;
	pmenu.add(infoReserv1,c);  // 3 eme info
	pchoixRes.add(infoReserv2,c);
	perr.add(infoReserv3,c);
	pchoixCh.add(infoReserv4,c);
	pvalidCh.add(infoReserv5,c);
	pFini.add(infoReserv6,c);

	c.gridx = 1;
	c.gridy = 1;
	c.gridheight=1;
	pmenu.add(new JLabel(),c);  //servent a éviter le répartissement de la place non utilisée vers l'exterieur
	pchoixRes.add(new JLabel(),c);
	perr.add(new JLabel(),c);
	pchoixCh.add(new JLabel(),c);
	pvalidCh.add(new JLabel(),c);
	pFini.add(new JLabel(),c);
	
	//bouton quitter
	c.gridx = 5;
	c.gridy = 0;
	c.gridheight=1;
	c.weighty=1.0f; 
	c.anchor = GridBagConstraints.LINE_END;
	c.fill = GridBagConstraints.NONE;
	pmenu.add(sortie1,c);
	pchoixRes.add(sortie2,c);
	perr.add(sortie3,c);
	pchoixCh.add(sortie4,c);
	pvalidCh.add(sortie5,c);
	pFini.add(sortie6,c);

	c.weightx=0.0f;
	c.gridheight=1;
	c.gridx = 2;
	c.gridy = 0;
	pmenu.add(idReservText,c);
	c.gridy = 1;
	pmenu.add(prenomCliText,c);
	c.gridy = 2;
	pmenu.add(nomCliText,c);
	c.gridx = 3;
	c.gridy = 0;
	pmenu.add(idReservField,c);
	c.gridy = 1;
	pmenu.add(prenomCliField,c);
	c.gridy = 2;
	pmenu.add(nomCliField,c);

	c.gridx=4;
	c.gridy=4;
	pmenu.add(valider1, c);
	pchoixRes.add(valider2, c);
	pchoixCh.add(valider4, c);
	pvalidCh.add(valider5, c);
	c.gridx=2;
	pvalidCh.add(changerCh,c);


	c.gridx=1;
	c.gridy=1;
	c.gridwidth=3;  //colonnes
	c.gridheight=3;
	pchoixCh.add(hotel, c);
	
	    
	
	///////*******************************************valid.setActionCommand("Client");

	cards.add(menu,pmenu);
	cards.add(choixRes,pchoixRes);
	cards.add(err,perr);
	cards.add(choixCh,pchoixCh);
	cards.add(validCh,pvalidCh);
	cards.add(fini,pFini);

	this.add(cards);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
    }
    /**
     * Permet de r&eacute;initialiser la fenetre.
     * 
     **/
    public void changerVersDebut(){   //1
	setInitialisation();
	this.remove(liste1);
	pmenu.remove(liste1);
	cards.remove(liste1);
	this.revalidate();
	valider1.setActionCommand("Client");
	((CardLayout) cards.getLayout()).show(cards,menu);
    }
    public void changerVersFin(){ 
	((CardLayout) cards.getLayout()).show(cards,fini);
    }
    /**
     * Permet d'afficher un message d'erreur.
     *
     * @param e String message, Object c.
     **/
    public void changerVersValideCh(){
	((CardLayout) cards.getLayout()).show(cards,validCh);
    }
    
    /**
     * Permet d'afficher un message d'erreur.
     *
     * @param e String message, Object c.
     **/
    public void changerVersErreur(String message, Object c){   //3
	//if pb avec client
	//message.setText("Le client "+c.prenom+" "+c.nom+" n'a pas été trouvé.");    // message existe?
	((CardLayout) cards.getLayout()).show(cards,err);
    }
    /**
     * Permet d'afficher le bouton radio pour choisir la r&eacute;servation.
     *
     * @param e Client c.
     **/
    public void changerVersChoixReserv(Client c/*, Reservation[] k*/){ 
	String id="";
	String prenom="";
	String nom="";
	for(int i=0;i<10;i++) {
	    /* je concatène par étape car le compilateur ma jeter dans une concaténation consécutive, oui c'est sale... mais bon good enought*/
	    
	    if(c.info[0][i]!=null) id=id+c.info[0][i];
	    if(c.info[1][i]!=null) nom=nom+c.info[1][i];
	    if(c.info[2][i]!=null) prenom=prenom+c.info[2][i];
	}
	infoClient2.setText("<html>Client<br><br>Nom:"+nom+"<br>Prénom:"+prenom+"<br>Id:"+id+"</html>");
        infoClient3.setText("<html>Client<br><br>Nom:"+nom+"<br>Prénom:"+prenom+"<br>Id:"+id+"</html>");
	infoClient4.setText("<html>Client<br><br>Nom:"+nom+"<br>Prénom:"+prenom+"<br>Id:"+id+"</html>");
	infoClient5.setText("<html>Client<br><br>Nom:"+nom+"<br>Prénom:"+prenom+"<br>Id:"+id+"</html>");
	infoClient6.setText("<html>Client<br><br>Nom:"+nom+"<br>Prénom:"+prenom+"<br>Id:"+id+"</html>");
	
	((CardLayout) cards.getLayout()).show(cards,choixRes);
    }



    public void changerVersValiderChambre(int tab[]){ // int? boolean?
	((CardLayout) cards.getLayout()).show(cards,validCh);
    }
    /**
     * Affiche les chambres disponibles correspondant au type de chambre de la réservation
     *
     * @param e int[] tab.
     **/
    public void changerVersChoixChambre(String tableau[][]){ // int? boolean?
	/*hotel.removeAll();
	int[] tab= new tab[50];
	for(int i=0; i<tableau.length(); i++){
	    tab[i]=Integer.StringTo(tableau[2][i]);
	}
	if (tab.length==50){
	    this.hotel.setLayout(new GridLayout(5,10));
	    for(int i = 1; i < 51; i++)
		if(tab[i-1]=1){
		    this.hotel.add(new JLabel(""+i));
		}
	    else
		this.hotel.add(new Bouton(""+i,l,Integer.toString(i)));
	    // else (est non dispo)
	    //comment faire pour différencier? couleur? if devant ? if() -croix unicode?- else -cas normal?
	}
	if (tab.length==25){
	    GridLayout ges = new GridLayout(5,5);
	    this.hotel.setLayout(ges);
	    for(int i = 1; i < 51; i++)
		// if dispo
		this.hotel.add(new JButton(""+i));
	    // else (est non dispo)
	    //hotel.add(new JLabel(""+i));
	    //comment faire pour différencier? couleur? if devant ? if() -croix unicode?- else -cas normal?
	}
	//message.setText("Le client "+c.prenom+" "+c.nom+" n'a pas été trouvé.");    // message existe?*/
	((CardLayout) cards.getLayout()).show(cards,choixCh);
    }

     /**
     * Initialise tous les objets de la fenetre pour la r&eacute;utilisation.
     *
     * @param e String message, Object c.
     **/
    public void setInitialisation(){  //pour les labels
        infoClient1.setText("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
        infoClient2.setText("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
        infoClient3.setText("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
        infoClient4.setText("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
        infoClient5.setText("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
        infoClient6.setText("<html>Client<br><br>Nom:<br>Prénom:<br>Id:</html>");
	
	infoReserv1.setText("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
        infoReserv2.setText("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
        infoReserv3.setText("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
	infoReserv4.setText("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
        infoReserv5.setText("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");
        infoReserv6.setText("<html>Réservation<br><br>Nb de nuits:<br>Type de chambre:<br></html>");

	idReservField.setText("");
	nomCliField.setText("");
	prenomCliField.setText("");
    }
   static String info[][]=new String[4][10];
    //JButton b_box = new JButton("ok");

    @SuppressWarnings("unchecked")
    public void Choix_Client(String[][] tab) {
    info=tab;
	liste1 = new JComboBox();
        

	int i_t=Integer.parseInt(info[3][0]);
	String client=null;
	for(int i=0;i<i_t;i++) {
	    /* je concatène par étape car le compilateur ma jeter dans une concaténation consécutive, oui c'est sale... mais bon good enought*/
	    client=info[0][i]+" ";
	    client=client+info[1][i];
	    client=client+" ";
	    client=client+info[2][i];
	    System.out.println(client);
	    liste1.addItem((String)client);
	}
	liste1.setActionCommand("bobox");
	valider1.setActionCommand("bobox");
	Listen l = new Listen(liste1);
	//b_box.addActionListener(l);
	c.gridx=2;
	c.gridy=3;
	c.gridwidth=1;  //colonnes
	c.gridheight=1;
	pmenu.add(liste1, c);
	this.revalidate();

    }

    static String reserve[][]=new String[4][10];
    @SuppressWarnings("unchecked")
    public void Choix_Reservation(String[][] reservation) {
	System.out.println("avant");
	reserve=reservation;
	System.out.println("aprés");
	int p=0;
        liste2 = new JComboBox();
	liste2.setActionCommand("reserver");
    	int i_t=Integer.parseInt(reservation[3][0]);
    	String client_r=null;
    	for(int i=0;i<i_t;i++) {
	    /* je concatène par étape car le compilateur ma jeter dans une concaténation consécutive, oui c'est sale... mais bon good enought*/
	    client_r=reservation[0][i]+" ";
	    client_r=client_r+reservation[1][i];
	    client_r=client_r+" ";
	    client_r=client_r+reservation[2][i];
	    System.out.println(client_r);
	    liste2.addItem((String)client_r);
	}	
	Listen li = new Listen(liste2,p);
	c.gridx=3;
	c.gridy=1;
	c.gridwidth=1;  //colonnes
	c.gridheight=1;
	System.out.println("essai liste");
	pchoixRes.add(liste2,c);
	this.revalidate();
    }
    
    public String[][] getInfo_box() {
    	return info;
    }
    public String[][] getReservation_box() {
	return reserve;
    }


    public void proposer_chambre(String id) {
	
	JLabel chambre = new JLabel("Chambre attribuer :"+id);
	Listen li = new Listen(id);
	c.gridx=2;
	c.gridy=2;
	pvalidCh.add(chambre,c);
	changerVersValideCh();
    }

    public void champ_vide() {
	JLabel vide = new JLabel("Veuillez entrer les information");
	this.add(vide);
    }
    
}
/**
     * Lorsqu'un bouton est cliqu&eacute;, actionPerformed s'active et appelle la fonction boutonPouser, et red&eacute;ssine la fen&ecirc;tre avec les nouvelles donn&eacute;es.
     *
     * @param e ActionEvent e.
     **/


// se met dans Listen

    /*@Override
    public void actionPerformed(ActionEvent e){
	String txt=e.getActionCommand();   //recoit par exemple "19"

	//si != de "-croix unicode-"{

	int valeur=Integer.parseInt(txt);  // on a 19
	this.etat.boutonPouser(valeur);    // réaction a un bouton, entrainait plein d'autres fonctions... du genre changer des variables
	mettreAJour(this.etat);            // remettais les données de la fenetre a jour
	this.fond.score.setText("Score:"+etat.donnerScore());  //mise a jour 
	this.fond.repaint();    //bah voila quoi
	//}
    }*/





/* pas mal:
   http://isabelle.thieblemont.pagesperso-orange.fr/java/cardlay.html  */
    
