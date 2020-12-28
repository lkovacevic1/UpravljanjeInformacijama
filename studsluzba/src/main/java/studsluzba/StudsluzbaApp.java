package studsluzba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import studsluzba.client.MainViewManager;


@SpringBootApplication
@EnableJpaRepositories
public class StudsluzbaApp extends Application{
	
	protected ConfigurableApplicationContext springContext;

	public static void main(String[] args) {
		launch(StudsluzbaApp.class);
	}
	
	@Override
	public void init() {
		springContext = SpringApplication.run(StudsluzbaApp.class);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("RAF studentska sluzba");
		MainViewManager mainView = springContext.getBean(MainViewManager.class);
		//setovanje stage-a za import podataka
		mainView.setMainStage(primaryStage);
		primaryStage.setScene(mainView.createScene());
		primaryStage.show();
	}

	@Override
	public void stop() {
		springContext.close();
		Platform.exit();
	}
	
}
