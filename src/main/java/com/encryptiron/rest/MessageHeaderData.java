package com.encryptiron.rest;

import java.time.Instant;

import com.google.gson.JsonObject;

import lombok.Getter;
import lombok.Setter;
import net.runelite.client.config.RuneScapeProfileType;

public final class MessageHeaderData 
{
    @Getter
    @Setter
    private static String playerName = null;
        
    @Getter
    @Setter
    private static RuneScapeProfileType profileType = null;
    
    @Getter
    @Setter
    private static Long accountId = null;

    @Getter
    @Setter
    private static Integer accountType = null;

    public static void reset()
    {
        MessageHeaderData.accountId = null;
        MessageHeaderData.accountType = null;
        MessageHeaderData.playerName = null;
    }

    public static JsonObject getMessageHeaderJson()
    {
        JsonObject headerData = new JsonObject();
        headerData.addProperty("account_id", getAccountId());
        headerData.addProperty("account_type", getAccountType());
        headerData.addProperty("player_name", getPlayerName());
        headerData.addProperty("profile_type", getProfileType().name());
        headerData.addProperty("time", Instant.now().toEpochMilli());
        
        return headerData;
    }
}
