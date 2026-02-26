package com.braze.models.push;

import android.os.Bundle;
import kotlin.jvm.internal.v;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f8100b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Bundle bundle, String str) {
        super(0);
        this.f8099a = str;
        this.f8100b = bundle;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to parse string as boolean with key " + this.f8099a + " and bundle: " + this.f8100b;
    }
}
