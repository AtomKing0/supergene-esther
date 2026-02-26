package com.braze.ui.support;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import com.braze.enums.inappmessage.Orientation;
import com.braze.support.BrazeLogger;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewUtils {

    @NotNull
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("ViewUtils");

    /* JADX INFO: renamed from: com.braze.ui.support.ViewUtils$isCurrentOrientationValid$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewUtils.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Current and preferred orientation are landscape.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.support.ViewUtils$isCurrentOrientationValid$2, reason: invalid class name */
    /* JADX INFO: compiled from: ViewUtils.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Current and preferred orientation are portrait.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.support.ViewUtils$isCurrentOrientationValid$3, reason: invalid class name */
    /* JADX INFO: compiled from: ViewUtils.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        final /* synthetic */ int $currentScreenOrientation;
        final /* synthetic */ Orientation $preferredOrientation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(int i10, Orientation orientation) {
            super(0);
            this.$currentScreenOrientation = i10;
            this.$preferredOrientation = orientation;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Current orientation " + this.$currentScreenOrientation + " and preferred orientation " + this.$preferredOrientation + " don't match";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.support.ViewUtils$removeViewFromParent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ViewUtils.kt */
    static final class C12671 extends v implements a<String> {
        public static final C12671 INSTANCE = new C12671();

        C12671() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "View passed in is null. Not removing from parent.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.support.ViewUtils$removeViewFromParent$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ViewUtils.kt */
    static final class C12682 extends v implements a<String> {
        final /* synthetic */ ViewGroup $parent;
        final /* synthetic */ View $this_removeViewFromParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12682(View view, ViewGroup viewGroup) {
            super(0);
            this.$this_removeViewFromParent = view;
            this.$parent = viewGroup;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Removed view: " + this.$this_removeViewFromParent + "\nfrom parent: " + this.$parent;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.support.ViewUtils$removeViewFromParent$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ViewUtils.kt */
    static final class C12693 extends v implements a<String> {
        public static final C12693 INSTANCE = new C12693();

        C12693() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Caught exception while removing view from parent.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.support.ViewUtils$setActivityRequestedOrientation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ViewUtils.kt */
    static final class C12701 extends v implements a<String> {
        final /* synthetic */ int $requestedOrientation;
        final /* synthetic */ Activity $this_setActivityRequestedOrientation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12701(int i10, Activity activity) {
            super(0);
            this.$requestedOrientation = i10;
            this.$this_setActivityRequestedOrientation = activity;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to set requested orientation " + this.$requestedOrientation + " for activity class: " + this.$this_setActivityRequestedOrientation.getLocalClassName();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.support.ViewUtils$setFocusableInTouchModeAndRequestFocus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ViewUtils.kt */
    static final class C12711 extends v implements a<String> {
        public static final C12711 INSTANCE = new C12711();

        C12711() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Caught exception while setting view to focusable in touch mode and requesting focus.";
        }
    }

    public static final double convertDpToPixels(@NotNull Context context, double d10) {
        t.i(context, "context");
        return d10 * ((double) context.getResources().getDisplayMetrics().density);
    }

    public static final int getMaxSafeBottomInset(@NotNull WindowInsetsCompat windowInsets) {
        t.i(windowInsets, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsets.getDisplayCutout();
        return Math.max(displayCutout != null ? displayCutout.getSafeInsetBottom() : 0, windowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
    }

    public static final int getMaxSafeLeftInset(@NotNull WindowInsetsCompat windowInsets) {
        t.i(windowInsets, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsets.getDisplayCutout();
        return Math.max(displayCutout != null ? displayCutout.getSafeInsetLeft() : 0, windowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).left);
    }

    public static final int getMaxSafeRightInset(@NotNull WindowInsetsCompat windowInsets) {
        t.i(windowInsets, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsets.getDisplayCutout();
        return Math.max(displayCutout != null ? displayCutout.getSafeInsetRight() : 0, windowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).right);
    }

    public static final int getMaxSafeTopInset(@NotNull WindowInsetsCompat windowInsets) {
        t.i(windowInsets, "windowInsets");
        DisplayCutoutCompat displayCutout = windowInsets.getDisplayCutout();
        return Math.max(displayCutout != null ? displayCutout.getSafeInsetTop() : 0, windowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).top);
    }

    public static final boolean isCurrentOrientationValid(int i10, @NotNull Orientation preferredOrientation) {
        t.i(preferredOrientation, "preferredOrientation");
        if (i10 == 2 && preferredOrientation == Orientation.LANDSCAPE) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 12, (Object) null);
            return true;
        }
        if (i10 == 1 && preferredOrientation == Orientation.PORTRAIT) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, false, (a) AnonymousClass2.INSTANCE, 12, (Object) null);
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, false, (a) new AnonymousClass3(i10, preferredOrientation), 12, (Object) null);
        return false;
    }

    public static final boolean isDeviceInNightMode(@NotNull Context context) {
        t.i(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final boolean isDeviceNotInTouchMode(@NotNull View view) {
        t.i(view, "view");
        return !view.isInTouchMode();
    }

    public static final boolean isRunningOnTablet(@NotNull Activity activity) {
        t.i(activity, "<this>");
        return activity.getResources().getConfiguration().smallestScreenWidthDp >= 600;
    }

    public static final void removeViewFromParent(@Nullable View view) {
        if (view == null) {
            try {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, false, (a) C12671.INSTANCE, 12, (Object) null);
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C12693.INSTANCE, 8, (Object) null);
                return;
            }
        }
        if ((view != null ? view.getParent() : null) instanceof ViewGroup) {
            ViewParent parent = view.getParent();
            t.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.removeView(view);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.D, (Throwable) null, false, (a) new C12682(view, viewGroup), 12, (Object) null);
        }
    }

    public static final void setActivityRequestedOrientation(@NotNull Activity activity, int i10) {
        t.i(activity, "<this>");
        try {
            activity.setRequestedOrientation(i10);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new C12701(i10, activity), 8, (Object) null);
        }
    }

    public static final void setFocusableInTouchModeAndRequestFocus(@NotNull View view) {
        t.i(view, "<this>");
        try {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C12711.INSTANCE, 8, (Object) null);
        }
    }

    public static final void setHeightOnViewLayoutParams(@NotNull View view, int i10) {
        t.i(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }
}
