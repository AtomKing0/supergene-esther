package com.google.ads.mediation.vungle;

import android.content.Context;
import com.vungle.ads.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleSdkWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void a(@NotNull Context context, @NotNull String str, @NotNull l0 l0Var);

    @Nullable
    String b(@NotNull Context context);

    @NotNull
    String getSdkVersion();

    boolean isInitialized();
}
