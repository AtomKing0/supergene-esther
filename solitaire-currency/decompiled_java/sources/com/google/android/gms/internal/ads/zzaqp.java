package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaqp extends ThreadLocal {
    zzaqp(zzaqq zzaqqVar) {
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Object initialValue() {
        return ByteBuffer.allocate(32);
    }
}
