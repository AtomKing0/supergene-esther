package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcci extends zzaqq {
    static final zzcci zzb = new zzcci();

    zzcci() {
    }

    @Override // com.google.android.gms.internal.ads.zzaqq
    public final zzaqu zza(String str, byte[] bArr, String str2) {
        return "moov".equals(str) ? new zzaqw() : "mvhd".equals(str) ? new zzaqx() : new zzaqy(str);
    }
}
