package bo.app;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class dv extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f2688a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dv(Map.Entry entry) {
        super(0);
        this.f2688a = entry;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to get expiration time. Deleting entry: " + this.f2688a;
    }
}
