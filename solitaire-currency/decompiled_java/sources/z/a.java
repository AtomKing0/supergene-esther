package z;

import android.graphics.drawable.Drawable;
import org.jetbrains.annotations.NotNull;
import v.f;
import v.j;
import v.r;
import w.h;

/* JADX INFO: compiled from: CrossfadeTransition.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final d f36953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final j f36954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f36955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f36956d;

    @Override // z.c
    public void a() {
        Drawable drawableD = this.f36953a.d();
        Drawable drawableA = this.f36954b.a();
        h hVarJ = this.f36954b.b().J();
        int i10 = this.f36955c;
        j jVar = this.f36954b;
        o.b bVar = new o.b(drawableD, drawableA, hVarJ, i10, ((jVar instanceof r) && ((r) jVar).d()) ? false : true, this.f36956d);
        j jVar2 = this.f36954b;
        if (jVar2 instanceof r) {
            this.f36953a.a(bVar);
        } else if (jVar2 instanceof f) {
            this.f36953a.c(bVar);
        }
    }

    public final int b() {
        return this.f36955c;
    }

    public final boolean c() {
        return this.f36956d;
    }
}
