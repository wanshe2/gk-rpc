package org.wanshe.gkrpc.codec;

/**
 * 反序列化
 *
 * @author wanshe
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
