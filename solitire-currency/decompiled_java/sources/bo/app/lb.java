package bo.app;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class lb extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f3322a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lb(List list) {
        super(0);
        this.f3322a = list;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Received new geofence list of size: " + this.f3322a.size();
    }
}
