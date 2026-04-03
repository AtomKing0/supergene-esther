package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ig0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3054a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ig0(String str) {
        super(0);
        this.f3054a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Received triggered condition Json with unknown type: "), this.f3054a, ". Not parsing.");
    }
}
