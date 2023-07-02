package org.jxch.capital.gui.support;

import javafx.scene.Parent;
import javafx.scene.Scene;

public interface FXMLSupport {

    default Scene getScene() {
        return FXMLFactory.getScene(getClass());
    }

    default Parent getParent() {
        return FXMLFactory.getParent(getClass());
    }

}
