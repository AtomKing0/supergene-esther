package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class v4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4070a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v4(String str) {
        super(0);
        this.f4070a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Push token "), this.f4070a, " registered and immediately being flushed.");
    }
}
