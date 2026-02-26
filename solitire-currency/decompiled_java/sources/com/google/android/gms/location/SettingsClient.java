package com.google.android.gms.location;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface SettingsClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    @NonNull
    Task<LocationSettingsResponse> checkLocationSettings(@NonNull LocationSettingsRequest locationSettingsRequest);

    @NonNull
    Task<Boolean> isGoogleLocationAccuracyEnabled();
}
