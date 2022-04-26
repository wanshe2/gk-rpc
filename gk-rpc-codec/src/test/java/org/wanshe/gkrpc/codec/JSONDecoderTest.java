package org.wanshe.gkrpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wanshe
 */
public class JSONDecoderTest {

    @Test
    public void decode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("wanshe");
        bean.setAge(18);

        byte[] bytes = encoder.encode(bean);

        Decoder decoder = new JSONDecoder();
        TestBean bean1 = decoder.decode(bytes, TestBean.class);
        assertEquals("wanshe", bean1.getName());
        assertEquals(18, bean1.getAge());
    }
}