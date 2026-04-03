package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q7 {
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] a(int r5, int r6, int r7) {
        /*
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto Lc
            int[] r5 = new int[r0]
            r5[r1] = r6
            r5[r2] = r7
            return r5
        Lc:
            r3 = r5 & 119(0x77, float:1.67E-43)
            r4 = 119(0x77, float:1.67E-43)
            if (r3 != r4) goto L19
            int[] r5 = new int[r2]
            r6 = 13
            r5[r1] = r6
            return r5
        L19:
            r3 = r5 & 112(0x70, float:1.57E-43)
            r4 = 112(0x70, float:1.57E-43)
            if (r3 != r4) goto L20
            goto L38
        L20:
            r3 = r5 & 48
            r4 = 48
            if (r3 != r4) goto L29
            r6 = 10
            goto L3a
        L29:
            r3 = r5 & 80
            r4 = 80
            if (r3 != r4) goto L32
            r6 = 12
            goto L3a
        L32:
            r3 = r5 & 16
            r4 = 16
            if (r3 != r4) goto L3a
        L38:
            r6 = 15
        L3a:
            r3 = r5 & 7
            r4 = 7
            if (r3 != r4) goto L40
            goto L67
        L40:
            r3 = 8388611(0x800003, float:1.1754948E-38)
            r4 = r5 & r3
            if (r4 != r3) goto L4a
            r7 = 20
            goto L69
        L4a:
            r3 = r5 & 3
            r4 = 3
            if (r3 != r4) goto L52
            r7 = 9
            goto L69
        L52:
            r3 = 8388613(0x800005, float:1.175495E-38)
            r4 = r5 & r3
            if (r4 != r3) goto L5c
            r7 = 21
            goto L69
        L5c:
            r3 = r5 & 5
            r4 = 5
            if (r3 != r4) goto L64
            r7 = 11
            goto L69
        L64:
            r5 = r5 & r2
            if (r5 != r2) goto L69
        L67:
            r7 = 14
        L69:
            int[] r5 = new int[r0]
            r5[r1] = r7
            r5[r2] = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.q7.a(int, int, int):int[]");
    }

    public static void c(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static void a(View view, long j10, Runnable runnable) {
        view.setVisibility(4);
        view.bringToFront();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(j10);
        alphaAnimation.setAnimationListener(new a(view, runnable));
        view.startAnimation(alphaAnimation);
    }

    public static boolean b(int i10) {
        return i10 == 0;
    }

    public static void b(View view, long j10, Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j10);
        alphaAnimation.setAnimationListener(new b(view, runnable));
        view.startAnimation(alphaAnimation);
    }

    public static Activity b(View view, com.applovin.impl.sdk.j jVar) {
        if (view == null) {
            return null;
        }
        for (int i10 = 0; i10 < 1000; i10++) {
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("ViewUtils", "Encountered error while retrieving activity from view", th);
                }
            }
        }
        return null;
    }

    public static boolean a(int i10, int i11) {
        return b(i10) != b(i11);
    }

    public static String a(int i10) {
        return i10 == 0 ? "VISIBLE" : i10 == 4 ? "INVISIBLE" : i10 == 8 ? "GONE" : String.valueOf(i10);
    }

    public static void a(View view, final com.applovin.impl.sdk.j jVar) {
        if (view == null || jVar == null || !k0.b()) {
            return;
        }
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.applovin.impl.ad
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                return q7.a(jVar, view2, windowInsets);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsets a(com.applovin.impl.sdk.j jVar, View view, WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(((Integer) jVar.a(l4.f5737s2)).intValue());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return WindowInsets.CONSUMED;
    }

    public static View b(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View viewFindViewById = rootView.findViewById(R.id.content);
        return viewFindViewById != null ? viewFindViewById : rootView;
    }

    public static boolean a(View view, Activity activity) {
        if (activity != null && view != null) {
            Window window = activity.getWindow();
            if (window != null) {
                return a(view, window.getDecorView());
            }
            View viewFindViewById = activity.findViewById(R.id.content);
            if (viewFindViewById != null) {
                return a(view, viewFindViewById.getRootView());
            }
        }
        return false;
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                if (a(view, viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f6706b;

        a(View view, Runnable runnable) {
            this.f6705a = view;
            this.f6706b = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Runnable runnable = this.f6706b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f6705a.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f6708b;

        b(View view, Runnable runnable) {
            this.f6707a = view;
            this.f6708b = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f6707a.setVisibility(4);
            Runnable runnable = this.f6708b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f6707a.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    public static String a(View view) {
        return view.getClass().getName() + '@' + Integer.toHexString(view.hashCode());
    }
}
