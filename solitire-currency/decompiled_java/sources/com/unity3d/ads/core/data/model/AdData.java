package com.unity3d.ads.core.data.model;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdData {

    @NotNull
    private final String data;

    private /* synthetic */ AdData(String str) {
        this.data = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AdData m3974boximpl(String str) {
        return new AdData(str);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m3975constructorimpl(@NotNull String data) {
        t.i(data, "data");
        return data;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3976equalsimpl(String str, Object obj) {
        return (obj instanceof AdData) && t.d(str, ((AdData) obj).m3980unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3977equalsimpl0(String str, String str2) {
        return t.d(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3978hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3979toStringimpl(String str) {
        return "AdData(data=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m3976equalsimpl(this.data, obj);
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    public int hashCode() {
        return m3978hashCodeimpl(this.data);
    }

    public String toString() {
        return m3979toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m3980unboximpl() {
        return this.data;
    }
}
