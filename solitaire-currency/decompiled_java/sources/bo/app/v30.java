package bo.app;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public final class v30 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentName f4068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f4069b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v30(ComponentName componentName, Intent intent) {
        super(0);
        this.f4068a = componentName;
        this.f4069b = intent;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Sent intent with component " + this.f4068a + " and explicit intent " + this.f4069b;
    }
}
