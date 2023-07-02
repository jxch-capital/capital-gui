package org.jxch.capital.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jxch.capital.gui.config.AppSettingConfig;
import org.jxch.capital.gui.support.FXMLController;
import org.jxch.capital.gui.support.FXMLSupport;

@Slf4j
@RequiredArgsConstructor
@FXMLController(fxmlPath = "/fxml/main.fxml")
public class MainController implements FXMLSupport {
    private final StudyPAChartController studyPAChartController;
    private final SettingController settingController;
    private final AppSettingConfig appSettingConfig;

    @FXML
    public BorderPane root;
    @FXML
    public MenuItem defaultMenu;

    @FXML
    public void initialize() {
        defaultMenu.fire();
    }

    @FXML
    public void studyPAChart(ActionEvent actionEvent) {
        root.setCenter(studyPAChartController.getParent());
    }

    public void setting(ActionEvent event) {
        root.setCenter(settingController.getParent());
    }

}
