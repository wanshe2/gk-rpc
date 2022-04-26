package org.wanshe.gkrpc;

import lombok.Data;

/**
 * 表示一个RPC请求
 *
 * @author wanshe
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
