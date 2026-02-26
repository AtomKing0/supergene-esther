package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzccg {
    private long zza;

    public final long zza(ByteBuffer byteBuffer) {
        zzaqx zzaqxVar;
        zzaqw zzaqwVar;
        long j10 = this.zza;
        if (j10 > 0) {
            return j10;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            Iterator it = new zzaqs(new zzccf(byteBufferDuplicate), zzcci.zzb).zzd().iterator();
            while (true) {
                zzaqxVar = null;
                if (!it.hasNext()) {
                    zzaqwVar = null;
                    break;
                }
                zzaqu zzaquVar = (zzaqu) it.next();
                if (zzaquVar instanceof zzaqw) {
                    zzaqwVar = (zzaqw) zzaquVar;
                    break;
                }
            }
            Iterator it2 = zzaqwVar.zzd().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzaqu zzaquVar2 = (zzaqu) it2.next();
                if (zzaquVar2 instanceof zzaqx) {
                    zzaqxVar = (zzaqx) zzaquVar2;
                    break;
                }
            }
            long jZzc = (zzaqxVar.zzc() * 1000) / zzaqxVar.zzd();
            this.zza = jZzc;
            return jZzc;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
