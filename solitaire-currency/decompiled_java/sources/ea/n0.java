package ea;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonTreeReader.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ea.a f25460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f25461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25462c;

    /* JADX INFO: compiled from: JsonTreeReader.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {112}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.k implements h9.q<v8.c<v8.k0, JsonElement>, v8.k0, z8.d<? super JsonElement>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f25463j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f25464k;

        a(z8.d<? super a> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull v8.c<v8.k0, JsonElement> cVar, @NotNull v8.k0 k0Var, @Nullable z8.d<? super JsonElement> dVar) {
            a aVar = n0.this.new a(dVar);
            aVar.f25464k = cVar;
            return aVar.invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f25463j;
            if (i10 == 0) {
                v8.u.b(obj);
                v8.c cVar = (v8.c) this.f25464k;
                byte bE = n0.this.f25460a.E();
                if (bE == 1) {
                    return n0.this.j(true);
                }
                if (bE == 0) {
                    return n0.this.j(false);
                }
                if (bE != 6) {
                    if (bE == 8) {
                        return n0.this.f();
                    }
                    ea.a.y(n0.this.f25460a, "Can't begin reading element, unexpected token", 0, null, 6, null);
                    throw new v8.h();
                }
                n0 n0Var = n0.this;
                this.f25463j = 1;
                obj = n0Var.h(cVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return (JsonElement) obj;
        }
    }

    /* JADX INFO: compiled from: JsonTreeReader.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", l = {23}, m = "readObject")
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f25466j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f25467k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f25468l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f25469m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f25470n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f25472p;

        b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f25470n = obj;
            this.f25472p |= Integer.MIN_VALUE;
            return n0.this.h(null, this);
        }
    }

    public n0(@NotNull kotlinx.serialization.json.e configuration, @NotNull ea.a lexer) {
        kotlin.jvm.internal.t.i(configuration, "configuration");
        kotlin.jvm.internal.t.i(lexer, "lexer");
        this.f25460a = lexer;
        this.f25461b = configuration.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement f() {
        byte bM = this.f25460a.m();
        if (this.f25460a.E() == 4) {
            ea.a.y(this.f25460a, "Unexpected leading comma", 0, null, 6, null);
            throw new v8.h();
        }
        ArrayList arrayList = new ArrayList();
        while (this.f25460a.f()) {
            arrayList.add(e());
            bM = this.f25460a.m();
            if (bM != 4) {
                ea.a aVar = this.f25460a;
                boolean z10 = bM == 9;
                int i10 = aVar.f25411a;
                if (!z10) {
                    ea.a.y(aVar, "Expected end of the array or comma", i10, null, 4, null);
                    throw new v8.h();
                }
            }
        }
        if (bM == 8) {
            this.f25460a.n((byte) 9);
        } else if (bM == 4) {
            ea.a.y(this.f25460a, "Unexpected trailing comma", 0, null, 6, null);
            throw new v8.h();
        }
        return new JsonArray(arrayList);
    }

    private final JsonElement g() {
        return (JsonElement) v8.b.b(new v8.a(new a(null)), v8.k0.f35197a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009c -> B:27:0x00a6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(v8.c<v8.k0, kotlinx.serialization.json.JsonElement> r21, z8.d<? super kotlinx.serialization.json.JsonElement> r22) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.n0.h(v8.c, z8.d):java.lang.Object");
    }

    private final JsonElement i() {
        byte bN = this.f25460a.n((byte) 6);
        if (this.f25460a.E() == 4) {
            ea.a.y(this.f25460a, "Unexpected leading comma", 0, null, 6, null);
            throw new v8.h();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.f25460a.f()) {
                break;
            }
            String strS = this.f25461b ? this.f25460a.s() : this.f25460a.q();
            this.f25460a.n((byte) 5);
            linkedHashMap.put(strS, e());
            bN = this.f25460a.m();
            if (bN != 4) {
                if (bN != 7) {
                    ea.a.y(this.f25460a, "Expected end of the object or comma", 0, null, 6, null);
                    throw new v8.h();
                }
            }
        }
        if (bN == 6) {
            this.f25460a.n((byte) 7);
        } else if (bN == 4) {
            ea.a.y(this.f25460a, "Unexpected trailing comma", 0, null, 6, null);
            throw new v8.h();
        }
        return new JsonObject(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive j(boolean z10) {
        String strS = (this.f25461b || !z10) ? this.f25460a.s() : this.f25460a.q();
        return (z10 || !kotlin.jvm.internal.t.d(strS, "null")) ? new kotlinx.serialization.json.n(strS, z10) : JsonNull.f30027a;
    }

    @NotNull
    public final JsonElement e() {
        byte bE = this.f25460a.E();
        if (bE == 1) {
            return j(true);
        }
        if (bE == 0) {
            return j(false);
        }
        if (bE == 6) {
            int i10 = this.f25462c + 1;
            this.f25462c = i10;
            this.f25462c--;
            return i10 == 200 ? g() : i();
        }
        if (bE == 8) {
            return f();
        }
        ea.a.y(this.f25460a, "Cannot begin reading element, unexpected token: " + ((int) bE), 0, null, 6, null);
        throw new v8.h();
    }
}
