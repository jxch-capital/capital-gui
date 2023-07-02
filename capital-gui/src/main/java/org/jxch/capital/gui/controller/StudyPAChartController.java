package org.jxch.capital.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jxch.capital.gui.support.FXMLController;
import org.jxch.capital.gui.support.FXMLSupport;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes2.QueryInterval;
import yahoofinance.query2v8.HistQuotesQuery2V8Request;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@FXMLController(fxmlPath = "/fxml/studyPAChart.fxml")
public class StudyPAChartController implements FXMLSupport {

    @FXML
    public TextField symbol;
    @FXML
    public TextField interval;


    public void query(ActionEvent event) throws IOException {
        // todo 实现自己的 HistQuotesQuery2V8Request（它的不支持日内图）
        HistQuotesQuery2V8Request request = new HistQuotesQuery2V8Request(symbol.getText(), QueryInterval.DAILY);
        List<HistoricalQuote> result = request.getResult();


    }
}
