package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class b50 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2416a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b50(String str) {
        super(0);
        this.f2416a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Stored user ID is longer than 997 bytes. Truncating. Original user ID: " + this.f2416a;
    }
}
