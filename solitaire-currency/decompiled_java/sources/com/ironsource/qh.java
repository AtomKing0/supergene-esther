package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface qh {
    void onAdInstanceDidBecomeVisible();

    void onAdInstanceDidClick();

    void onAdInstanceDidDismiss();

    void onAdInstanceDidFailedToShow(@NotNull IronSourceError ironSourceError);

    void onAdInstanceDidReward(@Nullable String str, int i10);

    void onAdInstanceDidShow();
}
