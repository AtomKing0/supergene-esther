package com.vungle.ads.internal.util;

import kotlin.collections.r0;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    @NotNull
    public static final o INSTANCE = new o();

    private o() {
    }

    @Nullable
    public final String getContentStringValue(@NotNull JsonObject json, @NotNull String key) {
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(key, "key");
        try {
            return kotlinx.serialization.json.h.l((JsonElement) r0.h(json, key)).a();
        } catch (Exception unused) {
            return null;
        }
    }
}
