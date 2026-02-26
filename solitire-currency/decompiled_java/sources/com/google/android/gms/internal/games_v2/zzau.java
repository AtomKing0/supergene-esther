package com.google.android.gms.internal.games_v2;

import android.app.Application;
import androidx.compose.animation.core.d;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzau {
    private static final AtomicReference zza = new AtomicReference();
    private final zzat zzb;
    private final zzav zzc;

    zzau(Application application, zzav zzavVar) {
        this.zzb = new zzat(this, application, null);
        this.zzc = zzavVar;
    }

    static zzau zza(Application application) {
        AtomicReference atomicReference = zza;
        zzau zzauVar = (zzau) atomicReference.get();
        if (zzauVar != null) {
            return zzauVar;
        }
        zzau zzauVar2 = new zzau(application, zzax.zza(application));
        while (!d.a(atomicReference, null, zzauVar2) && atomicReference.get() == null) {
        }
        return (zzau) Preconditions.checkNotNull((zzau) zza.get());
    }

    public final void zzc() {
        zzez.zza("AutomaticGamesAuthenticator", "startWatching()");
        zzat.zza(this.zzb);
    }
}
