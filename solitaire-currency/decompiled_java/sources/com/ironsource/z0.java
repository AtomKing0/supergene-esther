package com.ironsource;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class z0 implements a1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f16358b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String f16359c = "ext_";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, String> f16360a = new HashMap();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    @Override // com.ironsource.a1
    public void a(@NotNull String key, @NotNull String value) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        this.f16360a.put(key, value);
    }

    @Override // com.ironsource.a1
    public void b(@NotNull String key, @NotNull String value) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        this.f16360a.put("ext_" + key, value);
    }

    @Override // com.ironsource.a1
    @NotNull
    public Map<String, String> get() {
        return this.f16360a;
    }

    @Override // com.ironsource.a1
    public void a(@NotNull HashMap<String, String> params) {
        kotlin.jvm.internal.t.i(params, "params");
        this.f16360a.putAll(params);
    }
}
