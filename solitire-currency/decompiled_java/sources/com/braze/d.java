package com.braze;

import com.braze.configuration.BrazeConfig;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeConfig f8066a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BrazeConfig brazeConfig) {
        super(0);
        this.f8066a = brazeConfig;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Braze.configure() called with configuration: " + this.f8066a;
    }
}
