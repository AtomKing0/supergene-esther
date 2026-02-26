package bo.app;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class v60 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f4075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4076b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v60(Map.Entry entry, long j10) {
        super(0);
        this.f4075a = entry;
        this.f4076b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Evicting push id key " + this.f4075a + " based on cutoff: " + this.f4076b;
    }
}
