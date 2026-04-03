package w;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import w.c;

/* JADX INFO: compiled from: ViewSizeResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface l<T extends View> extends j {

    /* JADX INFO: compiled from: ViewSizeResolver.kt */
    public static final class a {

        /* JADX INFO: renamed from: w.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ViewSizeResolver.kt */
        static final class C0716a extends v implements h9.l<Throwable, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l<T> f35277g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver f35278h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ b f35279i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0716a(l<T> lVar, ViewTreeObserver viewTreeObserver, b bVar) {
                super(1);
                this.f35277g = lVar;
                this.f35278h = viewTreeObserver;
                this.f35279i = bVar;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
                invoke2(th);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                a.g(this.f35277g, this.f35278h, this.f35279i);
            }
        }

        /* JADX INFO: compiled from: ViewSizeResolver.kt */
        public static final class b implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f35280a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ l<T> f35281b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver f35282c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ o<i> f35283d;

            /* JADX WARN: Multi-variable type inference failed */
            b(l<T> lVar, ViewTreeObserver viewTreeObserver, o<? super i> oVar) {
                this.f35281b = lVar;
                this.f35282c = viewTreeObserver;
                this.f35283d = oVar;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                i iVarE = a.e(this.f35281b);
                if (iVarE != null) {
                    a.g(this.f35281b, this.f35282c, this);
                    if (!this.f35280a) {
                        this.f35280a = true;
                        this.f35283d.resumeWith(t.b(iVarE));
                    }
                }
                return true;
            }
        }

        private static <T extends View> c c(l<T> lVar, int i10, int i11, int i12) {
            if (i10 == -2) {
                return c.b.f35261a;
            }
            int i13 = i10 - i12;
            if (i13 > 0) {
                return w.a.a(i13);
            }
            int i14 = i11 - i12;
            if (i14 > 0) {
                return w.a.a(i14);
            }
            return null;
        }

        private static <T extends View> c d(l<T> lVar) {
            ViewGroup.LayoutParams layoutParams = lVar.getView().getLayoutParams();
            return c(lVar, layoutParams != null ? layoutParams.height : -1, lVar.getView().getHeight(), lVar.b() ? lVar.getView().getPaddingTop() + lVar.getView().getPaddingBottom() : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends View> i e(l<T> lVar) {
            c cVarD;
            c cVarF = f(lVar);
            if (cVarF == null || (cVarD = d(lVar)) == null) {
                return null;
            }
            return new i(cVarF, cVarD);
        }

        private static <T extends View> c f(l<T> lVar) {
            ViewGroup.LayoutParams layoutParams = lVar.getView().getLayoutParams();
            return c(lVar, layoutParams != null ? layoutParams.width : -1, lVar.getView().getWidth(), lVar.b() ? lVar.getView().getPaddingLeft() + lVar.getView().getPaddingRight() : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends View> void g(l<T> lVar, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            } else {
                lVar.getView().getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            }
        }

        @Nullable
        public static <T extends View> Object h(@NotNull l<T> lVar, @NotNull z8.d<? super i> dVar) throws Throwable {
            i iVarE = e(lVar);
            if (iVarE != null) {
                return iVarE;
            }
            p pVar = new p(a9.c.c(dVar), 1);
            pVar.C();
            ViewTreeObserver viewTreeObserver = lVar.getView().getViewTreeObserver();
            b bVar = new b(lVar, viewTreeObserver, pVar);
            viewTreeObserver.addOnPreDrawListener(bVar);
            pVar.m(new C0716a(lVar, viewTreeObserver, bVar));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objZ;
        }
    }

    boolean b();

    @NotNull
    T getView();
}
