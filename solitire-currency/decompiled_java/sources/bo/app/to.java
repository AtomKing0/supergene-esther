package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class to extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3961a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public to(long j10) {
        super(0);
        this.f3961a = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Posting new sync runnable with delay " + this.f3961a + " ms";
    }
}
