package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamh implements zzamf {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzadp zzc;

    @Nullable
    private final zzanv zzd;

    @Nullable
    private final zzek zze;

    @Nullable
    private final zzamx zzf;
    private final boolean[] zzg;
    private final zzamg zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;

    public zzamh() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e0  */
    @Override // com.google.android.gms.internal.ads.zzamf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzek r21) {
        /*
            Method dump skipped, instruction units count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamh.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zzb = zzansVar.zzb();
        this.zzc = zzacnVar.zzw(zzansVar.zza(), 2);
        zzanv zzanvVar = this.zzd;
        if (zzanvVar != null) {
            zzanvVar.zzb(zzacnVar, zzansVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z10) {
        zzdi.zzb(this.zzc);
        if (z10) {
            boolean z11 = this.zzp;
            long j10 = this.zzi - this.zzn;
            this.zzc.zzs(this.zzo, z11 ? 1 : 0, (int) j10, 0, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j10, int i10) {
        this.zzm = j10;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        zzfh.zzf(this.zzg);
        this.zzh.zzb();
        zzamx zzamxVar = this.zzf;
        if (zzamxVar != null) {
            zzamxVar.zzb();
        }
        this.zzi = 0L;
        this.zzj = false;
        this.zzm = C.TIME_UNSET;
        this.zzo = C.TIME_UNSET;
    }

    zzamh(@Nullable zzanv zzanvVar) {
        zzek zzekVar;
        this.zzd = zzanvVar;
        this.zzg = new boolean[4];
        this.zzh = new zzamg(128);
        if (zzanvVar != null) {
            this.zzf = new zzamx(178, 128);
            zzekVar = new zzek();
        } else {
            zzekVar = null;
            this.zzf = null;
        }
        this.zze = zzekVar;
        this.zzm = C.TIME_UNSET;
        this.zzo = C.TIME_UNSET;
    }
}
