package org.wanshe.gkrpc.example;

import lombok.extern.slf4j.Slf4j;
import org.wanshe.gkrpc.server.client.RpcClient;

/**
 * @author wanshe
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);

        int r1 = service.add(1, 2);
        int r2 = service.sub(1, 2);

        System.out.println(r1);
        System.out.println(r2);
    }
}
