package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface ee extends cb {

    public interface a {
        void a(@Nullable JSONObject jSONObject);
    }

    @NotNull
    JSONObject config();
}
