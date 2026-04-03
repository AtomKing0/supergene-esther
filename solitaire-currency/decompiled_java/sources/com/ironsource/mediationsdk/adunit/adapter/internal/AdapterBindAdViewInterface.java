package com.ironsource.mediationsdk.adunit.adapter.internal;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface AdapterBindAdViewInterface {
    void onAdViewBound(@NotNull AdData adData);

    void onAdViewWillBind(@NotNull AdData adData);
}
