package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzqz extends zzcu {
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private byte[] zzh = zzet.zzf;
    private int zzi;
    private long zzj;

    @Override // com.google.android.gms.internal.ads.zzcu, com.google.android.gms.internal.ads.zzct
    public final ByteBuffer zzb() {
        int i10;
        if (super.zzh() && (i10 = this.zzi) > 0) {
            zzj(i10).put(this.zzh, 0, this.zzi).flip();
            this.zzi = 0;
        }
        return super.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zze(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i10 = iLimit - iPosition;
        if (i10 == 0) {
            return;
        }
        int iMin = Math.min(i10, this.zzg);
        this.zzj += (long) (iMin / this.zzb.zze);
        this.zzg -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.zzg <= 0) {
            int i11 = i10 - iMin;
            int length = (this.zzi + i11) - this.zzh.length;
            ByteBuffer byteBufferZzj = zzj(length);
            int iMax = Math.max(0, Math.min(length, this.zzi));
            byteBufferZzj.put(this.zzh, 0, iMax);
            int iMax2 = Math.max(0, Math.min(length - iMax, i11));
            byteBuffer.limit(byteBuffer.position() + iMax2);
            byteBufferZzj.put(byteBuffer);
            byteBuffer.limit(iLimit);
            int i12 = i11 - iMax2;
            int i13 = this.zzi - iMax;
            this.zzi = i13;
            byte[] bArr = this.zzh;
            System.arraycopy(bArr, iMax, bArr, 0, i13);
            byteBuffer.get(this.zzh, this.zzi, i12);
            this.zzi += i12;
            byteBufferZzj.flip();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu, com.google.android.gms.internal.ads.zzct
    public final boolean zzh() {
        return super.zzh() && this.zzi == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final zzcr zzi(zzcr zzcrVar) throws zzcs {
        if (zzcrVar.zzd != 2) {
            throw new zzcs("Unhandled input format:", zzcrVar);
        }
        this.zzf = true;
        return (this.zzd == 0 && this.zze == 0) ? zzcr.zza : zzcrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void zzk() {
        if (this.zzf) {
            this.zzf = false;
            int i10 = this.zze;
            int i11 = this.zzb.zze;
            this.zzh = new byte[i10 * i11];
            this.zzg = this.zzd * i11;
        }
        this.zzi = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void zzl() {
        if (this.zzf) {
            int i10 = this.zzi;
            if (i10 > 0) {
                this.zzj += (long) (i10 / this.zzb.zze);
            }
            this.zzi = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void zzm() {
        this.zzh = zzet.zzf;
    }

    public final long zzo() {
        return this.zzj;
    }

    public final void zzp() {
        this.zzj = 0L;
    }

    public final void zzq(int i10, int i11) {
        this.zzd = i10;
        this.zze = i11;
    }
}
