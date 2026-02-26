package com.moloco.sdk.internal.services.usertracker;

import java.util.UUID;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements d {
    @Override // com.moloco.sdk.internal.services.usertracker.d
    @NotNull
    public String a() {
        String string = UUID.randomUUID().toString();
        t.h(string, "randomUUID().toString()");
        return string;
    }
}
