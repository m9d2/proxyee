package com.github.monkeywie.proxyee.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class WebSocketFrameHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            if (msg instanceof TextWebSocketFrame) {
                TextWebSocketFrame frame = (TextWebSocketFrame) msg;
                System.out.println("WebSocket Text Frame: " + frame.text());
            } else if (msg instanceof BinaryWebSocketFrame) {
                BinaryWebSocketFrame frame = (BinaryWebSocketFrame) msg;
                System.out.println("WebSocket Binary Frame: " + frame.content().readableBytes() + " bytes");
            } else {
                System.out.println("WebSocket Frame: " + msg.getClass().getSimpleName());
            }

            // 将消息传递给下一个处理器
            ctx.fireChannelRead(msg);
        }
    }