package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.games_v2.zzal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@zzal
public final class AuthenticationResult {

    @NonNull
    public static final AuthenticationResult zza = new AuthenticationResult(true);

    @NonNull
    public static final AuthenticationResult zzb = new AuthenticationResult(false);
    private final boolean zzc;

    private AuthenticationResult(boolean z10) {
        this.zzc = z10;
    }

    @zzal
    public boolean isAuthenticated() {
        return this.zzc;
    }
}
