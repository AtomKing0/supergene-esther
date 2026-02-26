package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.games_v2.zzal;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@zzal
public interface GamesSignInClient {
    @NonNull
    @zzal
    Task<AuthenticationResult> isAuthenticated();

    @NonNull
    @zzal
    Task<String> requestServerSideAccess(@NonNull String str, boolean z10);

    @NonNull
    @zzal
    Task<AuthenticationResult> signIn();
}
