package org.jxch.capital.gui;


import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.jxch.capital.gui.config.CapitalGuiAppStartedEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.lang.NonNull;

@Slf4j
@SpringBootApplication
public class CapitalGuiApp extends Application {
    public static final String MAIN_STAGE_BEAN_NAME = "mainStage";
    private static String[] ARGS;

    public static void main(String[] args) {
        ARGS = args;
        Application.launch();
    }

    @Override
    public void start(@NonNull Stage stage) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CapitalGuiApp.class, ARGS);
        applicationContext.getBeanFactory().registerSingleton(MAIN_STAGE_BEAN_NAME, stage);
        applicationContext.publishEvent(new CapitalGuiAppStartedEvent("CapitalGuiApp Started"));
    }

}