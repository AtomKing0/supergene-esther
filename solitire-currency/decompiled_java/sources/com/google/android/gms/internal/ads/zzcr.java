package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.v8;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcr {
    public static final zzcr zza = new zzcr(-1, -1, -1);
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    public zzcr(int i10, int i11, int i12) {
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = zzet.zzK(i12) ? zzet.zzm(i12, i11) : -1;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcr)) {
            return false;
        }
        zzcr zzcrVar = (zzcr) obj;
        return this.zzb == zzcrVar.zzb && this.zzc == zzcrVar.zzc && this.zzd == zzcrVar.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd)});
    }

    public final String toString() {
        return "AudioFormat[sampleRate=" + this.zzb + ", channelCount=" + this.zzc + ", encoding=" + this.zzd + v8.i.f15839e;
    }
}
