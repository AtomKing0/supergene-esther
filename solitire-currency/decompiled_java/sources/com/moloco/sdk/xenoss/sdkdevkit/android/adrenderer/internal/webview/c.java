package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.content.Context;
import f9.p;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f21619a;

    public c(@NotNull Context context) {
        t.i(context, "context");
        this.f21619a = context;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.i
    @NotNull
    public String a(@NotNull String fileName) throws IOException {
        t.i(fileName, "fileName");
        InputStream inputStreamOpen = this.f21619a.getAssets().open(fileName);
        t.h(inputStreamOpen, "context.assets.open(fileName)");
        Reader inputStreamReader = new InputStreamReader(inputStreamOpen, p9.d.f32952b);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String strE = p.e(bufferedReader);
            f9.c.a(bufferedReader, null);
            return strE;
        } finally {
        }
    }
}
