package io.sentry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonObjectDeserializer.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<c> f27629a = new ArrayList<>();

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27630a;

        static {
            int[] iArr = new int[io.sentry.vendor.gson.stream.b.values().length];
            f27630a = iArr;
            try {
                iArr[io.sentry.vendor.gson.stream.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27630a[io.sentry.vendor.gson.stream.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27630a[io.sentry.vendor.gson.stream.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27630a[io.sentry.vendor.gson.stream.b.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27630a[io.sentry.vendor.gson.stream.b.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f27630a[io.sentry.vendor.gson.stream.b.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f27630a[io.sentry.vendor.gson.stream.b.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f27630a[io.sentry.vendor.gson.stream.b.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f27630a[io.sentry.vendor.gson.stream.b.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f27630a[io.sentry.vendor.gson.stream.b.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    interface b {
        @Nullable
        Object a() throws IOException;
    }

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    private interface c {
        @NotNull
        Object getValue();
    }

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    private static final class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f27633a;

        f(@NotNull String str) {
            this.f27633a = str;
        }

        @Override // io.sentry.c2.c
        @NotNull
        public Object getValue() {
            return this.f27633a;
        }
    }

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    private static final class g implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f27634a;

        g(@NotNull Object obj) {
            this.f27634a = obj;
        }

        @Override // io.sentry.c2.c
        @NotNull
        public Object getValue() {
            return this.f27634a;
        }
    }

    @Nullable
    private c f() {
        if (this.f27629a.isEmpty()) {
            return null;
        }
        return this.f27629a.get(r0.size() - 1);
    }

    private boolean g() {
        if (i()) {
            return true;
        }
        c cVarF = f();
        p();
        if (!(f() instanceof f)) {
            if (!(f() instanceof d)) {
                return false;
            }
            d dVar = (d) f();
            if (cVarF == null || dVar == null) {
                return false;
            }
            dVar.f27631a.add(cVarF.getValue());
            return false;
        }
        f fVar = (f) f();
        p();
        e eVar = (e) f();
        if (fVar == null || cVarF == null || eVar == null) {
            return false;
        }
        eVar.f27632a.put(fVar.f27633a, cVarF.getValue());
        return false;
    }

    private boolean h(b bVar) throws IOException {
        Object objA = bVar.a();
        if (f() == null && objA != null) {
            q(new g(objA));
            return true;
        }
        if (f() instanceof f) {
            f fVar = (f) f();
            p();
            ((e) f()).f27632a.put(fVar.f27633a, objA);
            return false;
        }
        if (!(f() instanceof d)) {
            return false;
        }
        ((d) f()).f27631a.add(objA);
        return false;
    }

    private boolean i() {
        return this.f27629a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object l(d2 d2Var) throws IOException {
        return Boolean.valueOf(d2Var.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object m() throws IOException {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object k(d2 d2Var) throws IOException {
        try {
            try {
                return Integer.valueOf(d2Var.nextInt());
            } catch (Exception unused) {
                return Double.valueOf(d2Var.nextDouble());
            }
        } catch (Exception unused2) {
            return Long.valueOf(d2Var.nextLong());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void o(@NotNull final d2 d2Var) throws IOException {
        boolean zG;
        a aVar = null;
        switch (a.f27630a[d2Var.peek().ordinal()]) {
            case 1:
                d2Var.a();
                q(new d(aVar));
                zG = false;
                break;
            case 2:
                d2Var.c();
                zG = g();
                break;
            case 3:
                d2Var.h();
                q(new e(aVar));
                zG = false;
                break;
            case 4:
                d2Var.k();
                zG = g();
                break;
            case 5:
                q(new f(d2Var.C()));
                zG = false;
                break;
            case 6:
                zG = h(new b() { // from class: io.sentry.y1
                    @Override // io.sentry.c2.b
                    public final Object a() {
                        return d2Var.e0();
                    }
                });
                break;
            case 7:
                zG = h(new b() { // from class: io.sentry.z1
                    @Override // io.sentry.c2.b
                    public final Object a() {
                        return this.f28522a.k(d2Var);
                    }
                });
                break;
            case 8:
                zG = h(new b() { // from class: io.sentry.a2
                    @Override // io.sentry.c2.b
                    public final Object a() {
                        return c2.l(d2Var);
                    }
                });
                break;
            case 9:
                d2Var.n();
                zG = h(new b() { // from class: io.sentry.b2
                    @Override // io.sentry.c2.b
                    public final Object a() {
                        return c2.m();
                    }
                });
                break;
            case 10:
                zG = true;
                break;
            default:
                zG = false;
                break;
        }
        if (zG) {
            return;
        }
        o(d2Var);
    }

    private void p() {
        if (this.f27629a.isEmpty()) {
            return;
        }
        this.f27629a.remove(r0.size() - 1);
    }

    private void q(c cVar) {
        this.f27629a.add(cVar);
    }

    @Nullable
    public Object e(@NotNull d2 d2Var) throws IOException {
        o(d2Var);
        c cVarF = f();
        if (cVarF != null) {
            return cVarF.getValue();
        }
        return null;
    }

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    private static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayList<Object> f27631a;

        private d() {
            this.f27631a = new ArrayList<>();
        }

        @Override // io.sentry.c2.c
        @NotNull
        public Object getValue() {
            return this.f27631a;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    private static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final HashMap<String, Object> f27632a;

        private e() {
            this.f27632a = new HashMap<>();
        }

        @Override // io.sentry.c2.c
        @NotNull
        public Object getValue() {
            return this.f27632a;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }
}
