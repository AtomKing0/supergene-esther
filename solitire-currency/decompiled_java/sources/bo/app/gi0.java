package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class gi0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2915a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gi0(String str) {
        super(0);
        this.f2915a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("The custom event is a blocklisted custom event: "), this.f2915a, ". Invalid custom event.");
    }
}
