package org.wanshe.gkrpc.server;

import lombok.Data;
import org.wanshe.gkrpc.codec.Decoder;
import org.wanshe.gkrpc.codec.Encoder;
import org.wanshe.gkrpc.codec.JSONDecoder;
import org.wanshe.gkrpc.codec.JSONEncoder;
import org.wanshe.gkrpc.transport.HTTPTransportServer;
import org.wanshe.gkrpc.transport.TransportServer;

/**
 * server 配置
 *
 * @author wanshe
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 4573;

}
