package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import h9.r;
import h9.s;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyDsl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LazyListScope, k0> $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyListState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z10, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z11, l<? super LazyListScope, k0> lVar, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyListState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z10;
            this.$verticalArrangement = vertical;
            this.$horizontalAlignment = horizontal;
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
            LazyDslKt.LazyColumn(this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$verticalArrangement, this.$horizontalAlignment, this.$flingBehavior, this.$userScrollEnabled, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LazyListScope, k0> $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyListState $state;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z10, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, l<? super LazyListScope, k0> lVar, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyListState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z10;
            this.$verticalArrangement = vertical;
            this.$horizontalAlignment = horizontal;
            this.$flingBehavior = flingBehavior;
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
            LazyDslKt.LazyColumn(this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$verticalArrangement, this.$horizontalAlignment, this.$flingBehavior, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$LazyRow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    static final class C08711 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LazyListScope, k0> $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyListState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Alignment.Vertical $verticalAlignment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08711(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z10, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z11, l<? super LazyListScope, k0> lVar, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyListState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z10;
            this.$horizontalArrangement = horizontal;
            this.$verticalAlignment = vertical;
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
            LazyDslKt.LazyRow(this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$horizontalArrangement, this.$verticalAlignment, this.$flingBehavior, this.$userScrollEnabled, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$LazyRow$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    static final class C08722 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LazyListScope, k0> $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyListState $state;
        final /* synthetic */ Alignment.Vertical $verticalAlignment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08722(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z10, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, l<? super LazyListScope, k0> lVar, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyListState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z10;
            this.$horizontalArrangement = horizontal;
            this.$verticalAlignment = vertical;
            this.$flingBehavior = flingBehavior;
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
            LazyDslKt.LazyRow(this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$horizontalArrangement, this.$verticalAlignment, this.$flingBehavior, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class C08731 extends v implements l {
        public static final C08731 INSTANCE = new C08731();

        public C08731() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class C08742 extends v implements l<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ l<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08742(l<? super T, ? extends Object> lVar, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class AnonymousClass3 extends v implements l<Integer, Object> {
        final /* synthetic */ l<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(l<? super T, ? extends Object> lVar, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$4, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class AnonymousClass4 extends v implements r<LazyItemScope, Integer, Composer, Integer, k0> {
        final /* synthetic */ r<LazyItemScope, T, Composer, Integer, k0> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(r<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, k0> rVar, List<? extends T> list) {
            super(4);
            this.$itemContent = rVar;
            this.$items = list;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@NotNull LazyItemScope items, int i10, @Nullable Composer composer, int i11) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$5, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class AnonymousClass5 extends v implements l {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$6, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class AnonymousClass6 extends v implements l<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ l<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass6(l<? super T, ? extends Object> lVar, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$7, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class AnonymousClass7 extends v implements l<Integer, Object> {
        final /* synthetic */ l<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(l<? super T, ? extends Object> lVar, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$8, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class AnonymousClass8 extends v implements r<LazyItemScope, Integer, Composer, Integer, k0> {
        final /* synthetic */ r<LazyItemScope, T, Composer, Integer, k0> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(r<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, k0> rVar, T[] tArr) {
            super(4);
            this.$itemContent = rVar;
            this.$items = tArr;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@NotNull LazyItemScope items, int i10, @Nullable Composer composer, int i11) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class C08751 extends v implements p {
        public static final C08751 INSTANCE = new C08751();

        public C08751() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class C08762 extends v implements l<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ p<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08762(p<? super Integer, ? super T, ? extends Object> pVar, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class C08773 extends v implements l<Integer, Object> {
        final /* synthetic */ p<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08773(p<? super Integer, ? super T, ? extends Object> pVar, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class C08784 extends v implements r<LazyItemScope, Integer, Composer, Integer, k0> {
        final /* synthetic */ s<LazyItemScope, Integer, T, Composer, Integer, k0> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08784(s<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, k0> sVar, List<? extends T> list) {
            super(4);
            this.$itemContent = sVar;
            this.$items = list;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@NotNull LazyItemScope items, int i10, @Nullable Composer composer, int i11) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class C08795 extends v implements p {
        public static final C08795 INSTANCE = new C08795();

        public C08795() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class C08806 extends v implements l<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ p<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08806(p<? super Integer, ? super T, ? extends Object> pVar, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$7, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class C08817 extends v implements l<Integer, Object> {
        final /* synthetic */ p<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08817(p<? super Integer, ? super T, ? extends Object> pVar, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    public static final class C08828 extends v implements r<LazyItemScope, Integer, Composer, Integer, k0> {
        final /* synthetic */ s<LazyItemScope, Integer, T, Composer, Integer, k0> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08828(s<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, k0> sVar, T[] tArr) {
            super(4);
            this.$itemContent = sVar;
            this.$items = tArr;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@NotNull LazyItemScope items, int i10, @Nullable Composer composer, int i11) {
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0108  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyColumn(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.lazy.LazyListState r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r32, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Horizontal r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r34, boolean r35, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.foundation.lazy.LazyListScope, v8.k0> r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            Method dump skipped, instruction units count: 598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, h9.l, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0106  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyRow(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.lazy.LazyListState r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r32, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Vertical r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r34, boolean r35, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.foundation.lazy.LazyListScope, v8.k0> r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            Method dump skipped, instruction units count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyRow(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, h9.l, androidx.compose.runtime.Composer, int, int):void");
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyListScope lazyListScope, @NotNull List<? extends T> items, @Nullable l<? super T, ? extends Object> lVar, @NotNull l<? super T, ? extends Object> contentType, @NotNull r<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.size(), lVar != null ? new C08742(lVar, items) : null, new AnonymousClass3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List items, l lVar, l contentType, r itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        if ((i10 & 4) != 0) {
            contentType = C08731.INSTANCE;
        }
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.size(), lVar != null ? new C08742(lVar, items) : null, new AnonymousClass3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyListScope lazyListScope, @NotNull List<? extends T> items, @Nullable p<? super Integer, ? super T, ? extends Object> pVar, @NotNull p<? super Integer, ? super T, ? extends Object> contentType, @NotNull s<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.size(), pVar != null ? new C08762(pVar, items) : null, new C08773(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C08784(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List items, p pVar, p contentType, s itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = null;
        }
        if ((i10 & 4) != 0) {
            contentType = C08751.INSTANCE;
        }
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.size(), pVar != null ? new C08762(pVar, items) : null, new C08773(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C08784(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyListScope lazyListScope, @NotNull T[] items, @Nullable l<? super T, ? extends Object> lVar, @NotNull l<? super T, ? extends Object> contentType, @NotNull r<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.length, lVar != null ? new AnonymousClass6(lVar, items) : null, new AnonymousClass7(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyListScope lazyListScope, @NotNull T[] items, @Nullable p<? super Integer, ? super T, ? extends Object> pVar, @NotNull p<? super Integer, ? super T, ? extends Object> contentType, @NotNull s<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.length, pVar != null ? new C08806(pVar, items) : null, new C08817(contentType, items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C08828(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List items, l lVar, r itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.size(), lVar != null ? new C08742(lVar, items) : null, new AnonymousClass3(C08731.INSTANCE, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List items, p pVar, s itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = null;
        }
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.size(), pVar != null ? new C08762(pVar, items) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C08784(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T> void items(LazyListScope lazyListScope, List<? extends T> items, l<? super T, ? extends Object> lVar, r<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.size(), lVar != null ? new C08742(lVar, items) : null, new AnonymousClass3(C08731.INSTANCE, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> items, p<? super Integer, ? super T, ? extends Object> pVar, s<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.size(), pVar != null ? new C08762(pVar, items) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C08784(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] items, p pVar, p contentType, s itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = null;
        }
        if ((i10 & 4) != 0) {
            contentType = C08795.INSTANCE;
        }
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.length, pVar != null ? new C08806(pVar, items) : null, new C08817(contentType, items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C08828(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] items, l lVar, l contentType, r itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        if ((i10 & 4) != 0) {
            contentType = AnonymousClass5.INSTANCE;
        }
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(contentType, "contentType");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.length, lVar != null ? new AnonymousClass6(lVar, items) : null, new AnonymousClass7(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope lazyListScope, T[] items, p<? super Integer, ? super T, ? extends Object> pVar, s<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.length, pVar != null ? new C08806(pVar, items) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C08828(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T> void items(LazyListScope lazyListScope, T[] items, l<? super T, ? extends Object> lVar, r<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, k0> itemContent) {
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.length, lVar != null ? new AnonymousClass6(lVar, items) : null, new AnonymousClass7(AnonymousClass5.INSTANCE, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(itemContent, items)));
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0117  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void LazyColumn(androidx.compose.ui.Modifier r26, androidx.compose.foundation.lazy.LazyListState r27, androidx.compose.foundation.layout.PaddingValues r28, boolean r29, androidx.compose.foundation.layout.Arrangement.Vertical r30, androidx.compose.ui.Alignment.Horizontal r31, androidx.compose.foundation.gestures.FlingBehavior r32, h9.l r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, h9.l, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0117  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void LazyRow(androidx.compose.ui.Modifier r26, androidx.compose.foundation.lazy.LazyListState r27, androidx.compose.foundation.layout.PaddingValues r28, boolean r29, androidx.compose.foundation.layout.Arrangement.Horizontal r30, androidx.compose.ui.Alignment.Vertical r31, androidx.compose.foundation.gestures.FlingBehavior r32, h9.l r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyDslKt.LazyRow(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.FlingBehavior, h9.l, androidx.compose.runtime.Composer, int, int):void");
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] items, p pVar, s itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = null;
        }
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.length, pVar != null ? new C08806(pVar, items) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C08828(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] items, l lVar, r itemContent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        t.i(lazyListScope, "<this>");
        t.i(items, "items");
        t.i(itemContent, "itemContent");
        lazyListScope.items(items.length, lVar != null ? new AnonymousClass6(lVar, items) : null, new AnonymousClass7(AnonymousClass5.INSTANCE, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(itemContent, items)));
    }
}
