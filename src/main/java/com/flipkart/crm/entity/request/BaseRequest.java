package com.flipkart.crm.entity.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by laxman.muttineni on 10/11/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseRequest {

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("client")
    private String client;

    @JsonProperty("agent_id")
    private String agentId;

    public BaseRequest() {
    }

    public BaseRequest(final String channel) {
        this.client = "self_serve";
        this.agentId = "self_serve";
        this.channel = client + "." + channel;
    }

    public BaseRequest(final String channel,
                       final String agentId,
                       final String client) {
        this.client = client;
        this.agentId = agentId;
        this.channel = client + "." + channel;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
