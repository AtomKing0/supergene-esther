package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamp implements zzamf {
    private zzadp zzb;
    private boolean zzc;
    private int zze;
    private int zzf;
    private final zzek zza = new zzek(10);
    private long zzd = C.TIME_UNSET;

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zza(zzek zzekVar) {
        zzdi.zzb(this.zzb);
        if (this.zzc) {
            int iZzb = zzekVar.zzb();
            int i10 = this.zzf;
            if (i10 < 10) {
                int iMin = Math.min(iZzb, 10 - i10);
                System.arraycopy(zzekVar.zzM(), zzekVar.zzd(), this.zza.zzM(), this.zzf, iMin);
                if (this.zzf + iMin == 10) {
                    this.zza.zzK(0);
                    if (this.zza.zzm() != 73 || this.zza.zzm() != 68 || this.zza.zzm() != 51) {
                        zzea.zzf("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    } else {
                        this.zza.zzL(3);
                        this.zze = this.zza.zzl() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iZzb, this.zze - this.zzf);
            this.zzb.zzq(zzekVar, iMin2);
            this.zzf += iMin2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 5);
        this.zzb = zzadpVarZzw;
        zzad zzadVar = new zzad();
        zzadVar.zzK(zzansVar.zzb());
        zzadVar.zzX(MimeTypes.APPLICATION_ID3);
        zzadpVarZzw.zzl(zzadVar.zzad());
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z10) {
        int i10;
        zzdi.zzb(this.zzb);
        if (this.zzc && (i10 = this.zze) != 0 && this.zzf == i10) {
            zzdi.zzf(this.zzd != C.TIME_UNSET);
            this.zzb.zzs(this.zzd, 1, this.zze, 0, null);
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j10, int i10) {
        if ((i10 & 4) == 0) {
            return;
        }
        this.zzc = true;
        this.zzd = j10;
        this.zze = 0;
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzc = false;
        this.zzd = C.TIME_UNSET;
    }
}
