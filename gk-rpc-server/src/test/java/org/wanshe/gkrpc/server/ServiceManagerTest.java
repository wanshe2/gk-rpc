package org.wanshe.gkrpc.server;

import org.junit.Before;
import org.junit.Test;
import org.wanshe.gkrpc.Request;
import org.wanshe.gkrpc.ServiceDescriptor;
import org.wanshe.gkrpc.common.utils.ReflectionUtils;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author wanshe
 */
public class ServiceManagerTest {
    ServiceManager sm;

    @Before
    public void init() {
        sm = new ServiceManager();
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void lookup() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);

        Method[] methods = ReflectionUtils.getPublicMethods(TestInterface.class);
        assertEquals(methods.length, 1);
        assertEquals(methods[0].getName(), "todo");
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, methods[0]);

        Request request = new Request();
        request.setService(sdp);

        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);
    }
}