package com.unity3d.ads.core.data.model;

import java.util.Locale;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OperationType.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum OperationType {
    UNKNOWN,
    INITIALIZATION,
    LOAD,
    LOAD_HEADER_BIDDING,
    SHOW,
    REFRESH,
    PRIVACY_UPDATE,
    INITIALIZATION_COMPLETED,
    TRANSACTION_EVENT,
    UNIVERSAL_EVENT;

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        String string = super.toString();
        Locale locale = Locale.getDefault();
        t.h(locale, "getDefault()");
        String lowerCase = string.toLowerCase(locale);
        t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
}
