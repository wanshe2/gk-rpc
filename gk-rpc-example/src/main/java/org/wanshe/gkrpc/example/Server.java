package org.wanshe.gkrpc.example;

import org.wanshe.gkrpc.server.RpcServer;
import org.wanshe.gkrpc.server.RpcServerConfig;

/**
 * @author wanshe
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
