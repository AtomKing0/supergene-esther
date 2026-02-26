package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzeej {
    @Nullable
    zzeeo zza(String str, WebView webView, String str2, String str3, @Nullable String str4, zzeel zzeelVar, zzeek zzeekVar, @Nullable String str5);

    @Nullable
    zzeeo zzb(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5, zzeel zzeelVar, zzeek zzeekVar, @Nullable String str6);

    @Nullable
    zzfmb zze(VersionInfoParcel versionInfoParcel, WebView webView, boolean z10);

    @Nullable
    String zzf(Context context);

    void zzg(zzflq zzflqVar, View view);

    void zzh(zzfmb zzfmbVar, View view);

    void zzi(zzflq zzflqVar);

    void zzj(zzflq zzflqVar, View view);

    void zzk(zzflq zzflqVar);

    boolean zzl(Context context);

    void zzm(zzfmb zzfmbVar, zzcey zzceyVar);
}
