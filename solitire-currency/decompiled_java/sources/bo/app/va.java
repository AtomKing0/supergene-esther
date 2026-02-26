package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class va extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4099a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public va(boolean z10) {
        super(0);
        this.f4099a = z10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Geofences enabled status of `" + this.f4099a + "` was unchanged during server config update.";
    }
}
