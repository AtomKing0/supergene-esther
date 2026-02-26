package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class yq extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4379b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yq(boolean z10, boolean z11) {
        super(0);
        this.f4378a = z10;
        this.f4379b = z11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Exporting the full device due to either: shouldShouldFullDeviceOnNextExport: " + this.f4378a + ", shouldReportPushPermissionsAsGranted: " + this.f4379b;
    }
}
