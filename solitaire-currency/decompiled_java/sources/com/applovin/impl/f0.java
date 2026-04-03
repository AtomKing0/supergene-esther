package com.applovin.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.applovin.impl.adview.AppLovinWebViewBase;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f0 extends AppLovinWebViewBase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f5163b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f5164a;

    public f0(Context context) {
        super(context);
        this.f5164a = new AtomicReference();
        if (f5163b == null) {
            try {
                WebView.class.getDeclaredMethod("onTouchEvent", MotionEvent.class);
                f5163b = Boolean.TRUE;
            } catch (NoSuchMethodException unused) {
                com.applovin.impl.sdk.n.h("AppLovinSdk", "WebView.onTouchEvent() not implemented");
                f5163b = Boolean.FALSE;
            }
        }
    }

    public boolean a() {
        return this.f5164a.get() != null;
    }

    @Nullable
    public MotionEvent getAndClearLastClickEvent() {
        return (MotionEvent) this.f5164a.getAndSet(null);
    }

    @Nullable
    public MotionEvent getLastClickEvent() {
        return (MotionEvent) this.f5164a.get();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f5164a.set(MotionEvent.obtain(motionEvent));
        if (f5163b.booleanValue()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
