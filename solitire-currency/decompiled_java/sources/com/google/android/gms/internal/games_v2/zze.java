package com.google.android.gms.internal.games_v2;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.Games;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zze extends GoogleApi {
    public zze(Context context, @Nullable com.google.android.gms.games.zzn zznVar) {
        super(context, (Api<com.google.android.gms.games.zzn>) Games.zze, zznVar, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    protected final ClientSettings.Builder createClientSettingsBuilder() {
        ClientSettings.Builder builderCreateClientSettingsBuilder = super.createClientSettingsBuilder();
        if (getApiOptions() != null) {
            String str = ((com.google.android.gms.games.zzn) getApiOptions()).zzl;
        }
        return builderCreateClientSettingsBuilder;
    }
}
