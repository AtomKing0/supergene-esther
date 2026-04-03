package com.ironsource;

import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.k9;
import com.ironsource.wd;
import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class d8 implements wd, wd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final qn f11776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final cs f11777b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11778a;

        static {
            int[] iArr = new int[h8.values().length];
            try {
                iArr[h8.Pacing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[h8.ShowCount.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[h8.Delivery.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11778a = iArr;
        }
    }

    public d8() {
        this(null, null, null, 7, null);
    }

    @Override // com.ironsource.wd
    @NotNull
    public synchronized f8 a(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        f8 f8VarA = this.f11776a.a(identifier);
        if (f8VarA.d()) {
            return f8VarA;
        }
        return this.f11777b.a(identifier);
    }

    @Override // com.ironsource.wd.a
    public synchronized void b(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        this.f11776a.b(identifier);
        this.f11777b.b(identifier);
    }

    public d8(@NotNull k9 currentTimeProvider, @NotNull ne pacingDataRepository, @NotNull og showCountDataRepository) {
        kotlin.jvm.internal.t.i(currentTimeProvider, "currentTimeProvider");
        kotlin.jvm.internal.t.i(pacingDataRepository, "pacingDataRepository");
        kotlin.jvm.internal.t.i(showCountDataRepository, "showCountDataRepository");
        this.f11776a = new qn(currentTimeProvider, pacingDataRepository);
        this.f11777b = new cs(currentTimeProvider, showCountDataRepository);
    }

    @Override // com.ironsource.wd.a
    @NotNull
    public synchronized Object a(@NotNull String identifier, @NotNull h8 cappingType, @NotNull ud cappingConfig) {
        Object objA;
        kotlin.jvm.internal.t.i(identifier, "identifier");
        kotlin.jvm.internal.t.i(cappingType, "cappingType");
        kotlin.jvm.internal.t.i(cappingConfig, "cappingConfig");
        int i10 = a.f11778a[cappingType.ordinal()];
        if (i10 == 1) {
            objA = this.f11776a.a(identifier, cappingType, cappingConfig);
        } else if (i10 == 2) {
            objA = this.f11777b.a(identifier, cappingType, cappingConfig);
        } else {
            if (i10 != 3) {
                throw new v8.q();
            }
            t.a aVar = v8.t.f35208b;
            objA = v8.t.b(v8.k0.f35197a);
        }
        return objA;
    }

    public /* synthetic */ d8(k9 k9Var, ne neVar, og ogVar, int i10, kotlin.jvm.internal.k kVar) {
        k9Var = (i10 & 1) != 0 ? new k9.a() : k9Var;
        if ((i10 & 2) != 0) {
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            kotlin.jvm.internal.t.h(applicationContext, "getInstance().applicationContext");
            neVar = new rn(new xr(applicationContext, "pacing_service", null, 4, null));
        }
        if ((i10 & 4) != 0) {
            Context applicationContext2 = ContextProvider.getInstance().getApplicationContext();
            kotlin.jvm.internal.t.h(applicationContext2, "getInstance().applicationContext");
            ogVar = new as(new xr(applicationContext2, "capping_service", null, 4, null));
        }
        this(k9Var, neVar, ogVar);
    }
}
