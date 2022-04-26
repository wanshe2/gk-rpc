package org.wanshe.gkrpc;

import lombok.Data;

/**
 * 表示一个RPC响应
 *
 * @author wanshe
 */
@Data
public class Response {
    /**
     * 状态码：0-成功：非0-失败
     */
    private int code = 0;
    /**
     * 状态描述信息
     */
    private String message = "ok";
    /**
     * 返回数据
     */
    private Object data;
}
