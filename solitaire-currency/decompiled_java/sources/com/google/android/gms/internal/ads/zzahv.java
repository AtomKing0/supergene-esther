package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahv extends zzahx {
    public final long zza;
    public final List zzb;
    public final List zzc;

    public zzahv(int i10, long j10) {
        super(i10);
        this.zza = j10;
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzahx
    public final String toString() {
        List list = this.zzb;
        return zzahx.zzf(this.zzd) + " leaves: " + Arrays.toString(list.toArray()) + " containers: " + Arrays.toString(this.zzc.toArray());
    }

    @Nullable
    public final zzahv zza(int i10) {
        int size = this.zzc.size();
        for (int i11 = 0; i11 < size; i11++) {
            zzahv zzahvVar = (zzahv) this.zzc.get(i11);
            if (zzahvVar.zzd == i10) {
                return zzahvVar;
            }
        }
        return null;
    }

    @Nullable
    public final zzahw zzb(int i10) {
        int size = this.zzb.size();
        for (int i11 = 0; i11 < size; i11++) {
            zzahw zzahwVar = (zzahw) this.zzb.get(i11);
            if (zzahwVar.zzd == i10) {
                return zzahwVar;
            }
        }
        return null;
    }

    public final void zzc(zzahv zzahvVar) {
        this.zzc.add(zzahvVar);
    }

    public final void zzd(zzahw zzahwVar) {
        this.zzb.add(zzahwVar);
    }
}
