package de.spaceStudio.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.google.gson.Gson;
import de.spaceStudio.client.util.Global;
import de.spaceStudio.client.util.RequestUtils;
import java.util.logging.Logger;

public class MultiPlayerService {

    /**
     * Logger object
     */
    private final static java.util.logging.Logger LOG = Logger.getLogger(MultiPlayerService.class.getName());


    public static void fetchMultiPlayerSession(){
        String url = Global.SERVER_URL + Global.MULTIPLAYER_ROOM_ID;
        Net.HttpRequest request = RequestUtils.setupRequest(url, "", Net.HttpMethods.GET);
        Gdx.net.sendHttpRequest(request, new Net.HttpResponseListener() {

            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                LOG.info("Downloading room session...");
                Global.multiPlayerSessionID = httpResponse.getResultAsString();
            }

            @Override
            public void failed(Throwable t) {

            }

            @Override
            public void cancelled() {

            }
        });
    }

    public static void joinMultiplayerRoom() {
        String url = Global.SERVER_URL + Global.MULTIPLAYER_JOIN_ROOM + Global.multiPlayerSessionID;
        Gson gson = new Gson();
        String payLoad = gson.toJson(Global.currentPlayer);
        Net.HttpRequest request = RequestUtils.setupRequest(url, payLoad, Net.HttpMethods.POST);
        Gdx.net.sendHttpRequest(request, new Net.HttpResponseListener() {

            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                LOG.info("Joining room session...");
                LOG.info(httpResponse.getResultAsString());
            }

            @Override
            public void failed(Throwable t) {

            }

            @Override
            public void cancelled() {

            }
        });
    }
    public static void checkMultiPlayerToStartSynchro() {
        String url = Global.SERVER_URL + Global.MULTIPLAYER_SYNCHRO_ROOM + Global.multiPlayerSessionID;
        Net.HttpRequest request = RequestUtils.setupRequest(url, "", Net.HttpMethods.GET);
        Gdx.net.sendHttpRequest(request, new Net.HttpResponseListener() {

            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                LOG.info("Waiting for players...");
                LOG.info(httpResponse.getResultAsString());
                if(httpResponse.getResultAsString().equals("True")){
                    // SetScreen Station Map
                } else {
                    // Notify Player try again or play single player
                }
            }

            @Override
            public void failed(Throwable t) {

            }

            @Override
            public void cancelled() {

            }
        });

    }
    }
