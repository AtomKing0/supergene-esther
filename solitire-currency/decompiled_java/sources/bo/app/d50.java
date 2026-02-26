package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class d50 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2625a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d50(String str) {
        super(0);
        this.f2625a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Offline user storage provider was given user ID longer than 997. Rejecting. User ID: " + this.f2625a;
    }
}
