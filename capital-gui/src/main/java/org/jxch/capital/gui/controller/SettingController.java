package org.jxch.capital.gui.controller;

import com.alibaba.fastjson2.JSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jxch.capital.gui.config.AppSettingConfig;
import org.jxch.capital.gui.support.FXMLController;
import org.jxch.capital.gui.support.FXMLSupport;
import org.jxch.capital.gui.support.WebProxy;

@Slf4j
@RequiredArgsConstructor
@FXMLController(fxmlPath = "/fxml/setting.fxml")
public class SettingController implements FXMLSupport {
    private final AppSettingConfig appSettingConfig;
    private final WebProxy webProxy;
    @FXML
    public TextField host;

    @FXML
    public TextField port;

    public void setProxy(ActionEvent event) {
        AppSettingConfig.Proxy proxy = new AppSettingConfig.Proxy(host.getText(), Integer.parseInt(port.getText()));
        appSettingConfig.setProxy(proxy);

        webProxy.proxy(appSettingConfig.getProxy());
        log.info("设置网络代理：{}", JSON.toJSONString(proxy));
    }

}
