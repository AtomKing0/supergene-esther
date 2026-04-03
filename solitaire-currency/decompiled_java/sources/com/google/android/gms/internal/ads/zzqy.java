package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzqy extends zzcu {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    zzqy() {
    }

    private static void zzo(int i10, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i10) * 4.656612875245797E-10d));
        if (iFloatToIntBits == zzd) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zze(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferZzj;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i10 = iLimit - iPosition;
        int i11 = this.zzb.zzd;
        if (i11 == 21) {
            byteBufferZzj = zzj((i10 / 3) * 4);
            while (iPosition < iLimit) {
                zzo(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferZzj);
                iPosition += 3;
            }
        } else if (i11 == 22) {
            byteBufferZzj = zzj(i10);
            while (iPosition < iLimit) {
                int i12 = byteBuffer.get(iPosition) & 255;
                int i13 = (byteBuffer.get(iPosition + 1) & 255) << 8;
                zzo(i12 | i13 | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferZzj);
                iPosition += 4;
            }
        } else if (i11 == 1342177280) {
            byteBufferZzj = zzj((i10 / 3) * 4);
            while (iPosition < iLimit) {
                zzo(((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferZzj);
                iPosition += 3;
            }
        } else {
            if (i11 != 1610612736) {
                throw new IllegalStateException();
            }
            byteBufferZzj = zzj(i10);
            while (iPosition < iLimit) {
                int i14 = byteBuffer.get(iPosition + 3) & 255;
                int i15 = (byteBuffer.get(iPosition + 2) & 255) << 8;
                zzo(i14 | i15 | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferZzj);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferZzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final zzcr zzi(zzcr zzcrVar) throws zzcs {
        int i10 = zzcrVar.zzd;
        int i11 = zzet.zza;
        if (i10 == 21 || i10 == 1342177280 || i10 == 22 || i10 == 1610612736) {
            return new zzcr(zzcrVar.zzb, zzcrVar.zzc, 4);
        }
        if (i10 == 4) {
            return zzcr.zza;
        }
        throw new zzcs("Unhandled input format:", zzcrVar);
    }
}
