package bo.app;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class ir extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3078a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ir(Context context) {
        super(0);
        this.f3078a = context;
    }

    @Override // h9.a
    public final Object invoke() {
        return this.f3078a.getSharedPreferences("com.appboy.device", 0);
    }
}
