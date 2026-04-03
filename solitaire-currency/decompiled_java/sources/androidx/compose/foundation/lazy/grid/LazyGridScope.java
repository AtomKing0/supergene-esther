package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import h9.l;
import h9.p;
import h9.q;
import h9.r;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyGridDsl.kt */
/* JADX INFO: loaded from: classes.dex */
@LazyGridScopeMarker
public interface LazyGridScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridScope$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(LazyGridScope lazyGridScope, Object obj, l lVar, Object obj2, q qVar, int i10, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
            }
            if ((i10 & 1) != 0) {
                obj = null;
            }
            if ((i10 & 2) != 0) {
                lVar = null;
            }
            if ((i10 & 4) != 0) {
                obj2 = null;
            }
            lazyGridScope.item(obj, lVar, obj2, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(LazyGridScope lazyGridScope, int i10, l lVar, p pVar, l lVar2, r rVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
            }
            l lVar3 = (i11 & 2) != 0 ? null : lVar;
            p pVar2 = (i11 & 4) != 0 ? null : pVar;
            if ((i11 & 8) != 0) {
                lVar2 = AnonymousClass1.INSTANCE;
            }
            lazyGridScope.items(i10, lVar3, pVar2, lVar2, rVar);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridScope$items$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
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

    void item(@Nullable Object obj, @Nullable l<? super LazyGridItemSpanScope, GridItemSpan> lVar, @Nullable Object obj2, @NotNull q<? super LazyGridItemScope, ? super Composer, ? super Integer, k0> qVar);

    void items(int i10, @Nullable l<? super Integer, ? extends Object> lVar, @Nullable p<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> pVar, @NotNull l<? super Integer, ? extends Object> lVar2, @NotNull r<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, k0> rVar);
}
