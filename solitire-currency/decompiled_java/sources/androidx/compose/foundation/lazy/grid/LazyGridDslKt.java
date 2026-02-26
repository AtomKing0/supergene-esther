package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import h9.l;
import h9.p;
import h9.q;
import h9.r;
import h9.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyGridDsl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LazyGridScope, k0> $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ GridCells $rows;
        final /* synthetic */ LazyGridState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z10, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z11, l<? super LazyGridScope, k0> lVar, int i10, int i11) {
            super(2);
            this.$rows = gridCells;
            this.$modifier = modifier;
            this.$state = lazyGridState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z10;
            this.$horizontalArrangement = horizontal;
            this.$verticalArrangement = vertical;
            this.$flingBehavior = flingBehavior;
            this.$userScrollEnabled = z11;
            this.$content = lVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LazyGridDslKt.LazyHorizontalGrid(this.$rows, this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$horizontalArrangement, this.$verticalArrangement, this.$flingBehavior, this.$userScrollEnabled, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    static final class C08831 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ GridCells $columns;
        final /* synthetic */ l<LazyGridScope, k0> $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyGridState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08831(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z10, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z11, l<? super LazyGridScope, k0> lVar, int i10, int i11) {
            super(2);
            this.$columns = gridCells;
            this.$modifier = modifier;
            this.$state = lazyGridState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z10;
            this.$verticalArrangement = vertical;
            this.$horizontalArrangement = horizontal;
            this.$flingBehavior = flingBehavior;
            this.$userScrollEnabled = z11;
            this.$content = lVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LazyGridDslKt.LazyVerticalGrid(this.$columns, this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$verticalArrangement, this.$horizontalArrangement, this.$flingBehavior, this.$userScrollEnabled, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C08841 extends v implements l {
        public static final C08841 INSTANCE = new C08841();

        public C08841() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$10, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class AnonymousClass10 extends v implements r<LazyGridItemScope, Integer, Composer, Integer, k0> {
        final /* synthetic */ r<LazyGridItemScope, T, Composer, Integer, k0> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass10(r<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, k0> rVar, T[] tArr) {
            super(4);
            this.$itemContent = rVar;
            this.$items = tArr;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@NotNull LazyGridItemScope items, int i10, @Nullable Composer composer, int i11) {
            int i12;
            t.i(items, "$this$items");
            if ((i11 & 14) == 0) {
                i12 = (composer.changed(items) ? 4 : 2) | i11;
            } else {
                i12 = i11;
            }
            if ((i11 & 112) == 0) {
                i12 |= composer.changed(i10) ? 32 : 16;
            }
            if ((i12 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$itemContent.invoke(items, this.$items[i10], composer, Integer.valueOf(i12 & 14));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class AnonymousClass2 extends v implements l<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ l<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(l<? super T, ? extends Object> lVar, List<? extends T> list) {
            super(1);
            this.$key = lVar;
            this.$items = list;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        @NotNull
        public final Object invoke(int i10) {
            return this.$key.invoke(this.$items.get(i10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class AnonymousClass3 extends v implements p<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ p<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(p<? super LazyGridItemSpanScope, ? super T, GridItemSpan> pVar, List<? extends T> list) {
            super(2);
            this.$span = pVar;
            this.$items = list;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ GridItemSpan mo4invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m531boximpl(m554invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m554invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i10) {
            t.i(lazyGridItemSpanScope, "$this$null");
            return this.$span.mo4invoke(lazyGridItemSpanScope, this.$items.get(i10)).m538unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$4, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class AnonymousClass4 extends v implements l<Integer, Object> {
        final /* synthetic */ l<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(l<? super T, ? extends Object> lVar, List<? extends T> list) {
            super(1);
            this.$contentType = lVar;
            this.$items = list;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        @Nullable
        public final Object invoke(int i10) {
            return this.$contentType.invoke(this.$items.get(i10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$5, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class AnonymousClass5 extends v implements r<LazyGridItemScope, Integer, Composer, Integer, k0> {
        final /* synthetic */ r<LazyGridItemScope, T, Composer, Integer, k0> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(r<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, k0> rVar, List<? extends T> list) {
            super(4);
            this.$itemContent = rVar;
            this.$items = list;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@NotNull LazyGridItemScope items, int i10, @Nullable Composer composer, int i11) {
            int i12;
            t.i(items, "$this$items");
            if ((i11 & 14) == 0) {
                i12 = (composer.changed(items) ? 4 : 2) | i11;
            } else {
                i12 = i11;
            }
            if ((i11 & 112) == 0) {
                i12 |= composer.changed(i10) ? 32 : 16;
            }
            if ((i12 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$itemContent.invoke(items, this.$items.get(i10), composer, Integer.valueOf(i12 & 14));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$6, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class AnonymousClass6 extends v implements l {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$7, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class AnonymousClass7 extends v implements l<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ l<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(l<? super T, ? extends Object> lVar, T[] tArr) {
            super(1);
            this.$key = lVar;
            this.$items = tArr;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        @NotNull
        public final Object invoke(int i10) {
            return this.$key.invoke(this.$items[i10]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$8, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class AnonymousClass8 extends v implements p<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ p<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(p<? super LazyGridItemSpanScope, ? super T, GridItemSpan> pVar, T[] tArr) {
            super(2);
            this.$span = pVar;
            this.$items = tArr;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ GridItemSpan mo4invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m531boximpl(m555invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m555invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i10) {
            t.i(lazyGridItemSpanScope, "$this$null");
            return this.$span.mo4invoke(lazyGridItemSpanScope, this.$items[i10]).m538unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$9, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class AnonymousClass9 extends v implements l<Integer, Object> {
        final /* synthetic */ l<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass9(l<? super T, ? extends Object> lVar, T[] tArr) {
            super(1);
            this.$contentType = lVar;
            this.$items = tArr;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        @Nullable
        public final Object invoke(int i10) {
            return this.$contentType.invoke(this.$items[i10]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C08851 extends v implements p {
        public static final C08851 INSTANCE = new C08851();

        public C08851() {
            super(2);
        }

        @Nullable
        public final Void invoke(int i10, Object obj) {
            return null;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), obj2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$10, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C088610 extends v implements r<LazyGridItemScope, Integer, Composer, Integer, k0> {
        final /* synthetic */ s<LazyGridItemScope, Integer, T, Composer, Integer, k0> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C088610(s<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, k0> sVar, T[] tArr) {
            super(4);
            this.$itemContent = sVar;
            this.$items = tArr;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@NotNull LazyGridItemScope items, int i10, @Nullable Composer composer, int i11) {
            int i12;
            t.i(items, "$this$items");
            if ((i11 & 14) == 0) {
                i12 = (composer.changed(items) ? 4 : 2) | i11;
            } else {
                i12 = i11;
            }
            if ((i11 & 112) == 0) {
                i12 |= composer.changed(i10) ? 32 : 16;
            }
            if ((i12 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$itemContent.invoke(items, Integer.valueOf(i10), this.$items[i10], composer, Integer.valueOf((i12 & 14) | (i12 & 112)));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C08872 extends v implements l<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ p<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08872(p<? super Integer, ? super T, ? extends Object> pVar, List<? extends T> list) {
            super(1);
            this.$key = pVar;
            this.$items = list;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        @NotNull
        public final Object invoke(int i10) {
            return this.$key.mo4invoke(Integer.valueOf(i10), this.$items.get(i10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C08883 extends v implements p<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ q<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08883(q<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> qVar, List<? extends T> list) {
            super(2);
            this.$span = qVar;
            this.$items = list;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ GridItemSpan mo4invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m531boximpl(m556invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m556invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i10) {
            t.i(lazyGridItemSpanScope, "$this$null");
            return this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i10), this.$items.get(i10)).m538unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C08894 extends v implements l<Integer, Object> {
        final /* synthetic */ p<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08894(p<? super Integer, ? super T, ? extends Object> pVar, List<? extends T> list) {
            super(1);
            this.$contentType = pVar;
            this.$items = list;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        @Nullable
        public final Object invoke(int i10) {
            return this.$contentType.mo4invoke(Integer.valueOf(i10), this.$items.get(i10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C08905 extends v implements r<LazyGridItemScope, Integer, Composer, Integer, k0> {
        final /* synthetic */ s<LazyGridItemScope, Integer, T, Composer, Integer, k0> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08905(s<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, k0> sVar, List<? extends T> list) {
            super(4);
            this.$itemContent = sVar;
            this.$items = list;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@NotNull LazyGridItemScope items, int i10, @Nullable Composer composer, int i11) {
            int i12;
            t.i(items, "$this$items");
            if ((i11 & 14) == 0) {
                i12 = (composer.changed(items) ? 4 : 2) | i11;
            } else {
                i12 = i11;
            }
            if ((i11 & 112) == 0) {
                i12 |= composer.changed(i10) ? 32 : 16;
            }
            if ((i12 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$itemContent.invoke(items, Integer.valueOf(i10), this.$items.get(i10), composer, Integer.valueOf((i12 & 14) | (i12 & 112)));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C08916 extends v implements p {
        public static final C08916 INSTANCE = new C08916();

        public C08916() {
            super(2);
        }

        @Nullable
        public final Void invoke(int i10, Object obj) {
            return null;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), obj2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$7, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C08927 extends v implements l<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ p<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08927(p<? super Integer, ? super T, ? extends Object> pVar, T[] tArr) {
            super(1);
            this.$key = pVar;
            this.$items = tArr;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        @NotNull
        public final Object invoke(int i10) {
            return this.$key.mo4invoke(Integer.valueOf(i10), this.$items[i10]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C08938 extends v implements p<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ q<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08938(q<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> qVar, T[] tArr) {
            super(2);
            this.$span = qVar;
            this.$items = tArr;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ GridItemSpan mo4invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m531boximpl(m557invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m557invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i10) {
            t.i(lazyGridItemSpanScope, "$this$null");
            return this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i10), this.$items[i10]).m538unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$9, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    public static final class C08949 extends v implements l<Integer, Object> {
        final /* synthetic */ p<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08949(p<? super Integer, ? super T, ? extends Object> pVar, T[] tArr) {
            super(1);
            this.$contentType = pVar;
            this.$items = tArr;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        @Nullable
        public final Object invoke(int i10) {
            return this.$contentType.mo4invoke(Integer.valueOf(i10), this.$items[i10]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010b  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyHorizontalGrid(@org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.grid.GridCells r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.lazy.grid.LazyGridState r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r32, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r34, boolean r35, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.foundation.lazy.grid.LazyGridScope, v8.k0> r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            Method dump skipped, instruction units count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, h9.l, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010b  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyVerticalGrid(@org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.grid.GridCells r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.lazy.grid.LazyGridState r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r32, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r34, boolean r35, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.foundation.lazy.grid.LazyGridScope, v8.k0> r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            Method dump skipped, instruction units count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, h9.l, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i10, int i11, int i12) {
        int i13 = i10 - (i12 * (i11 - 1));
        int i14 = i13 / i11;
        int i15 = i13 % i11;
        ArrayList arrayList = new ArrayList(i11);
        int i16 = 0;
        while (i16 < i11) {
            arrayList.add(Integer.valueOf((i16 < i15 ? 1 : 0) + i14));
            i16++;
        }
        return arrayList;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyGridScope lazyGridScope, @NotNull List<? extends T> items, @Nullable l<? super T, ? extends Object> lVar, @Nullable p<? super LazyGridItemSpanScope, ? super T, GridItemSpan> pVar, @NotNull l<? super T, ? extends Object> contentType, @NotNull r<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyGridScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyGridScope.items(items.size(), lVar != null ? new AnonymousClass2(lVar, items) : null, pVar != null ? new AnonymousClass3(pVar, items) : null, new AnonymousClass4(contentType, items), ComposableLambdaKt.composableLambdaInstance(699646206, true, new AnonymousClass5(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List items, l lVar, p pVar, l contentType, r itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        if ((i10 & 4) != 0) {
            pVar = null;
        }
        if ((i10 & 8) != 0) {
            contentType = C08841.INSTANCE;
        }
        t.i(lazyGridScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyGridScope.items(items.size(), lVar != null ? new AnonymousClass2(lVar, items) : null, pVar != null ? new AnonymousClass3(pVar, items) : null, new AnonymousClass4(contentType, items), ComposableLambdaKt.composableLambdaInstance(699646206, true, new AnonymousClass5(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyGridScope lazyGridScope, @NotNull List<? extends T> items, @Nullable p<? super Integer, ? super T, ? extends Object> pVar, @Nullable q<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> qVar, @NotNull p<? super Integer, ? super T, ? extends Object> contentType, @NotNull s<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyGridScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyGridScope.items(items.size(), pVar != null ? new C08872(pVar, items) : null, qVar != null ? new C08883(qVar, items) : null, new C08894(contentType, items), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new C08905(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List items, p pVar, q qVar, p contentType, s itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = null;
        }
        if ((i10 & 4) != 0) {
            qVar = null;
        }
        if ((i10 & 8) != 0) {
            contentType = C08851.INSTANCE;
        }
        t.i(lazyGridScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyGridScope.items(items.size(), pVar != null ? new C08872(pVar, items) : null, qVar != null ? new C08883(qVar, items) : null, new C08894(contentType, items), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new C08905(itemContent, items)));
    }

    @Composable
    private static final p<Density, Constraints, List<Integer>> rememberColumnWidthSums(GridCells gridCells, Arrangement.Horizontal horizontal, PaddingValues paddingValues, Composer composer, int i10) {
        composer.startReplaceableGroup(-1355301804);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(gridCells) | composer.changed(horizontal) | composer.changed(paddingValues);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyGridDslKt$rememberColumnWidthSums$1$1(paddingValues, gridCells, horizontal);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        p<Density, Constraints, List<Integer>> pVar = (p) objRememberedValue;
        composer.endReplaceableGroup();
        return pVar;
    }

    @Composable
    private static final p<Density, Constraints, List<Integer>> rememberRowHeightSums(GridCells gridCells, Arrangement.Vertical vertical, PaddingValues paddingValues, Composer composer, int i10) {
        composer.startReplaceableGroup(239683573);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(gridCells) | composer.changed(vertical) | composer.changed(paddingValues);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyGridDslKt$rememberRowHeightSums$1$1(paddingValues, gridCells, vertical);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        p<Density, Constraints, List<Integer>> pVar = (p) objRememberedValue;
        composer.endReplaceableGroup();
        return pVar;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyGridScope lazyGridScope, @NotNull T[] items, @Nullable l<? super T, ? extends Object> lVar, @Nullable p<? super LazyGridItemSpanScope, ? super T, GridItemSpan> pVar, @NotNull l<? super T, ? extends Object> contentType, @NotNull r<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyGridScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyGridScope.items(items.length, lVar != null ? new AnonymousClass7(lVar, items) : null, pVar != null ? new AnonymousClass8(pVar, items) : null, new AnonymousClass9(contentType, items), ComposableLambdaKt.composableLambdaInstance(407562193, true, new AnonymousClass10(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyGridScope lazyGridScope, @NotNull T[] items, @Nullable p<? super Integer, ? super T, ? extends Object> pVar, @Nullable q<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> qVar, @NotNull p<? super Integer, ? super T, ? extends Object> contentType, @NotNull s<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyGridScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyGridScope.items(items.length, pVar != null ? new C08927(pVar, items) : null, qVar != null ? new C08938(qVar, items) : null, new C08949(contentType, items), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new C088610(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] items, l lVar, p pVar, l contentType, r itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        if ((i10 & 4) != 0) {
            pVar = null;
        }
        if ((i10 & 8) != 0) {
            contentType = AnonymousClass6.INSTANCE;
        }
        t.i(lazyGridScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyGridScope.items(items.length, lVar != null ? new AnonymousClass7(lVar, items) : null, pVar != null ? new AnonymousClass8(pVar, items) : null, new AnonymousClass9(contentType, items), ComposableLambdaKt.composableLambdaInstance(407562193, true, new AnonymousClass10(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] items, p pVar, q qVar, p contentType, s itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = null;
        }
        if ((i10 & 4) != 0) {
            qVar = null;
        }
        if ((i10 & 8) != 0) {
            contentType = C08916.INSTANCE;
        }
        t.i(lazyGridScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyGridScope.items(items.length, pVar != null ? new C08927(pVar, items) : null, qVar != null ? new C08938(qVar, items) : null, new C08949(contentType, items), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new C088610(itemContent, items)));
    }
}
