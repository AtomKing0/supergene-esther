package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhel extends zzhej {
    private int zzg;

    protected zzhel(String str) {
        super("mvhd");
    }

    public final int zzg() {
        if (!this.zzb) {
            zzf();
        }
        return this.zzg;
    }

    protected final long zzh(ByteBuffer byteBuffer) {
        this.zzg = zzaqt.zzc(byteBuffer.get());
        zzaqt.zzd(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
