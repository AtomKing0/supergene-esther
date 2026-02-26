package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class al extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2394b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(String str, Object obj) {
        super(0);
        this.f2393a = str;
        this.f2394b = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Primary key '" + this.f2393a + "' had no identifier. No secondary key to read resource value. Returning default value: '" + this.f2394b + '\'';
    }
}
