package com.vinhnq.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

//import java.util.Base64;

/**
 * @author sonnt All commont code of project
 */
public class CommonCode {
    private static final Logger logger = LogManager.getLogger(CommonCode.class);

    /**
     * @return
     */
    public static String generateOTP() {
        try {
            String numbers = "0123456789";
            Random rndm_method = new Random();

            char[] otp = new char[6];

            for (int i = 0; i < 6; i++) {
                // Use of charAt() method : to get character value
                // Use of nextInt() as it is scanning the value as int
                otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
            }
            return new String(otp);
        } catch (Exception ex) {
            return "909090";
        }
    }


    public static String generatePassword() {
        try {
            String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
            String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
            String numbers = RandomStringUtils.randomNumeric(2);
            String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
            String totalChars = RandomStringUtils.randomAlphanumeric(2);
            String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                    .concat(numbers)
                    .concat(specialChar)
                    .concat(totalChars);
            List<Character> pwdChars = combinedChars.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            Collections.shuffle(pwdChars);
            String password = pwdChars.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
            return password;
        } catch (Exception ex) {
            return "909090";
        }
    }


    public static String selectedMenu(Object selectedCode, Object constCode) {
        if (constCode.equals(selectedCode)) {
            return " selected-menu ";
        } else {
            return "";
        }
    }
    public static boolean isEmail(String email) {
        try {
            Matcher matcher = CommonConst.REGEX.EMAIL.matcher(email);
            return matcher.find();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    /**
     * Class commont code file process
     */
    public static class CommonFile {

        /**
         * @param filename
         * @return Read sql file
         */
        public static String readSqlFile(String filename) {
            ClassLoader classLoader = CommonCode.class.getClassLoader();
            File file = new File(classLoader.getResource(filename).getFile());
            String content = "";
            try {
                content = new String(Files.readAllBytes(Paths.get(file.getPath())));
            } catch (IOException ex) {
                logger.error(ex.getMessage(), ex);
            }
            return content;
        }


        /**
         * @param fileURL     destination to folder save file
         * @param fileName    file name without file extension
         * @param imageString base64 code (need validate before call function)
         * @return File on server
         */
        public static File encodeBase64Image(String fileURL, String fileName, String imageString) {
            File file = null;
            try {
                // create a buffered image
                byte[] imageByte;
                String[] strings = imageString.split(",");
                String extension = CommonConst.COMMON_STRING.BLANK;

                if (strings.length != 2 && strings.length != 1) {
                    throw new FileUploadException();
                }

                switch (strings[0]) {// check image's extension
                    case "data:image/jpeg;base64":
                        extension = "jpeg";
                        break;
                    case "data:image/png;base64":
                        extension = "png";
                        break;
                    default:// should write cases for more images types
                        extension = "jpg";
                        break;
                }

                File dir = new File(fileURL);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                file = new File(fileURL.concat(File.separator.concat(fileName).concat(".".concat(extension))));
                imageByte = Base64.decodeBase64(strings.length == 2 ? strings[1] : strings[0]);
                try (OutputStream stream = new FileOutputStream(file)) {
                    stream.write(imageByte);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return file;
        }

        public static String encodeFileToBase64Binary(File file) throws Exception {
            try (FileInputStream fileInputStreamReader = new FileInputStream(file)) {
                byte[] bytes = new byte[(int) file.length()];
                fileInputStreamReader.read(bytes);
                return new String(Base64.encodeBase64(bytes), "UTF-8");
            } catch (Exception e) {
                return "";
            }
        }
    }
}
