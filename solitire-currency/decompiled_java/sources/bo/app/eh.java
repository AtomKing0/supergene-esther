package bo.app;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class eh extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih f2734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f2735b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eh(ih ihVar, ArrayList arrayList) {
        super(0);
        this.f2734a = ihVar;
        this.f2735b = arrayList;
    }

    @Override // h9.a
    public final Object invoke() {
        ((vw) this.f2734a.f3055a).b(eh0.class, new eh0(this.f2735b));
        return v8.k0.f35197a;
    }
}
