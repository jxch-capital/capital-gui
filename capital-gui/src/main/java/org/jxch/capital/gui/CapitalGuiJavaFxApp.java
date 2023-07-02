package org.jxch.capital.gui;


import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.jxch.capital.gui.config.JavaFxStartedEvent;
import org.jxch.capital.gui.util.SpringContextHolder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CapitalGuiJavaFxApp extends Application {
    public static final String MAIN_STAGE_BEAN_NAME = "mainStage";

    public static void appLaunch() {
        Application.launch();
    }

    @Override
    public void start(@NonNull Stage stage) {
        stage.show();
        SpringContextHolder.APP_CONTEXT.getBeanFactory().registerSingleton(MAIN_STAGE_BEAN_NAME, stage);
        SpringContextHolder.APP_CONTEXT.publishEvent(new JavaFxStartedEvent("CapitalGuiJavaFxApp Started"));
    }

}