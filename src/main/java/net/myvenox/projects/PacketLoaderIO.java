package net.myvenox.projects;

import net.myvenox.projects.packets.BungeeCordToSpigotPacket;
import net.myvenox.projects.packets.ServerToAnotherServerPacket;
import net.myvenox.projects.reader.PacketReader;

public class PacketLoaderIO {

    private String webLink;
    private final String ip;
    private final String token;
    private final PacketReader packetReader;
    private final PacketLoaderIO packetLoaderIO;
    private BungeeCordToSpigotPacket bungeeCordToSpigotPacket;
    private final ServerToAnotherServerPacket serverToAnotherServerPacket;

    public PacketLoaderIO(String ip, String token) {
        this.ip = ip;
        this.token = token;
        this.packetLoaderIO = this;
        this.packetReader = new PacketReader(ip, token, this.getWebLink());
        this.serverToAnotherServerPacket = new ServerToAnotherServerPacket(ip, token, this.getWebLink());
    }

    public void connectServers() {
        final String ip = "0.0.0.0";
        final String token = this.token;
        this.webLink = "http://" + ip + "/" + token + "/";
        this.bungeeCordToSpigotPacket = new BungeeCordToSpigotPacket(ip, token, this.getWebLink());
    }

    public void connectMainServers() {
        final String ip = this.ip;
        final String token = this.token;
        this.webLink = "http://" + ip + "/" + token + "/";
        this.bungeeCordToSpigotPacket = new BungeeCordToSpigotPacket(ip, token, this.getWebLink());
    }

    public PacketLoaderIO getPacketLoaderIO() {
        return this.packetLoaderIO;
    }

    public BungeeCordToSpigotPacket getBungeeCordToSpigotPacket() {
        return this.bungeeCordToSpigotPacket;
    }

    public ServerToAnotherServerPacket getServerToAnotherServerPacket() {
        return this.serverToAnotherServerPacket;
    }

    public String getWebLink() {
        return webLink;
    }

    public PacketReader getPacketReader() {
        return packetReader;
    }
}
