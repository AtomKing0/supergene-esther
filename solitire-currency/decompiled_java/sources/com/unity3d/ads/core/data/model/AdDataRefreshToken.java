package com.unity3d.ads.core.data.model;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdDataRefreshToken {

    @NotNull
    private final String data;

    private /* synthetic */ AdDataRefreshToken(String str) {
        this.data = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AdDataRefreshToken m3981boximpl(String str) {
        return new AdDataRefreshToken(str);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m3982constructorimpl(@NotNull String data) {
        t.i(data, "data");
        return data;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3983equalsimpl(String str, Object obj) {
        return (obj instanceof AdDataRefreshToken) && t.d(str, ((AdDataRefreshToken) obj).m3987unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3984equalsimpl0(String str, String str2) {
        return t.d(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3985hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3986toStringimpl(String str) {
        return "AdDataRefreshToken(data=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m3983equalsimpl(this.data, obj);
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    public int hashCode() {
        return m3985hashCodeimpl(this.data);
    }

    public String toString() {
        return m3986toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m3987unboximpl() {
        return this.data;
    }
}
