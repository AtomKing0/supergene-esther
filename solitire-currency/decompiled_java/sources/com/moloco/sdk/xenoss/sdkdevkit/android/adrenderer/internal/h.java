package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class h {
    public static final long a() {
        return System.currentTimeMillis();
    }

    @NotNull
    public static final SimpleDateFormat b(@NotNull String pattern) {
        kotlin.jvm.internal.t.i(pattern, "pattern");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ROOT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }
}
