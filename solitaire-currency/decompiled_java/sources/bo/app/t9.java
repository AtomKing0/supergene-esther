package bo.app;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class t9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cc0 f3905a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t9(cc0 cc0Var) {
        super(0);
        this.f3905a = cc0Var;
    }

    @Override // h9.a
    public final Object invoke() {
        ba baVar = new ba(lx.SESSION_START, (JSONObject) null, 0.0d, 14);
        baVar.a(this.f3905a);
        return baVar;
    }
}
