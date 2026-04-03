package com.google.android.gms.internal.ads;

import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzqx extends zzcu {
    private int zzd;
    private boolean zze;
    private int zzf;
    private long zzg;
    private byte[] zzi;
    private byte[] zzl;
    private int zzh = 0;
    private int zzj = 0;
    private int zzk = 0;

    public zzqx() {
        byte[] bArr = zzet.zzf;
        this.zzi = bArr;
        this.zzl = bArr;
    }

    private final int zzq(int i10) {
        int iZzr = ((zzr(SilenceSkippingAudioProcessor.DEFAULT_MAX_SILENCE_TO_KEEP_DURATION_US) - this.zzh) * this.zzd) - (this.zzi.length >> 1);
        zzdi.zzf(iZzr >= 0);
        int iMin = (int) Math.min((i10 * 0.2f) + 0.5f, iZzr);
        int i11 = this.zzd;
        return (iMin / i11) * i11;
    }

    private final int zzr(long j10) {
        return (int) ((j10 * ((long) this.zzb.zzb)) / 1000000);
    }

    private static int zzs(byte b10, byte b11) {
        return (b10 << 8) | (b11 & 255);
    }

    private final void zzt(boolean z10) {
        int i10;
        int length;
        int i11 = this.zzk;
        int length2 = this.zzi.length;
        if (i11 != length2) {
            if (!z10) {
                return;
            } else {
                z10 = true;
            }
        }
        if (this.zzh == 0) {
            if (z10) {
                zzu(i11, 3);
                length = i11;
            } else {
                zzdi.zzf(i11 >= (length2 >> 1));
                length = this.zzi.length >> 1;
                zzu(length, 0);
            }
            i10 = length;
        } else {
            int i12 = length2 >> 1;
            int i13 = i11 - i12;
            if (z10) {
                int iZzq = zzq(i13) + (this.zzi.length >> 1);
                zzu(iZzq, 2);
                int i14 = i12 + i13;
                i10 = iZzq;
                length = i14;
            } else {
                int iZzq2 = zzq(i13);
                zzu(iZzq2, 1);
                i10 = iZzq2;
                length = i13;
            }
        }
        zzdi.zzg(length % this.zzd == 0, "bytesConsumed is not aligned to frame size: %s" + length);
        zzdi.zzf(i11 >= i10);
        this.zzk -= length;
        int i15 = this.zzj + length;
        this.zzj = i15;
        this.zzj = i15 % this.zzi.length;
        int i16 = this.zzh;
        int i17 = this.zzd;
        this.zzh = i16 + (i10 / i17);
        this.zzg += (long) ((length - i10) / i17);
    }

    private final void zzu(int i10, int i11) {
        int i12;
        if (i10 == 0) {
            return;
        }
        zzdi.zzd(this.zzk >= i10);
        if (i11 == 2) {
            int i13 = this.zzj;
            int i14 = this.zzk;
            int i15 = i13 + i14;
            byte[] bArr = this.zzi;
            int length = bArr.length;
            if (i15 <= length) {
                System.arraycopy(bArr, i15 - i10, this.zzl, 0, i10);
            } else {
                int i16 = i14 - (length - i13);
                if (i16 >= i10) {
                    System.arraycopy(bArr, i16 - i10, this.zzl, 0, i10);
                } else {
                    int i17 = i10 - i16;
                    System.arraycopy(bArr, length - i17, this.zzl, 0, i17);
                    System.arraycopy(this.zzi, 0, this.zzl, i17, i16);
                }
            }
        } else {
            int i18 = this.zzj;
            int i19 = i18 + i10;
            byte[] bArr2 = this.zzi;
            int length2 = bArr2.length;
            if (i19 <= length2) {
                System.arraycopy(bArr2, i18, this.zzl, 0, i10);
            } else {
                int i20 = length2 - i18;
                System.arraycopy(bArr2, i18, this.zzl, 0, i20);
                System.arraycopy(this.zzi, 0, this.zzl, i20, i10 - i20);
            }
        }
        zzdi.zze(i10 % this.zzd == 0, "sizeToOutput is not aligned to frame size: " + i10);
        zzdi.zzf(this.zzj < this.zzi.length);
        byte[] bArr3 = this.zzl;
        zzdi.zze(i10 % this.zzd == 0, "byteOutput size is not aligned to frame size " + i10);
        if (i11 != 3) {
            for (int i21 = 0; i21 < i10; i21 += 2) {
                int i22 = i21 + 1;
                int iZzs = zzs(bArr3[i22], bArr3[i21]);
                if (i11 == 0) {
                    i12 = ((((i21 * 1000) / (i10 - 1)) * (-90)) / 1000) + 100;
                } else {
                    i12 = 10;
                    if (i11 == 2) {
                        i12 = 10 + (((90000 * i21) / (i10 - 1)) / 1000);
                    }
                }
                int i23 = (iZzs * i12) / 100;
                if (i23 >= 32767) {
                    bArr3[i21] = -1;
                    bArr3[i22] = 127;
                } else if (i23 <= -32768) {
                    bArr3[i21] = 0;
                    bArr3[i22] = -128;
                } else {
                    bArr3[i21] = (byte) (i23 & 255);
                    bArr3[i22] = (byte) (i23 >> 8);
                }
            }
        }
        zzj(i10).put(bArr3, 0, i10).flip();
    }

    private static final boolean zzv(byte b10, byte b11) {
        return Math.abs(zzs(b10, b11)) > 1024;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zze(ByteBuffer byteBuffer) {
        int iLimit;
        int i10;
        int iPosition;
        while (byteBuffer.hasRemaining() && !zzn()) {
            if (this.zzf != 0) {
                zzdi.zzf(this.zzj < this.zzi.length);
                int iLimit2 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition2 >= byteBuffer.limit()) {
                        iLimit = byteBuffer.limit();
                        break;
                    } else {
                        if (zzv(byteBuffer.get(iPosition2), byteBuffer.get(iPosition2 - 1))) {
                            int i11 = this.zzd;
                            iLimit = i11 * (iPosition2 / i11);
                            break;
                        }
                        iPosition2 += 2;
                    }
                }
                int iPosition3 = iLimit - byteBuffer.position();
                int i12 = this.zzj;
                int i13 = this.zzk;
                int i14 = i12 + i13;
                int length = this.zzi.length;
                if (i14 < length) {
                    i10 = length - i14;
                } else {
                    i14 = i13 - (length - i12);
                    i10 = i12 - i14;
                }
                int iMin = Math.min(iPosition3, i10);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuffer.get(this.zzi, i14, iMin);
                int i15 = this.zzk + iMin;
                this.zzk = i15;
                zzdi.zzf(i15 <= this.zzi.length);
                boolean z10 = iLimit < iLimit2 && iPosition3 < i10;
                zzt(z10);
                if (z10) {
                    this.zzf = 0;
                    this.zzh = 0;
                }
                byteBuffer.limit(iLimit2);
            } else {
                int iLimit3 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit3, byteBuffer.position() + this.zzi.length));
                int iLimit4 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit4 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    } else {
                        if (zzv(byteBuffer.get(iLimit4), byteBuffer.get(iLimit4 - 1))) {
                            int i16 = this.zzd;
                            iPosition = ((iLimit4 / i16) * i16) + i16;
                            break;
                        }
                        iLimit4 -= 2;
                    }
                }
                if (iPosition == byteBuffer.position()) {
                    this.zzf = 1;
                } else {
                    byteBuffer.limit(Math.min(iPosition, byteBuffer.capacity()));
                    zzj(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(iLimit3);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu, com.google.android.gms.internal.ads.zzct
    public final boolean zzg() {
        return super.zzg() && this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final zzcr zzi(zzcr zzcrVar) throws zzcs {
        if (zzcrVar.zzd == 2) {
            return zzcrVar.zzb == -1 ? zzcr.zza : zzcrVar;
        }
        throw new zzcs("Unhandled input format:", zzcrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzk() {
        if (zzg()) {
            int i10 = this.zzb.zzc;
            this.zzd = i10 + i10;
            int iZzr = zzr(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) / 2;
            int i11 = this.zzd;
            int i12 = (iZzr / i11) * i11;
            int i13 = i12 + i12;
            if (this.zzi.length != i13) {
                this.zzi = new byte[i13];
                this.zzl = new byte[i13];
            }
        }
        this.zzf = 0;
        this.zzg = 0L;
        this.zzh = 0;
        this.zzj = 0;
        this.zzk = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzl() {
        if (this.zzk > 0) {
            zzt(true);
            this.zzh = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzm() {
        this.zze = false;
        byte[] bArr = zzet.zzf;
        this.zzi = bArr;
        this.zzl = bArr;
    }

    public final long zzo() {
        return this.zzg;
    }

    public final void zzp(boolean z10) {
        this.zze = z10;
    }
}
