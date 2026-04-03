package com.ironsource.mediationsdk.adunit.adapter.listener;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface BannerAdListener extends AdapterAdViewListener {
    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    void onAdLoadSuccess(@NotNull View view, @NotNull FrameLayout.LayoutParams layoutParams);
}
