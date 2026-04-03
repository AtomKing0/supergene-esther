package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.caches.SimpleArrayMap;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public final class AsyncTypefaceCache {

    @NotNull
    private final Object PermanentFailure = AsyncTypefaceResult.m3376constructorimpl(null);

    @NotNull
    private final LruCache<Key, AsyncTypefaceResult> resultCache = new LruCache<>(16);

    @NotNull
    private final SimpleArrayMap<Key, AsyncTypefaceResult> permanentCache = new SimpleArrayMap<>(0, 1, null);

    @NotNull
    private final SynchronizedObject cacheLock = Synchronization_jvmKt.createSynchronizedObject();

    /* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
    public static final class Key {

        @NotNull
        private final Font font;

        @Nullable
        private final Object loaderKey;

        public Key(@NotNull Font font, @Nullable Object obj) {
            t.i(font, "font");
            this.font = font;
            this.loaderKey = obj;
        }

        public static /* synthetic */ Key copy$default(Key key, Font font, Object obj, int i10, Object obj2) {
            if ((i10 & 1) != 0) {
                font = key.font;
            }
            if ((i10 & 2) != 0) {
                obj = key.loaderKey;
            }
            return key.copy(font, obj);
        }

        @NotNull
        public final Font component1() {
            return this.font;
        }

        @Nullable
        public final Object component2() {
            return this.loaderKey;
        }

        @NotNull
        public final Key copy(@NotNull Font font, @Nullable Object obj) {
            t.i(font, "font");
            return new Key(font, obj);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return t.d(this.font, key.font) && t.d(this.loaderKey, key.loaderKey);
        }

        @NotNull
        public final Font getFont() {
            return this.font;
        }

        @Nullable
        public final Object getLoaderKey() {
            return this.loaderKey;
        }

        public int hashCode() {
            int iHashCode = this.font.hashCode() * 31;
            Object obj = this.loaderKey;
            return iHashCode + (obj == null ? 0 : obj.hashCode());
        }

        @NotNull
        public String toString() {
            return "Key(font=" + this.font + ", loaderKey=" + this.loaderKey + ')';
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1, reason: invalid class name */
    /* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @f(c = "androidx.compose.ui.text.font.AsyncTypefaceCache", f = "FontListFontFamilyTypefaceAdapter.kt", l = {399}, m = "runCached")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsyncTypefaceCache.this.runCached(null, null, false, null, this);
        }
    }

    public static /* synthetic */ void put$default(AsyncTypefaceCache asyncTypefaceCache, Font font, PlatformFontLoader platformFontLoader, Object obj, boolean z10, int i10, Object obj2) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        asyncTypefaceCache.put(font, platformFontLoader, obj, z10);
    }

    @Nullable
    /* JADX INFO: renamed from: get-1ASDuI8, reason: not valid java name */
    public final AsyncTypefaceResult m3374get1ASDuI8(@NotNull Font font, @NotNull PlatformFontLoader platformFontLoader) {
        AsyncTypefaceResult asyncTypefaceResult;
        t.i(font, "font");
        t.i(platformFontLoader, "platformFontLoader");
        Key key = new Key(font, platformFontLoader.getCacheKey());
        synchronized (this.cacheLock) {
            asyncTypefaceResult = this.resultCache.get(key);
            if (asyncTypefaceResult == null) {
                asyncTypefaceResult = this.permanentCache.get(key);
            }
        }
        return asyncTypefaceResult;
    }

    public final void put(@NotNull Font font, @NotNull PlatformFontLoader platformFontLoader, @Nullable Object obj, boolean z10) {
        t.i(font, "font");
        t.i(platformFontLoader, "platformFontLoader");
        Key key = new Key(font, platformFontLoader.getCacheKey());
        synchronized (this.cacheLock) {
            try {
                if (obj == null) {
                    this.permanentCache.put(key, AsyncTypefaceResult.m3375boximpl(this.PermanentFailure));
                } else if (z10) {
                    this.permanentCache.put(key, AsyncTypefaceResult.m3375boximpl(AsyncTypefaceResult.m3376constructorimpl(obj)));
                } else {
                    this.resultCache.put(key, AsyncTypefaceResult.m3375boximpl(AsyncTypefaceResult.m3376constructorimpl(obj)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runCached(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.Font r6, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.PlatformFontLoader r7, boolean r8, @org.jetbrains.annotations.NotNull h9.l<? super z8.d<java.lang.Object>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull z8.d<java.lang.Object> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.text.font.AsyncTypefaceCache.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1 r0 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1 r0 = new androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            boolean r8 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r6 = (androidx.compose.ui.text.font.AsyncTypefaceCache.Key) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.text.font.AsyncTypefaceCache r7 = (androidx.compose.ui.text.font.AsyncTypefaceCache) r7
            v8.u.b(r10)
            goto L7a
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            v8.u.b(r10)
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r10 = new androidx.compose.ui.text.font.AsyncTypefaceCache$Key
            java.lang.Object r7 = r7.getCacheKey()
            r10.<init>(r6, r7)
            androidx.compose.ui.text.platform.SynchronizedObject r6 = r5.cacheLock
            monitor-enter(r6)
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r5.resultCache     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r7 = r7.get(r10)     // Catch: java.lang.Throwable -> Lb0
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r7 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r7     // Catch: java.lang.Throwable -> Lb0
            if (r7 != 0) goto L5c
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r5.permanentCache     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r7 = r7.get(r10)     // Catch: java.lang.Throwable -> Lb0
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r7 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r7     // Catch: java.lang.Throwable -> Lb0
        L5c:
            if (r7 == 0) goto L64
            java.lang.Object r7 = r7.m3382unboximpl()     // Catch: java.lang.Throwable -> Lb0
            monitor-exit(r6)
            return r7
        L64:
            v8.k0 r7 = v8.k0.f35197a     // Catch: java.lang.Throwable -> Lb0
            monitor-exit(r6)
            r0.L$0 = r5
            r0.L$1 = r10
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r6 = r9.invoke(r0)
            if (r6 != r1) goto L76
            return r1
        L76:
            r7 = r5
            r4 = r10
            r10 = r6
            r6 = r4
        L7a:
            androidx.compose.ui.text.platform.SynchronizedObject r9 = r7.cacheLock
            monitor-enter(r9)
            if (r10 != 0) goto L8d
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r8 = r7.permanentCache     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r7 = r7.PermanentFailure     // Catch: java.lang.Throwable -> L8b
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r7 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m3375boximpl(r7)     // Catch: java.lang.Throwable -> L8b
            r8.put(r6, r7)     // Catch: java.lang.Throwable -> L8b
            goto Laa
        L8b:
            r6 = move-exception
            goto Lae
        L8d:
            if (r8 == 0) goto L9d
            androidx.compose.ui.text.caches.SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r7.permanentCache     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r8 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m3376constructorimpl(r10)     // Catch: java.lang.Throwable -> L8b
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r8 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m3375boximpl(r8)     // Catch: java.lang.Throwable -> L8b
            r7.put(r6, r8)     // Catch: java.lang.Throwable -> L8b
            goto Laa
        L9d:
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.AsyncTypefaceCache$Key, androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult> r7 = r7.resultCache     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r8 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m3376constructorimpl(r10)     // Catch: java.lang.Throwable -> L8b
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r8 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m3375boximpl(r8)     // Catch: java.lang.Throwable -> L8b
            r7.put(r6, r8)     // Catch: java.lang.Throwable -> L8b
        Laa:
            v8.k0 r6 = v8.k0.f35197a     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r9)
            return r10
        Lae:
            monitor-exit(r9)
            throw r6
        Lb0:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncTypefaceCache.runCached(androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.PlatformFontLoader, boolean, h9.l, z8.d):java.lang.Object");
    }

    @Nullable
    public final Object runCachedBlocking(@NotNull Font font, @NotNull PlatformFontLoader platformFontLoader, @NotNull h9.a<? extends Object> block) {
        t.i(font, "font");
        t.i(platformFontLoader, "platformFontLoader");
        t.i(block, "block");
        synchronized (this.cacheLock) {
            try {
                Key key = new Key(font, platformFontLoader.getCacheKey());
                AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceResult) this.resultCache.get(key);
                if (asyncTypefaceResult == null) {
                    asyncTypefaceResult = (AsyncTypefaceResult) this.permanentCache.get(key);
                }
                if (asyncTypefaceResult != null) {
                    Object objM3382unboximpl = asyncTypefaceResult.m3382unboximpl();
                    r.b(2);
                    r.a(2);
                    return objM3382unboximpl;
                }
                k0 k0Var = k0.f35197a;
                r.b(1);
                r.a(1);
                Object objInvoke = block.invoke();
                put$default(this, font, platformFontLoader, objInvoke, false, 8, null);
                return objInvoke;
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
    public static final class AsyncTypefaceResult {

        @Nullable
        private final Object result;

        private /* synthetic */ AsyncTypefaceResult(Object obj) {
            this.result = obj;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ AsyncTypefaceResult m3375boximpl(Object obj) {
            return new AsyncTypefaceResult(obj);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m3377equalsimpl(Object obj, Object obj2) {
            return (obj2 instanceof AsyncTypefaceResult) && t.d(obj, ((AsyncTypefaceResult) obj2).m3382unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3378equalsimpl0(Object obj, Object obj2) {
            return t.d(obj, obj2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m3379hashCodeimpl(Object obj) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        /* JADX INFO: renamed from: isPermanentFailure-impl, reason: not valid java name */
        public static final boolean m3380isPermanentFailureimpl(Object obj) {
            return obj == null;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m3381toStringimpl(Object obj) {
            return "AsyncTypefaceResult(result=" + obj + ')';
        }

        public boolean equals(Object obj) {
            return m3377equalsimpl(this.result, obj);
        }

        @Nullable
        public final Object getResult() {
            return this.result;
        }

        public int hashCode() {
            return m3379hashCodeimpl(this.result);
        }

        public String toString() {
            return m3381toStringimpl(this.result);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ Object m3382unboximpl() {
            return this.result;
        }

        @NotNull
        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static Object m3376constructorimpl(@Nullable Object obj) {
            return obj;
        }
    }
}
