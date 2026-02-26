package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class gr extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2923a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gr(String str) {
        super(0);
        this.f2923a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return h1.a(new StringBuilder("Unable to inspect package ["), this.f2923a, ']');
    }
}
