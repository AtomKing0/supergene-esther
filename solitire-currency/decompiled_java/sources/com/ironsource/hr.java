package com.ironsource;

import com.ironsource.lg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class hr implements lg, lg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, Integer> f12508a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, Integer> f12509b = new HashMap();

    @Override // com.ironsource.lg.a
    public void a(@NotNull lg.b smash) {
        kotlin.jvm.internal.t.i(smash, "smash");
        synchronized (this) {
            String strC = smash.c();
            if (this.f12508a.containsKey(strC)) {
                Map<String, Integer> map = this.f12508a;
                Integer num = map.get(strC);
                kotlin.jvm.internal.t.f(num);
                map.put(strC, Integer.valueOf(num.intValue() + 1));
            }
            v8.k0 k0Var = v8.k0.f35197a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    @Override // com.ironsource.lg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(@org.jetbrains.annotations.NotNull com.ironsource.lg.b r3) {
        /*
            r2 = this;
            java.lang.String r0 = "smash"
            kotlin.jvm.internal.t.i(r3, r0)
            monitor-enter(r2)
            java.lang.String r0 = r3.c()     // Catch: java.lang.Throwable -> L2c
            java.util.Map<java.lang.String, java.lang.Integer> r1 = r2.f12508a     // Catch: java.lang.Throwable -> L2c
            boolean r1 = r1.containsKey(r0)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L29
            java.util.Map<java.lang.String, java.lang.Integer> r1 = r2.f12508a     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Throwable -> L2c
            kotlin.jvm.internal.t.f(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> L2c
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L2c
            int r3 = r3.b()     // Catch: java.lang.Throwable -> L2c
            if (r0 < r3) goto L29
            r3 = 1
            goto L2a
        L29:
            r3 = 0
        L2a:
            monitor-exit(r2)
            return r3
        L2c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.hr.b(com.ironsource.lg$b):boolean");
    }

    @Override // com.ironsource.lg.a
    public void a(@NotNull List<? extends lg.b> smashes) {
        kotlin.jvm.internal.t.i(smashes, "smashes");
        for (lg.b bVar : smashes) {
            this.f12508a.put(bVar.c(), 0);
            this.f12509b.put(bVar.c(), Integer.valueOf(bVar.b()));
        }
    }

    @Override // com.ironsource.lg
    public boolean a() {
        for (String str : this.f12509b.keySet()) {
            Integer num = this.f12508a.get(str);
            kotlin.jvm.internal.t.f(num);
            int iIntValue = num.intValue();
            Integer num2 = this.f12509b.get(str);
            kotlin.jvm.internal.t.f(num2);
            if (iIntValue < num2.intValue()) {
                return false;
            }
        }
        return true;
    }
}
