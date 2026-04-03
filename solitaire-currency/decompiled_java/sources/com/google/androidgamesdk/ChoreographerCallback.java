package com.google.androidgamesdk;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes3.dex */
public class ChoreographerCallback implements Choreographer.FrameCallback {
    private static final String LOG_TAG = "ChoreographerCallback";
    private long mCookie;
    private b mLooper;

    public ChoreographerCallback(long j10) {
        this.mCookie = j10;
        b bVar = new b();
        this.mLooper = bVar;
        bVar.start();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        nOnChoreographer(this.mCookie, j10);
    }

    public native void nOnChoreographer(long j10, long j11);

    public void postFrameCallback() {
        this.mLooper.f9967a.post(new a(this));
    }

    public void postFrameCallbackDelayed(long j10) {
        Choreographer.getInstance().postFrameCallbackDelayed(this, j10);
    }

    public void terminate() {
        this.mLooper.f9967a.getLooper().quit();
    }
}
