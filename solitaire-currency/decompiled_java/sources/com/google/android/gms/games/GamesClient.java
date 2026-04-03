package com.google.android.gms.games;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface GamesClient {
    @NonNull
    Task<Bundle> getActivationHint();

    @NonNull
    Task<String> getAppId();

    @NonNull
    @RequiresPermission("android.permission.GET_ACCOUNTS")
    Task<String> getCurrentAccountName();

    @NonNull
    Task<Intent> getSettingsIntent();

    @NonNull
    Task<Void> setGravityForPopups(int i10);

    @NonNull
    Task<Void> setViewForPopups(@NonNull View view);
}
