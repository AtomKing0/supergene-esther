package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfls {
    private final zzfmd zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();

    @Nullable
    private final String zze;

    @Nullable
    private final String zzf;
    private final zzflt zzg;

    private zzfls(zzfmd zzfmdVar, WebView webView, String str, List list, @Nullable String str2, @Nullable String str3, zzflt zzfltVar) {
        this.zza = zzfmdVar;
        this.zzb = webView;
        this.zzg = zzfltVar;
        this.zzf = str2;
        this.zze = str3;
    }

    public static zzfls zzb(zzfmd zzfmdVar, WebView webView, @Nullable String str, @Nullable String str2) {
        if (str2 != null) {
            zzfnj.zzd(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new zzfls(zzfmdVar, webView, null, null, str, str2, zzflt.HTML);
    }

    public static zzfls zzc(zzfmd zzfmdVar, WebView webView, @Nullable String str, @Nullable String str2) {
        zzfnj.zzd("", 256, "CustomReferenceData is greater than 256 characters");
        return new zzfls(zzfmdVar, webView, null, null, str, "", zzflt.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzflt zzd() {
        return this.zzg;
    }

    public final zzfmd zze() {
        return this.zza;
    }

    @Nullable
    public final String zzf() {
        return this.zzf;
    }

    @Nullable
    public final String zzg() {
        return this.zze;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
