package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w00 f3458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f3459b;

    public n(l00 request, w00 connectionResult) {
        kotlin.jvm.internal.t.i(request, "request");
        kotlin.jvm.internal.t.i(connectionResult, "connectionResult");
        this.f3458a = connectionResult;
        String str = (String) connectionResult.c().get("retry-after");
        this.f3459b = str != null ? com.braze.support.i.a(str) : null;
    }
}
