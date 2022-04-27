package org.wanshe.gkrpc.server.client;

import org.wanshe.gkrpc.Peer;
import org.wanshe.gkrpc.transport.TransportClient;

import java.util.List;

/**
 * 表示选择哪个server去连接
 *
 * @author wanshe
 */
public interface TransportSelector {
    /**
     * 初始化selector
     *
     * @param peers 可以连接的server端点信息
     * @param count client与server创建连接个数
     * @param clazz client实现类
     */
    void init(List<Peer> peers, int count,
              Class<? extends TransportClient> clazz);

    /**
     * 选择一个transport与server做交互
     *
     * @return 网络client
     */
    TransportClient select();

    /**
     * 释放用完的client
     *
     * @param client
     */
    void release(TransportClient client);

    void close();
}
