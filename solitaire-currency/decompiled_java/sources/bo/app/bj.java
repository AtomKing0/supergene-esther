package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class bj extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2460a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(String str) {
        super(0);
        this.f2460a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return h1.a(new StringBuilder("Failed to set custom float attribute "), this.f2460a, '.');
    }
}
