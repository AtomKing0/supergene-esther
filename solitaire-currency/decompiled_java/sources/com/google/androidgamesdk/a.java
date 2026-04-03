package com.google.androidgamesdk;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes3.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ChoreographerCallback f9966a;

    a(ChoreographerCallback choreographerCallback) {
        this.f9966a = choreographerCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().postFrameCallback(this.f9966a);
    }
}
