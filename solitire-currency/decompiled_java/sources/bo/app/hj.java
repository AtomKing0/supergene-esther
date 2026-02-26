package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class hj extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2985a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hj(String str) {
        super(0);
        this.f2985a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Failed to set custom attribute "), this.f2985a, " to now.");
    }
}
