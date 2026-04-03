package com.braze.support;

import kotlin.jvm.internal.v;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h9.a f8113a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(h9.a aVar) {
        super(0);
        this.f8113a = aVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return BrazeLogger.INSTANCE.toStringSafe(this.f8113a);
    }
}
