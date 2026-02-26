package bo.app;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class bh extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih f2450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f2451b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(ih ihVar, ArrayList arrayList) {
        super(0);
        this.f2450a = ihVar;
        this.f2451b = arrayList;
    }

    @Override // h9.a
    public final Object invoke() {
        ((vw) this.f2450a.f3055a).b(uz.class, new uz(this.f2451b));
        return v8.k0.f35197a;
    }
}
