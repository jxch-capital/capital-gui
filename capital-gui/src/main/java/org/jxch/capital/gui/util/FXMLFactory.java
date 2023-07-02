package org.jxch.capital.gui.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.util.Objects;

public class FXMLFactory {

    public static Parent getParent(String fxmlPath) {
        try {
            return FXMLLoader.load(Objects.requireNonNull(FXMLFactory.class.getResource(fxmlPath)));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @NonNull
    public static Scene getScene(String fxmlPath) {
        return new Scene(getParent(fxmlPath));
    }

    public static Parent getParent(@NonNull Class<?> controller) {
        FXMLController fxmlController = controller.getAnnotation(FXMLController.class);
        return getParent(Objects.requireNonNull(fxmlController, "可能没有设置 FXMLController 注解").fxmlPath());
    }

    @NonNull
    public static Scene getScene(@NonNull Class<? extends FXMLSupport> controller) {
        FXMLController fxmlController = controller.getAnnotation(FXMLController.class);
        return getScene(Objects.requireNonNull(fxmlController, "可能没有设置 FXMLController 注解").fxmlPath());
    }

}
