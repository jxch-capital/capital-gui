package org.jxch.capital.gui.config;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.jxch.capital.gui.CapitalGuiJavaFxApp;
import org.jxch.capital.gui.util.SpringContextHolder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Slf4j
@Configuration
public class MainStageConfig  {

    @EventListener
    public void onApplicationReady(JavaFxStartedEvent event) {
        Stage stage = SpringContextHolder.APP_CONTEXT.getBean(CapitalGuiJavaFxApp.MAIN_STAGE_BEAN_NAME, Stage.class);
        stage.setTitle("Capital");
        stage.setScene(new Scene(new Label("Hello World"), 300, 275));
    }

}
