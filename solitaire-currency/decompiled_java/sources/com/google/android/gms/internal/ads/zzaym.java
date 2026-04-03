package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaym {

    @VisibleForTesting
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    @Nullable
    public final zzayl zza(boolean z10) {
        synchronized (this.zzb) {
            zzayl zzaylVar = null;
            if (this.zzc.isEmpty()) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Queue empty");
                return null;
            }
            int i10 = 0;
            if (this.zzc.size() < 2) {
                zzayl zzaylVar2 = (zzayl) this.zzc.get(0);
                if (z10) {
                    this.zzc.remove(0);
                } else {
                    zzaylVar2.zzi();
                }
                return zzaylVar2;
            }
            int i11 = Integer.MIN_VALUE;
            int i12 = 0;
            for (zzayl zzaylVar3 : this.zzc) {
                int iZzb = zzaylVar3.zzb();
                if (iZzb > i11) {
                    i10 = i12;
                }
                int i13 = iZzb > i11 ? iZzb : i11;
                if (iZzb > i11) {
                    zzaylVar = zzaylVar3;
                }
                i12++;
                i11 = i13;
            }
            this.zzc.remove(i10);
            return zzaylVar;
        }
    }

    public final void zzb(zzayl zzaylVar) {
        synchronized (this.zzb) {
            if (this.zzc.size() >= 10) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Queue is full, current size = " + this.zzc.size());
                this.zzc.remove(0);
            }
            int i10 = this.zza;
            this.zza = i10 + 1;
            zzaylVar.zzj(i10);
            zzaylVar.zzn();
            this.zzc.add(zzaylVar);
        }
    }

    public final boolean zzc(zzayl zzaylVar) {
        synchronized (this.zzb) {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                zzayl zzaylVar2 = (zzayl) it.next();
                if (com.google.android.gms.ads.internal.zzu.zzo().zzi().zzP()) {
                    if (!com.google.android.gms.ads.internal.zzu.zzo().zzi().zzQ() && !zzaylVar.equals(zzaylVar2) && zzaylVar2.zzf().equals(zzaylVar.zzf())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzaylVar.equals(zzaylVar2) && zzaylVar2.zzd().equals(zzaylVar.zzd())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean zzd(zzayl zzaylVar) {
        synchronized (this.zzb) {
            return this.zzc.contains(zzaylVar);
        }
    }
}
