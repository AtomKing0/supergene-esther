package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfth extends zzfsk {
    final /* synthetic */ zzfti zza;
    private final zzftn zzb;

    zzfth(zzfti zzftiVar, zzftn zzftnVar) {
        this.zza = zzftiVar;
        this.zzb = zzftnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsl
    public final void zzb(Bundle bundle) {
        int i10 = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzftl zzftlVarZzc = zzftm.zzc();
        zzftlVarZzc.zzb(i10);
        if (string != null) {
            zzftlVarZzc.zza(string);
        }
        this.zzb.zza(zzftlVarZzc.zzc());
        if (i10 == 8157) {
            this.zza.zza();
        }
    }
}
