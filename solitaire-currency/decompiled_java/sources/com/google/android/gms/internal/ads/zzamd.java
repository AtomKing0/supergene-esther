package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamd implements zzamf {
    private final zzek zza;

    @Nullable
    private final String zzc;
    private final int zzd;
    private String zze;
    private zzadp zzf;
    private int zzh;
    private int zzi;
    private long zzj;
    private zzaf zzk;
    private int zzl;
    private int zzm;
    private int zzg = 0;
    private long zzp = C.TIME_UNSET;
    private final AtomicInteger zzb = new AtomicInteger();
    private int zzn = -1;
    private int zzo = -1;

    public zzamd(@Nullable String str, int i10, int i11) {
        this.zza = new zzek(new byte[i11]);
        this.zzc = str;
        this.zzd = i10;
    }

    private final void zzf(zzacg zzacgVar) {
        int i10;
        int i11 = zzacgVar.zzb;
        if (i11 == -2147483647 || (i10 = zzacgVar.zzc) == -1) {
            return;
        }
        zzaf zzafVar = this.zzk;
        if (zzafVar != null && i10 == zzafVar.zzz && i11 == zzafVar.zzA && zzet.zzG(zzacgVar.zza, zzafVar.zzm)) {
            return;
        }
        zzaf zzafVar2 = this.zzk;
        zzad zzadVar = zzafVar2 == null ? new zzad() : zzafVar2.zzb();
        zzadVar.zzK(this.zze);
        zzadVar.zzX(zzacgVar.zza);
        zzadVar.zzy(zzacgVar.zzc);
        zzadVar.zzY(zzacgVar.zzb);
        zzadVar.zzO(this.zzc);
        zzadVar.zzV(this.zzd);
        zzaf zzafVarZzad = zzadVar.zzad();
        this.zzk = zzafVarZzad;
        this.zzf.zzl(zzafVarZzad);
    }

    private final boolean zzg(zzek zzekVar, byte[] bArr, int i10) {
        int iMin = Math.min(zzekVar.zzb(), i10 - this.zzh);
        zzekVar.zzG(bArr, this.zzh, iMin);
        int i11 = this.zzh + iMin;
        this.zzh = i11;
        return i11 == i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01db  */
    @Override // com.google.android.gms.internal.ads.zzamf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzek r17) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamd.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zze = zzansVar.zzb();
        this.zzf = zzacnVar.zzw(zzansVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j10, int i10) {
        this.zzp = j10;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zzp = C.TIME_UNSET;
        this.zzb.set(0);
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z10) {
    }
}
