package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes3.dex */
class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static b f9646e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Object f9647a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final Handler f9648b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private c f9649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private c f9650d;

    /* JADX INFO: compiled from: SnackbarManager.java */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SnackbarManager.java */
    interface InterfaceC0217b {
        void a(int i10);

        void show();
    }

    /* JADX INFO: compiled from: SnackbarManager.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        final WeakReference<InterfaceC0217b> f9652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f9654c;

        c(int i10, InterfaceC0217b interfaceC0217b) {
            this.f9652a = new WeakReference<>(interfaceC0217b);
            this.f9653b = i10;
        }

        boolean a(@Nullable InterfaceC0217b interfaceC0217b) {
            return interfaceC0217b != null && this.f9652a.get() == interfaceC0217b;
        }
    }

    private b() {
    }

    private boolean a(@NonNull c cVar, int i10) {
        InterfaceC0217b interfaceC0217b = cVar.f9652a.get();
        if (interfaceC0217b == null) {
            return false;
        }
        this.f9648b.removeCallbacksAndMessages(cVar);
        interfaceC0217b.a(i10);
        return true;
    }

    static b c() {
        if (f9646e == null) {
            f9646e = new b();
        }
        return f9646e;
    }

    private boolean f(InterfaceC0217b interfaceC0217b) {
        c cVar = this.f9649c;
        return cVar != null && cVar.a(interfaceC0217b);
    }

    private boolean g(InterfaceC0217b interfaceC0217b) {
        c cVar = this.f9650d;
        return cVar != null && cVar.a(interfaceC0217b);
    }

    private void l(@NonNull c cVar) {
        int i10 = cVar.f9653b;
        if (i10 == -2) {
            return;
        }
        if (i10 <= 0) {
            i10 = i10 == -1 ? 1500 : 2750;
        }
        this.f9648b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f9648b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i10);
    }

    private void n() {
        c cVar = this.f9650d;
        if (cVar != null) {
            this.f9649c = cVar;
            this.f9650d = null;
            InterfaceC0217b interfaceC0217b = cVar.f9652a.get();
            if (interfaceC0217b != null) {
                interfaceC0217b.show();
            } else {
                this.f9649c = null;
            }
        }
    }

    public void b(InterfaceC0217b interfaceC0217b, int i10) {
        synchronized (this.f9647a) {
            if (f(interfaceC0217b)) {
                a(this.f9649c, i10);
            } else if (g(interfaceC0217b)) {
                a(this.f9650d, i10);
            }
        }
    }

    void d(@NonNull c cVar) {
        synchronized (this.f9647a) {
            if (this.f9649c == cVar || this.f9650d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(InterfaceC0217b interfaceC0217b) {
        boolean z10;
        synchronized (this.f9647a) {
            z10 = f(interfaceC0217b) || g(interfaceC0217b);
        }
        return z10;
    }

    public void h(InterfaceC0217b interfaceC0217b) {
        synchronized (this.f9647a) {
            if (f(interfaceC0217b)) {
                this.f9649c = null;
                if (this.f9650d != null) {
                    n();
                }
            }
        }
    }

    public void i(InterfaceC0217b interfaceC0217b) {
        synchronized (this.f9647a) {
            if (f(interfaceC0217b)) {
                l(this.f9649c);
            }
        }
    }

    public void j(InterfaceC0217b interfaceC0217b) {
        synchronized (this.f9647a) {
            if (f(interfaceC0217b)) {
                c cVar = this.f9649c;
                if (!cVar.f9654c) {
                    cVar.f9654c = true;
                    this.f9648b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void k(InterfaceC0217b interfaceC0217b) {
        synchronized (this.f9647a) {
            if (f(interfaceC0217b)) {
                c cVar = this.f9649c;
                if (cVar.f9654c) {
                    cVar.f9654c = false;
                    l(cVar);
                }
            }
        }
    }

    public void m(int i10, InterfaceC0217b interfaceC0217b) {
        synchronized (this.f9647a) {
            if (f(interfaceC0217b)) {
                c cVar = this.f9649c;
                cVar.f9653b = i10;
                this.f9648b.removeCallbacksAndMessages(cVar);
                l(this.f9649c);
                return;
            }
            if (g(interfaceC0217b)) {
                this.f9650d.f9653b = i10;
            } else {
                this.f9650d = new c(i10, interfaceC0217b);
            }
            c cVar2 = this.f9649c;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.f9649c = null;
                n();
            }
        }
    }
}
