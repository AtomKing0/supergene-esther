package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class uf extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4015c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uf(long j10, long j11, long j12) {
        super(0);
        this.f4013a = j10;
        this.f4014b = j11;
        this.f4015c = j12;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Messaging session timeout: " + this.f4013a + ", current diff: " + (this.f4014b - this.f4015c);
    }
}
