package com.moloco.sdk.acm.services;

import android.text.TextUtils;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f17466a = new b();

    public final boolean a(@NotNull String key) {
        t.i(key, "key");
        return Boolean.parseBoolean(b(key));
    }

    public final String b(String str) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            t.g(objInvoke, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) objInvoke;
            try {
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
            } catch (Exception unused) {
            }
            return str2;
        } catch (Exception unused2) {
            return null;
        }
    }
}
