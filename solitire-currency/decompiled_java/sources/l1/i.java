package l1;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o1.j;

/* JADX INFO: compiled from: ViewTarget.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class i<T extends View, Z> extends l1.a<Z> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f30218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f30219g = com.bumptech.glide.g.f8212a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f30220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f30221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private View.OnAttachStateChangeListener f30222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f30224e;

    /* JADX INFO: compiled from: ViewTarget.java */
    @VisibleForTesting
    static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        @VisibleForTesting
        static Integer f30225e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f30226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<g> f30227b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f30228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private ViewTreeObserverOnPreDrawListenerC0618a f30229d;

        /* JADX INFO: renamed from: l1.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ViewTarget.java */
        private static final class ViewTreeObserverOnPreDrawListenerC0618a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f30230a;

            ViewTreeObserverOnPreDrawListenerC0618a(@NonNull a aVar) {
                this.f30230a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f30230a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(@NonNull View view) {
            this.f30226a = view;
        }

        private static int c(@NonNull Context context) {
            if (f30225e == null) {
                Display defaultDisplay = ((WindowManager) j.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f30225e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f30225e.intValue();
        }

        private int e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f30228c && this.f30226a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f30226a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f30226a.getContext());
        }

        private int f() {
            int paddingTop = this.f30226a.getPaddingTop() + this.f30226a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f30226a.getLayoutParams();
            return e(this.f30226a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f30226a.getPaddingLeft() + this.f30226a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f30226a.getLayoutParams();
            return e(this.f30226a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i10) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }

        private boolean i(int i10, int i11) {
            return h(i10) && h(i11);
        }

        private void j(int i10, int i11) {
            Iterator it = new ArrayList(this.f30227b).iterator();
            while (it.hasNext()) {
                ((g) it.next()).c(i10, i11);
            }
        }

        void a() {
            if (this.f30227b.isEmpty()) {
                return;
            }
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                j(iG, iF);
                b();
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f30226a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f30229d);
            }
            this.f30229d = null;
            this.f30227b.clear();
        }

        void d(@NonNull g gVar) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                gVar.c(iG, iF);
                return;
            }
            if (!this.f30227b.contains(gVar)) {
                this.f30227b.add(gVar);
            }
            if (this.f30229d == null) {
                ViewTreeObserver viewTreeObserver = this.f30226a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0618a viewTreeObserverOnPreDrawListenerC0618a = new ViewTreeObserverOnPreDrawListenerC0618a(this);
                this.f30229d = viewTreeObserverOnPreDrawListenerC0618a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0618a);
            }
        }

        void k(@NonNull g gVar) {
            this.f30227b.remove(gVar);
        }
    }

    public i(@NonNull T t10) {
        this.f30220a = (T) j.d(t10);
        this.f30221b = new a(t10);
    }

    @Nullable
    private Object h() {
        return this.f30220a.getTag(f30219g);
    }

    private void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f30222c;
        if (onAttachStateChangeListener == null || this.f30224e) {
            return;
        }
        this.f30220a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f30224e = true;
    }

    private void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f30222c;
        if (onAttachStateChangeListener == null || !this.f30224e) {
            return;
        }
        this.f30220a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f30224e = false;
    }

    private void k(@Nullable Object obj) {
        f30218f = true;
        this.f30220a.setTag(f30219g, obj);
    }

    @Override // l1.h
    public void a(@Nullable k1.c cVar) {
        k(cVar);
    }

    @Override // l1.h
    @CallSuper
    public void b(@NonNull g gVar) {
        this.f30221b.k(gVar);
    }

    @Override // l1.a, l1.h
    @CallSuper
    public void c(@Nullable Drawable drawable) {
        super.c(drawable);
        i();
    }

    @Override // l1.a, l1.h
    @CallSuper
    public void d(@Nullable Drawable drawable) {
        super.d(drawable);
        this.f30221b.b();
        if (this.f30223d) {
            return;
        }
        j();
    }

    @Override // l1.h
    @CallSuper
    public void e(@NonNull g gVar) {
        this.f30221b.d(gVar);
    }

    @Override // l1.h
    @Nullable
    public k1.c getRequest() {
        Object objH = h();
        if (objH == null) {
            return null;
        }
        if (objH instanceof k1.c) {
            return (k1.c) objH;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public String toString() {
        return "Target for: " + this.f30220a;
    }
}
