package com.onetrust.otpublishers.headless.UI.extensions;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    @NotNull
    public static final String a(@NotNull String key, @NotNull String defaultValue, @Nullable JSONObject jSONObject) {
        String string;
        t.i(key, "key");
        t.i(defaultValue, "defaultValue");
        if (jSONObject != null) {
            try {
                string = jSONObject.getString(key);
            } catch (Exception unused) {
                string = defaultValue;
            }
        } else {
            string = null;
        }
        return string == null ? defaultValue : string;
    }

    @Nullable
    public static final String b(@NotNull JSONObject jSONObject, @NotNull String key) {
        t.i(jSONObject, "<this>");
        t.i(key, "key");
        try {
            return jSONObject.getString(key);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final boolean c(@NotNull String key, @Nullable JSONObject jSONObject, boolean z10) {
        t.i(key, "key");
        if (jSONObject == null) {
            return z10;
        }
        try {
            return jSONObject.getBoolean(key);
        } catch (Exception unused) {
            return z10;
        }
    }
}
