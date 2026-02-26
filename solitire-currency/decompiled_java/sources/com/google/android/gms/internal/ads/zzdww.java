package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdww implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdww(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* synthetic */ Object zzb() {
        zzfjl zzfjlVar = (zzfjl) this.zza.zzb();
        final CookieManager cookieManagerZza = com.google.android.gms.ads.internal.zzu.zzq().zza((Context) this.zzb.zzb());
        zzfjc zzfjcVarZzi = zzfiv.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwt
            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = cookieManagerZza;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzaF));
            }
        }, zzfjf.WEBVIEW_COOKIE, zzfjlVar).zzi(1L, TimeUnit.SECONDS);
        final zzfio zzfioVar = new zzfio() { // from class: com.google.android.gms.internal.ads.zzdwu
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                return "";
            }
        };
        return zzfjcVarZzi.zzc(Exception.class, new zzgbq(zzfioVar) { // from class: com.google.android.gms.internal.ads.zzfiw
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzgcj.zzh("");
            }
        }).zza();
    }
}
