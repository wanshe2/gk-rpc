package org.wanshe.gkrpc.server.client;

import lombok.extern.slf4j.Slf4j;
import org.wanshe.gkrpc.Peer;
import org.wanshe.gkrpc.common.utils.ReflectionUtils;
import org.wanshe.gkrpc.transport.TransportClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wanshe
 */
@Slf4j
public class RandomTransportSelector implements TransportSelector {
    /**
     * 已经连接好的client
     */
    private List<TransportClient> clients;

    public RandomTransportSelector() {
        clients = new ArrayList<>();
    }

    @Override
    public synchronized void init(List<Peer> peers, int count,
                     Class<? extends TransportClient> clazz) {
        count = Math.max(peers.size(), 1);

        // 每个端口都创建 count 个连接
        for (Peer peer : peers) {
            for (int i = 0; i < count; ++ i) {
                TransportClient client = ReflectionUtils.newInstance(clazz);

                client.connect(peer);
                clients.add(client);
            }
            log.info("connect server: {}", peer);
        }
    }

    @Override
    public synchronized TransportClient select() {
        int i = new Random().nextInt(clients.size());
        // 获取连接 - 移除出可用队列
        return clients.remove(i);
    }

    @Override
    public synchronized void release(TransportClient client) {
        clients.add(client);
    }

    @Override
    public synchronized void close() {
        for (TransportClient client : clients) {
            client.close();
        }
        clients.clear();
    }
}
