package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import h9.l;
import h9.q;
import h9.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyListScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListScopeImpl implements LazyListScope {

    @Nullable
    private List<Integer> _headerIndexes;

    @NotNull
    private final MutableIntervalList<LazyListIntervalContent> _intervals;

    @NotNull
    private final IntervalList<LazyListIntervalContent> intervals;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScopeImpl$item$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListScopeImpl.kt */
    static final class AnonymousClass1 extends v implements l<Integer, Object> {
        final /* synthetic */ Object $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj) {
            super(1);
            this.$key = obj;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        @NotNull
        public final Object invoke(int i10) {
            return this.$key;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScopeImpl$item$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListScopeImpl.kt */
    static final class AnonymousClass2 extends v implements l<Integer, Object> {
        final /* synthetic */ Object $contentType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Object obj) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScopeImpl$item$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListScopeImpl.kt */
    static final class AnonymousClass3 extends v implements r<LazyItemScope, Integer, Composer, Integer, k0> {
        final /* synthetic */ q<LazyItemScope, Composer, Integer, k0> $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(q<? super LazyItemScope, ? super Composer, ? super Integer, k0> qVar) {
            super(4);
            this.$content = qVar;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@NotNull LazyItemScope $receiver, int i10, @Nullable Composer composer, int i11) {
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

    public LazyListScopeImpl() {
        MutableIntervalList<LazyListIntervalContent> mutableIntervalList = new MutableIntervalList<>();
        this._intervals = mutableIntervalList;
        this.intervals = mutableIntervalList;
    }

    @NotNull
    public final List<Integer> getHeaderIndexes() {
        List<Integer> list = this._headerIndexes;
        return list == null ? kotlin.collections.v.l() : list;
    }

    @NotNull
    public final IntervalList<LazyListIntervalContent> getIntervals() {
        return this.intervals;
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public /* synthetic */ void item(Object obj, q qVar) {
        LazyListScope.CC.a(this, obj, qVar);
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public /* synthetic */ void items(int i10, l lVar, r rVar) {
        LazyListScope.CC.d(this, i10, lVar, rVar);
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    @ExperimentalFoundationApi
    public void stickyHeader(@Nullable Object obj, @Nullable Object obj2, @NotNull q<? super LazyItemScope, ? super Composer, ? super Integer, k0> content) {
        t.i(content, "content");
        List arrayList = this._headerIndexes;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this._headerIndexes = arrayList;
        }
        arrayList.add(Integer.valueOf(this._intervals.getSize()));
        item(obj, obj2, content);
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public void item(@Nullable Object obj, @Nullable Object obj2, @NotNull q<? super LazyItemScope, ? super Composer, ? super Integer, k0> content) {
        t.i(content, "content");
        this._intervals.addInterval(1, new LazyListIntervalContent(obj != null ? new AnonymousClass1(obj) : null, new AnonymousClass2(obj2), ComposableLambdaKt.composableLambdaInstance(-735119482, true, new AnonymousClass3(content))));
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public void items(int i10, @Nullable l<? super Integer, ? extends Object> lVar, @NotNull l<? super Integer, ? extends Object> contentType, @NotNull r<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        this._intervals.addInterval(i10, new LazyListIntervalContent(lVar, contentType, itemContent));
    }
}
