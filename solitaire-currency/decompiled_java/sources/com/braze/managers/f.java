package com.braze.managers;

import bo.app.d1;
import kotlin.jvm.internal.v;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8086a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str) {
        super(0);
        this.f8086a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Received null or blank serialized geofence string for geofence id "), this.f8086a, " from shared preferences. Not parsing.");
    }
}
