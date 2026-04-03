package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class iu implements c10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v00 f3079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h00 f3080b;

    public iu(vw internalEventPublisher, h00 brazeManager) {
        kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        this.f3079a = internalEventPublisher;
        this.f3080b = brazeManager;
        new ArrayList();
    }

    @Override // bo.app.c10
    public final void a(z80 requestInfo, a80 requestDispatchCallback, boolean z10) {
        kotlin.jvm.internal.t.i(requestInfo, "requestInfo");
        kotlin.jvm.internal.t.i(requestDispatchCallback, "requestDispatchCallback");
        l00 l00Var = requestInfo.f4410a;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new hu(l00Var), 7, (Object) null);
        s50 s50Var = new s50(l00Var, new w00(201, kotlin.collections.r0.g(), 4), this.f3080b);
        v00 v00Var = this.f3079a;
        l00Var.a(v00Var, v00Var, s50Var);
        l00Var.a(this.f3079a);
        requestDispatchCallback.a(s50Var);
        ((vw) this.f3079a).b(es.class, new es(l00Var));
    }

    public /* synthetic */ iu(vw vwVar, h00 h00Var, int i10) {
        this(vwVar, h00Var);
    }
}
