package com.applovin.impl;

import android.content.Context;
import android.provider.Settings;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    public static void a(com.applovin.impl.sdk.ad.b bVar, AppLovinFullscreenActivity appLovinFullscreenActivity, com.applovin.impl.sdk.j jVar) {
        String strB = d.b(appLovinFullscreenActivity);
        String strA = d.a(appLovinFullscreenActivity);
        String packageName = appLovinFullscreenActivity.getPackageName();
        boolean z10 = StringUtils.isValidString(strB) && !strB.equals(packageName);
        boolean z11 = StringUtils.isValidString(strA) && !strA.equals(packageName);
        if (z10 || z11) {
            Map mapB = a2.b(bVar);
            mapB.put("activity_task_affinity_mismatch", String.valueOf(z10));
            mapB.put("base_activity_task_affinity_mismatch", String.valueOf(z11));
            jVar.A().a(y1.f7776d0, "taskAffinityMismatch", mapB);
        }
    }

    public static void a(com.applovin.impl.adview.b bVar, com.applovin.impl.sdk.j jVar) {
        if (bVar == null) {
            return;
        }
        boolean zA = q.a(bVar);
        if (zA) {
            jVar.E().c(v1.f7568r);
        }
        boolean zA2 = a(bVar.getContext());
        if (zA2 || zA) {
            Map mapB = a2.b(bVar.getCurrentAd());
            mapB.put("can_draw_overlays", String.valueOf(zA2));
            mapB.put("is_ad_view_overlaid", String.valueOf(zA));
            jVar.A().a(y1.f7776d0, "overlayViolation", mapB);
        }
    }

    private static boolean a(Context context) {
        if (k0.e()) {
            return Settings.canDrawOverlays(context);
        }
        return k0.a("android.permission.SYSTEM_ALERT_WINDOW", context);
    }
}
