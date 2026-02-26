package bo.app;

import com.braze.support.JsonUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ze extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e00 f4434a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ze(e00 e00Var) {
        super(0);
        this.f4434a = e00Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Not adding session id to event: " + JsonUtils.getPrettyPrintedString(((ba) this.f4434a).forJsonPut());
    }
}
