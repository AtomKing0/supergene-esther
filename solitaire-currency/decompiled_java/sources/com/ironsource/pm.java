package com.ironsource;

import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class pm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final b5 f14360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14361b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f14362a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f14363b = "adm";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final String f14364c = "isOneFlow";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final String f14365d = "isMultipleAdObjects";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public static final String f14366e = "adsInternalInfo";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        public static final String f14367f = "success";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        public static final String f14368g = "error";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NotNull
        public static final String f14369h = "data";

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public pm() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final HashMap<String, String> a() {
        g5 g5VarG;
        HashMap<String, String> map = new HashMap<>();
        map.put("isOneFlow", String.valueOf(this.f14361b));
        map.put("isMultipleAdObjects", com.ironsource.mediationsdk.metadata.a.f13688g);
        List<k0> listA = el.f11917p.d().B().a();
        String string = (listA != null ? new JSONObject().put("success", true).put("data", listA) : new JSONObject().put("success", false).put("error", "Failed to get ad internal info")).toString();
        kotlin.jvm.internal.t.h(string, "if (jsonAdInternalInfo !…    .toString()\n        }");
        map.put(a.f14366e, string);
        b5 b5Var = this.f14360a;
        if (b5Var != null && (g5VarG = b5Var.g()) != null) {
            map.put("adm", g5VarG.a());
            map.putAll(g5VarG.b());
        }
        return map;
    }

    public pm(@Nullable b5 b5Var, boolean z10) {
        this.f14360a = b5Var;
        this.f14361b = z10;
    }

    public /* synthetic */ pm(b5 b5Var, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : b5Var, (i10 & 2) != 0 ? false : z10);
    }
}
