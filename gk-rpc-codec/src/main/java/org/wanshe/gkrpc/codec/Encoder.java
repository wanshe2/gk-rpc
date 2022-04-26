package org.wanshe.gkrpc.codec;

/**
 * 序列化
 *
 * @author wanshe
 */
public interface Encoder {
    byte[] encode(Object obj);
}
