package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class sf0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3855a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sf0(String str) {
        super(0);
        this.f3855a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Received null or blank serialized triggered action string for action id "), this.f3855a, " from shared preferences. Not parsing.");
    }
}
