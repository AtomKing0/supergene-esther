package com.ironsource;

import com.ironsource.gi;
import com.ironsource.oe;
import com.unity3d.mediation.LevelPlay;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public final class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ok f11984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, gi.d> f11985b;

    public eo(@NotNull ok tools, @NotNull Map<String, gi.d> interstitialPlacements) {
        kotlin.jvm.internal.t.i(tools, "tools");
        kotlin.jvm.internal.t.i(interstitialPlacements, "interstitialPlacements");
        this.f11984a = tools;
        this.f11985b = interstitialPlacements;
    }

    public final void a(@NotNull oe.a cappingService) {
        kotlin.jvm.internal.t.i(cappingService, "cappingService");
        LevelPlay.AdFormat adFormat = LevelPlay.AdFormat.INTERSTITIAL;
        for (Map.Entry<String, gi.d> entry : this.f11985b.entrySet()) {
            String key = entry.getKey();
            gi.d value = entry.getValue();
            b8 b8VarA = value.a();
            if (b8VarA != null) {
                h8 h8Var = h8.ShowCount;
                a(cappingService.a(key, adFormat, h8Var, new y7(b8VarA.a(), b8VarA.b(), b8VarA.c())), key, adFormat, h8Var);
            }
            tn tnVarD = value.d();
            if (tnVarD != null) {
                h8 h8Var2 = h8.Pacing;
                a(cappingService.a(key, adFormat, h8Var2, new y7(tnVarD.a(), tnVarD.b(), g8.Second)), key, adFormat, h8Var2);
            }
            h8 h8Var3 = h8.Delivery;
            aa aaVarB = value.b();
            a(cappingService.a(key, adFormat, h8Var3, new y7(aaVarB != null ? Boolean.valueOf(aaVarB.a()) : null, null, null, 6, null)), key, adFormat, h8Var3);
        }
    }

    private final void a(Object obj, String str, LevelPlay.AdFormat adFormat, h8 h8Var) throws JSONException {
        Throwable thE = v8.t.e(obj);
        if (thE != null) {
            int iA = new c8().a(h8Var);
            ok okVar = this.f11984a;
            okVar.a(str, okVar.a(adFormat), iA, thE.getMessage());
        }
    }
}
