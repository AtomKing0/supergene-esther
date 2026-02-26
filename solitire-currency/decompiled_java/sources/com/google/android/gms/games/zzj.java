package com.google.android.gms.games;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.internal.zzak;
import com.google.android.gms.games.internal.zzar;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzj extends Api.AbstractClientBuilder {
    /* synthetic */ zzj(zzi zziVar) {
    }

    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzn zznVarZze = (zzn) obj;
        if (zznVarZze == null) {
            zznVarZze = new zzl(null).zze();
        }
        zzak zzakVar = new zzak(context, looper, clientSettings, zznVarZze, connectionCallbacks, onConnectionFailedListener, zzar.zza());
        if (zznVarZze.zzo.zzc()) {
            zzakVar.zzS(com.google.android.gms.games.internal.zzg.zzc(context));
        }
        return zzakVar;
    }

    @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
    public final int getPriority() {
        return 1;
    }
}
