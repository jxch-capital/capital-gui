package org.jxch.capital.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import org.jxch.capital.gui.support.FXMLController;
import org.jxch.capital.gui.support.FXMLSupport;
import yahoofinance.histquotes.HistoricalQuote;

import java.util.List;

@FXMLController(fxmlPath = "/fxml/klineChart.fxml")
public class KlineChartController implements FXMLSupport {

    @FXML
    public WebView chart;


    public void updateChartByKLine(List<HistoricalQuote> quotes) {

    }

}
