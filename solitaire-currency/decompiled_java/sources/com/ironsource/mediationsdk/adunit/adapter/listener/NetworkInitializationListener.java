package com.ironsource.mediationsdk.adunit.adapter.listener;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface NetworkInitializationListener {
    void onInitFailed(int i10, @Nullable String str);

    void onInitSuccess();
}
