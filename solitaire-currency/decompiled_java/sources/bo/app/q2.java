package bo.app;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class q2 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f3677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3678c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q2(String str, Set set, boolean z10) {
        super(0);
        this.f3676a = str;
        this.f3677b = set;
        this.f3678c = z10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Checking event key [" + this.f3676a + "] against ephemeral event list " + this.f3677b + " and got match?: " + this.f3678c;
    }
}
