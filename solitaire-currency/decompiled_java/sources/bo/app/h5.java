package bo.app;

import com.braze.Braze;

/* JADX INFO: loaded from: classes2.dex */
public final class h5 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f2950a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h5(Braze braze) {
        super(0);
        this.f2950a = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        tf tfVar = ((ci0) this.f2950a.getUdm$android_sdk_base_release()).f2570v;
        j50 j50Var = new j50();
        j50Var.f3123b = Boolean.TRUE;
        tfVar.a(j50Var);
        return v8.k0.f35197a;
    }
}
