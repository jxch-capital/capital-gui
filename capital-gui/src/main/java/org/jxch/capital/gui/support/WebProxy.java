package org.jxch.capital.gui.support;

import lombok.extern.slf4j.Slf4j;
import org.jxch.capital.gui.config.AppSettingConfig;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.*;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class WebProxy {


    public void proxy(@NonNull AppSettingConfig.Proxy config) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP,
                new InetSocketAddress(config.getHost(), config.getPort()));

        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                return Collections.singletonList(proxy);
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                log.error("连接失败[{}]: {}. error: {}", sa, uri, ioe.getMessage());
                ioe.printStackTrace();
            }
        });
    }

}
