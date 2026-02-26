package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import h9.p;
import h9.q;
import h9.r;
import h9.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;
import v8.y;

/* JADX INFO: compiled from: MovableContent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MovableContentKt {
    public static final int movableContentKey = 126665345;

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$1, reason: invalid class name */
    /* JADX INFO: compiled from: MovableContent.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ MovableContent<k0> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MovableContent<k0> movableContent) {
            super(2);
            this.$movableContent = movableContent;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                composer.insertMovableContent(this.$movableContent, k0.f35197a);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [P] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$2, reason: invalid class name */
    /* JADX INFO: compiled from: MovableContent.kt */
    static final class AnonymousClass2<P> extends v implements q<P, Composer, Integer, k0> {
        final /* synthetic */ MovableContent<P> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MovableContent<P> movableContent) {
            super(3);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Object obj, Composer composer, Integer num) {
            invoke(obj, composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(P p10, @Nullable Composer composer, int i10) {
            if ((i10 & 14) == 0) {
                i10 |= composer.changed(p10) ? 4 : 2;
            }
            if ((i10 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                composer.insertMovableContent(this.$movableContent, p10);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [P1, P2] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$3, reason: invalid class name */
    /* JADX INFO: compiled from: MovableContent.kt */
    static final class AnonymousClass3<P1, P2> extends v implements r<P1, P2, Composer, Integer, k0> {
        final /* synthetic */ MovableContent<s<P1, P2>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(MovableContent<s<P1, P2>> movableContent) {
            super(4);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(Object obj, Object obj2, Composer composer, Integer num) {
            invoke(obj, obj2, composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(P1 p12, P2 p22, @Nullable Composer composer, int i10) {
            int i11;
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(p12) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(p22) ? 32 : 16;
            }
            if ((i11 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                composer.insertMovableContent(this.$movableContent, y.a(p12, p22));
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [P1, P2, P3] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$4, reason: invalid class name */
    /* JADX INFO: compiled from: MovableContent.kt */
    static final class AnonymousClass4<P1, P2, P3> extends v implements h9.s<P1, P2, P3, Composer, Integer, k0> {
        final /* synthetic */ MovableContent<s<s<P1, P2>, P3>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(MovableContent<s<s<P1, P2>, P3>> movableContent) {
            super(5);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.s
        public /* bridge */ /* synthetic */ k0 invoke(Object obj, Object obj2, Object obj3, Composer composer, Integer num) {
            invoke(obj, obj2, obj3, composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(P1 p12, P2 p22, P3 p32, @Nullable Composer composer, int i10) {
            int i11;
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(p12) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(p22) ? 32 : 16;
            }
            if ((i10 & 896) == 0) {
                i11 |= composer.changed(p32) ? 256 : 128;
            }
            if ((i11 & 5851) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                composer.insertMovableContent(this.$movableContent, y.a(y.a(p12, p22), p32));
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [P1, P2, P3, P4] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$5, reason: invalid class name */
    /* JADX INFO: compiled from: MovableContent.kt */
    static final class AnonymousClass5<P1, P2, P3, P4> extends v implements t<P1, P2, P3, P4, Composer, Integer, k0> {
        final /* synthetic */ MovableContent<s<s<P1, P2>, s<P3, P4>>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(MovableContent<s<s<P1, P2>, s<P3, P4>>> movableContent) {
            super(6);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.t
        public /* bridge */ /* synthetic */ k0 invoke(Object obj, Object obj2, Object obj3, Object obj4, Composer composer, Integer num) {
            invoke(obj, obj2, obj3, obj4, composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(P1 p12, P2 p22, P3 p32, P4 p42, @Nullable Composer composer, int i10) {
            int i11;
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(p12) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(p22) ? 32 : 16;
            }
            if ((i10 & 896) == 0) {
                i11 |= composer.changed(p32) ? 256 : 128;
            }
            if ((i10 & 7168) == 0) {
                i11 |= composer.changed(p42) ? 2048 : 1024;
            }
            if ((46811 & i11) == 9362 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                composer.insertMovableContent(this.$movableContent, y.a(y.a(p12, p22), y.a(p32, p42)));
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MovableContent.kt */
    static final class C09781<R> extends v implements q<R, Composer, Integer, k0> {
        final /* synthetic */ MovableContent<R> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09781(MovableContent<R> movableContent) {
            super(3);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Object obj, Composer composer, Integer num) {
            invoke(obj, composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(R r10, @Nullable Composer composer, int i10) {
            if ((i10 & 14) == 0) {
                i10 |= composer.changed(r10) ? 4 : 2;
            }
            if ((i10 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                composer.insertMovableContent(this.$movableContent, r10);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [P, R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MovableContent.kt */
    static final class C09792<P, R> extends v implements r<R, P, Composer, Integer, k0> {
        final /* synthetic */ MovableContent<s<R, P>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09792(MovableContent<s<R, P>> movableContent) {
            super(4);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(Object obj, Object obj2, Composer composer, Integer num) {
            invoke(obj, obj2, composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(R r10, P p10, @Nullable Composer composer, int i10) {
            int i11;
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(r10) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(p10) ? 32 : 16;
            }
            if ((i11 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                composer.insertMovableContent(this.$movableContent, y.a(r10, p10));
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [P1, R, P2] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MovableContent.kt */
    static final class C09803<P1, P2, R> extends v implements h9.s<R, P1, P2, Composer, Integer, k0> {
        final /* synthetic */ MovableContent<s<s<R, P1>, P2>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09803(MovableContent<s<s<R, P1>, P2>> movableContent) {
            super(5);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.s
        public /* bridge */ /* synthetic */ k0 invoke(Object obj, Object obj2, Object obj3, Composer composer, Integer num) {
            invoke(obj, obj2, obj3, composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(R r10, P1 p12, P2 p22, @Nullable Composer composer, int i10) {
            int i11;
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(r10) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(p12) ? 32 : 16;
            }
            if ((i10 & 896) == 0) {
                i11 |= composer.changed(p22) ? 256 : 128;
            }
            if ((i11 & 5851) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                composer.insertMovableContent(this.$movableContent, y.a(y.a(r10, p12), p22));
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [P1, R, P2, P3] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MovableContent.kt */
    static final class C09814<P1, P2, P3, R> extends v implements t<R, P1, P2, P3, Composer, Integer, k0> {
        final /* synthetic */ MovableContent<s<s<R, P1>, s<P2, P3>>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09814(MovableContent<s<s<R, P1>, s<P2, P3>>> movableContent) {
            super(6);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.t
        public /* bridge */ /* synthetic */ k0 invoke(Object obj, Object obj2, Object obj3, Object obj4, Composer composer, Integer num) {
            invoke(obj, obj2, obj3, obj4, composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(R r10, P1 p12, P2 p22, P3 p32, @Nullable Composer composer, int i10) {
            int i11;
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(r10) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(p12) ? 32 : 16;
            }
            if ((i10 & 896) == 0) {
                i11 |= composer.changed(p22) ? 256 : 128;
            }
            if ((i10 & 7168) == 0) {
                i11 |= composer.changed(p32) ? 2048 : 1024;
            }
            if ((46811 & i11) == 9362 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                composer.insertMovableContent(this.$movableContent, y.a(y.a(r10, p12), y.a(p22, p32)));
            }
        }
    }

    @NotNull
    public static final p<Composer, Integer, k0> movableContentOf(@NotNull p<? super Composer, ? super Integer, k0> content) {
        kotlin.jvm.internal.t.i(content, "content");
        return ComposableLambdaKt.composableLambdaInstance(-642339857, true, new AnonymousClass1(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-1079330685, true, new MovableContentKt$movableContentOf$movableContent$1(content)))));
    }

    @ComposableInferredTarget(scheme = "[0[0]:[_]]")
    @NotNull
    public static final <R> q<R, Composer, Integer, k0> movableContentWithReceiverOf(@NotNull q<? super R, ? super Composer, ? super Integer, k0> content) {
        kotlin.jvm.internal.t.i(content, "content");
        return ComposableLambdaKt.composableLambdaInstance(506997506, true, new C09781(new MovableContent(ComposableLambdaKt.composableLambdaInstance(250838178, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$1(content)))));
    }

    @NotNull
    public static final <P> q<P, Composer, Integer, k0> movableContentOf(@NotNull q<? super P, ? super Composer, ? super Integer, k0> content) {
        kotlin.jvm.internal.t.i(content, "content");
        return ComposableLambdaKt.composableLambdaInstance(-434707029, true, new AnonymousClass2(new MovableContent(content)));
    }

    @NotNull
    public static final <R, P> r<R, P, Composer, Integer, k0> movableContentWithReceiverOf(@NotNull r<? super R, ? super P, ? super Composer, ? super Integer, k0> content) {
        kotlin.jvm.internal.t.i(content, "content");
        return ComposableLambdaKt.composableLambdaInstance(627354118, true, new C09792(new MovableContent(ComposableLambdaKt.composableLambdaInstance(812082854, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$2(content)))));
    }

    @NotNull
    public static final <P1, P2> r<P1, P2, Composer, Integer, k0> movableContentOf(@NotNull r<? super P1, ? super P2, ? super Composer, ? super Integer, k0> content) {
        kotlin.jvm.internal.t.i(content, "content");
        return ComposableLambdaKt.composableLambdaInstance(-1200019734, true, new AnonymousClass3(new MovableContent(ComposableLambdaKt.composableLambdaInstance(1849814513, true, new MovableContentKt$movableContentOf$movableContent$2(content)))));
    }

    @NotNull
    public static final <R, P1, P2> h9.s<R, P1, P2, Composer, Integer, k0> movableContentWithReceiverOf(@NotNull h9.s<? super R, ? super P1, ? super P2, ? super Composer, ? super Integer, k0> content) {
        kotlin.jvm.internal.t.i(content, "content");
        return ComposableLambdaKt.composableLambdaInstance(583402949, true, new C09803(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-1322148760, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$3(content)))));
    }

    @NotNull
    public static final <P1, P2, P3> h9.s<P1, P2, P3, Composer, Integer, k0> movableContentOf(@NotNull h9.s<? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, k0> content) {
        kotlin.jvm.internal.t.i(content, "content");
        return ComposableLambdaKt.composableLambdaInstance(-1083870185, true, new AnonymousClass4(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-284417101, true, new MovableContentKt$movableContentOf$movableContent$3(content)))));
    }

    @NotNull
    public static final <R, P1, P2, P3> t<R, P1, P2, P3, Composer, Integer, k0> movableContentWithReceiverOf(@NotNull t<? super R, ? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, k0> content) {
        kotlin.jvm.internal.t.i(content, "content");
        return ComposableLambdaKt.composableLambdaInstance(1468683306, true, new C09814(new MovableContent(ComposableLambdaKt.composableLambdaInstance(838586922, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$4(content)))));
    }

    @NotNull
    public static final <P1, P2, P3, P4> t<P1, P2, P3, P4, Composer, Integer, k0> movableContentOf(@NotNull t<? super P1, ? super P2, ? super P3, ? super P4, ? super Composer, ? super Integer, k0> content) {
        kotlin.jvm.internal.t.i(content, "content");
        return ComposableLambdaKt.composableLambdaInstance(-1741877681, true, new AnonymousClass5(new MovableContent(ComposableLambdaKt.composableLambdaInstance(1876318581, true, new MovableContentKt$movableContentOf$movableContent$4(content)))));
    }
}
