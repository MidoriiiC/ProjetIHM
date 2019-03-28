import java.sql.*;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class GConnexion {
    Connection connexion= null;
    static String info[][]=new String[4][10];
    //etablie la connexion à la base de donnée
    public GConnexion() {
	try {
	    Class.forName("org.mariadb.jdbc.Driver");
	    try{
		connexion = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/mocret", "mocret", "Killian19981206");
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
	    System.out.println("La connection à bien était fermer");
	}catch(SQLException e) {
	    System.out.println("La connection à était mal fermer");
	}
	return 0;
    }

    public int Moyenne_Jour(String jour) {
    	Statement statement = null;
	ResultSet resultat = null;
	PreparedStatement prepare=null;
	PreparedStatement prepare_total=null;
	int nb_j=0; // nombre de reservation pour ce jour
	int nb_t=0; //nombre total de reservation
	int pourcentage=0; // nb_j/nb_t

	try {
	    statement=connexion.createStatement();
	}catch(SQLException e) {
	    System.out.println("statement");
	}

	try{
	    prepare =connexion.prepareStatement("SELECT COUNT (*) FROM Chambre WHERE date_debut=?");
	    prepare.setString(1,jour);

	    prepare_total=connexion.prepareStatement("SELECT COUNT (*) FROM Chambre");
	}catch(SQLException e) {
	    System.out.println("Problème COUNT");
	}

	try {
	    resultat = prepare.executeQuery();
	}catch(SQLException e) {
	    System.out.println("resultat");
	}

	try {
	    nb_j=resultat.getInt(0);
	}catch(SQLException e) {
	    System.out.println("problème récupération de nb_j");
	}

	try {
	    resultat = prepare_total.executeQuery();
	}catch(SQLException e) {
	    System.out.println("resultat_total");
	}

	try {
	    nb_t=resultat.getInt(0);
	}catch(SQLException e) {
	    System.out.println("problème récupération de nb_t");
	}

	pourcentage=nb_j/nb_t;
	pourcentage= pourcentage*100;

	try {
	    statement.close();
	    resultat.close();
	    prepare.close();
	    prepare_total.close();
	}catch(SQLException e) {
	    //throw
	}
	return pourcentage;


    }
}
