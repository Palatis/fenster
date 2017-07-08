package com.malmstein.fenster.helper;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;

public class BrightnessHelper {

    public static void setBrightness(Context context, int brightness) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
            final ContentResolver cResolver = context.getContentResolver();
            Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
        }
    }

    public static int getBrightness(Context context) {
        try {
            final ContentResolver cResolver = context.getContentResolver();
            return Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            return 0;
        }
    }
}
