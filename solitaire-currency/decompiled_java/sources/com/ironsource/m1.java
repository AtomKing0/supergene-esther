package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final HashMap<String, k2> f13104a = new HashMap<>();

    public enum a {
        DidntAttemptToLoad,
        FailedToLoad,
        LoadedSuccessfully,
        FailedToShow,
        ShowedSuccessfully,
        NotPartOfWaterfall
    }

    @NotNull
    public final k2 a(@NotNull String adUnitId, @NotNull List<? extends NetworkSettings> providers, int i10) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(providers, "providers");
        k2 k2Var = this.f13104a.get(adUnitId);
        if (k2Var != null) {
            return k2Var;
        }
        k2 k2Var2 = new k2(providers, i10);
        this.f13104a.put(adUnitId, k2Var2);
        return k2Var2;
    }
}
