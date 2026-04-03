package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgt implements zzfs {
    private final zzfs zza;
    private long zzb;
    private Uri zzc = Uri.EMPTY;
    private Map zzd = Collections.emptyMap();

    public zzgt(zzfs zzfsVar) {
        this.zza = zzfsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i10, int i11) throws IOException {
        int iZza = this.zza.zza(bArr, i10, i11);
        if (iZza != -1) {
            this.zzb += (long) iZza;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws IOException {
        this.zzc = zzfyVar.zza;
        this.zzd = Collections.emptyMap();
        long jZzb = this.zza.zzb(zzfyVar);
        Uri uriZzc = zzc();
        uriZzc.getClass();
        this.zzc = uriZzc;
        this.zzd = zze();
        return jZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    @Nullable
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Map zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzf(zzgu zzguVar) {
        zzguVar.getClass();
        this.zza.zzf(zzguVar);
    }

    public final long zzg() {
        return this.zzb;
    }

    public final Uri zzh() {
        return this.zzc;
    }

    public final Map zzi() {
        return this.zzd;
    }
}
