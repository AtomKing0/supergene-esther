package com.ironsource;

import android.view.View;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class gu extends xn {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f12346f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final String f12347g = "ViewVisibilityTrigger";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final b f12348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final iu f12349e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public static final class b implements jn {
        b() {
        }

        @Override // com.ironsource.jn
        public void a(boolean z10) {
            gu.this.a(!z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gu(@NotNull View view) {
        super(false, 1, null);
        kotlin.jvm.internal.t.i(view, "view");
        b bVar = new b();
        this.f12348d = bVar;
        iu iuVar = new iu(bVar);
        this.f12349e = iuVar;
        iuVar.a(view);
        a(!iuVar.c());
    }

    @Override // com.ironsource.xn
    @NotNull
    public String b() {
        return f12347g;
    }

    public final void e() {
        this.f12349e.b();
    }
}
