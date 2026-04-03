package com.ironsource;

import com.ironsource.gi;
import com.ironsource.wd;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public final class q1 implements e8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ok f14426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, gi.d> f14427b;

    public q1(@NotNull ok tools, @NotNull Map<String, gi.d> interstitialAdUnits) {
        kotlin.jvm.internal.t.i(tools, "tools");
        kotlin.jvm.internal.t.i(interstitialAdUnits, "interstitialAdUnits");
        this.f14426a = tools;
        this.f14427b = interstitialAdUnits;
    }

    @Override // com.ironsource.e8
    public void a(@NotNull wd.a cappingService) {
        kotlin.jvm.internal.t.i(cappingService, "cappingService");
        for (Map.Entry<String, gi.d> entry : this.f14427b.entrySet()) {
            String key = entry.getKey();
            gi.d value = entry.getValue();
            tn tnVarD = value.d();
            if (tnVarD != null) {
                h8 h8Var = h8.Pacing;
                a(cappingService.a(key, h8Var, new y7(tnVarD.a(), tnVarD.b(), tnVarD.c())), key, h8Var);
            }
            b8 b8VarA = value.a();
            if (b8VarA != null) {
                h8 h8Var2 = h8.ShowCount;
                a(cappingService.a(key, h8Var2, new y7(b8VarA.a(), b8VarA.b(), b8VarA.c())), key, h8Var2);
            }
        }
    }

    private final void a(Object obj, String str, h8 h8Var) throws JSONException {
        Throwable thE = v8.t.e(obj);
        if (thE != null) {
            this.f14426a.a(str, new c8().a(h8Var), thE.getMessage());
        }
    }
}
