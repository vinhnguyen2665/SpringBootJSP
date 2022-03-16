package com.vinhnq.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHelper {
    private static final Logger logger = LogManager.getLogger(DataHelper.class);

    public static void main(String[] args) {
        // readDataSensor("7D-2B-00-4A-27-44-03-61-0F-6A-BA-F5-9F-F9-A3-1C-43-03-FA-00-7C-FF-08-F6-E9-F8-7F-1C-C5-02-E9-00-88-FF-EF-F5-2D-FA-10-1D-06-03-EC-00-65-FF-95-14");
        readData("7D-11-00-4C-31-39-31-30-30-39-30-32-38-30-37-00-03-FF-01-00-84-03");
//        readData("7D-2B-00-4A-A5-5A-02-61-42-CE-78-1A-6A-10-9A-12-3C-03-4A-03-DC-FD-CD-18-29-0E-FF-14-22-02-C0-FD-55-FD-1C-17-B2-0D-88-15-72-02-3B-00-C5-FB-39-10");
//        readData("7D-19-00-4A-A5-B3-5A-02-61-62-0C-C5-16-50-A0-80-64-80-38-81-00-0A-00-10-00-00-46-CB-E0-07");
        //("7D-11-00-4C-31-39-31-30-30-39-30-32-38-30-37-00-03-FF-02-00-85-03");
    }

    public static int success = 0;
    public static int NoDefinitionCommand = 1;
    public static int commandArgumentIsOutOfRange = 2;
    public static int settingParameterIsOutOfRange = 3;
    public static int errorChecksum = 4;
    public static int errorState = 5;

    public static int NONE = 0;
    public static int IDLE = 1;
    public static int S_MODE = 2;
    public static int SD_MODE = 3;
    public static int R_MODE = 4;
    public static int RD_MODE = 5;
    public static Map<Integer, String> mapStatusStartRealTime = new HashMap<Integer, String>() {
        {
            put(success, "Success");
            put(NoDefinitionCommand, "Success");
            put(commandArgumentIsOutOfRange, "No definition command definition range.");
            put(settingParameterIsOutOfRange, "Setting parameter is out of range.");
            put(errorChecksum, "Error checksum.");
            put(errorState, "Error state.");

        }

    };
    public static Map<Integer, String> mapStatusProductUniqueID = new HashMap<Integer, String>() {
        {
            put(NONE, "NONE");
            put(IDLE, "IDLE");
            put(S_MODE, "S_MODE");
            put(SD_MODE, "SD_MODE");
            put(R_MODE, "R_MODE");
            put(RD_MODE, "RD_MODE");

        }

    };

    public static String readData(String hexString) {
        String result = "EMPTY";
        try {
            String[] inputArray = hexString.split("-");
//        String header = inputArray[0]; // 1Byte
//        String length = inputArray[2] + inputArray[1]; // 2Byte
            String ack = inputArray[3]; // 1Byte
            String data = hexString.substring(12, hexString.length() - 1 - 5); // nByte
//        String dataFlag = data.split("-")[0];
//        String checkSum = inputArray[inputArray.length - 2] + inputArray[inputArray.length - 1]; // 2Byte

            switch (ack) {
                case "4A": {
   /*             if (Integer.parseInt(length, 16) - 1 == 24) {
                    result = readDataSensor(data);
                }*/
                    result = hexString;
                    break;
                }
                case "48": {
                    result = startRealTime(data);
                    break;
                }
                case "4C": {
                    result = getProductUniqueID(data);
                    break;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public static String startRealTime(String hexString) {
        try {
            return "startRealTime: " + mapStatusStartRealTime.get(Integer.parseInt(hexString));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getProductUniqueID(String hexString) {
        try {
            Long serialNo;
            Long systemState;
            Long conflictRule;
            String[] inputArray = hexString.split("-");
            serialNo = Long.decode("0x" + inputArray[0]);
            List<Integer> serialNumberStrings = new ArrayList<>();
            for (int i = 0; i < 14; i++) {
                serialNumberStrings.add(Long.decode("0x" + inputArray[i]).intValue());
            }
            systemState = Long.decode(inputArray[14]);
            conflictRule = Long.decode("0x" + inputArray[15]);
            return "getProductUniqueID: " + serialNo + " " + serialNumberStrings.toString() + " "
                    + mapStatusProductUniqueID.get(systemState.intValue()) + " " + conflictRule;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Timestamp convertHexToTimestamp(String timeHex) {
        // convert seconds to milliseconds
        long timeStamp = Long.parseLong(timeHex, 16);
        Date date = new Date(timeStamp * 1000L);
        System.out.println(timeHex);
        System.out.println(date);
        Instant instant = Instant.ofEpochSecond(timeStamp);
        Timestamp timestamp = Timestamp.from(instant);
        System.out.println(timestamp);
        return timestamp;
    }
}
