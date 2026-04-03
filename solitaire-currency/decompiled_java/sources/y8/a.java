package y8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Thread.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: y8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Thread.kt */
    public static final class C0754a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h9.a<k0> f36902a;

        C0754a(h9.a<k0> aVar) {
            this.f36902a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f36902a.invoke();
        }
    }

    @NotNull
    public static final Thread a(boolean z10, boolean z11, @Nullable ClassLoader classLoader, @Nullable String str, int i10, @NotNull h9.a<k0> block) {
        t.i(block, "block");
        C0754a c0754a = new C0754a(block);
        if (z11) {
            c0754a.setDaemon(true);
        }
        if (i10 > 0) {
            c0754a.setPriority(i10);
        }
        if (str != null) {
            c0754a.setName(str);
        }
        if (classLoader != null) {
            c0754a.setContextClassLoader(classLoader);
        }
        if (z10) {
            c0754a.start();
        }
        return c0754a;
    }

    public static /* synthetic */ Thread b(boolean z10, boolean z11, ClassLoader classLoader, String str, int i10, h9.a aVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        boolean z12 = z10;
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        boolean z13 = z11;
        ClassLoader classLoader2 = (i11 & 4) != 0 ? null : classLoader;
        String str2 = (i11 & 8) != 0 ? null : str;
        if ((i11 & 16) != 0) {
            i10 = -1;
        }
        return a(z12, z13, classLoader2, str2, i10, aVar);
    }
}
