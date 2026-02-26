package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class be0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2445a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be0(String str) {
        super(0);
        this.f2445a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return h1.a(new StringBuilder("Encountered unexpected exception while parsing stored triggered action local assets on remote asset '"), this.f2445a, '\'');
    }
}
