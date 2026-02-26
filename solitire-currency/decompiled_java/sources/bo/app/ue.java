package bo.app;

import com.braze.support.JsonUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ue extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e00 f4011a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ue(e00 e00Var) {
        super(0);
        this.f4011a = e00Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Attempting to log event: " + JsonUtils.getPrettyPrintedString(((ba) this.f4011a).forJsonPut());
    }
}
