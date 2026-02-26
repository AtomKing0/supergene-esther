package com.ironsource;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class wj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final UUID f16040a;

    public wj() {
        UUID uuidRandomUUID = UUID.randomUUID();
        kotlin.jvm.internal.t.h(uuidRandomUUID, "randomUUID()");
        this.f16040a = uuidRandomUUID;
    }

    @NotNull
    public final String a() {
        String string = this.f16040a.toString();
        kotlin.jvm.internal.t.h(string, "id.toString()");
        return string;
    }

    @NotNull
    public final UUID b() {
        return this.f16040a;
    }
}
