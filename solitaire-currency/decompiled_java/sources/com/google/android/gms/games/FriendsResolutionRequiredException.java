package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class FriendsResolutionRequiredException extends ResolvableApiException {
    private FriendsResolutionRequiredException(Status status) {
        super(status);
    }

    @NonNull
    public static FriendsResolutionRequiredException zza(@NonNull Status status) {
        return new FriendsResolutionRequiredException(status);
    }
}
