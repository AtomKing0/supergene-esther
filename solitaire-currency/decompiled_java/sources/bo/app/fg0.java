package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class fg0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2827a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fg0(String str) {
        super(0);
        this.f2827a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Received templated message Json with unknown type: "), this.f2827a, ". Not parsing.");
    }
}
