package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import h9.b;
import h9.c;
import h9.e;
import h9.f;
import h9.g;
import h9.h;
import h9.i;
import h9.j;
import h9.k;
import h9.m;
import h9.n;
import h9.p;
import h9.q;
import h9.r;
import h9.s;
import h9.u;
import h9.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ComposableLambda.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class ComposableLambdaImpl implements ComposableLambda {

    @Nullable
    private Object _block;
    private final int key;

    @Nullable
    private RecomposeScope scope;

    @Nullable
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ Object $p1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, int i10) {
            super(2);
            this.$p1 = obj;
            this.$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, nc, this.$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$10, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass10 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p10;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;
        final /* synthetic */ Object $p9;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass10(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, int i10) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$p9 = obj9;
            this.$p10 = obj10;
            this.$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl composableLambdaImpl = ComposableLambdaImpl.this;
            Object obj = this.$p1;
            Object obj2 = this.$p2;
            Object obj3 = this.$p3;
            Object obj4 = this.$p4;
            Object obj5 = this.$p5;
            Object obj6 = this.$p6;
            Object obj7 = this.$p7;
            Object obj8 = this.$p8;
            Object obj9 = this.$p9;
            Object obj10 = this.$p10;
            int i11 = this.$changed;
            composableLambdaImpl.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, nc, i11 | 1, i11);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$11, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass11 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ int $changed1;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p10;
        final /* synthetic */ Object $p11;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;
        final /* synthetic */ Object $p9;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, int i10, int i11) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$p9 = obj9;
            this.$p10 = obj10;
            this.$p11 = obj11;
            this.$changed = i10;
            this.$changed1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, this.$p9, this.$p10, this.$p11, nc, this.$changed | 1, this.$changed1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$12, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass12 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ int $changed1;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p10;
        final /* synthetic */ Object $p11;
        final /* synthetic */ Object $p12;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;
        final /* synthetic */ Object $p9;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass12(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, int i10, int i11) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$p9 = obj9;
            this.$p10 = obj10;
            this.$p11 = obj11;
            this.$p12 = obj12;
            this.$changed = i10;
            this.$changed1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, this.$p9, this.$p10, this.$p11, this.$p12, nc, this.$changed | 1, this.$changed1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$13, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass13 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ int $changed1;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p10;
        final /* synthetic */ Object $p11;
        final /* synthetic */ Object $p12;
        final /* synthetic */ Object $p13;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;
        final /* synthetic */ Object $p9;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass13(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, int i10, int i11) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$p9 = obj9;
            this.$p10 = obj10;
            this.$p11 = obj11;
            this.$p12 = obj12;
            this.$p13 = obj13;
            this.$changed = i10;
            this.$changed1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, this.$p9, this.$p10, this.$p11, this.$p12, this.$p13, nc, this.$changed | 1, this.$changed1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$14, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass14 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ int $changed1;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p10;
        final /* synthetic */ Object $p11;
        final /* synthetic */ Object $p12;
        final /* synthetic */ Object $p13;
        final /* synthetic */ Object $p14;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;
        final /* synthetic */ Object $p9;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass14(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, int i10, int i11) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$p9 = obj9;
            this.$p10 = obj10;
            this.$p11 = obj11;
            this.$p12 = obj12;
            this.$p13 = obj13;
            this.$p14 = obj14;
            this.$changed = i10;
            this.$changed1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, this.$p9, this.$p10, this.$p11, this.$p12, this.$p13, this.$p14, nc, this.$changed | 1, this.$changed1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$15, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass15 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ int $changed1;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p10;
        final /* synthetic */ Object $p11;
        final /* synthetic */ Object $p12;
        final /* synthetic */ Object $p13;
        final /* synthetic */ Object $p14;
        final /* synthetic */ Object $p15;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;
        final /* synthetic */ Object $p9;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass15(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, int i10, int i11) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$p9 = obj9;
            this.$p10 = obj10;
            this.$p11 = obj11;
            this.$p12 = obj12;
            this.$p13 = obj13;
            this.$p14 = obj14;
            this.$p15 = obj15;
            this.$changed = i10;
            this.$changed1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, this.$p9, this.$p10, this.$p11, this.$p12, this.$p13, this.$p14, this.$p15, nc, this.$changed | 1, this.$changed1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$16, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass16 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ int $changed1;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p10;
        final /* synthetic */ Object $p11;
        final /* synthetic */ Object $p12;
        final /* synthetic */ Object $p13;
        final /* synthetic */ Object $p14;
        final /* synthetic */ Object $p15;
        final /* synthetic */ Object $p16;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;
        final /* synthetic */ Object $p9;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass16(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, int i10, int i11) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$p9 = obj9;
            this.$p10 = obj10;
            this.$p11 = obj11;
            this.$p12 = obj12;
            this.$p13 = obj13;
            this.$p14 = obj14;
            this.$p15 = obj15;
            this.$p16 = obj16;
            this.$changed = i10;
            this.$changed1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, this.$p9, this.$p10, this.$p11, this.$p12, this.$p13, this.$p14, this.$p15, this.$p16, nc, this.$changed | 1, this.$changed1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$17, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass17 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ int $changed1;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p10;
        final /* synthetic */ Object $p11;
        final /* synthetic */ Object $p12;
        final /* synthetic */ Object $p13;
        final /* synthetic */ Object $p14;
        final /* synthetic */ Object $p15;
        final /* synthetic */ Object $p16;
        final /* synthetic */ Object $p17;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;
        final /* synthetic */ Object $p9;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass17(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, int i10, int i11) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$p9 = obj9;
            this.$p10 = obj10;
            this.$p11 = obj11;
            this.$p12 = obj12;
            this.$p13 = obj13;
            this.$p14 = obj14;
            this.$p15 = obj15;
            this.$p16 = obj16;
            this.$p17 = obj17;
            this.$changed = i10;
            this.$changed1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, this.$p9, this.$p10, this.$p11, this.$p12, this.$p13, this.$p14, this.$p15, this.$p16, this.$p17, nc, this.$changed | 1, this.$changed1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$18, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass18 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ int $changed1;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p10;
        final /* synthetic */ Object $p11;
        final /* synthetic */ Object $p12;
        final /* synthetic */ Object $p13;
        final /* synthetic */ Object $p14;
        final /* synthetic */ Object $p15;
        final /* synthetic */ Object $p16;
        final /* synthetic */ Object $p17;
        final /* synthetic */ Object $p18;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;
        final /* synthetic */ Object $p9;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass18(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, int i10, int i11) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$p9 = obj9;
            this.$p10 = obj10;
            this.$p11 = obj11;
            this.$p12 = obj12;
            this.$p13 = obj13;
            this.$p14 = obj14;
            this.$p15 = obj15;
            this.$p16 = obj16;
            this.$p17 = obj17;
            this.$p18 = obj18;
            this.$changed = i10;
            this.$changed1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, this.$p9, this.$p10, this.$p11, this.$p12, this.$p13, this.$p14, this.$p15, this.$p16, this.$p17, this.$p18, nc, this.$changed | 1, this.$changed1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Object obj, Object obj2, int i10) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, nc, this.$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$3, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Object obj, Object obj2, Object obj3, int i10) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, nc, this.$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$4, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, nc, this.$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$5, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass5 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i10) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, nc, this.$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$6, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass6 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i10) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, nc, this.$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$7, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass7 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, int i10) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, nc, this.$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$8, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass8 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, int i10) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, nc, this.$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$9, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambda.jvm.kt */
    static final class AnonymousClass9 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $changed;
        final /* synthetic */ Object $p1;
        final /* synthetic */ Object $p2;
        final /* synthetic */ Object $p3;
        final /* synthetic */ Object $p4;
        final /* synthetic */ Object $p5;
        final /* synthetic */ Object $p6;
        final /* synthetic */ Object $p7;
        final /* synthetic */ Object $p8;
        final /* synthetic */ Object $p9;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, int i10) {
            super(2);
            this.$p1 = obj;
            this.$p2 = obj2;
            this.$p3 = obj3;
            this.$p4 = obj4;
            this.$p5 = obj5;
            this.$p6 = obj6;
            this.$p7 = obj7;
            this.$p8 = obj8;
            this.$p9 = obj9;
            this.$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            ComposableLambdaImpl.this.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, this.$p9, nc, this.$changed | 1);
        }
    }

    public ComposableLambdaImpl(int i10, boolean z10) {
        this.key = i10;
        this.tracked = z10;
    }

    private final void trackRead(Composer composer) {
        RecomposeScope recomposeScope;
        if (!this.tracked || (recomposeScope = composer.getRecomposeScope()) == null) {
            return;
        }
        composer.recordUsed(recomposeScope);
        if (ComposableLambdaKt.replacableWith(this.scope, recomposeScope)) {
            this.scope = recomposeScope;
            return;
        }
        List<RecomposeScope> list = this.scopes;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.scopes = arrayList;
            arrayList.add(recomposeScope);
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (ComposableLambdaKt.replacableWith(list.get(i10), recomposeScope)) {
                list.set(i10, recomposeScope);
                return;
            }
        }
        list.add(recomposeScope);
    }

    private final void trackWrite() {
        if (this.tracked) {
            RecomposeScope recomposeScope = this.scope;
            if (recomposeScope != null) {
                recomposeScope.invalidate();
                this.scope = null;
            }
            List<RecomposeScope> list = this.scopes;
            if (list != null) {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    list.get(i10).invalidate();
                }
                list.clear();
            }
        }
    }

    public final int getKey() {
        return this.key;
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(Composer composer, Integer num) {
        return invoke(composer, num.intValue());
    }

    public final void update(@NotNull Object block) {
        t.i(block, "block");
        if (t.d(this._block, block)) {
            return;
        }
        boolean z10 = this._block == null;
        this._block = block;
        if (z10) {
            return;
        }
        trackWrite();
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.q
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Composer composer, Integer num) {
        return invoke(obj, composer, num.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.r
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Composer composer, Integer num) {
        return invoke(obj, obj2, composer, num.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.s
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Composer composer, Integer num) {
        return invoke(obj, obj2, obj3, composer, num.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.t
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Composer composer, Integer num) {
        return invoke(obj, obj2, obj3, obj4, composer, num.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.u
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Composer composer, Integer num) {
        return invoke(obj, obj2, obj3, obj4, obj5, composer, num.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.v
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Composer composer, Integer num) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, composer, num.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.w
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Composer composer, Integer num) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, composer, num.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.b
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Composer composer, Integer num) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, composer, num.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.c
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Composer composer, Integer num) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, composer, num.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.e
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Composer composer, Integer num, Integer num2) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, composer, num.intValue(), num2.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.f
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Composer composer, Integer num, Integer num2) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, composer, num.intValue(), num2.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.g
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Composer composer, Integer num, Integer num2) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, composer, num.intValue(), num2.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.h
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Composer composer, Integer num, Integer num2) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, composer, num.intValue(), num2.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.i
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Composer composer, Integer num, Integer num2) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, composer, num.intValue(), num2.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.j
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Composer composer, Integer num, Integer num2) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, composer, num.intValue(), num2.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Composer composer, Integer num, Integer num2) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, composer, num.intValue(), num2.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.m
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Composer composer, Integer num, Integer num2) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, composer, num.intValue(), num2.intValue());
    }

    @Override // androidx.compose.runtime.internal.ComposableLambda, h9.n
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Composer composer, Integer num, Integer num2) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, composer, num.intValue(), num2.intValue());
    }

    @Nullable
    public Object invoke(@NotNull Composer c10, int i10) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i10 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(0) : ComposableLambdaKt.sameBits(0));
        Object obj = this._block;
        if (obj != null) {
            Object objMo4invoke = ((p) t0.f(obj, 2)).mo4invoke(composerStartRestartGroup, Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope((p) t0.f(this, 2));
            }
            return objMo4invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @NotNull Composer c10, int i10) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(1) : ComposableLambdaKt.sameBits(1)) | i10;
        Object obj2 = this._block;
        if (obj2 != null) {
            Object objInvoke = ((q) t0.f(obj2, 3)).invoke(obj, composerStartRestartGroup, Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(obj, i10));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @NotNull Composer c10, int i10) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(2) : ComposableLambdaKt.sameBits(2)) | i10;
        Object obj3 = this._block;
        if (obj3 != null) {
            Object objInvoke = ((r) t0.f(obj3, 4)).invoke(obj, obj2, composerStartRestartGroup, Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(obj, obj2, i10));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function4<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull Composer c10, int i10) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(3) : ComposableLambdaKt.sameBits(3)) | i10;
        Object obj4 = this._block;
        if (obj4 != null) {
            Object objInvoke = ((s) t0.f(obj4, 5)).invoke(obj, obj2, obj3, composerStartRestartGroup, Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(obj, obj2, obj3, i10));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function5<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @NotNull Composer c10, int i10) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(4) : ComposableLambdaKt.sameBits(4)) | i10;
        Object obj5 = this._block;
        if (obj5 != null) {
            Object objInvoke = ((h9.t) t0.f(obj5, 6)).invoke(obj, obj2, obj3, obj4, composerStartRestartGroup, Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(obj, obj2, obj3, obj4, i10));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function6<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @NotNull Composer c10, int i10) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i10 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(5) : ComposableLambdaKt.sameBits(5));
        Object obj6 = this._block;
        if (obj6 != null) {
            Object objInvoke = ((u) t0.f(obj6, 7)).invoke(obj, obj2, obj3, obj4, obj5, composerStartRestartGroup, Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(obj, obj2, obj3, obj4, obj5, i10));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function7<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @NotNull Composer c10, int i10) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i10 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(6) : ComposableLambdaKt.sameBits(6));
        Object obj7 = this._block;
        if (obj7 != null) {
            Object objInvoke = ((h9.v) t0.f(obj7, 8)).invoke(obj, obj2, obj3, obj4, obj5, obj6, composerStartRestartGroup, Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(obj, obj2, obj3, obj4, obj5, obj6, i10));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function8<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @NotNull Composer c10, int i10) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i10 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(7) : ComposableLambdaKt.sameBits(7));
        Object obj8 = this._block;
        if (obj8 != null) {
            Object objInvoke = ((w) t0.f(obj8, 9)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, composerStartRestartGroup, Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(obj, obj2, obj3, obj4, obj5, obj6, obj7, i10));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function9<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @NotNull Composer c10, int i10) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i10 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(8) : ComposableLambdaKt.sameBits(8));
        Object obj9 = this._block;
        if (obj9 != null) {
            Object objInvoke = ((b) t0.f(obj9, 10)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, composerStartRestartGroup, Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass8(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, i10));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function10<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @NotNull Composer c10, int i10) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i10 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(9) : ComposableLambdaKt.sameBits(9));
        Object obj10 = this._block;
        if (obj10 != null) {
            Object objInvoke = ((c) t0.f(obj10, 11)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, composerStartRestartGroup, Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, i10));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function11<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @NotNull Composer c10, int i10, int i11) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i11 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(10) : ComposableLambdaKt.sameBits(10));
        Object obj11 = this._block;
        if (obj11 != null) {
            Object objInvoke = ((e) t0.f(obj11, 13)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, composerStartRestartGroup, Integer.valueOf(i10), Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass10(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, i10));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function13<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @NotNull Composer c10, int i10, int i11) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i11 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(11) : ComposableLambdaKt.sameBits(11));
        Object obj12 = this._block;
        if (obj12 != null) {
            Object objInvoke = ((f) t0.f(obj12, 14)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, composerStartRestartGroup, Integer.valueOf(i10), Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass11(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, i10, i11));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function14<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @NotNull Composer c10, int i10, int i11) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i11 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(12) : ComposableLambdaKt.sameBits(12));
        Object obj13 = this._block;
        if (obj13 != null) {
            Object objInvoke = ((g) t0.f(obj13, 15)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, composerStartRestartGroup, Integer.valueOf(i10), Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass12(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, i10, i11));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function15<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @NotNull Composer c10, int i10, int i11) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i11 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(13) : ComposableLambdaKt.sameBits(13));
        Object obj14 = this._block;
        if (obj14 != null) {
            Object objInvoke = ((h) t0.f(obj14, 16)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, composerStartRestartGroup, Integer.valueOf(i10), Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass13(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, i10, i11));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function16<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @NotNull Composer c10, int i10, int i11) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i11 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(14) : ComposableLambdaKt.sameBits(14));
        Object obj15 = this._block;
        if (obj15 != null) {
            Object objInvoke = ((i) t0.f(obj15, 17)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, composerStartRestartGroup, Integer.valueOf(i10), Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass14(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, i10, i11));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function17<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @NotNull Composer c10, int i10, int i11) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i11 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(15) : ComposableLambdaKt.sameBits(15));
        Object obj16 = this._block;
        if (obj16 != null) {
            Object objInvoke = ((j) t0.f(obj16, 18)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, composerStartRestartGroup, Integer.valueOf(i10), Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass15(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, i10, i11));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function18<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'p15')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @NotNull Composer c10, int i10, int i11) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i11 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(16) : ComposableLambdaKt.sameBits(16));
        Object obj17 = this._block;
        if (obj17 != null) {
            Object objInvoke = ((k) t0.f(obj17, 19)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, composerStartRestartGroup, Integer.valueOf(i10), Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass16(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, i10, i11));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function19<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'p15')] kotlin.Any?, @[ParameterName(name = 'p16')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @NotNull Composer c10, int i10, int i11) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i11 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(17) : ComposableLambdaKt.sameBits(17));
        Object obj18 = this._block;
        if (obj18 != null) {
            Object objInvoke = ((m) t0.f(obj18, 20)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, composerStartRestartGroup, Integer.valueOf(i10), Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass17(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, i10, i11));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function20<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'p15')] kotlin.Any?, @[ParameterName(name = 'p16')] kotlin.Any?, @[ParameterName(name = 'p17')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
    }

    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @NotNull Composer c10, int i10, int i11) {
        t.i(c10, "c");
        Composer composerStartRestartGroup = c10.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = i11 | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(18) : ComposableLambdaKt.sameBits(18));
        Object obj19 = this._block;
        if (obj19 != null) {
            Object objInvoke = ((n) t0.f(obj19, 21)).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, composerStartRestartGroup, Integer.valueOf(i10), Integer.valueOf(iDifferentBits));
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass18(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, i10, i11));
            }
            return objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function21<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'p7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'p15')] kotlin.Any?, @[ParameterName(name = 'p16')] kotlin.Any?, @[ParameterName(name = 'p17')] kotlin.Any?, @[ParameterName(name = 'p18')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
    }
}
