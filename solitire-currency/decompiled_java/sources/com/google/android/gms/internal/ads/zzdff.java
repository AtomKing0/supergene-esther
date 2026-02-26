package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdff extends zzdch {
    zzdff(Set set) {
        super(set);
    }

    public final synchronized void zza(@Nullable final com.google.android.gms.ads.nonagon.signalgeneration.zzay zzayVar) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdfd
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzdfc) obj).zze(zzayVar);
            }
        });
    }

    public final synchronized void zzb(@Nullable final String str) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdfe
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzdfc) obj).zzf(str);
            }
        });
    }
}
