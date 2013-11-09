package com.centerorbit.hive_daq;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by andy on 11/7/13.
 */

public class Weather extends AsyncTask<String, Void, String> {

    private static final String API_KEY = "d52fc31f5e5f29cda931c20d73a0c9b9";
    private static final String URL = "https://api.forecast.io/forecast/";
    private WeatherInterface callback;

    public void getLatest(Float latitude, Float longitude, WeatherInterface callback){
        this.callback = callback;
        String url = URL+API_KEY+"/"+latitude.toString()+","+longitude.toString();
        this.execute(url);
    }

    private static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    private static String connect(String url)
    {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
            //Log.i(TAG,response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
                instream.close();
                return result;
            }
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
        return null;
    }

    @Override
    protected String doInBackground(String... Params){
        String url = Params[0];
        String JsonResponse = connect(url);
        return JsonResponse;
    }

    @Override
    protected void onPostExecute(String result) {
        try{
            JSONObject json = new JSONObject(result);
            callback.weatherHasUpdated(json);
        }
        catch (JSONException error){
            //Yeah, well.. things happen.
            callback.weatherFailedUpdate();
        }
    }
}