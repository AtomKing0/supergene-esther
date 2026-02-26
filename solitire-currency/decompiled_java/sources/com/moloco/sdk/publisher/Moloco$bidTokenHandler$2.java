package com.moloco.sdk.publisher;

import com.moloco.sdk.internal.services.bidtoken.j;
import com.moloco.sdk.internal.services.bidtoken.o;
import com.moloco.sdk.service_locator.a;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class Moloco$bidTokenHandler$2 extends v implements a<j> {
    public static final Moloco$bidTokenHandler$2 INSTANCE = new Moloco$bidTokenHandler$2();

    public Moloco$bidTokenHandler$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final j invoke() {
        return new j(o.a(), Moloco.INSTANCE.getInitializationHandler(), a.h.f18920a.f(), com.moloco.sdk.acm.a.f17293a);
    }
}
