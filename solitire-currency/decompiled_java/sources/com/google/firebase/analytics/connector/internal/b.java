package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zziv;
import com.google.common.collect.c0;
import com.google.common.collect.y;
import io.sentry.protocol.App;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c0<String> f10232a = c0.v("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final y<String> f10233b = y.v("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final y<String> f10234c = y.t(TtmlNode.TEXT_EMPHASIS_AUTO, App.TYPE, "am");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final y<String> f10235d = y.s("_r", "_dbg");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final y<String> f10236e = new y.a().i(zziv.zza).i(zziv.zzb).k();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final y<String> f10237f = y.s("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static void a(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean b(String str, Bundle bundle) {
        if (f10233b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        y<String> yVar = f10235d;
        int size = yVar.size();
        int i10 = 0;
        while (i10 < size) {
            String str2 = yVar.get(i10);
            i10++;
            if (bundle.containsKey(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals(AppMeasurement.FCM_ORIGIN) || str.equals(AppMeasurement.FIAM_ORIGIN);
        }
        if (f10236e.contains(str2)) {
            return false;
        }
        y<String> yVar = f10237f;
        int size = yVar.size();
        int i10 = 0;
        while (i10 < size) {
            String str3 = yVar.get(i10);
            i10++;
            if (str2.matches(str3)) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!e(str) || bundle == null) {
            return false;
        }
        y<String> yVar = f10235d;
        int size = yVar.size();
        int i10 = 0;
        while (i10 < size) {
            String str3 = yVar.get(i10);
            i10++;
            if (bundle.containsKey(str3)) {
                return false;
            }
        }
        str.hashCode();
        switch (str) {
            case "fcm":
                bundle.putString("_cis", "fcm_integration");
                return true;
            case "fdl":
                bundle.putString("_cis", "fdl_integration");
                return true;
            case "fiam":
                bundle.putString("_cis", "fiam_integration");
                return true;
            default:
                return false;
        }
    }

    public static boolean e(String str) {
        return !f10234c.contains(str);
    }
}
