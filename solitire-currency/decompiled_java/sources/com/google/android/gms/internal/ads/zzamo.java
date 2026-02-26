package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamo implements zzamf {
    private final zzani zza;
    private String zzb;
    private zzadp zzc;
    private zzamn zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzamx zzg = new zzamx(32, 128);
    private final zzamx zzh = new zzamx(33, 128);
    private final zzamx zzi = new zzamx(34, 128);
    private final zzamx zzj = new zzamx(39, 128);
    private final zzamx zzk = new zzamx(40, 128);
    private long zzm = C.TIME_UNSET;
    private final zzek zzn = new zzek();

    public zzamo(zzani zzaniVar) {
        this.zza = zzaniVar;
    }

    private final void zzf(byte[] bArr, int i10, int i11) {
        this.zzd.zzc(bArr, i10, i11);
        if (!this.zze) {
            this.zzg.zza(bArr, i10, i11);
            this.zzh.zza(bArr, i10, i11);
            this.zzi.zza(bArr, i10, i11);
        }
        this.zzj.zza(bArr, i10, i11);
        this.zzk.zza(bArr, i10, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0139  */
    @Override // com.google.android.gms.internal.ads.zzamf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzek r32) {
        /*
            Method dump skipped, instruction units count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamo.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zzb = zzansVar.zzb();
        zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 2);
        this.zzc = zzadpVarZzw;
        this.zzd = new zzamn(zzadpVarZzw);
        this.zza.zzb(zzacnVar, zzansVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z10) {
        zzdi.zzb(this.zzc);
        int i10 = zzet.zza;
        if (z10) {
            this.zzd.zza(this.zzl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j10, int i10) {
        this.zzm = j10;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzl = 0L;
        this.zzm = C.TIME_UNSET;
        zzfh.zzf(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        zzamn zzamnVar = this.zzd;
        if (zzamnVar != null) {
            zzamnVar.zzd();
        }
    }
}
