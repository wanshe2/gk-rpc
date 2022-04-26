package org.wanshe.gkrpc.transport;

import org.wanshe.gkrpc.Peer;

import java.io.InputStream;

/**
 * 1、创建连接
 * 2、发送数据，等待响应
 * 3、关闭连接
 *
 * @author wanshe
 */
public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();
}
