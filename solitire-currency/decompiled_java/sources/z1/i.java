package z1;

import android.content.Context;

/* JADX INFO: compiled from: CreationContextFactory.java */
/* JADX INFO: loaded from: classes2.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f36987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i2.a f36988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i2.a f36989c;

    i(Context context, i2.a aVar, i2.a aVar2) {
        this.f36987a = context;
        this.f36988b = aVar;
        this.f36989c = aVar2;
    }

    h a(String str) {
        return h.a(this.f36987a, this.f36988b, this.f36989c, str);
    }
}
