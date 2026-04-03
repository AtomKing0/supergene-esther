package com.king.amp.sa;

import android.app.Activity;
import androidx.annotation.Keep;
import com.unity3d.services.UnityAdsConstants;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class DefaultFileSystem {
    public static String getDefaultAppDirectory(Activity activity) {
        return activity.getDir("abm", 0).getAbsolutePath() + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH;
    }
}
