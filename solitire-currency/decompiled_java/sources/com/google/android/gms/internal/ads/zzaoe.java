package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaoe implements zzack {
    private final zzek zza = new zzek(4);
    private final zzadk zzb = new zzadk(-1, -1, MimeTypes.IMAGE_WEBP);

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
        this.zza.zzH(4);
        zzaby zzabyVar = (zzaby) zzaclVar;
        zzabyVar.zzm(this.zza.zzM(), 0, 4, false);
        if (this.zza.zzu() == 1380533830) {
            zzabyVar.zzl(4, false);
            this.zza.zzH(4);
            zzabyVar.zzm(this.zza.zzM(), 0, 4, false);
            if (this.zza.zzu() == 1464156752) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}
