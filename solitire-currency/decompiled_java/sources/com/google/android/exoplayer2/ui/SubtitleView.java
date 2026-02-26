package com.google.android.exoplayer2.ui;

import a4.o0;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n3.b;

/* JADX INFO: loaded from: classes2.dex */
public final class SubtitleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<n3.b> f8444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y3.b f8445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f8447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f8448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f8452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f8453j;

    interface a {
        void a(List<n3.b> list, y3.b bVar, float f10, int i10, float f11);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8444a = Collections.emptyList();
        this.f8445b = y3.b.f36504g;
        this.f8446c = 0;
        this.f8447d = 0.0533f;
        this.f8448e = 0.08f;
        this.f8449f = true;
        this.f8450g = true;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context);
        this.f8452i = aVar;
        this.f8453j = aVar;
        addView(aVar);
        this.f8451h = 1;
    }

    private n3.b a(n3.b bVar) {
        b.C0631b c0631bB = bVar.b();
        if (!this.f8449f) {
            e0.e(c0631bB);
        } else if (!this.f8450g) {
            e0.f(c0631bB);
        }
        return c0631bB.a();
    }

    private void c(int i10, float f10) {
        this.f8446c = i10;
        this.f8447d = f10;
        f();
    }

    private void f() {
        this.f8452i.a(getCuesWithStylingPreferencesApplied(), this.f8445b, this.f8447d, this.f8446c, this.f8448e);
    }

    private List<n3.b> getCuesWithStylingPreferencesApplied() {
        if (this.f8449f && this.f8450g) {
            return this.f8444a;
        }
        ArrayList arrayList = new ArrayList(this.f8444a.size());
        for (int i10 = 0; i10 < this.f8444a.size(); i10++) {
            arrayList.add(a(this.f8444a.get(i10)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (o0.f214a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private y3.b getUserCaptionStyle() {
        if (o0.f214a < 19 || isInEditMode()) {
            return y3.b.f36504g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? y3.b.f36504g : y3.b.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t10) {
        removeView(this.f8453j);
        View view = this.f8453j;
        if (view instanceof g0) {
            ((g0) view).g();
        }
        this.f8453j = t10;
        this.f8452i = t10;
        addView(t10);
    }

    public void b(float f10, boolean z10) {
        c(z10 ? 1 : 0, f10);
    }

    public void d() {
        setStyle(getUserCaptionStyle());
    }

    public void e() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setApplyEmbeddedFontSizes(boolean z10) {
        this.f8450g = z10;
        f();
    }

    public void setApplyEmbeddedStyles(boolean z10) {
        this.f8449f = z10;
        f();
    }

    public void setBottomPaddingFraction(float f10) {
        this.f8448e = f10;
        f();
    }

    public void setCues(@Nullable List<n3.b> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f8444a = list;
        f();
    }

    public void setFractionalTextSize(float f10) {
        b(f10, false);
    }

    public void setStyle(y3.b bVar) {
        this.f8445b = bVar;
        f();
    }

    public void setViewType(int i10) {
        if (this.f8451h == i10) {
            return;
        }
        if (i10 == 1) {
            setView(new com.google.android.exoplayer2.ui.a(getContext()));
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new g0(getContext()));
        }
        this.f8451h = i10;
    }
}
