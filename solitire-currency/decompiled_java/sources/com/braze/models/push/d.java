package com.braze.models.push;

import android.os.Bundle;
import kotlin.jvm.internal.v;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f8094b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Bundle bundle, String str) {
        super(0);
        this.f8093a = str;
        this.f8094b = bundle;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to parse non blank string with key " + this.f8093a + " and bundle: " + this.f8094b;
    }
}
