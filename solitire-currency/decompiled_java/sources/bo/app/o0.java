package bo.app;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3532b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(long j10, long j11) {
        super(0);
        this.f3531a = j10;
        this.f3532b = j11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Braze SDK loaded in " + TimeUnit.MILLISECONDS.convert(this.f3531a - this.f3532b, TimeUnit.NANOSECONDS) + " ms / " + (this.f3531a - this.f3532b) + " nanos";
    }
}
