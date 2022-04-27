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
        log.info(":" + CalcService.class + " : " + CalcService.class.getName());
        CalcService service = (CalcService) client.getProxy(CalcService.class);

        if (service == null) {
            log.info("return is null");
            return ;
        } else {
            log.info("serviceClass : " + service.getClass().getName());
            log.info("service add : " + service.add(1, 1));
        }

        int r1 = service.add(1, 2);
        int r2 = service.sub(1, 2);

        System.out.println(r1);
        System.out.println(r2);
    }
}
