package com.braze.managers;

import kotlin.jvm.internal.v;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8087a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str) {
        super(0);
        this.f8087a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Encountered Json exception while parsing stored geofence: " + this.f8087a;
    }
}
