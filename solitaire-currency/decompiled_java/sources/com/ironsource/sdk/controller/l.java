package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.ironsource.gl;
import com.ironsource.ha;
import com.ironsource.n9;
import com.ironsource.o9;
import com.ironsource.p9;
import com.ironsource.qf;
import com.ironsource.sdk.controller.f;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface l {

    public interface a {
        void a(@NotNull f.a aVar);
    }

    public interface b {
        void a(@NotNull gl glVar);
    }

    void a();

    void a(Activity activity);

    void a(Context context);

    void a(ha haVar);

    void a(ha haVar, Map<String, String> map, n9 n9Var);

    void a(ha haVar, Map<String, String> map, o9 o9Var);

    void a(f.c cVar, @Nullable a aVar);

    void a(String str, o9 o9Var);

    void a(String str, String str2, ha haVar, n9 n9Var);

    void a(String str, String str2, ha haVar, o9 o9Var);

    void a(String str, String str2, ha haVar, p9 p9Var);

    void a(JSONObject jSONObject);

    void a(JSONObject jSONObject, n9 n9Var);

    void a(JSONObject jSONObject, o9 o9Var);

    void a(JSONObject jSONObject, p9 p9Var);

    boolean a(String str);

    void b(Context context);

    void b(ha haVar);

    void b(ha haVar, Map<String, String> map, o9 o9Var);

    void b(JSONObject jSONObject);

    void d();

    void destroy();

    @Deprecated
    void e();

    void f();

    qf.c g();
}
