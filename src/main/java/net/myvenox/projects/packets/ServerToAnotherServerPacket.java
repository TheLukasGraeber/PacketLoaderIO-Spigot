package net.myvenox.projects.packets;

import net.myvenox.projects.reader.PacketReader;

import java.io.IOException;

public class ServerToAnotherServerPacket {

    private final String ip;
    private final String token;
    private final String webLink;
    private final PacketReader packetReader;

    public ServerToAnotherServerPacket(String ip, String token, String webLink) {
        this.ip = ip;
        this.token = token;
        this.webLink = webLink;
        this.packetReader = new PacketReader(this.getIp(), this.getToken(), this.getWebLink());
    }

    public void registerPacket(String mainPacket, String packet) {
        try {
            this.getPacketReader().sendToReader(mainPacket, packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerPacket(String mainPacket, String packet, String packet2) {
        try {
            this.getPacketReader().sendToReader(mainPacket, packet, packet2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerPacket(String mainPacket, String packet, String packet2, String packet3) {
        try {
            this.getPacketReader().sendToReader(mainPacket, packet, packet2, packet3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerPacket(String mainPacket, String packet, String packet2, String packet3, String packet4) {
        try {
            this.getPacketReader().sendToReader(mainPacket, packet, packet2, packet3, packet4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerPacket(String mainPacket, String packet, String packet2, String packet3, String packet4, String packet5) {
        try {
            this.getPacketReader().sendToReader(mainPacket, packet, packet2, packet3, packet4, packet5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerPacket(String mainPacket, String packet, String packet2, String packet3, String packet4, String packet5, String packet6) {
        try {
            this.getPacketReader().sendToReader(mainPacket, packet, packet2, packet3, packet4, packet5, packet6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteMainPacket(String mainPacket) {
        try {
            this.getPacketReader().deleteMainPacket(mainPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean isMainPacketRegistered(String mainPacket) {
        return this.getPacketReader().isMainPacketRegistered(mainPacket);
    }

    public String getPacket(String mainPacket, int id) {
        return this.getPacketReader().getPacket(mainPacket, id);
    }

    private String getIp() {
        return ip;
    }

    private String getToken() {
        return token;
    }

    public String getWebLink() {
        return webLink;
    }

    public PacketReader getPacketReader() {
        return packetReader;
    }

}
