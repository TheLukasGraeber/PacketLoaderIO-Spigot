System kann nur durch unser Webseiten System verwendet werden!       

        final PacketLoaderIO packetLoaderIO = new PacketLoaderIO("IP", "TOKEN");
        packetLoaderIO.connectMainServers();
        packetLoaderIO.getBungeeCordToSpigotPacket().registerPacket("PACKET", "PACKET");
        if (packetLoaderIO.getBungeeCordToSpigotPacket().isMainPacketRegistered("PACKET")) {
            if (packetLoaderIO.getBungeeCordToSpigotPacket().getPacket("PACKET", 1).equalsIgnoreCase("PACKET")) {
                //Was soll es machen, wenn es positiv ischt?
                packetLoaderIO.getBungeeCordToSpigotPacket().deleteMainPacket("PACKET");
            } else {
                //Was soll es machen, wenn es negative ischt?
            }
        }
        
    public void onPlayerMoveInAudio(PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        if (!registeredSounds.containsKey(player.getUniqueId().toString())) {
            if (player.getLocation().getY() == 105) {
                this.registeredSounds.put(player.getUniqueId().toString(), "");
                packetLoaderIO.getBungeeCordToSpigotPacket().registerPacket("sound::" + player.getName() + "::playing.mp3", "sound::" + player.getName() + "::playing.mp3");
                if (packetLoaderIO.getBungeeCordToSpigotPacket().isMainPacketRegistered("sound::" + player.getName() + "::playing.mp3")) {
                    if (packetLoaderIO.getBungeeCordToSpigotPacket().getPacket("sound::" + player.getName() + "::playing.mp3", 1).equalsIgnoreCase("sound::" + player.getName() + "::playing.mp3")) {
                        player.sendMessage("SOUND PLAYED");
                        packetLoaderIO.getBungeeCordToSpigotPacket().deleteMainPacket("sound::" + player.getName() + "::playing.mp3");
                    } else {
                        player.sendMessage("SOUND NOT SEND");
                    }
                }
            }
        }
    }
