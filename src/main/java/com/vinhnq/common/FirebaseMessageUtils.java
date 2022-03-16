package com.vinhnq.common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.vinhnq.beans.NotificationBeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FirebaseMessageUtils {
    private static final Logger logger = LogManager.getLogger(FirebaseMessageUtils.class);
    final static private String FCM_URL = "https://fcm.googleapis.com/fcm/send";
    private static final String SERVER_AUTH_KEY = "AAAAWdQKaFs:APA91bFATAn3i68qKqvdo7wJTbYbkvYRploY0zgllT1Wd7cf9Jdxe_ZKi0XBWdhgBg0fjVeAf256wJE-FI9dhip_GxX1ff-yLQmyijDghfkfStP-_slnI2IoZrH5D5bUon-Xvyk9RWPu";


    public static void main(String[] args) {
        String token = "cMGMYiUxT5iUKPj8yPaaGw:APA91bH_ilm20HB0dt9rsnw3c7YSRydeo3pbf9cdTGEYkCKlG3O52RmlJm9d3KMEfQifYO6jhjTI3GhznzPDdUOmrtomuR1AYfCWZMDVei5H5_Pu4GIFXmJRZwYGFoZoyLHxKymgL3-g";
        List<String> lstToken = new ArrayList<>();
        lstToken.add(token);
        NotificationBeans notificationBeans = new NotificationBeans();
        notificationBeans.setTitle("VinhNQ Testing");
        notificationBeans.setBody("Bạn có khoẻ không? お疲れ様です。ビインです。本日の作業を報告させて頂きます。");
        send_FCM_NotificationMulti(lstToken, SERVER_AUTH_KEY, notificationBeans);
    }

    /**
     * Method to send push notification to Android FireBased Cloud messaging
     * Server.
     *
     * @param tokenId    Generated and provided from Android Client Developer
     * @param server_key Key which is Generated in FCM Server
     * @param message    which contains actual information.
     */

    public static void send_FCM_Notification(String tokenId, String server_key, String message) {
        try {
            // Create URL instance.
            URL url = new URL(FCM_URL);
            // create connection.
            HttpURLConnection conn;
            conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //set method as POST or GET
            conn.setRequestMethod("POST");
            //pass FCM server key
            conn.setRequestProperty("Authorization", "key=" + server_key);
            //Specify Message Format
            conn.setRequestProperty("Content-Type", "application/json");
            //Create JSON Object & pass value
            JSONObject infoJson = new JSONObject();

            infoJson.put("title", "Alankit");
            infoJson.put("body", message);

            JSONObject json = new JSONObject();
            json.put("to", tokenId.trim());
            json.put("notification", infoJson);

            System.out.println("json :" + json.toString());
            System.out.println("infoJson :" + infoJson.toString());
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            int status = 0;
            if (null != conn) {
                status = conn.getResponseCode();
            }
            if (status != 0) {

                if (status == 200) {
                    //SUCCESS message
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    logger.info("Android Notification Response : " + reader.readLine());
                } else if (status == 401) {
                    //client side error
                    logger.error("Notification Response : TokenId : " + tokenId + " Error occurred :");
                } else if (status == 501) {
                    //server side error
                    logger.error("Notification Response : [ errorCode=ServerError ] TokenId : " + tokenId);
                } else if (status == 503) {
                    //server side error
                    logger.error("Notification Response : FCM Service is Unavailable TokenId :" + tokenId);
                }
            }
        } catch (MalformedURLException mlfexception) {
            // Prototcal Error
            logger.error("Error occurred while sending push Notification!.." + mlfexception.getMessage(), mlfexception);
        } catch (Exception mlfexception) {
            //URL problem
            logger.error("Reading URL, Error occurred while sending push Notification !.." + mlfexception.getMessage(), mlfexception);
        }

    }

    public static void send_FCM_NotificationMulti(List<String> putIds2, NotificationBeans notificationBeans) {
        send_FCM_NotificationMulti(putIds2, SERVER_AUTH_KEY, notificationBeans);
    }

    public static void send_FCM_NotificationMulti(List<String> putIds2, String server_key, NotificationBeans notificationBeans) {
        try {
            // Create URL instance.
            URL url = new URL(FCM_URL);
            // create connection.
            HttpURLConnection conn;
            conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //set method as POST or GET
            conn.setRequestMethod("POST");
            //pass FCM server key
            conn.setRequestProperty("Authorization", "key=" + server_key);
            //Specify Message Format
            conn.setRequestProperty("Content-Type", "application/json");
            //Create JSON Object & pass value

            JSONArray regId = null;
            JSONObject objData = null;
            Map<String, String> data = null;
            JSONObject notif = null;

            regId = new JSONArray();
            for (int i = 0; i < putIds2.size(); i++) {
                regId.add(putIds2.get(i));
            }
            notif = new JSONObject();
            notif.put("title", notificationBeans.getTitle());
            notif.put("body", notificationBeans.getBody());
            notif.put("priority", "high");

            data = new HashMap<>();
            data.put("body", notificationBeans.getBody());
            data.put("notification", notif.toJSONString());


            objData = new JSONObject();
            objData.put("registration_ids", regId);
            objData.put("data", data);
            //objData.put("notification", notif);
            objData.put("sound", "default");
            objData.put("badge", "1");
            objData.put("priority", "high");
            objData.put("click_action", "openMessageListActivity");
            objData.put("icon", "ic_notification");
            logger.info("PASS JSON:>" + objData.toString());
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write(objData.toJSONString());
            wr.flush();
            int status = 0;
            if (null != conn) {
                status = conn.getResponseCode();
            }
            if (status != 0) {

                if (status == 200) {
                    //SUCCESS message
                    BufferedReader reader = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));
                    logger.info("Android Notification Response : " + reader.readLine());
                } else if (status == 401) {
                    //client side error
                    logger.error("Notification Response : TokenId : " + regId + " Error occurred :");
                } else if (status == 501) {
                    //server side error
                    logger.error("Notification Response : [ errorCode=ServerError ] TokenId :" + regId);
                } else if (status == 503) {
                    //server side error
                    logger.error("Notification Response : FCM Service is Unavailable TokenId :" + regId);
                }
            }
        } catch (MalformedURLException mlfexception) {
            // Prototcal Error
            logger.error("Error occurred while sending push Notification!.." + mlfexception.getMessage(), mlfexception);
        } catch (IOException mlfexception) {
            //URL problem
            logger.error("Reading URL, Error occurred while sending push Notification !.." + mlfexception.getMessage(), mlfexception);
        } catch (Exception exception) {
            //General Error or exception.
            logger.error("Error occurred while sending push Notification!.." + exception.getMessage(), exception);
        }

    }
}
