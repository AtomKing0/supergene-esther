package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: ScrollExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollExtensionsKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScrollExtensions.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", l = {40}, m = "animateScrollBy")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
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
            return ScrollExtensionsKt.animateScrollBy(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScrollExtensions.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2", f = "ScrollExtensions.kt", l = {41}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<ScrollScope, z8.d<? super k0>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ kotlin.jvm.internal.k0 $previousValue;
        final /* synthetic */ float $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ScrollExtensions.kt */
        static final class AnonymousClass1 extends v implements p<Float, Float, k0> {
            final /* synthetic */ ScrollScope $$this$scroll;
            final /* synthetic */ kotlin.jvm.internal.k0 $previousValue;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(kotlin.jvm.internal.k0 k0Var, ScrollScope scrollScope) {
                super(2);
                this.$previousValue = k0Var;
                this.$$this$scroll = scrollScope;
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(Float f10, Float f11) {
                invoke(f10.floatValue(), f11.floatValue());
                return k0.f35197a;
            }

            public final void invoke(float f10, float f11) {
                kotlin.jvm.internal.k0 k0Var = this.$previousValue;
                float f12 = k0Var.f29829a;
                k0Var.f29829a = f12 + this.$$this$scroll.scrollBy(f10 - f12);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(float f10, AnimationSpec<Float> animationSpec, kotlin.jvm.internal.k0 k0Var, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$value = f10;
            this.$animationSpec = animationSpec;
            this.$previousValue = k0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$value, this.$animationSpec, this.$previousValue, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull ScrollScope scrollScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(scrollScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                ScrollScope scrollScope = (ScrollScope) this.L$0;
                float f10 = this.$value;
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$previousValue, scrollScope);
                this.label = 1;
                if (SuspendAnimationKt.animate$default(0.0f, f10, 0.0f, animationSpec, anonymousClass1, this, 4, null) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScrollExtensions.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", l = {61}, m = "scrollBy")
    static final class C08431 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08431(z8.d<? super C08431> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScrollExtensionsKt.scrollBy(null, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScrollExtensions.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2", f = "ScrollExtensions.kt", l = {}, m = "invokeSuspend")
    static final class C08442 extends l implements p<ScrollScope, z8.d<? super k0>, Object> {
        final /* synthetic */ kotlin.jvm.internal.k0 $consumed;
        final /* synthetic */ float $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08442(kotlin.jvm.internal.k0 k0Var, float f10, z8.d<? super C08442> dVar) {
            super(2, dVar);
            this.$consumed = k0Var;
            this.$value = f10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08442 c08442 = new C08442(this.$consumed, this.$value, dVar);
            c08442.L$0 = obj;
            return c08442;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull ScrollScope scrollScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08442) create(scrollScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            ScrollScope scrollScope = (ScrollScope) this.L$0;
            this.$consumed.f29829a = scrollScope.scrollBy(this.$value);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$stopScroll$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScrollExtensions.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$stopScroll$2", f = "ScrollExtensions.kt", l = {}, m = "invokeSuspend")
    static final class C08452 extends l implements p<ScrollScope, z8.d<? super k0>, Object> {
        int label;

        C08452(z8.d<? super C08452> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C08452(dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull ScrollScope scrollScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08452) create(scrollScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return k0.f35197a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object animateScrollBy(@org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.ScrollableState r7, float r8, @org.jetbrains.annotations.NotNull androidx.compose.animation.core.AnimationSpec<java.lang.Float> r9, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Float> r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.ScrollExtensionsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1 r0 = (androidx.compose.foundation.gestures.ScrollExtensionsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1 r0 = new androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1
            r0.<init>(r10)
        L18:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = a9.b.e()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r7 = r4.L$0
            kotlin.jvm.internal.k0 r7 = (kotlin.jvm.internal.k0) r7
            v8.u.b(r10)
            goto L57
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            v8.u.b(r10)
            kotlin.jvm.internal.k0 r10 = new kotlin.jvm.internal.k0
            r10.<init>()
            r3 = 0
            androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2 r5 = new androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2
            r1 = 0
            r5.<init>(r8, r9, r10, r1)
            r8 = 1
            r6 = 0
            r4.L$0 = r10
            r4.label = r2
            r1 = r7
            r2 = r3
            r3 = r5
            r5 = r8
            java.lang.Object r7 = androidx.compose.foundation.gestures.d.a(r1, r2, r3, r4, r5, r6)
            if (r7 != r0) goto L56
            return r0
        L56:
            r7 = r10
        L57:
            float r7 = r7.f29829a
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.b.c(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy(androidx.compose.foundation.gestures.ScrollableState, float, androidx.compose.animation.core.AnimationSpec, z8.d):java.lang.Object");
    }

    public static /* synthetic */ Object animateScrollBy$default(ScrollableState scrollableState, float f10, AnimationSpec animationSpec, z8.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animateScrollBy(scrollableState, f10, animationSpec, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object scrollBy(@org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.ScrollableState r7, float r8, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Float> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.ScrollExtensionsKt.C08431
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1 r0 = (androidx.compose.foundation.gestures.ScrollExtensionsKt.C08431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1 r0 = new androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1
            r0.<init>(r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = a9.b.e()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r7 = r4.L$0
            kotlin.jvm.internal.k0 r7 = (kotlin.jvm.internal.k0) r7
            v8.u.b(r9)
            goto L57
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            v8.u.b(r9)
            kotlin.jvm.internal.k0 r9 = new kotlin.jvm.internal.k0
            r9.<init>()
            r3 = 0
            androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2 r5 = new androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2
            r1 = 0
            r5.<init>(r9, r8, r1)
            r8 = 1
            r6 = 0
            r4.L$0 = r9
            r4.label = r2
            r1 = r7
            r2 = r3
            r3 = r5
            r5 = r8
            java.lang.Object r7 = androidx.compose.foundation.gestures.d.a(r1, r2, r3, r4, r5, r6)
            if (r7 != r0) goto L56
            return r0
        L56:
            r7 = r9
        L57:
            float r7 = r7.f29829a
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.b.c(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollExtensionsKt.scrollBy(androidx.compose.foundation.gestures.ScrollableState, float, z8.d):java.lang.Object");
    }

    @Nullable
    public static final Object stopScroll(@NotNull ScrollableState scrollableState, @NotNull MutatePriority mutatePriority, @NotNull z8.d<? super k0> dVar) {
        Object objScroll = scrollableState.scroll(mutatePriority, new C08452(null), dVar);
        return objScroll == a9.d.e() ? objScroll : k0.f35197a;
    }

    public static /* synthetic */ Object stopScroll$default(ScrollableState scrollableState, MutatePriority mutatePriority, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopScroll(scrollableState, mutatePriority, dVar);
    }
}
