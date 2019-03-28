import java.sql.*;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class Chambre {
    static String id[][] = new String[2][50];
    Connection connexion_t=null;
    public Chambre() {
	try {
	    Class.forName("org.mariadb.jdbc.Driver");
	    try{
	    	connexion_t = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/mocret", "mocret", "Killian19981206");
	    }catch(SQLException e) {
	    	System.err.println("Erreur de connection "+ e.getMessage());
	    }
	}catch(ClassNotFoundException e) {
	    System.err.println(e.getMessage());
	}
    }

    Statement statement = null;
    ResultSet resultat = null;
    PreparedStatement reservation=null;
    public String[][] attribute_chambre(String categorie) {
	
	try {
	    statement=connexion_t.createStatement();
	}catch(SQLException e) {
	    System.out.println("statement");
	}
	try{
	    reservation=connexion_t.prepareStatement("SELECT id,etat FROM Chambre WHERE categorie=? AND etat=0");
	    reservation.setString(1,categorie);
	}catch(SQLException e) {
	    System.out.println("reservartion error");
	}

	try {
	    resultat = reservation.executeQuery();
	}catch(SQLException e) {
	    System.out.println("resultat reservation");
	}
	try {
	    Boolean encore=resultat.next();
	    int i=0;
	    while(encore) {
	    	id[0][i]=resultat.getString("id");
		id[1][i]=resultat.getString("categorie");
	    	i++;
		encore=resultat.next();
	    }
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
	return id;


    }

    public void prend_Chambre(String id) {
	PreparedStatement update_date=null;
	try {
	    statement=connexion_t.createStatement();
	}catch(SQLException e) {
	    System.out.println("statement");
	}
	try{
	    reservation=connexion_t.prepareStatement("UPDATE Chambre SET etat=1 WHERE id=?;");
	    reservation.setString(1,id);

	    update_date=connexion_t.prepareStatement("UPDATE Chambre set date_debut=CURRENT_DATE where id=?;");
	    update_date.setString(1,id);
	}catch(SQLException e) {
	    System.out.println("reservartion error");
	}

	try {
	    resultat=null;
	    resultat = reservation.executeQuery();
	}catch(SQLException e) {
	    System.out.println("resultat reservation");
	}

	try {
	    resultat=null;
	    resultat = update_date.executeQuery();
	}catch(SQLException e) {
	    System.out.println("resultat update_date");
	}
	try{
	    statement.close();
	    reservation.close();
	    resultat.close();
	    connexion_t.close();
	}catch(SQLException e) {
	    //throw
	}
	
    }
    public String[][] getChambre() {
	return id;
    }
    
}


