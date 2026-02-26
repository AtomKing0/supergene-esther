package com.ironsource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class v9 implements o8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v9 f15876a = new v9();

    private v9() {
    }

    @Override // com.ironsource.o8
    @NotNull
    public InputStream a(@NotNull String url) throws IOException {
        kotlin.jvm.internal.t.i(url, "url");
        InputStream inputStreamOpenStream = new URL(url).openStream();
        kotlin.jvm.internal.t.h(inputStreamOpenStream, "URL(url).openStream()");
        return inputStreamOpenStream;
    }
}
