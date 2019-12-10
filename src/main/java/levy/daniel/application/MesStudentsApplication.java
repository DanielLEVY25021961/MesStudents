package levy.daniel.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import levy.daniel.application.model.persistence.metier.students.dao.jpaspring.StudentDao;
import levy.daniel.application.model.persistence.metier.students.entities.jpa.impl.StudentEntityJPA;

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
public class MesStudentsApplication {
	
	
	
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
	public static void main(String... args) {
		
		ApplicationContext ctx = SpringApplication.run(MesStudentsApplication.class, args);
		
		StudentDao studentDao = ctx.getBean(StudentDao.class);
		
		Pageable pageable = PageRequest.of(0, 3);
				
		Page<StudentEntityJPA> page = studentDao.findByNameContains("ard", pageable);
		
		page.forEach(s -> System.out.println(s));
		
	} // Fin de main(...)._________________________________________________
	
	

} // FIN DE LA CLASSE MesStudentsApplication.--------------------------------
