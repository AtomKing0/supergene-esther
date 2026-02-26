package com.braze.models.push;

import android.os.Bundle;
import kotlin.jvm.internal.v;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f8098b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Bundle bundle, String str) {
        super(0);
        this.f8097a = str;
        this.f8098b = bundle;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to parse string with key " + this.f8097a + " and bundle: " + this.f8098b;
    }
}
