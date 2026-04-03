package com.ironsource.mediationsdk.ads.nativead.internal;

import android.view.View;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayMediaView;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class NativeAdViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private View f13296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private View f13297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private View f13298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private View f13299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private LevelPlayMediaView f13300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private View f13301f;

    @Nullable
    public final View getAdvertiserView() {
        return this.f13297b;
    }

    @Nullable
    public final View getBodyView() {
        return this.f13299d;
    }

    @Nullable
    public final View getCallToActionView() {
        return this.f13301f;
    }

    @Nullable
    public final View getIconView() {
        return this.f13298c;
    }

    @Nullable
    public final LevelPlayMediaView getMediaView() {
        return this.f13300e;
    }

    @Nullable
    public final View getTitleView() {
        return this.f13296a;
    }

    public final void setAdvertiserView(@Nullable View view) {
        this.f13297b = view;
    }

    public final void setBodyView(@Nullable View view) {
        this.f13299d = view;
    }

    public final void setCallToActionView(@Nullable View view) {
        this.f13301f = view;
    }

    public final void setIconView(@Nullable View view) {
        this.f13298c = view;
    }

    public final void setMediaView(@Nullable LevelPlayMediaView levelPlayMediaView) {
        this.f13300e = levelPlayMediaView;
    }

    public final void setTitleView(@Nullable View view) {
        this.f13296a = view;
    }
}
