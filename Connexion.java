import java.sql.*;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class Connexion {
    Connection connexion= null;
    static String info[][]=new String[4][10];
    //etablie la connexion à la base de donnée
    public Connexion() {
	try {
	    Class.forName("org.mariadb.jdbc.Driver");
	    try{
		connexion = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/projetihm", "projetihm", "mhitejorp");
	    }catch(SQLException e) {
		System.err.println("Erreur de connection "+ e.getMessage());
	    }
	}catch(ClassNotFoundException e) {
	    System.err.println(e.getMessage());
	}
    }

    //ferme la connexion à la base de donnée
    public int fermer_Connexion() {
	try {
	    connexion.close();
	    System.out.println("La connection à bien été fermée");
	}catch(SQLException e) {
	    System.out.println("La connection à été mal fermée");
	}
	return 0;
    }



    //récupère les informations sur le clients rechercher
    public String[][] getClient(String id, String nom, String prenom, int nb) {
	/*nb sert à savoir à quel cas de figure nous somme confronter et donc de crée la requette adéquate*/
	Statement statement = null;
	ResultSet resultat = null;
	PreparedStatement prepare=null;
	String id_t[] = new String[10];
	String nom_t[] = new String[10];
	String prenom_t[] = new String[10];
	String i_t[] = new String[1];

	
	try {
	    statement=connexion.createStatement();
	}catch(SQLException e) {
	    System.out.println("statement");
	}
	try {
	    //les 3 champs sont pleins
	    if(nb==1) {
		prepare =connexion.prepareStatement("SELECT id,nom,prenom FROM Client WHERE id=? AND nom=? AND prenom=?");
		prepare.setString(1,id);
		prepare.setString(2,nom);
		prepare.setString(3,prenom);
	    }
	    
	    //id et nom remplie mais pas prenom
	    if(nb==2) {
		prepare =connexion.prepareStatement("SELECT id,nom,prenom FROM Client WHERE id=? AND nom=? ");
		prepare.setString(1,id);
		prepare.setString(2,nom);
	    }
	    
	    //id et prenom remplie mais pas nom
	    if(nb==3) {
		prepare =connexion.prepareStatement("SELECT id,nom,prenom FROM Client WHERE id=? AND prenom=?");
		prepare.setString(1,id);
		prepare.setString(2,prenom);
	    }
	    
	    //nom et prenom remplie mais pas id
	    if(nb==4) {
		prepare =connexion.prepareStatement("SELECT id,nom,prenom FROM Client WHERE  nom=? AND prenom=?");
		prepare.setString(1,nom);
		prepare.setString(2,prenom);
	    }
	    
	    //juste id est remplie
	    if(nb==5) {
		prepare =connexion.prepareStatement("SELECT id,nom,prenom FROM Client WHERE id=?");
		prepare.setString(1,id);
	    }
	    
	    //juste nom est remplie
	    if(nb==6) {
		prepare =connexion.prepareStatement("SELECT id,nom,prenom FROM Client WHERE nom=?");
		prepare.setString(1,nom);
	    }
	    
	    //juste prenom remplie
	    if(nb==7) {
		prepare =connexion.prepareStatement("SELECT id,nom,prenom FROM Client WHERE prenom=?");
		prepare.setString(1,prenom);
	    }

	}catch(SQLException e) {
	    System.out.println("Prepare");
	}
	
	//execute la requete
	try {
	    
	    resultat = prepare.executeQuery();
	}catch(SQLException e) {
	    System.out.println("resultat");
	}
	// affiche les information recuperer
	try {
	    Boolean encore = resultat.next();
	    int i=0;
	    while(encore) {
		id_t[i] = resultat.getString("id");
		nom_t[i] = resultat.getString("nom");
		prenom_t[i] = resultat.getString("prenom");
		System.out.println("donnee retournee par id: " +id_t[i]+ "  nom : " +nom_t[i]+"  prenom: "+prenom_t[i]);
		i++;
		encore=resultat.next();
	    }
	    i_t[0]= Integer.toString(i);
	    prepare.close();
	    info[0]=id_t;
	    info[1]=nom_t;
	    info[2]=prenom_t;
	    info[3]=i_t;
	}catch(SQLException e) {
	    //trhow
	}
	return info;
    }


    public String[][] getReservation(String id) {
	Statement statement = null;
	ResultSet resultat = null;
	PreparedStatement reservation=null;
	String reference[] = new String[10];
	Date debut[] =new Date[10];
	String nuits[] =new String[10];
	String categorie[] =new String[10];
	String reservation_t[][] = new String[4][10];
	String i_t[] = new String[1];

	//prépare la requete pour categorie de chambre réservé
	try {
	    statement=connexion.createStatement();
	}catch(SQLException e) {
	    System.out.println("statement");
	}
	try{
	    reservation=connexion.prepareStatement("SELECT reference,debut,nuits,categorie FROM Reservation WHERE client=?");
	    reservation.setString(1,id);
	}catch(SQLException e) {
	    System.out.println("reservartion error");
	}
	//execute requete
	try {
	    resultat=null;
	    resultat = reservation.executeQuery();
	    System.out.println("Prepare bien fermer");
	}catch(SQLException e) {
	    System.out.println("resultat reservation");
	}
	//affiche le resultat
	try {
	    Boolean encore=resultat.next();
	    int i=0;
	    while(encore) {    
		reference[i] = resultat.getString("reference");
		debut[i] = resultat.getDate("debut");
		nuits[i] = resultat.getString("nuits");
		categorie[i] =resultat.getString("categorie");
		System.out.println("reference : "+reference[i]+" debut : "+debut[i]+" nuits : "+nuits[i]+" Categorie reserve : " +categorie[i]);
		i++;
		encore=resultat.next();
	    }
	    i_t[0]= Integer.toString(i);
	    reservation_t[0]=reference;
	    reservation_t[1]= nuits;
	    reservation_t[2]=categorie;
	    reservation_t[3]=i_t;
	}catch(SQLException e) {
	    //trhow
	}
	try{
	    resultat.close();
	    reservation.close();
	    statement.close();
	}catch(SQLException e) {
	    //throw
	}
	return reservation_t;
    }


    public void attribute_Chambre(String categorie) {
	System.out.println("ok");
	
    }

    public String[][] getInfo() {
	return info;
    }

    	
}


