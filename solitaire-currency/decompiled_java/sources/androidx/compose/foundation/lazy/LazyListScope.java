package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composer;
import h9.l;
import h9.q;
import h9.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyDsl.kt */
/* JADX INFO: loaded from: classes.dex */
@LazyScopeMarker
public interface LazyListScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScope$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void a(LazyListScope lazyListScope, Object obj, q content) {
            t.i(content, "content");
            lazyListScope.item(obj, null, content);
        }

        public static void b(LazyListScope lazyListScope, @Nullable Object obj, @Nullable Object obj2, @NotNull q content) {
            t.i(content, "content");
            throw new IllegalStateException("The method is not implemented".toString());
        }

        public static void c(LazyListScope lazyListScope, int i10, @Nullable l lVar, @NotNull l contentType, @NotNull r itemContent) {
            t.i(contentType, "contentType");
            t.i(itemContent, "itemContent");
            throw new IllegalStateException("The method is not implemented".toString());
        }

        public static /* synthetic */ void d(LazyListScope lazyListScope, int i10, l lVar, r itemContent) {
            t.i(itemContent, "itemContent");
            lazyListScope.items(i10, lVar, AnonymousClass2.INSTANCE, itemContent);
        }

        public static /* synthetic */ void i(LazyListScope lazyListScope, Object obj, q qVar, int i10, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
            }
            if ((i10 & 1) != 0) {
                obj = null;
            }
            lazyListScope.item(obj, qVar);
        }

        public static /* synthetic */ void j(LazyListScope lazyListScope, Object obj, Object obj2, q qVar, int i10, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
            }
            if ((i10 & 1) != 0) {
                obj = null;
            }
            if ((i10 & 2) != 0) {
                obj2 = null;
            }
            lazyListScope.item(obj, obj2, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void k(LazyListScope lazyListScope, int i10, l lVar, l lVar2, r rVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
            }
            if ((i11 & 2) != 0) {
                lVar = null;
            }
            if ((i11 & 4) != 0) {
                lVar2 = AnonymousClass1.INSTANCE;
            }
            lazyListScope.items(i10, lVar, lVar2, rVar);
        }

        public static /* synthetic */ void l(LazyListScope lazyListScope, int i10, l lVar, r rVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
            }
            if ((i11 & 2) != 0) {
                lVar = null;
            }
            lazyListScope.items(i10, lVar, rVar);
        }

        public static /* synthetic */ void m(LazyListScope lazyListScope, Object obj, Object obj2, q qVar, int i10, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
            }
            if ((i10 & 1) != 0) {
                obj = null;
            }
            if ((i10 & 2) != 0) {
                obj2 = null;
            }
            lazyListScope.stickyHeader(obj, obj2, qVar);
        }
    }

    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static void item(@NotNull LazyListScope lazyListScope, @Nullable Object obj, @Nullable Object obj2, @NotNull q<? super LazyItemScope, ? super Composer, ? super Integer, k0> content) {
            t.i(content, "content");
            CC.b(lazyListScope, obj, obj2, content);
        }

        @Deprecated
        public static void items(@NotNull LazyListScope lazyListScope, int i10, @Nullable l<? super Integer, ? extends Object> lVar, @NotNull l<? super Integer, ? extends Object> contentType, @NotNull r<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, k0> itemContent) {
            t.i(contentType, "contentType");
            t.i(itemContent, "itemContent");
            CC.c(lazyListScope, i10, lVar, contentType, itemContent);
        }

        @Deprecated
        public static /* synthetic */ void item(LazyListScope lazyListScope, Object obj, q content) {
            t.i(content, "content");
            CC.a(lazyListScope, obj, content);
        }

        @Deprecated
        public static /* synthetic */ void items(LazyListScope lazyListScope, int i10, l lVar, r itemContent) {
            t.i(itemContent, "itemContent");
            CC.d(lazyListScope, i10, lVar, itemContent);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScope$items$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    static final class AnonymousClass1 extends v implements l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Nullable
        public final Void invoke(int i10) {
            return null;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScope$items$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    static final class AnonymousClass2 extends v implements l<Integer, Object> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Nullable
        public final Object invoke(int i10) {
            return null;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* synthetic */ void item(Object obj, q qVar);

    void item(@Nullable Object obj, @Nullable Object obj2, @NotNull q<? super LazyItemScope, ? super Composer, ? super Integer, k0> qVar);

    void items(int i10, @Nullable l<? super Integer, ? extends Object> lVar, @NotNull l<? super Integer, ? extends Object> lVar2, @NotNull r<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, k0> rVar);

    /* synthetic */ void items(int i10, l lVar, r rVar);

    @ExperimentalFoundationApi
    void stickyHeader(@Nullable Object obj, @Nullable Object obj2, @NotNull q<? super LazyItemScope, ? super Composer, ? super Integer, k0> qVar);
}
