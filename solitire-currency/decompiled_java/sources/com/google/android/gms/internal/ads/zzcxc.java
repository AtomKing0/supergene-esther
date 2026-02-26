package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public final class zzcxc extends zzdch implements zzcwu {
    @VisibleForTesting
    public zzcxc(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zza(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcxb
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzcxg) obj).zzq(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzb() {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcxa
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzcxg) obj).zzq(zzfgi.zzd(11, null, null));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzc(final zzdgw zzdgwVar) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcwz
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzcxg) obj).zzq(zzfgi.zzd(12, zzdgwVar.getMessage(), null));
            }
        });
    }
}
