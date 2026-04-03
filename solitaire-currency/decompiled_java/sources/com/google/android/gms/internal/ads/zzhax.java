package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhax extends zzhay {
    zzhax(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final byte zza(long j10) {
        return Memory.peekByte(j10);
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final double zzb(Object obj, long j10) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j10));
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final float zzc(Object obj, long j10) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j10));
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzd(long j10, byte[] bArr, long j11, long j12) {
        Memory.peekByteArray(j10, bArr, (int) j11, (int) j12);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zzhaz.zzk(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zzhaz.zzl(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.ads.zzhaz.zzl(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.ads.zzhaz.zzk(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zze(Object obj, long j10, boolean z10) {
        if (zzhaz.zzb) {
            zzhaz.zzk(obj, j10, z10);
        } else {
            zzhaz.zzl(obj, j10, z10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzf(Object obj, long j10, byte b10) {
        if (zzhaz.zzb) {
            zzhaz.zzG(obj, j10, b10);
        } else {
            zzhaz.zzH(obj, j10, b10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzg(Object obj, long j10, double d10) {
        this.zza.putLong(obj, j10, Double.doubleToLongBits(d10));
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzh(Object obj, long j10, float f10) {
        this.zza.putInt(obj, j10, Float.floatToIntBits(f10));
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final boolean zzi(Object obj, long j10) {
        return zzhaz.zzb ? zzhaz.zzw(obj, j10) : zzhaz.zzx(obj, j10);
    }
}
