package androidx.core.util;

import android.util.LruCache;
import h9.l;
import h9.p;
import h9.r;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class AnonymousClass1 extends v implements p {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: invoke */
        public final Integer mo4invoke(@NotNull Object obj, @NotNull Object obj2) {
            return 1;
        }
    }

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class AnonymousClass2 extends v implements l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@NotNull Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class AnonymousClass3 extends v implements r {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        public final void invoke(boolean z10, @NotNull Object obj, @NotNull Object obj2, @Nullable Object obj3) {
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(((Boolean) obj).booleanValue(), obj2, obj3, obj4);
            return k0.f35197a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ l<K, V> $create;
        final /* synthetic */ r<Boolean, K, V, V, k0> $onEntryRemoved;
        final /* synthetic */ p<K, V, Integer> $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(int i10, p<? super K, ? super V, Integer> pVar, l<? super K, ? extends V> lVar, r<? super Boolean, ? super K, ? super V, ? super V, k0> rVar) {
            super(i10);
            this.$sizeOf = pVar;
            this.$create = lVar;
            this.$onEntryRemoved = rVar;
        }

        @Override // android.util.LruCache
        @Nullable
        protected V create(@NotNull K k10) {
            return this.$create.invoke(k10);
        }

        @Override // android.util.LruCache
        protected void entryRemoved(boolean z10, @NotNull K k10, @NotNull V v10, @Nullable V v11) {
            this.$onEntryRemoved.invoke(Boolean.valueOf(z10), k10, v10, v11);
        }

        @Override // android.util.LruCache
        protected int sizeOf(@NotNull K k10, @NotNull V v10) {
            return this.$sizeOf.mo4invoke(k10, v10).intValue();
        }
    }

    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i10, @NotNull p<? super K, ? super V, Integer> pVar, @NotNull l<? super K, ? extends V> lVar, @NotNull r<? super Boolean, ? super K, ? super V, ? super V, k0> rVar) {
        return new AnonymousClass4(i10, pVar, lVar, rVar);
    }

    public static /* synthetic */ LruCache lruCache$default(int i10, p pVar, l lVar, r rVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            pVar = AnonymousClass1.INSTANCE;
        }
        if ((i11 & 4) != 0) {
            lVar = AnonymousClass2.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            rVar = AnonymousClass3.INSTANCE;
        }
        return new AnonymousClass4(i10, pVar, lVar, rVar);
    }
}
