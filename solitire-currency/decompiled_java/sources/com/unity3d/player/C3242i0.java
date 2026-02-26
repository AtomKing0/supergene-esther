package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: com.unity3d.player.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3242i0 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C3235f f24118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private UnityPlayer f24119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private K f24120c;

    public C3242i0(Context context, UnityPlayer unityPlayer) {
        int i10;
        super(context);
        this.f24120c = new K(context);
        this.f24119b = unityPlayer;
        C3235f c3235f = new C3235f(context, unityPlayer);
        this.f24118a = c3235f;
        c3235f.setId(context.getResources().getIdentifier("unitySurfaceView", "id", context.getPackageName()));
        if (a()) {
            this.f24118a.getHolder().setFormat(-3);
            this.f24118a.setZOrderOnTop(true);
            i10 = 0;
        } else {
            this.f24118a.getHolder().setFormat(-1);
            i10 = ViewCompat.MEASURED_STATE_MASK;
        }
        setBackgroundColor(i10);
        this.f24118a.getHolder().addCallback(new SurfaceHolderCallbackC3240h0(this));
        this.f24118a.setFocusable(true);
        this.f24118a.setFocusableInTouchMode(true);
        this.f24118a.setContentDescription(a(context));
        addView(this.f24118a, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private static String a(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", TypedValues.Custom.S_STRING, context.getPackageName()));
    }

    public final void b() {
        K k10 = this.f24120c;
        UnityPlayer unityPlayer = this.f24119b;
        J j10 = k10.f23951b;
        if (j10 != null && j10.getParent() != null) {
            unityPlayer.removeView(k10.f23951b);
        }
        this.f24120c.f23951b = null;
    }

    public final boolean c() {
        C3235f c3235f = this.f24118a;
        return c3235f != null && c3235f.a();
    }

    final void a(float f10) {
        this.f24118a.a(f10);
    }

    private static boolean a() {
        Activity activity = UnityPlayer.currentActivity;
        if (activity == null) {
            return false;
        }
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent});
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z10;
    }
}
