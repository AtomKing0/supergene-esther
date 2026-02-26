package com.unity3d.ironsourceads.banner;

import android.content.Context;
import android.widget.FrameLayout;
import com.ironsource.i6;
import com.ironsource.j6;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class BannerAdView extends FrameLayout implements j6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i6 f23852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private BannerAdViewListener f23853b;

    private BannerAdView(Context context) {
        super(context);
    }

    @NotNull
    public final BannerAdInfo getAdInfo() {
        i6 i6Var = this.f23852a;
        if (i6Var == null) {
            t.A("bannerAdViewInternal");
            i6Var = null;
        }
        return i6Var.c();
    }

    @Nullable
    public final BannerAdViewListener getListener() {
        return this.f23853b;
    }

    @Override // com.ironsource.j6
    public void onBannerAdClicked() {
        BannerAdViewListener bannerAdViewListener = this.f23853b;
        if (bannerAdViewListener != null) {
            bannerAdViewListener.onBannerAdClicked(this);
        }
    }

    @Override // com.ironsource.j6
    public void onBannerAdShown() {
        BannerAdViewListener bannerAdViewListener = this.f23853b;
        if (bannerAdViewListener != null) {
            bannerAdViewListener.onBannerAdShown(this);
        }
    }

    public final void setListener(@Nullable BannerAdViewListener bannerAdViewListener) {
        this.f23853b = bannerAdViewListener;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BannerAdView(@NotNull i6 bannerAdViewInternal) {
        t.i(bannerAdViewInternal, "bannerAdViewInternal");
        Context context = bannerAdViewInternal.d().getContext();
        t.h(context, "bannerAdViewInternal.container.context");
        this(context);
        this.f23852a = bannerAdViewInternal;
        bannerAdViewInternal.a(new WeakReference<>(this));
        bannerAdViewInternal.b(new WeakReference<>(this));
    }
}
