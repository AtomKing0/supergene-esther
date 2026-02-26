package com.king.amp.sa;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes4.dex */
public class AbmWebView extends WebView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f16651b = "AbmWebView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f16652a;

    public interface a {
        void a(boolean z10);
    }

    public AbmWebView(Context context) {
        super(context.getApplicationContext());
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        Log.d(f16651b, "onVisibilityChanged to " + i10);
        super.onVisibilityChanged(view, i10);
        a aVar = this.f16652a;
        if (aVar != null) {
            aVar.a(i10 == 0);
        }
    }

    public void setVisibilityListener(a aVar) {
        this.f16652a = aVar;
    }

    public AbmWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
