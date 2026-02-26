package com.unity3d.services.ads.token;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import v8.k0;

/* JADX INFO: compiled from: TokenStorage.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface TokenStorage {
    void appendTokens(@NotNull JSONArray jSONArray) throws JSONException;

    void createTokens(@NotNull JSONArray jSONArray) throws JSONException;

    void deleteTokens();

    @NotNull
    k0 getNativeGeneratedToken();

    @Nullable
    String getToken();

    void setInitToken(@Nullable String str);
}
