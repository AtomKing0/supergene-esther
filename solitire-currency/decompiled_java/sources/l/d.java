package l;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.o0;
import s9.y;
import v8.k0;

/* JADX INFO: compiled from: AsyncImage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements w.j, LayoutModifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final y<Constraints> f30155a = o0.a(Constraints.m3629boximpl(j.c()));

    /* JADX INFO: compiled from: AsyncImage.kt */
    static final class a extends v implements l<Placeable.PlacementScope, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Placeable f30156g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Placeable placeable) {
            super(1);
            this.f30156g = placeable;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
            invoke2(placementScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
            Placeable.PlacementScope.place$default(placementScope, this.f30156g, 0, 0, 0.0f, 4, null);
        }
    }

    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class b implements s9.h<w.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ s9.h f30157a;

        /* JADX INFO: compiled from: Emitters.kt */
        public static final class a<T> implements s9.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ s9.i f30158a;

            /* JADX INFO: renamed from: l.d$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @kotlin.coroutines.jvm.internal.f(c = "coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2", f = "AsyncImage.kt", l = {225}, m = "emit")
            public static final class C0617a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                /* synthetic */ Object f30159j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                int f30160k;

                public C0617a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f30159j = obj;
                    this.f30160k |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(s9.i iVar) {
                this.f30158a = iVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // s9.i
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull z8.d r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof l.d.b.a.C0617a
                    if (r0 == 0) goto L13
                    r0 = r8
                    l.d$b$a$a r0 = (l.d.b.a.C0617a) r0
                    int r1 = r0.f30160k
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f30160k = r1
                    goto L18
                L13:
                    l.d$b$a$a r0 = new l.d$b$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.f30159j
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f30160k
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    v8.u.b(r8)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    v8.u.b(r8)
                    s9.i r8 = r6.f30158a
                    androidx.compose.ui.unit.Constraints r7 = (androidx.compose.ui.unit.Constraints) r7
                    long r4 = r7.m3647unboximpl()
                    w.i r7 = l.a.c(r4)
                    if (r7 == 0) goto L4b
                    r0.f30160k = r3
                    java.lang.Object r7 = r8.emit(r7, r0)
                    if (r7 != r1) goto L4b
                    return r1
                L4b:
                    v8.k0 r7 = v8.k0.f35197a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: l.d.b.a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        public b(s9.h hVar) {
            this.f30157a = hVar;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull s9.i<? super w.i> iVar, @NotNull z8.d dVar) {
            Object objCollect = this.f30157a.collect(new a(iVar), dVar);
            return objCollect == a9.d.e() ? objCollect : k0.f35197a;
        }
    }

    @Override // w.j
    @Nullable
    public Object a(@NotNull z8.d<? super w.i> dVar) {
        return s9.j.w(new b(this.f30155a), dVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.a(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.b(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j10) {
        this.f30155a.setValue(Constraints.m3629boximpl(j10));
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
        return MeasureScope.CC.p(measureScope, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new a(placeableMo2987measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.c(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i10) {
        return androidx.compose.ui.layout.c.d(this, intrinsicMeasureScope, intrinsicMeasurable, i10);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}
