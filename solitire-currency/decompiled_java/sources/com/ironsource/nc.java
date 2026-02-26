package com.ironsource;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface nc {
    void a(@Nullable String str);

    void onAdInstanceDidBecomeVisible();

    void onAdInstanceDidClick();

    void onAdInstanceDidDismiss();

    void onAdInstanceDidReward(@Nullable String str, int i10);

    void onAdInstanceDidShow();
}
