package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class da0 extends uu {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f2637l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da0(cs dispatchDataProvider) {
        super(k00.SDK_DEBUGGER_LOG, dispatchDataProvider);
        kotlin.jvm.internal.t.i(dispatchDataProvider, "dispatchDataProvider");
        this.f2637l = true;
    }

    @Override // bo.app.uu
    public final void a(long j10) {
    }

    @Override // bo.app.uu
    public final boolean d() {
        return this.f2637l;
    }

    @Override // bo.app.uu
    public final void a(long j10, z80 requestInfo, n apiResponse) {
        kotlin.jvm.internal.t.i(requestInfo, "requestInfo");
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        super.a(j10, requestInfo, apiResponse);
        requestInfo.a(j10, a90.COMPLETE);
    }
}
