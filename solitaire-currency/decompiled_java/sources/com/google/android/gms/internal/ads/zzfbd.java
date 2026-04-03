package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfbd implements zzfcc {
    private zzcvx zza;
    private final Executor zzb = zzgda.zzb();

    public final zzcvx zza() {
        return this.zza;
    }

    public final m zzb(zzfcd zzfcdVar, zzfcb zzfcbVar, @Nullable zzcvx zzcvxVar) {
        zzcvw zzcvwVarZza = zzfcbVar.zza(zzfcdVar.zzb);
        zzcvwVarZza.zzb(new zzfcg(true));
        zzcvx zzcvxVar2 = (zzcvx) zzcvwVarZza.zzh();
        this.zza = zzcvxVar2;
        final zzctc zzctcVarZzb = zzcvxVar2.zzb();
        final zzfhd zzfhdVar = new zzfhd();
        return zzgcj.zzm(zzgcj.zzn(zzgca.zzu(zzctcVarZzb.zzj()), new zzgbq(this) { // from class: com.google.android.gms.internal.ads.zzfbb
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                zzfex zzfexVar = (zzfex) obj;
                zzfhdVar.zzb = zzfexVar;
                Iterator it = zzfexVar.zzb.zza.iterator();
                boolean z10 = false;
                loop0: while (true) {
                    if (it.hasNext()) {
                        Iterator it2 = ((zzfel) it.next()).zza.iterator();
                        while (it2.hasNext()) {
                            if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                                break loop0;
                            }
                            z10 = true;
                        }
                    } else if (z10) {
                        return zzctcVarZzb.zzi(zzgcj.zzh(zzfexVar));
                    }
                }
                return zzgcj.zzh(null);
            }
        }, this.zzb), new zzful() { // from class: com.google.android.gms.internal.ads.zzfbc
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                zzfhd zzfhdVar2 = zzfhdVar;
                zzfhdVar2.zzc = (zzcru) obj;
                return zzfhdVar2;
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    public final /* bridge */ /* synthetic */ m zzc(zzfcd zzfcdVar, zzfcb zzfcbVar, @Nullable Object obj) {
        return zzb(zzfcdVar, zzfcbVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
