package com.ironsource.mediationsdk.adunit.adapter.internal.listener;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface AdapterAdInteractionListener extends AdapterAdListener {
    void onAdClosed();

    void onAdEnded();

    void onAdShowFailed(int i10, @Nullable String str);

    void onAdShowSuccess();

    void onAdStarted();

    void onAdVisible();
}
