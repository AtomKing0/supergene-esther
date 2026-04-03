package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media3.common.PlaybackException;

/* JADX INFO: loaded from: classes4.dex */
final class U extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f24020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected UnityPlayer f24021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected P f24022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected S f24023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private C f24024e;

    public U(Context context, UnityPlayer unityPlayer) {
        super(context);
        this.f24022c = null;
        this.f24023d = null;
        this.f24024e = null;
        this.f24020a = context;
        this.f24021b = unityPlayer;
    }

    public final Rect a() {
        Rect rect = new Rect();
        this.f24021b.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        this.f24021b.getLocationOnScreen(iArr);
        Point point = new Point(rect.left - iArr[0], rect.height() - this.f24022c.getHeight());
        Point point2 = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point2);
        int height = this.f24021b.getHeight();
        int i10 = height - point2.y;
        int i11 = height - point.y;
        int height2 = this.f24022c.getHeight() + i10;
        UnityPlayer unityPlayer = this.f24021b;
        if (i11 != height2) {
            unityPlayer.reportSoftInputIsVisible(true);
        } else {
            unityPlayer.reportSoftInputIsVisible(false);
        }
        return new Rect(point.x, point.y, this.f24022c.getWidth(), i11);
    }

    public final void b() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (!PlatformSupport.VANILLA_ICE_CREAM_SUPPORT) {
            getWindow().setBackgroundDrawable(colorDrawable);
            return;
        }
        Insets insets = this.f24021b.getActivity().getWindow().getDecorView().getRootWindowInsets().getInsets(WindowInsets.Type.displayCutout());
        getWindow().setBackgroundDrawable(new InsetDrawable((Drawable) colorDrawable, insets.left, insets.top, insets.right, 0));
    }

    protected P createSoftInputView(EditText editText) {
        P p10 = new P(this.f24020a, editText);
        p10.f23979a.setOnClickListener(this);
        setContentView(p10);
        return p10;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f24023d.d() || !(motionEvent.getAction() == 4 || this.f24023d.f24004d)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Runnable runnable;
        C c10 = this.f24024e;
        if (c10 != null) {
            y6.c cVar = c10.f23918a;
            if (!(cVar != null) || (runnable = ((B) cVar).f23916a) == null) {
                return;
            }
            runnable.run();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        S s10 = this.f24023d;
        s10.a(s10.b(), false);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        C c10 = this.f24024e;
        if (c10 != null) {
            c10.unregisterOnBackPressedCallback();
            this.f24024e = null;
        }
        super.onStop();
    }

    public final void a(S s10, boolean z10, boolean z11) {
        this.f24023d = s10;
        Window window = getWindow();
        window.requestFeature(1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        b();
        this.f24022c = createSoftInputView(this.f24023d.f24003c);
        window.setLayout(-1, -2);
        window.clearFlags(2);
        window.clearFlags(androidx.media3.common.C.BUFFER_FLAG_FIRST_SAMPLE);
        window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        if (!z11) {
            window.addFlags(32);
            window.addFlags(262144);
        }
        a(z10);
        getWindow().setSoftInputMode(5);
        this.f24024e = D.a(this, PlaybackException.CUSTOM_ERROR_CODE_BASE, new T(this));
    }

    public final void a(boolean z10) {
        P p10 = this.f24022c;
        if (z10) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) p10.f23980b.getLayoutParams();
            layoutParams.height = 1;
            p10.f23980b.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) p10.f23979a.getLayoutParams();
            layoutParams2.height = 1;
            p10.f23979a.setLayoutParams(layoutParams2);
            Rect rect = p10.f23983e;
            p10.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            p10.setVisibility(4);
        } else {
            p10.setVisibility(0);
            Rect rect2 = p10.f23982d;
            p10.setPadding(rect2.left, rect2.top, rect2.right, rect2.bottom);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) p10.f23980b.getLayoutParams();
            layoutParams3.height = -2;
            p10.f23980b.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) p10.f23979a.getLayoutParams();
            layoutParams4.height = -2;
            p10.f23979a.setLayoutParams(layoutParams4);
        }
        p10.invalidate();
        p10.requestLayout();
    }
}
