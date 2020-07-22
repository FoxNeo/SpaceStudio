package de.spaceStudio.client.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.google.gson.Gson;
import de.spaceStudio.server.model.CrewMember;
import de.spaceStudio.server.model.Section;
import de.spaceStudio.server.model.Ship;
import de.spaceStudio.server.model.Weapon;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public final class RequestUtils {

    private final static Logger LOG = Logger.getLogger(RequestUtils.class.getName());

    /**
     * Prepares the headers and other configurations
     *
     * @param url
     * @param payload
     * @param httpMethod
     * @return
     */
    public static Net.HttpRequest setupRequest(String url, String payload, String httpMethod) {
        Net.HttpRequest request = new Net.HttpRequest(httpMethod);
        request.setTimeOut(0);
        request.setUrl(url);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        request.setContent(payload);
        return request;
    }

    public static String genericGetRequest(String url, boolean noWait, Integer id) {
        Net.HttpRequest r = setupRequest(url, "", Net.HttpMethods.GET);

        final String[] responseString = {null};

        LOG.info("Sending get Request to: " + url);
        Gdx.net.sendHttpRequest(r, new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                int statusCode = httpResponse.getStatus().getStatusCode();
                LOG.info("statusCode: " + statusCode);
                responseString[0] = httpResponse.getResultAsString();

                Gson gson = new Gson();
                if (url.contains("sections")) {
                    Global.combatSections.put(id,  Arrays.asList(gson.fromJson(responseString[0], Section[].class)));
                } else if (url.contains("weapon")) {
                    Global.combatWeapons.put(id,  Arrays.asList(gson.fromJson(responseString[0], Weapon[].class)));
                } else if (url.contains("crewMembers")) {
                    Global.combatCrew.put(id,  Arrays.asList(gson.fromJson(responseString[0], CrewMember[].class)));
                }


            }

            @Override
            public void failed(Throwable t) {
            LOG.severe("Request Failed");
            }

            @Override
            public void cancelled() {
                LOG.severe("Request Canceled");
            }
        });

        return responseString[0];
    }

    public static void weaponsByShip(Ship ship) {
        genericGetRequest(Global.SERVER_URL + Global.ASK_FOR_SHIP +"/" + ship.getId() + "/" + Global.WEAPONS, false, ship.getId());
    }

    public static void sectionsByShip(Ship ship) {
        genericGetRequest( Global.SERVER_URL + Global.ASK_FOR_SHIP +"/" + ship.getId() + "/" + Global.SECTIONS, false, ship.getId());
    }
    public static void crewMemeberByShip(Ship ship) {
        genericGetRequest( Global.SERVER_URL + Global.ASK_FOR_SHIP +"/" + ship.getId() + "/" + Global.CREWMEMBERS, false, ship.getId());
    }

}
