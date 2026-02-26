package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class cm {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f11590e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private static volatile cm f11591f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private so f11592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f11593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private String f11594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private m8 f11595d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final cm a() {
            cm cmVar = cm.f11591f;
            if (cmVar == null) {
                synchronized (this) {
                    cmVar = cm.f11591f;
                    if (cmVar == null) {
                        cmVar = new cm(null);
                        cm.f11591f = cmVar;
                    }
                }
            }
            return cmVar;
        }

        @NotNull
        public final x2 a(@NotNull IronSource.AD_UNIT adFormat) {
            kotlin.jvm.internal.t.i(adFormat, "adFormat");
            cm cmVar = cm.f11591f;
            m8 m8VarB = cmVar != null ? cmVar.b() : null;
            cm cmVar2 = cm.f11591f;
            so soVarE = cmVar2 != null ? cmVar2.e() : null;
            return (m8VarB == null || soVarE == null) ? new va() : new l7(m8VarB, soVarE, adFormat);
        }
    }

    private cm() {
        this.f11593b = new AtomicBoolean(false);
        this.f11594c = "";
    }

    @NotNull
    public static final cm d() {
        return f11590e.a();
    }

    @Nullable
    public final m8 b() {
        return this.f11595d;
    }

    @NotNull
    public final AtomicBoolean c() {
        return this.f11593b;
    }

    @Nullable
    public final so e() {
        return this.f11592a;
    }

    @NotNull
    public final String f() {
        return this.f11594c;
    }

    public final void g() {
        this.f11593b.set(true);
    }

    public /* synthetic */ cm(kotlin.jvm.internal.k kVar) {
        this();
    }

    public final void a(@Nullable m8 m8Var) {
        this.f11595d = m8Var;
    }

    public final void a(@Nullable so soVar) {
        this.f11592a = soVar;
    }

    public final void a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f11594c = str;
    }
}
