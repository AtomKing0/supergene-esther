package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.util.Base64;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.j;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements f {
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.f
    @NotNull
    public String a(@NotNull String content) {
        t.i(content, "content");
        byte[] bytes = j.f(content).getBytes(p9.d.f32952b);
        t.h(bytes, "this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 1);
        t.h(strEncodeToString, "encodeToString(\n        …se64.NO_PADDING\n        )");
        return strEncodeToString;
    }
}
