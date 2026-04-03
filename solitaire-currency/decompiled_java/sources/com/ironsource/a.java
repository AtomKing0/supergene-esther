package com.ironsource;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class a extends Thread {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f11164l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final com.ironsource.b f11165m = new C0249a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ih f11166n = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11170d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ironsource.b f11167a = f11165m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ih f11168b = f11166n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f11169c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11171e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11172f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11173g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile int f11174h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11175i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11176j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f11177k = new c();

    class b implements ih {
        b() {
        }

        @Override // com.ironsource.ih
        public void a(InterruptedException interruptedException) {
            Log.w("ANRHandler", "Interrupted: " + interruptedException.getMessage());
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f11174h = (aVar.f11174h + 1) % Integer.MAX_VALUE;
        }
    }

    public a(int i10) {
        this.f11170d = i10;
    }

    public int a() {
        return this.f11176j;
    }

    public int b() {
        return this.f11175i;
    }

    public a c() {
        this.f11171e = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setName("|ANR-ANRHandler|");
        int i10 = -1;
        while (!isInterrupted() && this.f11176j < this.f11175i) {
            int i11 = this.f11174h;
            this.f11169c.post(this.f11177k);
            try {
                Thread.sleep(this.f11170d);
                if (this.f11174h != i11) {
                    this.f11176j = 0;
                } else if (this.f11173g || !Debug.isDebuggerConnected()) {
                    this.f11176j++;
                    this.f11167a.a();
                    String str = i9.f12568l;
                    if (str != null && !str.trim().isEmpty()) {
                        new wb(i9.f12568l, String.valueOf(System.currentTimeMillis()), "ANR").a();
                    }
                } else {
                    if (this.f11174h != i10) {
                        Log.w("ANRHandler", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                    }
                    i10 = this.f11174h;
                }
            } catch (InterruptedException e10) {
                this.f11168b.a(e10);
                return;
            }
        }
        if (this.f11176j >= this.f11175i) {
            this.f11167a.b();
        }
    }

    public a b(boolean z10) {
        this.f11172f = z10;
        return this;
    }

    public a a(com.ironsource.b bVar) {
        if (bVar == null) {
            bVar = f11165m;
        }
        this.f11167a = bVar;
        return this;
    }

    public a a(ih ihVar) {
        if (ihVar == null) {
            ihVar = f11166n;
        }
        this.f11168b = ihVar;
        return this;
    }

    public a a(String str) {
        if (str == null) {
            str = "";
        }
        this.f11171e = str;
        return this;
    }

    public a a(boolean z10) {
        this.f11173g = z10;
        return this;
    }

    private String a(StackTraceElement[] stackTraceElementArr) {
        String str = "";
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (stackTraceElement != null) {
                    str = str + stackTraceElement.toString() + ";\n";
                }
            }
        }
        return str;
    }

    public void a(int i10) {
        this.f11175i = i10;
    }

    /* JADX INFO: renamed from: com.ironsource.a$a, reason: collision with other inner class name */
    class C0249a implements com.ironsource.b {
        C0249a() {
        }

        @Override // com.ironsource.b
        public void b() {
            throw new RuntimeException("ANRHandler has given up");
        }

        @Override // com.ironsource.b
        public void a() {
        }
    }
}
