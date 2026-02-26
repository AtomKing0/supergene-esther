package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class tn extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3960a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tn(String str) {
        super(0);
        this.f3960a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Nested Custom Attribute Key '"), this.f3960a, "' is invalid.");
    }
}
