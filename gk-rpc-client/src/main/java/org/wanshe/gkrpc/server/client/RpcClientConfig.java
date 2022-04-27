package org.wanshe.gkrpc.server.client;

import lombok.Data;
import org.wanshe.gkrpc.Peer;
import org.wanshe.gkrpc.codec.Decoder;
import org.wanshe.gkrpc.codec.Encoder;
import org.wanshe.gkrpc.codec.JSONDecoder;
import org.wanshe.gkrpc.codec.JSONEncoder;
import org.wanshe.gkrpc.transport.HTTPTransportClient;
import org.wanshe.gkrpc.transport.TransportClient;

import java.util.Arrays;
import java.util.List;

/**
 * @author wanshe
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass
            = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass
            = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1", 4573)
    );
}
