package com.unity3d.services.core.properties;

import android.app.Activity;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes4.dex */
public class MadeWithUnityDetector {
    public static final String UNITY_PLAYER_CLASS_NAME = "com.unity3d.player.UnityPlayer";

    public static boolean isMadeWithUnity() {
        try {
            Activity activity = UnityPlayer.currentActivity;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
