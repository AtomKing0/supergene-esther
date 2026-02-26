package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgt extends ContentObserver {
    private final /* synthetic */ zzgr zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgt(zzgr zzgrVar, Handler handler) {
        super(null);
        this.zza = zzgrVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        this.zza.zzd();
    }
}
