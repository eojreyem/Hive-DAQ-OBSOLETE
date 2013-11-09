package com.centerorbit.hive_daq;

import org.json.JSONObject;

/**
 * Created by andy on 11/8/13.
 */
public interface WeatherInterface {
    public void weatherHasUpdated(JSONObject weather);
    public void weatherFailedUpdate();
}
