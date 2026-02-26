package com.ironsource.mediationsdk.demandOnly;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.l5;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: loaded from: classes4.dex */
public class ISDemandOnlyBannerLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f13363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ISBannerSize f13364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Activity f13366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l5 f13368f;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f13369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout.LayoutParams f13370b;

        a(View view, FrameLayout.LayoutParams layoutParams) {
            this.f13369a = view;
            this.f13370b = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISDemandOnlyBannerLayout.this.removeAllViews();
            ViewParent parent = this.f13369a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f13369a);
            }
            ISDemandOnlyBannerLayout.this.f13363a = this.f13369a;
            ISDemandOnlyBannerLayout.this.addView(this.f13369a, 0, this.f13370b);
        }
    }

    public ISDemandOnlyBannerLayout(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.f13367e = false;
        this.f13366d = activity;
        this.f13364b = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
        this.f13368f = new l5();
    }

    public Activity getActivity() {
        return this.f13366d;
    }

    public ISDemandOnlyBannerListener getBannerDemandOnlyListener() {
        return this.f13368f.a();
    }

    public View getBannerView() {
        return this.f13363a;
    }

    public l5 getListener() {
        return this.f13368f;
    }

    public String getPlacementName() {
        return this.f13365c;
    }

    public ISBannerSize getSize() {
        return this.f13364b;
    }

    public boolean isDestroyed() {
        return this.f13367e;
    }

    public void removeBannerListener() {
        IronLog.API.info();
        this.f13368f.b((Object) null);
    }

    public void setBannerDemandOnlyListener(ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
        IronLog.API.info();
        this.f13368f.b(iSDemandOnlyBannerListener);
    }

    public void setPlacementName(String str) {
        this.f13365c = str;
    }

    private ISDemandOnlyBannerLayout(Context context) {
        super(context);
        this.f13367e = false;
    }

    protected void a() {
        this.f13367e = true;
        this.f13366d = null;
        this.f13364b = null;
        this.f13365c = null;
        this.f13363a = null;
        removeBannerListener();
    }

    void a(View view, FrameLayout.LayoutParams layoutParams) {
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(view, layoutParams));
    }
}
