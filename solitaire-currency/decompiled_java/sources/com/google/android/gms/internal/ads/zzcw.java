package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcw implements zzct {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzcr zze;
    private zzcr zzf;
    private zzcr zzg;
    private zzcr zzh;
    private boolean zzi;

    @Nullable
    private zzcv zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzcw() {
        zzcr zzcrVar = zzcr.zza;
        this.zze = zzcrVar;
        this.zzf = zzcrVar;
        this.zzg = zzcrVar;
        this.zzh = zzcrVar;
        ByteBuffer byteBuffer = zzct.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final zzcr zza(zzcr zzcrVar) throws zzcs {
        if (zzcrVar.zzd != 2) {
            throw new zzcs("Unhandled input format:", zzcrVar);
        }
        int i10 = this.zzb;
        if (i10 == -1) {
            i10 = zzcrVar.zzb;
        }
        this.zze = zzcrVar;
        zzcr zzcrVar2 = new zzcr(i10, zzcrVar.zzc, 2);
        this.zzf = zzcrVar2;
        this.zzi = true;
        return zzcrVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final ByteBuffer zzb() {
        int iZza;
        zzcv zzcvVar = this.zzj;
        if (zzcvVar != null && (iZza = zzcvVar.zza()) > 0) {
            if (this.zzk.capacity() < iZza) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iZza).order(ByteOrder.nativeOrder());
                this.zzk = byteBufferOrder;
                this.zzl = byteBufferOrder.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzcvVar.zzd(this.zzl);
            this.zzo += (long) iZza;
            this.zzk.limit(iZza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zzct.zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zzc() {
        if (zzg()) {
            zzcr zzcrVar = this.zze;
            this.zzg = zzcrVar;
            zzcr zzcrVar2 = this.zzf;
            this.zzh = zzcrVar2;
            if (this.zzi) {
                this.zzj = new zzcv(zzcrVar.zzb, zzcrVar.zzc, this.zzc, this.zzd, zzcrVar2.zzb);
            } else {
                zzcv zzcvVar = this.zzj;
                if (zzcvVar != null) {
                    zzcvVar.zzc();
                }
            }
        }
        this.zzm = zzct.zza;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zzd() {
        zzcv zzcvVar = this.zzj;
        if (zzcvVar != null) {
            zzcvVar.zze();
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzcv zzcvVar = this.zzj;
            zzcvVar.getClass();
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.zzn += (long) iRemaining;
            zzcvVar.zzf(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        zzcr zzcrVar = zzcr.zza;
        this.zze = zzcrVar;
        this.zzf = zzcrVar;
        this.zzg = zzcrVar;
        this.zzh = zzcrVar;
        ByteBuffer byteBuffer = zzct.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final boolean zzg() {
        if (this.zzf.zzb == -1) {
            return false;
        }
        if (Math.abs(this.zzc - 1.0f) >= 1.0E-4f || Math.abs(this.zzd - 1.0f) >= 1.0E-4f) {
            return true;
        }
        return this.zzf.zzb != this.zze.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzcv zzcvVar = this.zzj;
        return zzcvVar == null || zzcvVar.zza() == 0;
    }

    public final long zzi(long j10) {
        long j11 = this.zzo;
        if (j11 < 1024) {
            return (long) (((double) this.zzc) * j10);
        }
        long j12 = this.zzn;
        zzcv zzcvVar = this.zzj;
        zzcvVar.getClass();
        long jZzb = j12 - ((long) zzcvVar.zzb());
        int i10 = this.zzh.zzb;
        int i11 = this.zzg.zzb;
        return i10 == i11 ? zzet.zzt(j10, jZzb, j11, RoundingMode.FLOOR) : zzet.zzt(j10, jZzb * ((long) i10), j11 * ((long) i11), RoundingMode.FLOOR);
    }

    public final void zzj(float f10) {
        if (this.zzd != f10) {
            this.zzd = f10;
            this.zzi = true;
        }
    }

    public final void zzk(float f10) {
        if (this.zzc != f10) {
            this.zzc = f10;
            this.zzi = true;
        }
    }
}
