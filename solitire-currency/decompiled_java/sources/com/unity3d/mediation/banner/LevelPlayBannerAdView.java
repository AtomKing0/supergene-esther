package com.unity3d.mediation.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ironsource.p6;
import com.ironsource.zj;
import com.unity3d.mediation.LevelPlayAdSize;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LevelPlayBannerAdView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final zj f23910a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayBannerAdView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        t.i(context, "context");
    }

    private final p6 a(Context context) {
        p6 p6Var = new p6(context);
        p6Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return p6Var;
    }

    public final void destroy() {
        this.f23910a.f();
    }

    @NotNull
    public final LevelPlayAdSize getAdSize() {
        return this.f23910a.g();
    }

    @NotNull
    public final String getAdUnitId() {
        return this.f23910a.b();
    }

    @Nullable
    public final LevelPlayBannerAdViewListener getBannerListener() {
        return this.f23910a.h();
    }

    @NotNull
    public final String getPlacementName() {
        return this.f23910a.i();
    }

    public final void loadAd() {
        this.f23910a.k();
    }

    public final void pauseAutoRefresh() {
        this.f23910a.l();
    }

    public final void resumeAutoRefresh() {
        this.f23910a.m();
    }

    public final void setAdSize(@NotNull LevelPlayAdSize adSize) {
        t.i(adSize, "adSize");
        this.f23910a.a(adSize);
    }

    public final void setBannerListener(@Nullable LevelPlayBannerAdViewListener levelPlayBannerAdViewListener) {
        this.f23910a.a(levelPlayBannerAdViewListener);
    }

    public final void setPlacementName(@Nullable String str) {
        zj zjVar = this.f23910a;
        if (str == null) {
            str = "";
        }
        zjVar.b(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayBannerAdView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelPlayBannerAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t.i(context, "context");
        p6 p6VarA = a(context);
        addView(p6VarA);
        this.f23910a = new zj(p6VarA, attributeSet);
    }

    public /* synthetic */ LevelPlayBannerAdView(Context context, AttributeSet attributeSet, int i10, int i11, k kVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayBannerAdView(@NotNull Context context, @NotNull String adUnitId) {
        this(context, null, 0, 6, null);
        t.i(context, "context");
        t.i(adUnitId, "adUnitId");
        this.f23910a.a(adUnitId);
    }
}
