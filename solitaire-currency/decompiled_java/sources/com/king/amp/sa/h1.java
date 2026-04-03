package com.king.amp.sa;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

/* JADX INFO: compiled from: IWebViewClientEventsListener.java */
/* JADX INFO: loaded from: classes4.dex */
public interface h1 {
    void b(WebResourceRequest webResourceRequest, WebResourceError webResourceError);

    boolean e(RenderProcessGoneDetail renderProcessGoneDetail);

    WebResourceResponse g(Uri uri);

    void h(int i10, String str, String str2);

    void i(SslErrorHandler sslErrorHandler, SslError sslError);

    void j(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

    boolean k(Uri uri);

    void l(String str, Bitmap bitmap);

    void n(String str);
}
