package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdhe implements zzcrx {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzhfu zzd;
    private final zzdjm zze;

    zzdhe(Map map, Map map2, Map map3, zzhfu zzhfuVar, zzdjm zzdjmVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzhfuVar;
        this.zze = zzdjmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrx
    @Nullable
    public final zzeet zza(int i10, String str) {
        zzeet zzeetVarZza;
        zzeet zzeetVar = (zzeet) this.zza.get(str);
        if (zzeetVar != null) {
            return zzeetVar;
        }
        if (i10 != 1) {
            if (i10 != 4) {
                return null;
            }
            zzehh zzehhVar = (zzehh) this.zzc.get(str);
            if (zzehhVar != null) {
                return new zzeeu(zzehhVar, new zzful() { // from class: com.google.android.gms.internal.ads.zzcrz
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj) {
                        return new zzcsc((List) obj);
                    }
                });
            }
            zzeetVarZza = (zzeet) this.zzb.get(str);
            if (zzeetVarZza == null) {
                return null;
            }
        } else if (this.zze.zze() == null || (zzeetVarZza = ((zzcrx) this.zzd.zzb()).zza(i10, str)) == null) {
            return null;
        }
        return new zzeeu(zzeetVarZza, new zzful() { // from class: com.google.android.gms.internal.ads.zzcsa
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return new zzcsc((zzcru) obj);
            }
        });
    }
}
