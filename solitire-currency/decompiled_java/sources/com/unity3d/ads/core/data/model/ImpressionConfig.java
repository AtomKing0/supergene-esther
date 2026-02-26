package com.unity3d.ads.core.data.model;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ImpressionConfig {

    @NotNull
    private final String data;

    private /* synthetic */ ImpressionConfig(String str) {
        this.data = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImpressionConfig m3988boximpl(String str) {
        return new ImpressionConfig(str);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m3989constructorimpl(@NotNull String data) {
        t.i(data, "data");
        return data;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3990equalsimpl(String str, Object obj) {
        return (obj instanceof ImpressionConfig) && t.d(str, ((ImpressionConfig) obj).m3994unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3991equalsimpl0(String str, String str2) {
        return t.d(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3992hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3993toStringimpl(String str) {
        return "ImpressionConfig(data=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m3990equalsimpl(this.data, obj);
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    public int hashCode() {
        return m3992hashCodeimpl(this.data);
    }

    public String toString() {
        return m3993toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m3994unboximpl() {
        return this.data;
    }
}
