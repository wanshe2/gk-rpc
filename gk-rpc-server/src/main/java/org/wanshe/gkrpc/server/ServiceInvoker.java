package org.wanshe.gkrpc.server;

import org.wanshe.gkrpc.Request;
import org.wanshe.gkrpc.common.utils.ReflectionUtils;

/**
 * 调用具体服务
 *
 * @author wanshe
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(
                service.getTarget(),
                service.getMethod(),
                request.getParameters()
        );
    }
}
