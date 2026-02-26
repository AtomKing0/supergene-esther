package v;

import android.view.View;
import androidx.annotation.MainThread;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ViewTargetRequestManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class v implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final View f34980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private t f34981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private b2 f34982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private u f34983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f34984e;

    /* JADX INFO: compiled from: ViewTargetRequestManager.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.request.ViewTargetRequestManager$dispose$1", f = "ViewTargetRequestManager.kt", l = {}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f34985j;

        a(z8.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return v.this.new a(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f34985j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            v.this.c(null);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public v(@NotNull View view) {
        this.f34980a = view;
    }

    public final synchronized void a() {
        b2 b2Var = this.f34982c;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.f34982c = kotlinx.coroutines.k.d(t1.f29982a, e1.c().getImmediate(), null, new a(null), 2, null);
        this.f34981b = null;
    }

    @NotNull
    public final synchronized t b(@NotNull v0<? extends j> v0Var) {
        t tVar = this.f34981b;
        if (tVar != null && a0.j.r() && this.f34984e) {
            this.f34984e = false;
            tVar.a(v0Var);
            return tVar;
        }
        b2 b2Var = this.f34982c;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.f34982c = null;
        t tVar2 = new t(this.f34980a, v0Var);
        this.f34981b = tVar2;
        return tVar2;
    }

    @MainThread
    public final void c(@Nullable u uVar) {
        u uVar2 = this.f34983d;
        if (uVar2 != null) {
            uVar2.d();
        }
        this.f34983d = uVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    @MainThread
    public void onViewAttachedToWindow(@NotNull View view) {
        u uVar = this.f34983d;
        if (uVar == null) {
            return;
        }
        this.f34984e = true;
        uVar.e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    @MainThread
    public void onViewDetachedFromWindow(@NotNull View view) {
        u uVar = this.f34983d;
        if (uVar != null) {
            uVar.d();
        }
    }
}
