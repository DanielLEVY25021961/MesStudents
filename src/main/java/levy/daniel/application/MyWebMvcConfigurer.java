package levy.daniel.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import levy.daniel.application.model.utilitaires.formattersspring.LocalDateFormatter;
import levy.daniel.application.model.utilitaires.formattersspring.LocalDateTimeFormatter;

/**
 * CLASSE MyWebMvcConfigurer :<br/>
 * Surcharge la configuration de SPRING pour ajouter des convertisseurs
 * , Thymeleaf, les Layouts de Thymeleafs
 * , les chemins des ressources, ....<br/>
 * <ul>
 * <li>doit comporter l'annotation "Configuration" 
 * pour être lue lors du lancement de l'application (Bootstrap).</li>
 * <li>ATTENTION : 
 * <strong>ne doit surtout pas comporter l'annotation EnableWebMvc</strong>. 
 * Cette annotation <i>annule toute la configuration automatique 
 * réalisée par SPRING BOOT</i>.</li>
 * <li></li>
 * <li></li>
 * <li></li>
 * </ul>
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
 * @since 2 déc. 2019
 *
 */
@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "{levy.daniel.application}")
public class MyWebMvcConfigurer 
						implements WebMvcConfigurer, ApplicationContextAware  {

	// ************************ATTRIBUTS************************************/

	/**
	 * ApplicationContext injecté par SPRING.
	 */
	private ApplicationContext applicationContext;
	
	/**
	 * Localisation des ressources.
	 */
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS 
		= {"classpath:/META-INF/resources/"
				, "classpath:/META-INF/resources/webjars/"
				, "classpath:/resources/"
				, "classpath:/resources/static/"
				, "classpath:/static/"
				, "classpath:/public/"};
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(MyWebMvcConfigurer.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE. 
	 */
	public MyWebMvcConfigurer() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


    
	/**
	 * {@inheritDoc}<br/>
	 * <br/>
	 * <ul>
	 * <li>ajoute des <strong>convertisseurs de format</strong> 
	 * à SPRING BOOT 2.2.1 et SPRING Framework 5.2.1.</li>
	 * <li>INDISPENSABLE POUR REALISER LA CONVERSION DES <code>String</code> 
	 * provenant d'un Calendrier (input de type="date") en
	 * <code>java.time.LocalDate</code> directement dans les 
	 * FORMULAIRES DE SAISIE pour transmettre un BEAN au CONTROLLER.</li>
	 * <li>Une fois ces convertisseurs enregistrés dans le contexte SPRING 
	 * par le <code>org.springframework.format.FormatterRegistry</code>, 
	 * ils sont directement appelés pour convertir dans les pages HTML 
	 * contenant des formulaires.</li>
	 * </ul>
	 */
	@Override
    public void addFormatters(final FormatterRegistry pRegistry) {
		
        pRegistry.addFormatter(localDateTimeFormatter());
        pRegistry.addFormatter(localDateFormatter());
        
    } // Fin de addFormatters(...).________________________________________

	
	
	/**
	 * retourne un LocalDateTimeFormatter implémentant 
	 * <code>org.springframework.format.Formatter&lt;LocalDateTime&gt;</code> 
	 * pour la conversion des <code>java.time.LocalDateTime</code>.
	 *
	 * @return : LocalDateTimeFormatter : 
	 * <code>levy.daniel.application.model.utilitaires
	 * .formattersspring.LocalDateTimeFormatter</code>
	 */
	@Bean("LocalDateTimeFormatter")
	public LocalDateTimeFormatter localDateTimeFormatter() {
		return new LocalDateTimeFormatter();		
	} // Fin de localDateTimeFormatter().__________________________________

	
	
	/**
	 * retourne un LocalDateFormatter implémentant 
	 * <code>org.springframework.format.Formatter&lt;LocalDate&gt;</code> 
	 * pour la conversion des <code>java.time.LocalDate</code>.
	 *
	 * @return : LocalDateFormatter : 
	 * <code>levy.daniel.application.model.utilitaires.formattersspring
	 * .LocalDateFormatter</code>
	 */
	@Bean("LocalDateFormatter")
	public LocalDateFormatter localDateFormatter() {
		return new LocalDateFormatter();		
	} // Fin de localDateFormatter().______________________________________

	

//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//		
//		if (!registry.hasMappingForPattern("/webjars/**")) {
//			registry.addResourceHandler("/webjars/**").addResourceLocations(
//					"classpath:/META-INF/resources/webjars/");
//		}
//		
//		if (!registry.hasMappingForPattern("/**")) {
//			registry.addResourceHandler("/**").addResourceLocations(
//					CLASSPATH_RESOURCE_LOCATIONS);
//		}
//		
//        registry.addResourceHandler("/images/**").addResourceLocations("/images/", "classpath:/static/images/");
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/", "classpath:/static/css/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/", "classpath:/static/js/");
//        
//        
//    }
	
	
	
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//    } 
	
	
	
//    /**
//     * installe le nz.net.ultraq.thymeleaf.LayoutDialect.<br/>
//     *
//     * @return : nz.net.ultraq.thymeleaf.LayoutDialect
//     */
//    @Bean
//    public LayoutDialect layoutDialect() {
//        return new LayoutDialect();
//    } // Fin de layoutDialect().___________________________________________
	
	
 
//    /**
//     * .<br/>
//     * <br/>
//     *
//     * @return : SpringResourceTemplateResolver :  .<br/>
//     */
//    @Bean
//    public SpringResourceTemplateResolver springResourceTemplateResolver() {
//        return new SpringResourceTemplateResolver();
//    }
 
 
    
//    /**
//     * .<br/>
//     * <br/>
//     *
//     * @return : ITemplateResolver :  .<br/>
//     */
//    @Bean
//    @Description("Thymeleaf template resolver serving HTML 5")
//    public ITemplateResolver thymeleafTemplateResolver() {
// 
//        final ClassLoaderTemplateResolver templateResolver 
//        	= new ClassLoaderTemplateResolver();
// 
//        templateResolver.setPrefix("templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        templateResolver.setCharacterEncoding("UTF-8");
//        templateResolver.setCacheable(false);
//        templateResolver.setOrder(0);
//        templateResolver.setCheckExistence(true);
//        
//        return templateResolver;
//    }

 
    
//    /**
//     * .<br/>
//     * <br/>
//     *
//     * @return : SpringTemplateEngine :  .<br/>
//     */
//    @Bean
//    @Description("Thymeleaf template engine with Spring integration")
//    public SpringTemplateEngine thymeleafTemplateEngine() {
// 
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        
        /* ajout le Layout Dialect de Thymeleaf au SpringTemplateEngine. */
//        templateEngine.addDialect(new LayoutDialect());
//        
//        return templateEngine;
//    }
	
	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @return : ViewResolver :  .<br/>
	 */
//	@Bean
//	@Description("Thymeleaf view resolver")
//    public ViewResolver thymeleafViewResolver() {
// 
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
// 
//        viewResolver.setTemplateEngine(thymeleafTemplateEngine());
//        viewResolver.setCharacterEncoding("UTF-8");
//     
//        return viewResolver;
//    }


    
	/**
	 * {@inheritDoc}
	 */
	@Autowired
	@Override
	public void setApplicationContext(
			final ApplicationContext pApplicationContext) throws BeansException {
		this.applicationContext = pApplicationContext;		
	}
	
	
	
} // FIN DE LA CLASSE MyWebMvcConfigurer.------------------------------------
