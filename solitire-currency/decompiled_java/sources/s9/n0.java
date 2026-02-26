package s9;

import androidx.media3.exoplayer.RendererCapabilities;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
final class n0<T> extends t9.b<p0> implements y<T>, c<T>, t9.p<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f33737f = AtomicReferenceFieldUpdater.newUpdater(n0.class, Object.class, "_state");

    @Nullable
    private volatile Object _state;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f33738e;

    /* JADX INFO: compiled from: StateFlow.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {RendererCapabilities.DECODER_SUPPORT_MASK, 396, 401}, m = "collect")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33739j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33740k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f33741l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f33742m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f33743n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        /* synthetic */ Object f33744o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ n0<T> f33745p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f33746q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(n0<T> n0Var, z8.d<? super a> dVar) {
            super(dVar);
            this.f33745p = n0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33744o = obj;
            this.f33746q |= Integer.MIN_VALUE;
            return this.f33745p.collect(null, this);
        }
    }

    public n0(@NotNull Object obj) {
        this._state = obj;
    }

    private final boolean p(Object obj, Object obj2) {
        int i10;
        p0[] p0VarArrM;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f33737f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.t.d(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.t.d(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i11 = this.f33738e;
            if ((i11 & 1) != 0) {
                this.f33738e = i11 + 2;
                return true;
            }
            int i12 = i11 + 1;
            this.f33738e = i12;
            p0[] p0VarArrM2 = m();
            v8.k0 k0Var = v8.k0.f35197a;
            while (true) {
                p0[] p0VarArr = p0VarArrM2;
                if (p0VarArr != null) {
                    for (p0 p0Var : p0VarArr) {
                        if (p0Var != null) {
                            p0Var.g();
                        }
                    }
                }
                synchronized (this) {
                    i10 = this.f33738e;
                    if (i10 == i12) {
                        this.f33738e = i12 + 1;
                        return true;
                    }
                    p0VarArrM = m();
                    v8.k0 k0Var2 = v8.k0.f35197a;
                }
                p0VarArrM2 = p0VarArrM;
                i12 = i10;
            }
        }
    }

    @Override // s9.x
    public boolean a(T t10) {
        setValue(t10);
        return true;
    }

    @Override // t9.p
    @NotNull
    public h<T> b(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        return o0.d(this, gVar, i10, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:38:0x00b3, B:40:0x00b9], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:40:0x00b9, B:38:0x00b3], limit reached: 57 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00da A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [t9.d] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, s9.p0] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, s9.i] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d8 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ea -> B:34:0x00a6). Please report as a decompilation issue!!! */
    @Override // s9.c0, s9.h
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull s9.i<? super T> r11, @org.jetbrains.annotations.NotNull z8.d<?> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.n0.collect(s9.i, z8.d):java.lang.Object");
    }

    @Override // s9.y
    public boolean d(T t10, T t11) {
        if (t10 == null) {
            t10 = (T) t9.s.f34171a;
        }
        if (t11 == null) {
            t11 = (T) t9.s.f34171a;
        }
        return p(t10, t11);
    }

    @Override // s9.x
    public void e() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // s9.x, s9.i
    @Nullable
    public Object emit(T t10, @NotNull z8.d<? super v8.k0> dVar) {
        setValue(t10);
        return v8.k0.f35197a;
    }

    @Override // s9.y, s9.m0
    public T getValue() {
        u9.h0 h0Var = t9.s.f34171a;
        T t10 = (T) f33737f.get(this);
        if (t10 == h0Var) {
            return null;
        }
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // t9.b
    @NotNull
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public p0 i() {
        return new p0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // t9.b
    @NotNull
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public p0[] j(int i10) {
        return new p0[i10];
    }

    @Override // s9.y
    public void setValue(T t10) {
        if (t10 == null) {
            t10 = (T) t9.s.f34171a;
        }
        p(null, t10);
    }
}
