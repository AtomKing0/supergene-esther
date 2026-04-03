package androidx.collection;

import h9.l;
import h9.p;
import h9.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class AnonymousClass1 extends v implements p {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        public final int invoke(@NotNull Object obj, @NotNull Object obj2) {
            t.j(obj, "<anonymous parameter 0>");
            t.j(obj2, "<anonymous parameter 1>");
            return 1;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object obj, Object obj2) {
            return Integer.valueOf(invoke(obj, obj2));
        }
    }

    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class AnonymousClass2 extends v implements l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@NotNull Object it) {
            t.j(it, "it");
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class AnonymousClass3 extends v implements r {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(((Boolean) obj).booleanValue(), obj2, obj3, obj4);
            return k0.f35197a;
        }

        public final void invoke(boolean z10, @NotNull Object obj, @NotNull Object obj2, @Nullable Object obj3) {
            t.j(obj, "<anonymous parameter 1>");
            t.j(obj2, "<anonymous parameter 2>");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$4, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ l $create;
        final /* synthetic */ int $maxSize;
        final /* synthetic */ r $onEntryRemoved;
        final /* synthetic */ p $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(p pVar, l lVar, r rVar, int i10, int i11) {
            super(i11);
            this.$sizeOf = pVar;
            this.$create = lVar;
            this.$onEntryRemoved = rVar;
            this.$maxSize = i10;
        }

        @Override // androidx.collection.LruCache
        @Nullable
        protected V create(@NotNull K key) {
            t.j(key, "key");
            return (V) this.$create.invoke(key);
        }

        @Override // androidx.collection.LruCache
        protected void entryRemoved(boolean z10, @NotNull K key, @NotNull V oldValue, @Nullable V v10) {
            t.j(key, "key");
            t.j(oldValue, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(z10), key, oldValue, v10);
        }

        @Override // androidx.collection.LruCache
        protected int sizeOf(@NotNull K key, @NotNull V value) {
            t.j(key, "key");
            t.j(value, "value");
            return ((Number) this.$sizeOf.mo4invoke(key, value)).intValue();
        }
    }

    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i10, @NotNull p<? super K, ? super V, Integer> sizeOf, @NotNull l<? super K, ? extends V> create, @NotNull r<? super Boolean, ? super K, ? super V, ? super V, k0> onEntryRemoved) {
        t.j(sizeOf, "sizeOf");
        t.j(create, "create");
        t.j(onEntryRemoved, "onEntryRemoved");
        return new AnonymousClass4(sizeOf, create, onEntryRemoved, i10, i10);
    }

    @NotNull
    public static /* synthetic */ LruCache lruCache$default(int i10, p pVar, l lVar, r rVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            pVar = AnonymousClass1.INSTANCE;
        }
        p sizeOf = pVar;
        if ((i11 & 4) != 0) {
            lVar = AnonymousClass2.INSTANCE;
        }
        l create = lVar;
        if ((i11 & 8) != 0) {
            rVar = AnonymousClass3.INSTANCE;
        }
        r onEntryRemoved = rVar;
        t.j(sizeOf, "sizeOf");
        t.j(create, "create");
        t.j(onEntryRemoved, "onEntryRemoved");
        return new AnonymousClass4(sizeOf, create, onEntryRemoved, i10, i10);
    }
}
