package net.myvenox.projects.reader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class PacketReader {

    private final String ip;
    private final String token;
    private final String webLink;

    public PacketReader(String ip, String token, String webLink) {
        this.ip = ip;
        this.token = token;
        this.webLink = webLink;
    }

    public void sendToReader(String mainPacket, String packet) throws IOException {
        URLConnection request = null;
        try {
            URL url = new URL("http://" + this.getIp() + "/" + token + "/reader/send.php?token=" + token + "&mainPacket=" + mainPacket + "&packet=" + packet);
            request = url.openConnection();
            request.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assert request != null;
        request.getContent();
    }

    public void sendToReader(String mainPacket, String packet, String packet2) throws IOException {
        URLConnection request = null;
        try {
            URL url = new URL("http://" + this.getIp() + "/" + token + "/reader/send.php?token=" + token + "&mainPacket=" + mainPacket + "&packet=" + packet + "&packet2=" + packet2);
            request = url.openConnection();
            request.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assert request != null;
        request.getContent();
    }

    public void sendToReader(String mainPacket, String packet, String packet2, String packet3) throws IOException {
        URLConnection request = null;
        try {
            URL url = new URL("http://" + this.getIp() + "/" + token + "/reader/send.php?token=" + token + "&mainPacket=" + mainPacket + "&packet=" + packet + "&packet2=" + packet2 + "&packet3=" + packet3);
            request = url.openConnection();
            request.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assert request != null;
        request.getContent();
    }

    public void sendToReader(String mainPacket, String packet, String packet2, String packet3, String packet4) throws IOException {
        URLConnection request = null;
        try {
            URL url = new URL("http://" + this.getIp() + "/" + token + "/reader/send.php?token=" + token + "&mainPacket=" + mainPacket + "&packet=" + packet + "&packet2=" + packet2 + "&packet3=" + packet3 + "&packet4=" + packet4);
            request = url.openConnection();
            request.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assert request != null;
        request.getContent();
    }

    public void sendToReader(String mainPacket, String packet, String packet2, String packet3, String packet4, String packet5) throws IOException {
        URLConnection request = null;
        try {
            URL url = new URL("http://" + this.getIp() + "/" + token + "/reader/send.php?token=" + token + "&mainPacket=" + mainPacket + "&packet=" + packet + "&packet2=" + packet2 + "&packet3=" + packet3 + "&packet4=" + packet4 + "&packet5=" + packet5);
            request = url.openConnection();
            request.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assert request != null;
        request.getContent();
    }

    public void sendToReader(String mainPacket, String packet, String packet2, String packet3, String packet4, String packet5, String packet6) throws IOException {
        URLConnection request = null;
        try {
            URL url = new URL("http://" + this.getIp() + "/" + token + "/reader/send.php?token=" + token + "&mainPacket=" + mainPacket + "&packet=" + packet + "&packet2=" + packet2 + "&packet3=" + packet3 + "&packet4=" + packet4 + "&packet5=" + packet5 + "&packet6=" + packet6);
            request = url.openConnection();
            request.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assert request != null;
        request.getContent();
    }

    public String deleteMainPacket(String mainPacket) throws IOException {
        URLConnection request = null;
        try {
            URL url = new URL("http://" + this.getIp() + "/" + token + "/packets/delete.php?token=" + token + "&mainPacket=" + mainPacket);
            request = url.openConnection();
            request.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assert request != null;
        return request.getContent().toString();
    }

    public Boolean isMainPacketRegistered(String mainPacket) {
        URL url = null;
        try {
            url = new URL("http://" + this.getIp() + "/" + this.getToken() + "/packets/" + mainPacket + "/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (!(url == null)) {
            return true;
        }
        return null;
    }

    public String getPacket(String mainPacket, int packageID) {
        try{
            String url = null;
            if (packageID == 1) {
                url = "http://" + this.getIp() + "/" + this.getToken() + "/packets/" + mainPacket + "/packet.html";
            } else {
                url = "http://" + this.getIp() + "/" + this.getToken() + "/packets/" + mainPacket + "/packet" + packageID + ".html";
            }
            URLConnection openConnection = new URL(url).openConnection();
            openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            @SuppressWarnings("resource")
            Scanner scan = new Scanner((new InputStreamReader(openConnection.getInputStream())));
            while(scan.hasNextLine()){
                String firstline = scan.nextLine();
                return firstline;
            }
        } catch(Exception e){
            return "false";
        }
        return null;
    }

    public String getIp() {
        return ip;
    }

    public String getToken() {
        return token;
    }

    public String getWebLink() {
        return webLink;
    }
}
