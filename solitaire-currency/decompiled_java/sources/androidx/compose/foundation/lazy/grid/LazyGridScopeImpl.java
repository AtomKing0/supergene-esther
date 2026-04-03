package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import h9.l;
import h9.p;
import h9.q;
import h9.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyGridScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridScopeImpl implements LazyGridScope {
    private boolean hasCustomSpans;

    @NotNull
    private final MutableIntervalList<LazyGridIntervalContent> intervals = new MutableIntervalList<>();

    @NotNull
    private final p<LazyGridItemSpanScope, Integer, GridItemSpan> DefaultSpan = LazyGridScopeImpl$DefaultSpan$1.INSTANCE;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridScopeImpl$item$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridScopeImpl.kt */
    static final class AnonymousClass3 extends v implements l<Integer, Object> {
        final /* synthetic */ Object $contentType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Object obj) {
            super(1);
            this.$contentType = obj;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        @Nullable
        public final Object invoke(int i10) {
            return this.$contentType;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridScopeImpl$item$4, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridScopeImpl.kt */
    static final class AnonymousClass4 extends v implements r<LazyGridItemScope, Integer, Composer, Integer, k0> {
        final /* synthetic */ q<LazyGridItemScope, Composer, Integer, k0> $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(q<? super LazyGridItemScope, ? super Composer, ? super Integer, k0> qVar) {
            super(4);
            this.$content = qVar;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@NotNull LazyGridItemScope $receiver, int i10, @Nullable Composer composer, int i11) {
            t.i($receiver, "$this$$receiver");
            if ((i11 & 14) == 0) {
                i11 |= composer.changed($receiver) ? 4 : 2;
            }
            if ((i11 & 651) == 130 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$content.invoke($receiver, composer, Integer.valueOf(i11 & 14));
            }
        }
    }

    public final boolean getHasCustomSpans$foundation_release() {
        return this.hasCustomSpans;
    }

    @NotNull
    public final MutableIntervalList<LazyGridIntervalContent> getIntervals$foundation_release() {
        return this.intervals;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void item(@Nullable Object obj, @Nullable l<? super LazyGridItemSpanScope, GridItemSpan> lVar, @Nullable Object obj2, @NotNull q<? super LazyGridItemScope, ? super Composer, ? super Integer, k0> content) {
        t.i(content, "content");
        this.intervals.addInterval(1, new LazyGridIntervalContent(obj != null ? new LazyGridScopeImpl$item$1$1(obj) : null, lVar != null ? new LazyGridScopeImpl$item$2$1(lVar) : this.DefaultSpan, new AnonymousClass3(obj2), ComposableLambdaKt.composableLambdaInstance(-1504808184, true, new AnonymousClass4(content))));
        if (lVar != null) {
            this.hasCustomSpans = true;
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void items(int i10, @Nullable l<? super Integer, ? extends Object> lVar, @Nullable p<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> pVar, @NotNull l<? super Integer, ? extends Object> contentType, @NotNull r<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        this.intervals.addInterval(i10, new LazyGridIntervalContent(lVar, pVar == null ? this.DefaultSpan : pVar, contentType, itemContent));
        if (pVar != null) {
            this.hasCustomSpans = true;
        }
    }

    public final void setHasCustomSpans$foundation_release(boolean z10) {
        this.hasCustomSpans = z10;
    }
}
