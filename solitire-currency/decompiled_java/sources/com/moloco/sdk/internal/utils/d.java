package com.moloco.sdk.internal.utils;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    @NotNull
    public static final String a(@NotNull String substituteCountDownTimeLeftMacro, int i10) {
        t.i(substituteCountDownTimeLeftMacro, "$this$substituteCountDownTimeLeftMacro");
        return q.G(substituteCountDownTimeLeftMacro, "[SECONDS_LEFT]", Long.toString(((long) i10) & 4294967295L, 10), false, 4, null);
    }

    @NotNull
    public static final String b(@NotNull String str, long j10) {
        t.i(str, "<this>");
        return q.G(str, "[HAPPENED_AT_TS]", String.valueOf(j10), false, 4, null);
    }

    @NotNull
    public static final String c(@NotNull String str, @NotNull String errorCode) {
        t.i(str, "<this>");
        t.i(errorCode, "errorCode");
        return q.G(str, "[ERROR_CODE]", errorCode, false, 4, null);
    }

    @NotNull
    public static final String d(@NotNull String str, @NotNull String errorCode, long j10) {
        t.i(str, "<this>");
        t.i(errorCode, "errorCode");
        return b(c(str, errorCode), j10);
    }

    @NotNull
    public static final String e(@NotNull String str, @Nullable String str2) {
        String strG;
        t.i(str, "<this>");
        return (str2 == null || (strG = q.G(str, "[MTID]", str2, false, 4, null)) == null) ? str : strG;
    }
}
