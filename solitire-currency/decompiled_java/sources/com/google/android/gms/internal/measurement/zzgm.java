package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgm extends ContentObserver {
    private final /* synthetic */ zzgk zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgm(zzgk zzgkVar, Handler handler) {
        super(null);
        this.zza = zzgkVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        this.zza.zza.set(true);
    }
}
