package com.vungle.ads.internal.platform;

import android.content.Context;
import android.util.AndroidRuntimeException;
import android.webkit.WebSettings;
import androidx.core.util.Consumer;
import com.vungle.ads.internal.util.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WebViewUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    @NotNull
    public static final a Companion = new a(null);
    private static final String TAG = e.class.getSimpleName();

    @NotNull
    private final Context context;

    /* JADX INFO: compiled from: WebViewUtil.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public e(@NotNull Context context) {
        t.i(context, "context");
        this.context = context;
    }

    public final void getUserAgent(@NotNull Consumer<String> consumer) {
        t.i(consumer, "consumer");
        try {
            consumer.accept(WebSettings.getDefaultUserAgent(this.context));
        } catch (Exception e10) {
            if (e10 instanceof AndroidRuntimeException) {
                p.a aVar = p.Companion;
                String TAG2 = TAG;
                t.h(TAG2, "TAG");
                aVar.e(TAG2, "WebView could be missing here");
            }
            consumer.accept(null);
        }
    }
}
