package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class th0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3953b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public th0(String str, Object obj) {
        super(0);
        this.f3952a = str;
        this.f3953b = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to write to user object json from prefs with key: [" + this.f3952a + "] value: [" + this.f3953b + ']';
    }
}
