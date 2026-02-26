package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ee extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2729a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ee(int i10) {
        super(0);
        this.f2729a = i10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Log level already set via system property. BrazeLogger.setLogLevel() ignored for level: " + this.f2729a;
    }
}
