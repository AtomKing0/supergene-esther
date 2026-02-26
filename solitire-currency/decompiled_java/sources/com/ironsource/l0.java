package com.ironsource;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface l0 {

    public interface a {
        void a(@NotNull j1 j1Var, @NotNull String str);

        void a(@NotNull k0 k0Var);

        void a(@NotNull JSONObject jSONObject, @NotNull j1 j1Var, @NotNull String str);
    }

    @Nullable
    k0 a(@NotNull String str);

    @NotNull
    List<k0> a();
}
