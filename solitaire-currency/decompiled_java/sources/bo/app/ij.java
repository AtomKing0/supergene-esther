package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ij extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3067b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ij(String str, long j10) {
        super(0);
        this.f3066a = str;
        this.f3067b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to set custom attribute " + this.f3066a + " to " + this.f3067b + " seconds from epoch.";
    }
}
