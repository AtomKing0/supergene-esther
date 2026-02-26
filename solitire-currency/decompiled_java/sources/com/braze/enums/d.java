package com.braze.enums;

import kotlin.jvm.internal.v;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8069a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i10) {
        super(0);
        this.f8069a = i10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "No month with value " + this.f8069a + ", value must be in (0,11)";
    }
}
