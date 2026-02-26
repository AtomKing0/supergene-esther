package com.ironsource;

import android.app.Activity;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface ci {
    @NotNull
    f1 a();

    void a(@NotNull Activity activity, @Nullable String str);

    void loadAd();

    void onAdInfoChanged(@NotNull LevelPlayAdInfo levelPlayAdInfo);
}
