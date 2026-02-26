package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4235b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(String str, String str2) {
        super(0);
        this.f4234a = str;
        this.f4235b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to load image from disk cache: " + this.f4234a + '/' + this.f4235b;
    }
}
