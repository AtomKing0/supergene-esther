package v;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w.c;

/* JADX INFO: compiled from: RequestService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final j.e f34960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final a0.t f34961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final a0.n f34962c;

    public q(@NotNull j.e eVar, @NotNull a0.t tVar, @Nullable a0.r rVar) {
        this.f34960a = eVar;
        this.f34961b = tVar;
        this.f34962c = a0.f.a(rVar);
    }

    private final boolean d(i iVar, w.i iVar2) {
        return c(iVar, iVar.j()) && this.f34962c.a(iVar2);
    }

    private final boolean e(i iVar) {
        return iVar.O().isEmpty() || kotlin.collections.p.H(a0.j.o(), iVar.j());
    }

    @WorkerThread
    public final boolean a(@NotNull n nVar) {
        return !a0.a.d(nVar.f()) || this.f34962c.b();
    }

    @NotNull
    public final f b(@NotNull i iVar, @NotNull Throwable th) {
        Drawable drawableT;
        if (!(th instanceof l) || (drawableT = iVar.u()) == null) {
            drawableT = iVar.t();
        }
        return new f(drawableT, iVar, th);
    }

    public final boolean c(@NotNull i iVar, @NotNull Bitmap.Config config) {
        if (!a0.a.d(config)) {
            return true;
        }
        if (!iVar.h()) {
            return false;
        }
        x.a aVarM = iVar.M();
        if (aVarM instanceof x.b) {
            View view = ((x.b) aVarM).getView();
            if (view.isAttachedToWindow() && !view.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final n f(@NotNull i iVar, @NotNull w.i iVar2) {
        Bitmap.Config configJ = e(iVar) && d(iVar, iVar2) ? iVar.j() : Bitmap.Config.ARGB_8888;
        b bVarD = this.f34961b.b() ? iVar.D() : b.DISABLED;
        boolean z10 = iVar.i() && iVar.O().isEmpty() && configJ != Bitmap.Config.ALPHA_8;
        w.c cVarB = iVar2.b();
        c.b bVar = c.b.f35261a;
        return new n(iVar.l(), configJ, iVar.k(), iVar2, (kotlin.jvm.internal.t.d(cVarB, bVar) || kotlin.jvm.internal.t.d(iVar2.a(), bVar)) ? w.h.FIT : iVar.J(), a0.i.a(iVar), z10, iVar.I(), iVar.r(), iVar.x(), iVar.L(), iVar.E(), iVar.C(), iVar.s(), bVarD);
    }

    @NotNull
    public final p g(@NotNull i iVar, @NotNull b2 b2Var) {
        Lifecycle lifecycleZ = iVar.z();
        x.a aVarM = iVar.M();
        return aVarM instanceof x.b ? new u(this.f34960a, iVar, (x.b) aVarM, lifecycleZ, b2Var) : new a(lifecycleZ, b2Var);
    }
}
