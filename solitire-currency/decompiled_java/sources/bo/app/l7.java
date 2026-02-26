package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class l7 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3310a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l7(String str) {
        super(0);
        this.f3310a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("The Braze SDK requires the permission "), this.f3310a, ". Check your AndroidManifest.");
    }
}
