package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbfy {
    private final zzbfx zza;

    @VisibleForTesting
    public zzbfy(zzbfx zzbfxVar) {
        Context context;
        this.zza = zzbfxVar;
        try {
            context = (Context) ObjectWrapper.unwrap(zzbfxVar.zzh());
        } catch (RemoteException | NullPointerException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
            context = null;
        }
        if (context != null) {
            try {
                this.zza.zzs(ObjectWrapper.wrap(new MediaView(context)));
            } catch (RemoteException e11) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e11);
            }
        }
    }

    public final zzbfx zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
            return null;
        }
    }
}
