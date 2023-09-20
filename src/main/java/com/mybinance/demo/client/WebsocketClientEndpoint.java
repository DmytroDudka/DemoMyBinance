package com.mybinance.demo.client;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

@Slf4j
@ClientEndpoint
public class WebsocketClientEndpoint {

    Session userSession = null;
    private MessageHandler messageHandler;
    WebSocketContainer container;

    public WebsocketClientEndpoint() {
        container = ContainerProvider.getWebSocketContainer();
    }

    public void connect(URI endpointURI) {
        try {
            container.connectToServer(this, endpointURI);
        } catch (DeploymentException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnOpen
    public void onOpen(Session userSession) {
        System.out.println("opening websocket");
        this.userSession = userSession;
    }

    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        System.out.println("closing websocket");
        this.userSession = null;
    }


    @OnMessage
    public void onMessage(String message) {
        if (this.messageHandler != null) {
            this.messageHandler.handleMessage(message);
        }
    }

    public void addMessageHandler(MessageHandler msgHandler) {
        this.messageHandler = msgHandler;
    }

    public void sendMessage(String message) {
        this.userSession.getAsyncRemote().sendText(message);
    }

    public void close() {
        try {
            this.userSession.close();
        } catch (IOException e) {
            System.err.println("IOException: session can't be closed normally" + e.getMessage());
        }
    }

    public static interface MessageHandler {
        public void handleMessage(String message);
    }
}
