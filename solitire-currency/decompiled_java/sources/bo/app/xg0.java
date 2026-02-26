package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class xg0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4271a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xg0(String str) {
        super(0);
        this.f4271a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Retrieving triggered action id "), this.f4271a, " eligibility information from local storage.");
    }
}
