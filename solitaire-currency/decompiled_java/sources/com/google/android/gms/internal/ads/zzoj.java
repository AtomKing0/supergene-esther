package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzoj extends ContentObserver {
    final /* synthetic */ zzom zza;
    private final ContentResolver zzb;
    private final Uri zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzoj(zzom zzomVar, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        this.zza = zzomVar;
        this.zzb = contentResolver;
        this.zzc = uri;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        zzom zzomVar = this.zza;
        this.zza.zzj(zzof.zzc(zzomVar.zza, zzomVar.zzh, zzomVar.zzg));
    }

    public final void zza() {
        this.zzb.registerContentObserver(this.zzc, false, this);
    }

    public final void zzb() {
        this.zzb.unregisterContentObserver(this);
    }
}
