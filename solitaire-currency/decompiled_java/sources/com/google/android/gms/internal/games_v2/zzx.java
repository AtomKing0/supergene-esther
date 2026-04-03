package com.google.android.gms.internal.games_v2;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzx extends GmsClient {
    private final zzq zze;

    public zzx(Context context, Looper looper, ClientSettings clientSettings, zzq zzqVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zze = zzqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @Nullable
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.connect.IGamesConnectService");
        return iInterfaceQueryLocalInterface instanceof zzae ? (zzae) iInterfaceQueryLocalInterface : new zzae(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        zzq zzqVar = this.zze;
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.games.key.API_VERSION", zzqVar.zza);
        bundle.putString(ServiceSpecificExtraArgs.GamesExtraArgs.GAME_PACKAGE_NAME, zzqVar.zzb);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 213000000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.connect.IGamesConnectService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.games.internal.connect.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }
}
