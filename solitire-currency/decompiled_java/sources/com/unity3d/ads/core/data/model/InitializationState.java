package com.unity3d.ads.core.data.model;

import java.util.Locale;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InitializationState.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum InitializationState {
    NOT_INITIALIZED,
    INITIALIZING,
    INITIALIZED,
    FAILED;

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
