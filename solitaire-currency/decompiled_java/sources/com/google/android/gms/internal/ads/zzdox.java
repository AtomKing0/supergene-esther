package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdox implements zzhfc {
    private final zzhfu zza;

    public zzdox(zzhfu zzhfuVar) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbbc.zza.EnumC0191zza enumC0191zza = ((zzcwh) this.zza).zza().zzo.zza == 3 ? zzbbc.zza.EnumC0191zza.REWARDED_INTERSTITIAL : zzbbc.zza.EnumC0191zza.REWARD_BASED_VIDEO_AD;
        zzhfk.zzb(enumC0191zza);
        return enumC0191zza;
    }
}
