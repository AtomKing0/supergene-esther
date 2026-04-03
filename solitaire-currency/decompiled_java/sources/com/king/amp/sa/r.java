package com.king.amp.sa;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import com.king.amp.sa.AbmWebView;
import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbmHtmlBridge.java */
/* JADX INFO: loaded from: classes4.dex */
public class r implements AbmWebView.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f16867d = "AbmHtmlBridge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f16868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbmWebView f16869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f16870c;

    /* JADX INFO: compiled from: AbmHtmlBridge.java */
    public interface a {
        void a(String str);

        void c(String str);

        void d(String str);

        void f(String str);

        void m();

        void onClose();
    }

    /* JADX INFO: compiled from: AbmHtmlBridge.java */
    public enum b {
        LOADING,
        DEFAULT,
        RESIZED,
        EXPANDED,
        HIDDEN;

        public String c() {
            return toString().toLowerCase(Locale.US);
        }
    }

    r(@NonNull Context context, @NonNull AbmWebView abmWebView, @NonNull a aVar) {
        this.f16868a = context;
        this.f16869b = abmWebView;
        this.f16870c = aVar;
        abmWebView.setVisibilityListener(this);
    }

    private void b(@NonNull String str, @NonNull String str2) {
        i("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(str) + ", " + JSONObject.quote(str2) + ")");
    }

    private void c(@NonNull String str) {
        i("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(str) + ")");
    }

    private Map<String, String> e(@NonNull Uri uri) {
        HashMap map = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            map.put(str, TextUtils.join(",", uri.getQueryParameters(str)));
        }
        return map;
    }

    private void i(@NonNull String str) {
        Log.d(f16867d, "Injecting Javascript into WebView:\n\t" + str);
        AbmWebView abmWebView = this.f16869b;
        if (abmWebView == null) {
            return;
        }
        abmWebView.evaluateJavascript("javascript:" + str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void s(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.amp.sa.r.s(java.lang.String, java.util.Map):void");
    }

    @NonNull
    private String t(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    @Override // com.king.amp.sa.AbmWebView.a
    public void a(boolean z10) {
        r(z10);
    }

    void d() {
        i("window.mraidbridge.fireReadyEvent()");
    }

    public void f(String str) {
        Log.i(f16867d, "onPageFinished with progress: " + this.f16869b.getProgress());
    }

    public WebResourceResponse g(Uri uri) {
        if (!com.vungle.ads.internal.l.AD_MRAID_JS_FILE_NAME.equals(uri.getLastPathSegment())) {
            return null;
        }
        try {
            return new WebResourceResponse("text/javascript", "UTF-8", new SequenceInputStream(Collections.enumeration(Arrays.asList(new ByteArrayInputStream("javascript:".getBytes()), this.f16868a.getResources().openRawResource(j6.h.f28752a)))));
        } catch (Exception e10) {
            Log.e(f16867d, "Unable to read resource", e10);
            return null;
        }
    }

    public boolean h(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if (!"mraid".equals(scheme) || host == null || host.isEmpty()) {
            return false;
        }
        try {
            s(host, e(uri));
            return true;
        } catch (IllegalArgumentException e10) {
            String message = e10.getMessage();
            Objects.requireNonNull(message);
            b(host, message);
            return true;
        }
    }

    public void j(Rect rect) {
        i("window.mraidbridge.setCurrentPosition(" + t(rect) + ")");
    }

    public void k(Rect rect) {
        i("window.mraidbridge.setDefaultPosition(" + t(rect) + ")");
    }

    public void l(int i10, int i11) {
        i("window.mraidbridge.setMaxSize(" + i10 + ", " + i11 + ")");
    }

    void m() {
        i("window.mraidbridge.setPlacementType(" + JSONObject.quote("Interstitial") + ")");
    }

    public void n(int i10, int i11) {
        i("window.mraidbridge.setScreenSize(" + i10 + ", " + i11 + ")");
    }

    public void o(Rect rect) {
        i("window.mraidbridge.notifySizeChangeEvent(" + t(rect) + ")");
    }

    void p() {
        i("window.mraidbridge.setSupports(false,false,false,false,true)");
    }

    void q(b bVar) {
        i("window.mraidbridge.setState(" + JSONObject.quote(bVar.c()) + ")");
    }

    void r(boolean z10) {
        i("window.mraidbridge.fireChangeEvent(" + (z10 ? "{'viewable':'true'}" : "{'viewable':'false'}") + ")");
    }
}
