package com.ironsource;

import android.app.Activity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface nl {

    public interface a {
        void a();

        void a(@NotNull dg dgVar);

        void a(@NotNull String str);

        void b();
    }

    @Nullable
    a a();

    void a(@NotNull Activity activity, @NotNull JSONObject jSONObject);

    void a(@NotNull fu fuVar);

    void a(@NotNull gg ggVar);

    void a(@Nullable a aVar);

    void a(@NotNull JSONObject jSONObject);

    void b();

    void destroy();
}
