package com.moloco.sdk.publisher;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class MediationInfo {
    public static final int $stable = 0;

    @NotNull
    private final String name;

    public MediationInfo(@NotNull String name) {
        t.i(name, "name");
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}
