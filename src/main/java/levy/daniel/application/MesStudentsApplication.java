package levy.daniel.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CLASSE MesStudentsApplication :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 30 nov. 2019
 *
 */
@SpringBootApplication
public class MesStudentsApplication { // NOPMD by dan on 11/12/19 20:07
	
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MesStudentsApplication() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * Point d'entrée de l'application.
	 *
	 * @param args : String[].<br/>
	 */
	public static void main(final String... args) {
		
		SpringApplication.run(MesStudentsApplication.class, args);
		
	} // Fin de main(...)._________________________________________________
	
	

} // FIN DE LA CLASSE MesStudentsApplication.--------------------------------
