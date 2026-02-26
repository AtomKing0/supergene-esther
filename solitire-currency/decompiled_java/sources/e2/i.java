package e2;

import android.content.Context;
import f2.x;

/* JADX INFO: compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements a2.b<x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<Context> f24725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u8.a<g2.d> f24726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u8.a<f2.f> f24727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u8.a<i2.a> f24728d;

    public i(u8.a<Context> aVar, u8.a<g2.d> aVar2, u8.a<f2.f> aVar3, u8.a<i2.a> aVar4) {
        this.f24725a = aVar;
        this.f24726b = aVar2;
        this.f24727c = aVar3;
        this.f24728d = aVar4;
    }

    public static i a(u8.a<Context> aVar, u8.a<g2.d> aVar2, u8.a<f2.f> aVar3, u8.a<i2.a> aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static x c(Context context, g2.d dVar, f2.f fVar, i2.a aVar) {
        return (x) a2.d.c(h.a(context, dVar, fVar, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x get() {
        return c(this.f24725a.get(), this.f24726b.get(), this.f24727c.get(), this.f24728d.get());
    }
}
