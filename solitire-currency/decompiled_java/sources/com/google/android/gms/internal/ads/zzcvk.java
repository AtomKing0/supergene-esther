package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcvk implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzcvk(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final VersionInfoParcel versionInfoParcelZza = ((zzchc) this.zzb).zza();
        final zzffg zzffgVarZza = ((zzcwh) this.zzc).zza();
        return new zzful() { // from class: com.google.android.gms.internal.ads.zzcvj
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                zzfel zzfelVar = (zzfel) obj;
                com.google.android.gms.ads.internal.util.zzau zzauVar = new com.google.android.gms.ads.internal.util.zzau(context);
                zzauVar.zzp(zzfelVar.zzB);
                zzauVar.zzq(zzfelVar.zzC.toString());
                zzauVar.zzo(versionInfoParcelZza.afmaVersion);
                zzauVar.zzn(zzffgVarZza.zzf);
                return zzauVar;
            }
        };
    }
}
