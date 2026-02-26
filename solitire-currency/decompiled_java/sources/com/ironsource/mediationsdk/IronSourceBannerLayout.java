package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.m5;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;

/* JADX INFO: loaded from: classes4.dex */
public class IronSourceBannerLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f13251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ISBannerSize f13252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Activity f13254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f13257g;

    public interface a {
        void onWindowFocusChanged(boolean z10);
    }

    public IronSourceBannerLayout(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.f13255e = false;
        this.f13256f = false;
        this.f13254d = activity;
        this.f13252b = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
    }

    protected void a() {
        this.f13255e = true;
        this.f13254d = null;
        this.f13252b = null;
        this.f13253c = null;
        this.f13251a = null;
        this.f13257g = null;
        removeBannerListener();
    }

    protected IronSourceBannerLayout b() {
        IronSourceBannerLayout ironSourceBannerLayout = new IronSourceBannerLayout(this.f13254d, this.f13252b);
        ironSourceBannerLayout.setPlacementName(this.f13253c);
        return ironSourceBannerLayout;
    }

    public Activity getActivity() {
        return this.f13254d;
    }

    public LevelPlayBannerListener getLevelPlayBannerListener() {
        return m5.a().b();
    }

    public String getPlacementName() {
        return this.f13253c;
    }

    public ISBannerSize getSize() {
        return this.f13252b;
    }

    public a getWindowFocusChangedListener() {
        return this.f13257g;
    }

    public boolean isDestroyed() {
        return this.f13255e;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        a aVar = this.f13257g;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z10);
        }
    }

    public void removeBannerListener() {
        IronLog.API.info();
        m5.a().a((LevelPlayBannerListener) null);
    }

    public void setBannerSize(ISBannerSize iSBannerSize) {
        this.f13252b = iSBannerSize;
    }

    @Deprecated
    public void setLevelPlayBannerListener(LevelPlayBannerListener levelPlayBannerListener) {
        IronLog.API.info();
        m5.a().a(levelPlayBannerListener);
    }

    public void setPlacementName(String str) {
        this.f13253c = str;
    }

    public void setWindowFocusChangedListener(a aVar) {
        this.f13257g = aVar;
    }

    public IronSourceBannerLayout(Context context) {
        super(context);
        this.f13255e = false;
        this.f13256f = false;
    }
}
