package org.wanshe.gkrpc.codec;

/**
 * εεΊεε
 *
 * @author wanshe
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
