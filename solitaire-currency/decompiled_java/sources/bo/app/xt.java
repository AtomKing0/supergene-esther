package bo.app;

import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class xt extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.n0 f4302a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xt(kotlin.jvm.internal.n0 n0Var) {
        super(0);
        this.f4302a = n0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.a
    public final Object invoke() {
        return "DUST stream response code " + ((HttpURLConnection) this.f4302a.f29834a).getResponseCode();
    }
}
