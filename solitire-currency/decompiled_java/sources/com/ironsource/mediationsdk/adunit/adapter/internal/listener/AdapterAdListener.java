package com.ironsource.mediationsdk.adunit.adapter.internal.listener;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface AdapterAdListener {
    void onAdClicked();

    void onAdLoadFailed(@NotNull AdapterErrorType adapterErrorType, int i10, String str);

    void onAdLoadSuccess();

    void onAdOpened();
}
