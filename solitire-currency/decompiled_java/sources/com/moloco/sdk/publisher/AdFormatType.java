package com.moloco.sdk.publisher;

import java.util.Locale;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.c;

/* JADX INFO: loaded from: classes4.dex */
public enum AdFormatType {
    BANNER,
    INTERSTITIAL,
    REWARDED,
    MREC,
    NATIVE;

    @NotNull
    public final String toLowercase() {
        String lowerCase = toString().toLowerCase(Locale.ROOT);
        t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @NotNull
    public final String toTitlecase() {
        String lowercase = toLowercase();
        if (lowercase.length() <= 0) {
            return lowercase;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = lowercase.charAt(0);
        sb.append((Object) (Character.isLowerCase(cCharAt) ? c.i(cCharAt) : String.valueOf(cCharAt)));
        String strSubstring = lowercase.substring(1);
        t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        return sb.toString();
    }
}
