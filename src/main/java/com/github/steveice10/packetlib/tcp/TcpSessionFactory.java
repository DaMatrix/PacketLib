package com.github.steveice10.packetlib.tcp;

import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.ConnectionListener;
import com.github.steveice10.packetlib.Server;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.SessionFactory;
import com.github.steveice10.packetlib.packet.PacketProtocol;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * A session factory used to create TCP sessions.
 */
public class TcpSessionFactory implements SessionFactory {
    private Proxy clientProxy;

    public TcpSessionFactory() {
    }

    public TcpSessionFactory(Proxy clientProxy) {
        this.clientProxy = clientProxy;
    }

    @Override
    public Session createClientSession(final Client client) {
        return new TcpClientSession(client.getHost(), client.getPort(), client.getPacketProtocol(), client, this.clientProxy);
    }

    @Override
    public ConnectionListener createServerListener(final Server server) {
        return new TcpConnectionListener(server.getHost(), server.getPort(), server);
    }

    @Override
    public Session createServerSession(InetSocketAddress address, PacketProtocol protocol, Server server) {
        return new TcpServerSession(address.getHostName(), address.getPort(), protocol, server);
    }
}
