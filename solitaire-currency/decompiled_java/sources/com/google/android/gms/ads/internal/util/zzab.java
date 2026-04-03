package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import androidx.autofill.HintConstants;
import com.google.android.gms.internal.ads.zzbav;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzcer;
import com.google.android.gms.internal.ads.zzeds;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzab {
    /* synthetic */ zzab(zzaa zzaaVar) {
    }

    @Nullable
    public CookieManager zza(Context context) {
        throw null;
    }

    public WebResourceResponse zzb(String str, String str2, int i10, String str3, Map map, InputStream inputStream) {
        throw null;
    }

    public zzcer zzc(zzcej zzcejVar, zzbav zzbavVar, boolean z10, @Nullable zzeds zzedsVar) {
        throw null;
    }

    public boolean zzd(Activity activity, Configuration configuration) {
        return false;
    }

    @Nullable
    public Intent zzf(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("app_package", activity.getPackageName());
        intent.putExtra("app_uid", activity.getApplicationInfo().uid);
        return intent;
    }

    public zzbbc.zzq zzg(Context context, TelephonyManager telephonyManager) {
        return zzbbc.zzq.ENUM_UNKNOWN;
    }

    public boolean zzi(Context context, String str) {
        return false;
    }

    public int zzj(AudioManager audioManager) {
        return 0;
    }

    public int zzm(Context context) {
        return ((TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkType();
    }

    public void zzk(Activity activity) {
    }

    public void zzh(Context context, String str, String str2) {
    }
}
