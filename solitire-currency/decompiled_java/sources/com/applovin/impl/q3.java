package com.applovin.impl;

import android.os.Process;
import androidx.core.util.Consumer;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PriorityBlockingQueue f6652a = new PriorityBlockingQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6653b;

    /* JADX INFO: Access modifiers changed from: private */
    static class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BlockingQueue f6654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f6655b;

        private void a() {
            b((c) this.f6654a.take());
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        private b(BlockingQueue blockingQueue, int i10, com.applovin.impl.sdk.j jVar) {
            super("AppLovinSdk:network");
            if (blockingQueue == null) {
                throw new IllegalArgumentException("No request queue specified");
            }
            if (jVar == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            this.f6654a = blockingQueue;
            this.f6655b = jVar;
            setPriority(((Integer) jVar.a(l4.Q)).intValue());
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00ce A[Catch: all -> 0x0149, TRY_LEAVE, TryCatch #4 {all -> 0x0149, blocks: (B:55:0x00b6, B:57:0x00ce, B:74:0x00fa, B:59:0x00db, B:62:0x00e7, B:72:0x00f8, B:71:0x00f5), top: B:89:0x00b6, inners: #11 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void b(final com.applovin.impl.q3.c r17) {
            /*
                Method dump skipped, instruction units count: 336
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.q3.b.b(com.applovin.impl.q3$c):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(c cVar, d dVar) {
            cVar.f6662f.accept(dVar);
        }

        private HttpURLConnection a(c cVar) throws ProtocolException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(cVar.f6657a).openConnection();
            httpURLConnection.setRequestMethod(cVar.f6658b);
            httpURLConnection.setConnectTimeout(cVar.f6661e);
            httpURLConnection.setReadTimeout(cVar.f6661e);
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoInput(true);
            if (!cVar.f6659c.isEmpty()) {
                for (Map.Entry entry : cVar.f6659c.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return httpURLConnection;
        }
    }

    public static class c implements Comparable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final AtomicInteger f6656i = new AtomicInteger();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f6659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f6660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f6661e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Consumer f6662f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Executor f6663g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f6664h;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f6665a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f6666b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private Map f6667c = new HashMap();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private byte[] f6668d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f6669e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private Consumer f6670f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private Executor f6671g;

            public a a(String str) {
                this.f6665a = str;
                return this;
            }

            public a b(String str) {
                this.f6666b = str;
                return this;
            }

            public a a(Map map) {
                if (map == null) {
                    map = new HashMap();
                }
                this.f6667c = map;
                return this;
            }

            public a a(String str, String str2) {
                this.f6667c.put(str, str2);
                return this;
            }

            public a a(byte[] bArr) {
                this.f6668d = bArr;
                return this;
            }

            public a a(int i10) {
                this.f6669e = i10;
                return this;
            }

            public a a(Consumer consumer) {
                this.f6670f = consumer;
                return this;
            }

            public a a(Executor executor) {
                this.f6671g = executor;
                return this;
            }

            public c a() {
                return new c(this);
            }
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return this.f6664h - cVar.f6664h;
        }

        private c(a aVar) {
            this.f6657a = aVar.f6665a;
            this.f6658b = aVar.f6666b;
            this.f6659c = aVar.f6667c != null ? aVar.f6667c : Collections.emptyMap();
            this.f6660d = aVar.f6668d;
            this.f6661e = aVar.f6669e;
            this.f6662f = aVar.f6670f;
            this.f6663g = aVar.f6671g;
            this.f6664h = f6656i.incrementAndGet();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f6673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f6674c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f6675d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Throwable f6676e;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f6677a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private byte[] f6678b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private byte[] f6679c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private long f6680d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Throwable f6681e;

            public a a(int i10) {
                this.f6677a = i10;
                return this;
            }

            public a b(byte[] bArr) {
                this.f6679c = bArr;
                return this;
            }

            public a a(byte[] bArr) {
                this.f6678b = bArr;
                return this;
            }

            public a a(Throwable th) {
                this.f6681e = th;
                return this;
            }

            public a a(long j10) {
                this.f6680d = j10;
                return this;
            }

            public d a() {
                return new d(this);
            }
        }

        public static a a() {
            return new a();
        }

        public int b() {
            return this.f6672a;
        }

        public int c() throws Throwable {
            Throwable th = this.f6676e;
            if (th == null) {
                return this.f6672a;
            }
            throw th;
        }

        public byte[] d() throws Throwable {
            Throwable th = this.f6676e;
            if (th == null) {
                return this.f6673b;
            }
            throw th;
        }

        public long e() {
            return this.f6675d;
        }

        public byte[] f() {
            return this.f6674c;
        }

        private d(a aVar) {
            this.f6672a = aVar.f6677a;
            this.f6673b = aVar.f6678b;
            this.f6674c = aVar.f6679c;
            this.f6675d = aVar.f6680d;
            this.f6676e = aVar.f6681e;
        }
    }

    public q3(com.applovin.impl.sdk.j jVar) {
        this.f6653b = jVar;
    }

    public void a() {
        for (int i10 = 0; i10 < ((Integer) this.f6653b.a(l4.P)).intValue(); i10++) {
            new b(this.f6652a, i10, this.f6653b).start();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.f6652a.add(cVar);
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }
}
