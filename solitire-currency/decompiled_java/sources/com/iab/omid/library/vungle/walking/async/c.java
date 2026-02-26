package com.iab.omid.library.vungle.walking.async;

import com.iab.omid.library.vungle.walking.async.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Runnable> f11154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f11155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<b> f11156c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f11157d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f11154a = linkedBlockingQueue;
        this.f11155b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void a() {
        b bVarPoll = this.f11156c.poll();
        this.f11157d = bVarPoll;
        if (bVarPoll != null) {
            bVarPoll.a(this.f11155b);
        }
    }

    public void b(b bVar) {
        bVar.a(this);
        this.f11156c.add(bVar);
        if (this.f11157d == null) {
            a();
        }
    }

    @Override // com.iab.omid.library.vungle.walking.async.b.a
    public void a(b bVar) {
        this.f11157d = null;
        a();
    }
}
