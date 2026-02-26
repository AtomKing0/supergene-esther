package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ae extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2371a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(String str) {
        super(0);
        this.f2371a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("BrazeLogger log level set to "), this.f2371a, " via device system property. Note that subsequent calls to BrazeLogger.setLogLevel() will have no effect.");
    }
}
