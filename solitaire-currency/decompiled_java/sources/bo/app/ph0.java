package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ph0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3631a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ph0(String str) {
        super(0);
        this.f3631a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to load user object json from prefs with json string: " + this.f3631a;
    }
}
