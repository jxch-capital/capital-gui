package org.jxch.capital.gui.config;

import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jxch.capital.gui.CapitalGuiApp;
import org.jxch.capital.gui.controller.MainController;
import org.jxch.capital.gui.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.lang.NonNull;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class MainStageConfig {
    private final MainController mainController;

    @Value("${app.title}")
    private String title;

    @EventListener
    public void onApplicationReady(@NonNull CapitalGuiAppStartedEvent event) {
        Stage stage = SpringContextHolder.APP_CONTEXT.getBean(CapitalGuiApp.MAIN_STAGE_BEAN_NAME, Stage.class);
        stage.setTitle(this.title);
        stage.setScene(mainController.getScene());
        stage.show();
        log.info(event.getMessage());
    }

}
