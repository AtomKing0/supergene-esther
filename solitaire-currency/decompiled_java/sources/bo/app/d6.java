package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class d6 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h9.a f2626a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d6(h9.a aVar) {
        super(0);
        this.f2626a = aVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Early returning because the Braze instance isn't fully initialized. Always use Braze.getInstance(context) to get the latest Braze instance. Please report to Braze if the issue continues. > " + ((String) this.f2626a.invoke());
    }
}
