package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.data.datasource.CacheDataSource;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.services.core.extensions.CoroutineExtensionsKt;
import h9.p;
import java.io.File;
import java.util.Map;
import java.util.Set;
import kotlin.collections.a0;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: CoroutineExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1", f = "AndroidCacheRepository.kt", l = {50}, m = "invokeSuspend")
public final class AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1 extends l implements p<o0, d<? super CacheResult>, Object> {
    final /* synthetic */ String $filename$inlined;
    final /* synthetic */ Object $key;
    final /* synthetic */ int $priority$inlined;
    final /* synthetic */ String $url$inlined;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidCacheRepository this$0;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineExtensions.kt */
    @f(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1", f = "AndroidCacheRepository.kt", l = {52}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements p<o0, d<? super CacheResult>, Object> {
        final /* synthetic */ String $filename$inlined;
        final /* synthetic */ int $priority$inlined;
        final /* synthetic */ String $url$inlined;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidCacheRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(d dVar, AndroidCacheRepository androidCacheRepository, String str, String str2, int i10) {
            super(2, dVar);
            this.this$0 = androidCacheRepository;
            this.$filename$inlined = str;
            this.$url$inlined = str2;
            this.$priority$inlined = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(dVar, this.this$0, this.$filename$inlined, this.$url$inlined, this.$priority$inlined);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                CacheDataSource cacheDataSource = this.this$0.remoteCacheDataSource;
                File file = this.this$0.cacheDir;
                String str = this.$filename$inlined;
                String str2 = this.$url$inlined;
                Integer numD = b.d(this.$priority$inlined);
                this.label = 1;
                obj = cacheDataSource.getFile(file, str, str2, numD, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return obj;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super CacheResult> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineExtensions.kt */
    @f(c = "com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2$1", f = "CoroutineExtensions.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends l implements p<o0, d<? super k0>, Object> {
        int label;

        public AnonymousClass2(d dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass2(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            Set<Map.Entry<Object, v0<?>>> setEntrySet = CoroutineExtensionsKt.getDeferreds().entrySet();
            t.h(setEntrySet, "deferreds.entries");
            a0.H(setEntrySet, CoroutineExtensionsKt.AnonymousClass2.AnonymousClass1.C04981.INSTANCE);
            CoroutineExtensionsKt.getDeferredsCleanLaunched().set(false);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1(Object obj, d dVar, AndroidCacheRepository androidCacheRepository, String str, String str2, int i10) {
        super(2, dVar);
        this.$key = obj;
        this.this$0 = androidCacheRepository;
        this.$filename$inlined = str;
        this.$url$inlined = str2;
        this.$priority$inlined = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1 androidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1 = new AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1(this.$key, dVar, this.this$0, this.$filename$inlined, this.$url$inlined, this.$priority$inlined);
        androidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1.L$0 = obj;
        return androidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return obj;
        }
        u.b(obj);
        o0 o0Var = (o0) this.L$0;
        v0<?> v0VarB = CoroutineExtensionsKt.getDeferreds().get(this.$key);
        if (v0VarB == null || !v0VarB.isActive()) {
            v0VarB = null;
        }
        if (v0VarB == null) {
            v0VarB = k.b(o0Var, null, null, new AnonymousClass1(null, this.this$0, this.$filename$inlined, this.$url$inlined, this.$priority$inlined), 3, null);
            CoroutineExtensionsKt.getDeferreds().put(this.$key, v0VarB);
        }
        v0<?> v0Var = v0VarB;
        if (CoroutineExtensionsKt.getDeferreds().size() > 100 && !CoroutineExtensionsKt.getDeferredsCleanLaunched().getAndSet(true)) {
            k.d(o0Var, null, null, new AnonymousClass2(null), 3, null);
        }
        this.label = 1;
        Object objI0 = v0Var.i0(this);
        return objI0 == objE ? objE : objI0;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super CacheResult> dVar) {
        return ((AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
