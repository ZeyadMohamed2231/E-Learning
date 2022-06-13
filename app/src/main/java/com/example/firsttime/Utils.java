package com.example.firsttime;

import android.util.Log;
import android.util.Pair;

import com.vdocipher.aegis.player.VdoPlayer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Utility class
 */

public class Utils {
    private static final String TAG = "Utils";

    static String digitalClockTime(int timeInMilliSeconds) {
        int totalSeconds = timeInMilliSeconds/1000;
        int hours = totalSeconds / (60 * 60);
        int minutes = (totalSeconds - hours * 60 * 60) / 60;
        int seconds = (totalSeconds - hours * 60 * 60 - minutes * 60);

        String timeThumb = "";
        if (hours > 0) {
            if (hours < 10) {
                timeThumb += "0" + hours + ":";
            } else {
                timeThumb += hours + ":";
            }
        }
        if (minutes > 0) {
            if (minutes < 10) {
                timeThumb += "0" + minutes + ":";
            } else {
                timeThumb += minutes + ":";
            }
        } else {
            timeThumb += "00" + ":";
        }
        if (seconds < 10) {
            timeThumb += "0" + seconds;
        } else {
            timeThumb += seconds;
        }
        return timeThumb;
    }

    /**
     * @return index of number in provided array closest to the provided number
     */
    public static int getClosestFloatIndex(float[] refArray, float comp) {
        float distance = Math.abs(refArray[0] - comp);
        int index = 0;
        for (int i = 1; i < refArray.length; i++) {
            float currDistance = Math.abs(refArray[i] - comp);
            if (currDistance < distance) {
                index = i;
                distance = currDistance;
            }
        }
        return index;
    }

    public static String playbackStateString(boolean playWhenReady, int playbackState) {
        String stateName;
        switch (playbackState) {
            case VdoPlayer.STATE_IDLE:
                stateName = "STATE_IDLE";
                break;
            case VdoPlayer.STATE_READY:
                stateName = "STATE_READY";
                break;
            case VdoPlayer.STATE_BUFFERING:
                stateName = "STATE_BUFFERING";
                break;
            case VdoPlayer.STATE_ENDED:
                stateName = "STATE_ENDED";
                break;
            default:
                stateName = "STATE_UNKNOWN";
        }
        return "playWhenReady " + (playWhenReady ? "true" : "false") + ", " + stateName;
    }

    public static String getSizeString(int bitsPerSec, long millisec) {
        double sizeMB = ((double)bitsPerSec / (8 * 1024 * 1024)) * (millisec / 1000);
        return round(sizeMB, 2) + " MB";
    }

    public static long getSizeBytes(int bitsPerSec, long millisec) {
        return (bitsPerSec / 8) * (millisec / 1000);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // call on non-ui thread only
    public static Pair<String, String> getSampleOtpAndPlaybackInfo(String videoId) throws IOException, JSONException {

        final String SAMPLE_OTP_PLAYBACK_INFO_URL = "https://dev.vdocipher.com/api/videos/"+videoId+"/otp";

        URL url = new URL(SAMPLE_OTP_PLAYBACK_INFO_URL);
        final HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("authorization","Apisecret ddpuP0sVKVPFkj0u9IOVARvg6saY3NrOPeCWlvqfZzSgzOfgj7wEy0YIGg1sQINK");
        connection.setDoOutput(true);
        String waterMark="a7a";
        String jsonInputString = "{'annotate':'[{'type':'rtext', 'text':"+waterMark+", 'alpha':'0.60', 'color':'0xFF0000','size':'15','interval':'5000'}]";

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }


        int responseCode = connection.getResponseCode();

        if (responseCode == 200) {
            InputStream is = connection.getInputStream();
            Log.i("40","40");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            Log.i("41","41");
            String inLine;
            Log.i("42","42");
            StringBuffer responseBuffer = new StringBuffer();
            Log.i("43","43");
            while ((inLine = br.readLine()) != null) {
                responseBuffer.append(inLine);
                Log.i("44","44");
            }
            br.close();

            Log.i("45","45");

            String response = responseBuffer.toString();
            Log.i("46","46");
            Log.i(TAG, "response: " + response);

            JSONObject jObj = new JSONObject(response);
            Log.i("46","46");
            String otp = jObj.getString("otp");
            Log.i("46",otp);
            String playbackInfo = jObj.getString("playbackInfo");
            return Pair.create(otp, playbackInfo);
        } else {
            Log.e(TAG, "error response code = " + responseCode);
            throw new IOException("Network error, code " + responseCode);
        }
    }
}
