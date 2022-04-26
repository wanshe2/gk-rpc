package org.wanshe.gkrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的handler
 *
 * @author wanshe
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream toResponse);
}
