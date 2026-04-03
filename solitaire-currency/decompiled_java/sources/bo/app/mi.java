package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class mi extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3428a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mi(String str) {
        super(0);
        this.f3428a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Failed to remove custom attribute with key '"), this.f3428a, "'.");
    }
}
