package com.ironsource;

import android.annotation.SuppressLint;
import android.os.Build;
import android.webkit.WebView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface qj {

    public static final class a implements qj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private WebView f14529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14530b;

        public a() {
            this(0, 1, null);
        }

        @SuppressLint({"NewApi"})
        private final void b(String str) {
            WebView webView = this.f14529a;
            if (webView != null) {
                webView.evaluateJavascript(str, null);
            }
        }

        private final void c(String str) {
            WebView webView = this.f14529a;
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }

        @Override // com.ironsource.qj
        public void a(@NotNull WebView webView) {
            kotlin.jvm.internal.t.i(webView, "webView");
            this.f14529a = webView;
        }

        public a(int i10) {
            this.f14530b = i10 >= 19;
        }

        @Override // com.ironsource.qj
        public void a(@NotNull String script) {
            kotlin.jvm.internal.t.i(script, "script");
            try {
                if (this.f14530b) {
                    b(script);
                } else {
                    c(script);
                }
            } catch (Throwable th) {
                i9.d().a(th);
                this.f14530b = false;
                c(script);
            }
        }

        public /* synthetic */ a(int i10, int i11, kotlin.jvm.internal.k kVar) {
            this((i11 & 1) != 0 ? Build.VERSION.SDK_INT : i10);
        }

        @Override // com.ironsource.qj
        public boolean a() {
            return this.f14529a != null;
        }
    }

    void a(@NotNull WebView webView);

    void a(@NotNull String str);

    boolean a();
}
