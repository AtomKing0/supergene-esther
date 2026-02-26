package com.onetrust.otpublishers.headless.UI.mobiledatautils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.onetrust.otpublishers.headless.Internal.Helper.k;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23606a;

        public a(String str) {
            this.f23606a = str;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, this.f23606a));
        }
    }

    public static void a(Context context, com.google.android.material.bottomsheet.a aVar) {
        int i10;
        FrameLayout frameLayout = (FrameLayout) aVar.findViewById(p6.d.f32685f1);
        if (frameLayout != null) {
            BottomSheetBehavior bottomSheetBehaviorM = BottomSheetBehavior.M(frameLayout);
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (context == null) {
                i10 = 0;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                i10 = displayMetrics.heightPixels;
            }
            if (layoutParams != null) {
                layoutParams.height = (i10 * 2) / 3;
            }
            frameLayout.setLayoutParams(layoutParams);
            bottomSheetBehaviorM.s0(3);
            bottomSheetBehaviorM.n0(frameLayout.getMeasuredHeight());
        }
    }

    public static void b(@NonNull Context context, @NonNull String str, ViewGroup viewGroup, int i10) {
        if (viewGroup != null) {
            TextView textView = new TextView(context);
            textView.setVisibility(0);
            textView.setHeight(0);
            textView.setWidth(0);
            textView.setText(str);
            viewGroup.addView(textView);
            ViewCompat.setLabelFor(textView, i10);
        }
    }

    public static void c(@NonNull CompoundButton compoundButton, int i10, int i11) {
        compoundButton.setButtonTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{i10, i11}));
    }

    public static void d(@NonNull TextView textView, String str) {
        ViewCompat.setAccessibilityDelegate(textView, new a(str));
    }

    public static void e(@NonNull com.google.android.material.bottomsheet.b bVar, @NonNull FragmentActivity fragmentActivity, @NonNull String str) {
        try {
            bVar.show(fragmentActivity.getSupportFragmentManager(), str);
        } catch (IllegalStateException e10) {
            OTLogger.a("OneTrust", 3, "Activity in illegal state to add a Banner fragment " + e10);
            if (fragmentActivity == null) {
                OTLogger.a("OneTrust", 6, "showUIOnForeground : Activity is null - ".concat(str));
            } else if (fragmentActivity.isDestroyed()) {
                OTLogger.a("OneTrust", 6, "showUIOnForeground : Activity is destroyed - ".concat(str));
            } else {
                fragmentActivity.getLifecycle().addObserver(new b(bVar, fragmentActivity, str));
            }
        }
    }

    public static void f(String str, Context context, View view) {
        boolean zE = k.e(context);
        OTLogger.a(str, 3, "useRTL: " + zE);
        if (zE) {
            view.setLayoutDirection(1);
        }
    }

    public static void g(@Nullable String str, @NonNull View view) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return;
        }
        view.setBackgroundColor(Color.parseColor(str));
    }

    public static boolean h(@NonNull Context context) {
        if (!((AccessibilityManager) context.getSystemService("accessibility")).isEnabled()) {
            return false;
        }
        OTLogger.a("OneTrust", 3, "isAccessibilityEnabled - true");
        return true;
    }

    public static boolean i(@Nullable Context context, String str) {
        if (context != null) {
            return true;
        }
        OTLogger.a("OneTrust", 6, "Context is null - ".concat(str));
        return false;
    }

    public static void j(@NonNull com.google.android.material.bottomsheet.b bVar, @NonNull FragmentActivity fragmentActivity, @NonNull String str) {
        bVar.show(fragmentActivity.getSupportFragmentManager().beginTransaction().remove(bVar), str);
    }
}
