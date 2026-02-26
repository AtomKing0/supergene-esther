package com.braze.models.push;

import android.os.Bundle;
import kotlin.jvm.internal.v;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f8096b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Bundle bundle, String str) {
        super(0);
        this.f8095a = str;
        this.f8096b = bundle;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to parse string as int with key " + this.f8095a + " and bundle: " + this.f8096b;
    }
}
