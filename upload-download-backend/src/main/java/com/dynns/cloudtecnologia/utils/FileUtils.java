package com.dynns.cloudtecnologia.utils;


import java.io.*;

public class FileUtils {


    public static byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }
        return byteArrayOutputStream.toByteArray();
    }


    public static InputStream byteArrayToInputStream(byte[] byteArray) {
        return new ByteArrayInputStream(byteArray);
    }

}
