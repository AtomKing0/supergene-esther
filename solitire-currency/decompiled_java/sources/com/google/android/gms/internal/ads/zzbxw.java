package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbxw implements zzaxw {
    private final Context zza;
    private final Object zzb;
    private final String zzc;
    private boolean zzd;

    public zzbxw(Context context, String str) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = str;
        this.zzd = false;
        this.zzb = new Object();
    }

    public final String zza() {
        return this.zzc;
    }

    public final void zzb(boolean z10) {
        if (com.google.android.gms.ads.internal.zzu.zzn().zzp(this.zza)) {
            synchronized (this.zzb) {
                if (this.zzd == z10) {
                    return;
                }
                this.zzd = z10;
                if (TextUtils.isEmpty(this.zzc)) {
                    return;
                }
                if (this.zzd) {
                    com.google.android.gms.ads.internal.zzu.zzn().zzf(this.zza, this.zzc);
                } else {
                    com.google.android.gms.ads.internal.zzu.zzn().zzg(this.zza, this.zzc);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxw
    public final void zzdp(zzaxv zzaxvVar) {
        zzb(zzaxvVar.zzj);
    }
}
