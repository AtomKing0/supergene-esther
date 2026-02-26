package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcx extends zzcu {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // com.google.android.gms.internal.ads.zzct
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zze(java.nio.ByteBuffer r12) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcx.zze(java.nio.ByteBuffer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final zzcr zzi(zzcr zzcrVar) throws zzcs {
        int i10 = zzcrVar.zzd;
        if (i10 != 3) {
            if (i10 == 2) {
                return zzcr.zza;
            }
            if (i10 != 268435456 && i10 != 21 && i10 != 1342177280 && i10 != 22 && i10 != 1610612736 && i10 != 4) {
                throw new zzcs("Unhandled input format:", zzcrVar);
            }
        }
        return new zzcr(zzcrVar.zzb, zzcrVar.zzc, 2);
    }
}
