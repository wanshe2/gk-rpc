package org.wanshe.gkrpc.server;

import lombok.extern.slf4j.Slf4j;
import org.wanshe.gkrpc.Request;
import org.wanshe.gkrpc.ServiceDescriptor;
import org.wanshe.gkrpc.common.utils.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理RPC暴露的服务
 *
 * @author wanshe
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> service;

    public ServiceManager() {
        this.service = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);

            service.put(sdp, sis);
            log.info("register service : {} {}", sdp.getClazz(), sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request) {
        ServiceDescriptor sdp = request.getService();
        return service.get(sdp);
    }
}
