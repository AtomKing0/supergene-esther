package bo.app;

import com.braze.Braze;

/* JADX INFO: loaded from: classes2.dex */
public final class e3 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f2700a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e3(Braze braze) {
        super(0);
        this.f2700a = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        z9 z9Var = ba.f2429g;
        z9Var.getClass();
        kotlin.jvm.internal.t.i("feed_displayed", "name");
        e00 e00VarA = z9Var.a(new k9());
        if (e00VarA != null) {
            ((ci0) this.f2700a.getUdm$android_sdk_base_release()).f2570v.a(e00VarA);
        }
        return v8.k0.f35197a;
    }
}
