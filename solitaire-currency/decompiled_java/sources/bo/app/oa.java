package bo.app;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public final class oa extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f3551a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oa(Intent intent) {
        super(0);
        this.f3551a = intent;
    }

    @Override // h9.a
    public final Object invoke() {
        return "BrazeFlushPushDeliveryReceiver received intent: " + this.f3551a.getAction();
    }
}
