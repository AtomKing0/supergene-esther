package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class d60 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2627a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d60(int i10) {
        super(0);
        this.f2627a = i10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Notification permission request count is " + this.f2627a + ". Returning value of 'shouldShowRequestPermissionRationale(NOTIFICATION_PERMISSION)'";
    }
}
