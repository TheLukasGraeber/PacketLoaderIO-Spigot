package net.myvenox.projects.loggers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class PacketLogger {

    private final String webLink;

    public PacketLogger(String methode, String address, String page, String mainPacket, String webLink) {
        this.webLink = webLink;
        if (methode.equalsIgnoreCase("error_sending::website_not_exist")) {
            this.getWebsiteNotExistErrorSending(address);
        } else if (methode.equalsIgnoreCase("error_sending::website_page_not_exist")) {
            this.getWebsitePageNotExistErrorSending(page);
        } else if (methode.equalsIgnoreCase("successful_sending::packet")) {
            this.getSuccessfulPacketSending(mainPacket);
        }
    }

    public PacketLogger(String methode, String address, String page, String webLink) {
        this.webLink = webLink;
        if (methode.equalsIgnoreCase("error_sending::website_not_exist")) {
            this.getWebsiteNotExistErrorSending(address);
        } else if (methode.equalsIgnoreCase("error_sending::website_page_not_exist")) {
            this.getWebsitePageNotExistErrorSending(page);
        }
    }

    public PacketLogger(String methode, String address, String webLink) {
        this.webLink = webLink;
        if (methode.equalsIgnoreCase("error_sending::website_not_exist")) {
            this.getWebsiteNotExistErrorSending(address);
        }
    }


    public PacketLogger(String methode, String mainPacket, String packet, String packet2, String packet3, String webLink) {
        this.webLink = webLink;
        if (methode.equalsIgnoreCase("successful_sending::packet")) {
            this.getSuccessfulPacketSending(mainPacket);
        }
    }

    private void sendLoggerInfo(String message) {
        System.out.println(message.replaceAll("&", "§"));
    }

    private void getSuccessfulPacketSending(String mainPacket) {
        this.sendLoggerInfo("SUCCESSFUL: " + mainPacket);
    }

    private void getWebsiteNotExistErrorSending(String address) {
        Socket s = null;
        try {
            s = new Socket(address, 80);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert s != null;
        if (!s.isConnected()) {
            this.sendLoggerInfo("Error: Website Host is not exist!");
        }
    }

    private void getWebsitePageNotExistErrorSending(String page) {
        URL url = null;
        try {
            url = new URL(this.getWebLink());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (url == null) {
            this.sendLoggerInfo("Error: One Website Page is not exist!");
            this.sendLoggerInfo("Page: " + page);
        }
    }

    public String getWebLink() {
        return webLink;
    }
}
