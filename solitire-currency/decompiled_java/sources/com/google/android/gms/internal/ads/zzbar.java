package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbar {

    @Nullable
    private zzbag zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    zzbar(Context context) {
        this.zzc = context;
    }

    static /* bridge */ /* synthetic */ void zze(zzbar zzbarVar) {
        synchronized (zzbarVar.zzd) {
            zzbag zzbagVar = zzbarVar.zza;
            if (zzbagVar == null) {
                return;
            }
            zzbagVar.disconnect();
            zzbarVar.zza = null;
            Binder.flushPendingCommands();
        }
    }

    final Future zzc(zzbah zzbahVar) {
        zzbal zzbalVar = new zzbal(this);
        zzbap zzbapVar = new zzbap(this, zzbahVar, zzbalVar);
        zzbaq zzbaqVar = new zzbaq(this, zzbalVar);
        synchronized (this.zzd) {
            zzbag zzbagVar = new zzbag(this.zzc, com.google.android.gms.ads.internal.zzu.zzt().zzb(), zzbapVar, zzbaqVar);
            this.zza = zzbagVar;
            zzbagVar.checkAvailabilityAndConnect();
        }
        return zzbalVar;
    }
}
