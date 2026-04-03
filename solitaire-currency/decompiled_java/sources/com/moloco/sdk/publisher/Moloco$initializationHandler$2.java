package com.moloco.sdk.publisher;

import com.moloco.sdk.internal.publisher.e0;
import com.moloco.sdk.service_locator.a;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class Moloco$initializationHandler$2 extends v implements a<e0> {
    public static final Moloco$initializationHandler$2 INSTANCE = new Moloco$initializationHandler$2();

    public Moloco$initializationHandler$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final e0 invoke() {
        return new e0(a.h.f18920a.f());
    }
}
