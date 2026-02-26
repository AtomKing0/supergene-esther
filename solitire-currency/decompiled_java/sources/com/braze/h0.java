package com.braze;

import android.content.Intent;
import bo.app.ci0;
import v8.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f8074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f8075b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(Intent intent, Braze braze) {
        super(0);
        this.f8074a = intent;
        this.f8075b = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        Braze.Companion.requestTriggersIfInAppMessageTestPush$android_sdk_base_release(this.f8074a, ((ci0) this.f8075b.getUdm$android_sdk_base_release()).f2570v);
        return k0.f35197a;
    }
}
