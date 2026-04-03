package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;

/* JADX INFO: loaded from: classes4.dex */
final class X extends S {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f24042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f24043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Runnable f24044j;

    public X(Context context, UnityPlayer unityPlayer) {
        super(context, unityPlayer);
        this.f24042h = false;
    }

    @Override // com.unity3d.player.S
    public final void a(boolean z10) {
        EditText editText;
        int i10;
        this.f24004d = z10;
        if (z10) {
            editText = this.f24003c;
            i10 = 4;
        } else {
            editText = this.f24003c;
            i10 = 0;
        }
        editText.setVisibility(i10);
        this.f24003c.invalidate();
        this.f24003c.requestLayout();
    }

    @Override // com.unity3d.player.S
    public final void c() {
        Runnable runnable;
        Handler handler = this.f24043i;
        if (handler != null && (runnable = this.f24044j) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f24002b.removeView(this.f24003c);
        this.f24042h = false;
        invokeOnClose();
    }

    @Override // com.unity3d.player.S
    protected EditText createEditText(S s10) {
        return new W(this.f24001a, s10);
    }

    @Override // com.unity3d.player.S
    public final boolean d() {
        return false;
    }

    @Override // com.unity3d.player.S
    public final void e() {
        if (this.f24042h) {
            return;
        }
        this.f24002b.addView(this.f24003c);
        this.f24002b.bringChildToFront(this.f24003c);
        this.f24003c.setVisibility(0);
        this.f24003c.requestFocus();
        this.f24044j = new V(this);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f24043i = handler;
        handler.postDelayed(this.f24044j, 400L);
        this.f24042h = true;
    }
}
