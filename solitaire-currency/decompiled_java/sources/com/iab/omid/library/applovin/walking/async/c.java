package com.iab.omid.library.applovin.walking.async;

import com.iab.omid.library.applovin.walking.async.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Runnable> f10766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f10767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<b> f10768c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f10769d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f10766a = linkedBlockingQueue;
        this.f10767b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b bVarPoll = this.f10768c.poll();
        this.f10769d = bVarPoll;
        if (bVarPoll != null) {
            bVarPoll.a(this.f10767b);
        }
    }

    public void b(b bVar) {
        bVar.a(this);
        this.f10768c.add(bVar);
        if (this.f10769d == null) {
            a();
        }
    }

    @Override // com.iab.omid.library.applovin.walking.async.b.a
    public void a(b bVar) {
        this.f10769d = null;
        a();
    }
}
