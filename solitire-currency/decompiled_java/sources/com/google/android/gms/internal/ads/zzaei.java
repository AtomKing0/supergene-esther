package com.google.android.gms.internal.ads;

import androidx.media3.extractor.mp4.Atom;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaei implements zzack {
    private final zzek zza = new zzek(4);
    private final zzadk zzb = new zzadk(-1, -1, "image/avif");

    private final boolean zza(zzacl zzaclVar, int i10) throws IOException {
        this.zza.zzH(4);
        ((zzaby) zzaclVar).zzm(this.zza.zzM(), 0, 4, false);
        return this.zza.zzu() == ((long) i10);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) throws IOException {
        return this.zzb.zzb(zzaclVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zzb.zze(zzacnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j10, long j11) {
        this.zzb.zzi(j10, j11);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws IOException {
        ((zzaby) zzaclVar).zzl(4, false);
        return zza(zzaclVar, Atom.TYPE_ftyp) && zza(zzaclVar, 1635150182);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}
