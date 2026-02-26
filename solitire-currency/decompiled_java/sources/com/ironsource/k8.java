package com.ironsource;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class k8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f12854a = a.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList f12855b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12856c;

    enum a {
        NOT_READY,
        READY
    }

    public k8(String str) {
        this.f12856c = str;
    }

    public synchronized void a() {
        Object[] array = this.f12855b.toArray();
        for (int i10 = 0; i10 < array.length; i10++) {
            ((Runnable) array[i10]).run();
            array[i10] = null;
        }
        this.f12855b.clear();
    }

    public synchronized void b() {
        this.f12854a = a.NOT_READY;
    }

    public synchronized void c() {
        this.f12854a = a.READY;
    }

    public synchronized void a(Runnable runnable) {
        if (this.f12854a != a.READY) {
            this.f12855b.add(runnable);
        } else {
            runnable.run();
        }
    }
}
