package bo.app;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public final class x3 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f4238a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x3(Intent intent) {
        super(0);
        this.f4238a = intent;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Error logging push notification with intent: " + this.f4238a;
    }
}
