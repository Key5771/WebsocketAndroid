package com.sslab.test;

import android.provider.Telephony;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Map;

public class Client extends WebSocketClient {

    public Client(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public Client(URI serverUri) {
        super(serverUri);
    }

    public Client(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        send("Hello, it is me. Mario");
        System.out.println("opened connection");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("received: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed by " + (remote ? "remote peer" : "us") + "Code: " + code + " Reason: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}
