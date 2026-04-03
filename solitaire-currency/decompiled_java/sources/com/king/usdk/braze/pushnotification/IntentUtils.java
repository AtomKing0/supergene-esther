package com.king.usdk.braze.pushnotification;

import android.app.ActivityManager;
import android.content.Context;
import androidx.annotation.Keep;
import com.king.usdk.braze.AndroidLogger;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class IntentUtils {
    private static final String TAG = "IntentUtils";

    private IntentUtils() {
    }

    public static boolean applicationInForeground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        boolean z10 = false;
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty() && runningAppProcesses.get(0).processName.equalsIgnoreCase(context.getPackageName()) && runningAppProcesses.get(0).importance == 100) {
            z10 = true;
        }
        AndroidLogger.d(TAG, "applicationInForeground: " + z10);
        return z10;
    }
}
