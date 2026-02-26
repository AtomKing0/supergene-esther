package com.moloco.sdk.internal.services;

import android.content.SharedPreferences;
import com.moloco.sdk.internal.MolocoLogger;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final SharedPreferences f18690a;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.PreferencesDataStoreServiceImpl$getString$2", f = "DataStoreService.kt", l = {}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super String>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18691j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f18693l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f18693l = str;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super String> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return h.this.new a(this.f18693l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18691j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            if (!h.this.f18690a.contains(this.f18693l)) {
                return null;
            }
            try {
                return h.this.f18690a.getString(this.f18693l, "");
            } catch (ClassCastException unused) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type for key: " + this.f18693l, null, false, 12, null);
                return null;
            }
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.PreferencesDataStoreServiceImpl$set$2", f = "DataStoreService.kt", l = {}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18694j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ T f18695k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h f18696l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f18697m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(T t10, h hVar, String str, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f18695k = t10;
            this.f18696l = hVar;
            this.f18697m = str;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new b(this.f18695k, this.f18696l, this.f18697m, dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18694j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            T t10 = this.f18695k;
            if (t10 instanceof Integer) {
                this.f18696l.f18690a.edit().putInt(this.f18697m, ((Number) this.f18695k).intValue()).apply();
            } else if (t10 instanceof String) {
                this.f18696l.f18690a.edit().putString(this.f18697m, (String) this.f18695k).apply();
            } else if (t10 instanceof Float) {
                this.f18696l.f18690a.edit().putFloat(this.f18697m, ((Number) this.f18695k).floatValue()).apply();
            } else if (t10 instanceof Boolean) {
                this.f18696l.f18690a.edit().putBoolean(this.f18697m, ((Boolean) this.f18695k).booleanValue()).apply();
            } else if (t10 instanceof Double) {
                this.f18696l.f18690a.edit().putString(this.f18697m, String.valueOf(((Number) this.f18695k).doubleValue())).apply();
            } else if (t10 instanceof Long) {
                this.f18696l.f18690a.edit().putString(this.f18697m, String.valueOf(((Number) this.f18695k).longValue())).apply();
            } else {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type: " + this.f18695k + " for key: " + this.f18697m, null, false, 12, null);
            }
            return k0.f35197a;
        }
    }

    public h(@NotNull SharedPreferences sharedPreferences) {
        kotlin.jvm.internal.t.i(sharedPreferences, "sharedPreferences");
        this.f18690a = sharedPreferences;
    }

    @Override // com.moloco.sdk.internal.services.f0
    @Nullable
    public Object a(@NotNull String str, @NotNull z8.d<? super String> dVar) {
        return kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getIo(), new a(str, null), dVar);
    }

    @Override // com.moloco.sdk.internal.services.f0
    @Nullable
    public <T> Object b(@NotNull String str, T t10, @NotNull z8.d<? super k0> dVar) {
        Object objG = kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getIo(), new b(t10, this, str, null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }
}
