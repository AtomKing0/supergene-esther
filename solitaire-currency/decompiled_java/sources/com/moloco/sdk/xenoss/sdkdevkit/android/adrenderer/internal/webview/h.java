package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import com.vungle.ads.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.j;
import p9.q;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final i f21621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final f f21622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final g f21623c;

    public h(@NotNull i localAssetLoader, @NotNull f contentEncoder, @NotNull g cssMarginHandler) {
        t.i(localAssetLoader, "localAssetLoader");
        t.i(contentEncoder, "contentEncoder");
        t.i(cssMarginHandler, "cssMarginHandler");
        this.f21621a = localAssetLoader;
        this.f21622b = contentEncoder;
        this.f21623c = cssMarginHandler;
    }

    @NotNull
    public String a(@NotNull String html) {
        t.i(html, "html");
        String strA = this.f21621a.a(l.AD_MRAID_JS_FILE_NAME);
        return j.f("\n            <script>" + this.f21621a.a("mraid-bridge.js") + "</script>\n            <iframe id=\"adFrame\"\n                style=\"width:100vw; height:100vh; border:none;\"\n                src=\"data:text/html;base64," + this.f21622b.a(q.G(this.f21623c.a(html), "<script src=\"mraid.js\"></script>", "<script>" + strA + "</script>", false, 4, null)) + "\"\n                sandbox=\"allow-scripts allow-same-origin\"\n            >\n            </iframe>\n        ");
    }

    public /* synthetic */ h(i iVar, f fVar, g gVar, int i10, k kVar) {
        this(iVar, fVar, (i10 & 4) != 0 ? new g() : gVar);
    }
}
