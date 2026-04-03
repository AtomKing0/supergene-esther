package com.moloco.sdk.publisher;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.j;
import s9.m0;
import s9.o0;
import s9.y;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public abstract class Banner extends FrameLayout implements AdLoad, Destroyable {
    public static final int $stable = 8;

    @NotNull
    private final y<Boolean> _isViewShown;

    @Nullable
    private BannerAdShowListener adShowListener;

    @NotNull
    private final m0<Boolean> isViewShown;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Banner(@NotNull Context context) {
        super(context);
        t.i(context, "context");
        setTag("MolocoBannerView");
        y<Boolean> yVarA = o0.a(Boolean.FALSE);
        this._isViewShown = yVarA;
        this.isViewShown = j.c(yVarA);
    }

    @Nullable
    public BannerAdShowListener getAdShowListener() {
        return this.adShowListener;
    }

    @NotNull
    public m0<Boolean> isViewShown() {
        return this.isViewShown;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int i10) {
        t.i(changedView, "changedView");
        this._isViewShown.setValue(Boolean.valueOf(changedView.isShown()));
    }

    public void setAdShowListener(@Nullable BannerAdShowListener bannerAdShowListener) {
        this.adShowListener = bannerAdShowListener;
    }
}
