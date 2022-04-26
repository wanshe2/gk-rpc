package org.wanshe.gkrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于JSON的序列化实现
 *
 * @author wanshe
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
