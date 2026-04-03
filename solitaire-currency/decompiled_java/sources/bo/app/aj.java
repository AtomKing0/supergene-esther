package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class aj extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2389a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(String str) {
        super(0);
        this.f2389a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return h1.a(new StringBuilder("Failed to set custom integer attribute "), this.f2389a, '.');
    }
}
