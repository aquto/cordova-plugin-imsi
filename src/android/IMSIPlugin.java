package com.plugin.IMSI;


import org.json.JSONArray;

import android.content.Context;
import android.telephony.TelephonyManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

public class IMSIPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        PluginResult.Status status = PluginResult.Status.OK;
        String result = "";

        if (action.equals("get")) {
            TelephonyManager telephonyManager = (TelephonyManager)this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
            result = telephonyManager.getSubscriberId();
        }
        else {
            status = PluginResult.Status.INVALID_ACTION;
        }
        callbackContext.sendPluginResult(new PluginResult(status, result));
        return true;
    }

}
