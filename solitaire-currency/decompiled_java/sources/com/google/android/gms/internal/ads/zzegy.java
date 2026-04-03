package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzegy implements zzdgx {
    private final zzfel zza;
    private final zzbql zzb;
    private final AdFormat zzc;

    @Nullable
    private zzcxi zzd = null;

    zzegy(zzfel zzfelVar, zzbql zzbqlVar, AdFormat adFormat) {
        this.zza = zzfelVar;
        this.zzb = zzbqlVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final void zza(boolean z10, Context context, zzcxd zzcxdVar) throws zzdgw {
        boolean zZzs;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int iOrdinal = this.zzc.ordinal();
            if (iOrdinal == 1) {
                zZzs = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 5) {
                        zZzs = this.zzb.zzr(ObjectWrapper.wrap(context));
                    }
                    throw new zzdgw("Adapter failed to show.");
                }
                zZzs = this.zzb.zzt(ObjectWrapper.wrap(context));
            }
            if (zZzs) {
                if (this.zzd == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbm)).booleanValue() || this.zza.zzY != 2) {
                    return;
                }
                this.zzd.zza();
                return;
            }
            throw new zzdgw("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdgw(th);
        }
    }

    public final void zzb(zzcxi zzcxiVar) {
        this.zzd = zzcxiVar;
    }
}
