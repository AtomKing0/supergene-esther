package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class hb0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2968a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb0(String str) {
        super(0);
        this.f2968a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Detected SDK update from '"), this.f2968a, "' -> '32.1.0'. Clearing config update time.");
    }
}
