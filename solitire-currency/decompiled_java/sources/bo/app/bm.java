package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class bm extends uu {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(cs dispatchDataProvider) {
        super(k00.CONTENT_CARD_SYNC, dispatchDataProvider);
        kotlin.jvm.internal.t.i(dispatchDataProvider, "dispatchDataProvider");
    }

    @Override // bo.app.uu
    public final void a(long j10) {
        b(j10);
    }

    @Override // bo.app.uu
    public final void a(long j10, z80 requestInfo, s50 apiResponse) {
        kotlin.jvm.internal.t.i(requestInfo, "requestInfo");
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        super.a(j10, requestInfo, apiResponse);
        Long l10 = apiResponse.f3459b;
        if (l10 != null) {
            requestInfo.f4411b = l10.longValue() + j10;
            requestInfo.a(j10, a90.PENDING_RETRY);
            l00 l00Var = requestInfo.f4410a;
            mn mnVar = l00Var instanceof mn ? (mn) l00Var : null;
            if (mnVar == null) {
                return;
            }
            mnVar.f3437l = requestInfo.f4417h;
        }
    }
}
