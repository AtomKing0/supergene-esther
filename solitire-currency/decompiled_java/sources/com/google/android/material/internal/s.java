package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class s {

    /* JADX INFO: compiled from: ViewUtils.java */
    class a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f9493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f9494b;

        a(c cVar, d dVar) {
            this.f9493a = cVar;
            this.f9494b = dVar;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return this.f9493a.a(view, windowInsetsCompat, new d(this.f9494b));
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public interface c {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, d dVar);
    }

    public static void b(@NonNull View view, @NonNull c cVar) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new a(cVar, new d(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        j(view);
    }

    public static float c(@NonNull Context context, @Dimension(unit = 0) int i10) {
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    @Nullable
    public static Integer d(@NonNull View view) {
        ColorStateList colorStateListF = com.google.android.material.drawable.b.f(view.getBackground());
        if (colorStateListF != null) {
            return Integer.valueOf(colorStateListF.getDefaultColor());
        }
        return null;
    }

    @Nullable
    private static InputMethodManager e(@NonNull View view) {
        return (InputMethodManager) ContextCompat.getSystemService(view.getContext(), InputMethodManager.class);
    }

    public static float f(@NonNull View view) {
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ViewCompat.getElevation((View) parent);
        }
        return elevation;
    }

    public static boolean g(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static PorterDuff.Mode i(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void j(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    public static void k(@NonNull final View view, final boolean z10) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.r
            @Override // java.lang.Runnable
            public final void run() {
                s.l(view, z10);
            }
        });
    }

    public static void l(@NonNull View view, boolean z10) {
        WindowInsetsControllerCompat windowInsetsController;
        if (!z10 || (windowInsetsController = ViewCompat.getWindowInsetsController(view)) == null) {
            e(view).showSoftInput(view, 1);
        } else {
            windowInsetsController.show(WindowInsetsCompat.Type.ime());
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9498d;

        public d(int i10, int i11, int i12, int i13) {
            this.f9495a = i10;
            this.f9496b = i11;
            this.f9497c = i12;
            this.f9498d = i13;
        }

        public d(@NonNull d dVar) {
            this.f9495a = dVar.f9495a;
            this.f9496b = dVar.f9496b;
            this.f9497c = dVar.f9497c;
            this.f9498d = dVar.f9498d;
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            view.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
