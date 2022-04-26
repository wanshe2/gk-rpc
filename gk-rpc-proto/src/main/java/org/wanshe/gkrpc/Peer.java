package org.wanshe.gkrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表示网络传输的一个端点
 *
 * @author wanshe
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}