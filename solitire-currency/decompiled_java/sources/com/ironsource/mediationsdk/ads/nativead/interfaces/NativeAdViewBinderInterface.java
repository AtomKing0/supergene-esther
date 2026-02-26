package com.ironsource.mediationsdk.ads.nativead.interfaces;

import android.view.View;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayMediaView;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface NativeAdViewBinderInterface {
    void setAdvertiserView(@Nullable View view);

    void setBodyView(@Nullable View view);

    void setCallToActionView(@Nullable View view);

    void setIconView(@Nullable View view);

    void setMediaView(@Nullable LevelPlayMediaView levelPlayMediaView);

    void setTitleView(@Nullable View view);
}
