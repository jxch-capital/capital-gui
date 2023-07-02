package org.jxch.capital.gui;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes2.QueryInterval;
import yahoofinance.query2v8.HistQuotesQuery2V8Request;

import java.io.IOException;
import java.net.*;
import java.util.Collections;
import java.util.List;

@Slf4j
class JStockTest {

    @Test
    public void test() throws IOException {

        // 设置代理服务器的主机和端口
        String proxyHost = "127.0.0.1";
        int proxyPort = 10809;

        // 创建代理对象
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));

        // 设置全局的代理选择器
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                return Collections.singletonList(proxy);
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                // 处理连接失败的情况
                log.info("连接失败");
            }
        });


        String symbol = "AAPL"; // 股票代码

        HistQuotesQuery2V8Request request = new HistQuotesQuery2V8Request(symbol, QueryInterval.DAILY);
        List<HistoricalQuote> result = request.getResult();

        log.info(JSON.toJSONString(request));

    }


  
}