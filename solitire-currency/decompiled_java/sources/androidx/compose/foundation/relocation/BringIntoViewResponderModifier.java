package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: BringIntoViewResponder.kt */
/* JADX INFO: loaded from: classes.dex */
final class BringIntoViewResponderModifier extends BringIntoViewChildModifier implements ModifierLocalProvider<BringIntoViewParent>, BringIntoViewParent {

    @Nullable
    private s<Rect, ? extends b2> newestDispatchedRequest;

    @Nullable
    private s<Rect, ? extends b2> newestReceivedRequest;
    public BringIntoViewResponder responder;

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$bringChildIntoView$2, reason: invalid class name */
    /* JADX INFO: compiled from: BringIntoViewResponder.kt */
    @f(c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$bringChildIntoView$2", f = "BringIntoViewResponder.kt", l = {214, Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE, 230}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ LayoutCoordinates $childCoordinates;
        final /* synthetic */ Rect $rect;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(LayoutCoordinates layoutCoordinates, Rect rect, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$childCoordinates = layoutCoordinates;
            this.$rect = rect;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass2 anonymousClass2 = BringIntoViewResponderModifier.this.new AnonymousClass2(this.$childCoordinates, this.$rect, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x00b0 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #1 {all -> 0x0034, blocks: (B:13:0x002f, B:39:0x00a8, B:41:0x00b0), top: B:76:0x002f }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0134  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 314
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewResponderModifier.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BringIntoViewResponder.kt */
    @f(c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2", f = "BringIntoViewResponder.kt", l = {272}, m = "invokeSuspend")
    static final class C08952 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ LayoutCoordinates $layoutCoordinates;
        final /* synthetic */ Rect $localRect;
        final /* synthetic */ Rect $parentRect;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: BringIntoViewResponder.kt */
        @f(c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2$1", f = "BringIntoViewResponder.kt", l = {267}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ Rect $localRect;
            int label;
            final /* synthetic */ BringIntoViewResponderModifier this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(BringIntoViewResponderModifier bringIntoViewResponderModifier, Rect rect, d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.this$0 = bringIntoViewResponderModifier;
                this.$localRect = rect;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new AnonymousClass1(this.this$0, this.$localRect, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    BringIntoViewResponder responder = this.this$0.getResponder();
                    Rect rect = this.$localRect;
                    this.label = 1;
                    if (responder.bringChildIntoView(rect, this) == objE) {
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

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08952(Rect rect, LayoutCoordinates layoutCoordinates, Rect rect2, d<? super C08952> dVar) {
            super(2, dVar);
            this.$parentRect = rect;
            this.$layoutCoordinates = layoutCoordinates;
            this.$localRect = rect2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C08952 c08952 = BringIntoViewResponderModifier.this.new C08952(this.$parentRect, this.$layoutCoordinates, this.$localRect, dVar);
            c08952.L$0 = obj;
            return c08952;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                k.d((o0) this.L$0, null, null, new AnonymousClass1(BringIntoViewResponderModifier.this, this.$localRect, null), 3, null);
                BringIntoViewParent parent = BringIntoViewResponderModifier.this.getParent();
                Rect rect = this.$parentRect;
                LayoutCoordinates layoutCoordinates = this.$layoutCoordinates;
                this.label = 1;
                if (parent.bringChildIntoView(rect, layoutCoordinates, this) == objE) {
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

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C08952) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BringIntoViewResponderModifier(@NotNull BringIntoViewParent defaultParent) {
        super(defaultParent);
        t.i(defaultParent, "defaultParent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dispatchRequest(s<Rect, ? extends b2> sVar, LayoutCoordinates layoutCoordinates, d<? super k0> dVar) {
        this.newestDispatchedRequest = sVar;
        Rect rectC = sVar.c();
        Object objF = p0.f(new C08952(getResponder().calculateRectForParent(rectC), layoutCoordinates, rectC, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewParent
    @Nullable
    public Object bringChildIntoView(@NotNull Rect rect, @NotNull LayoutCoordinates layoutCoordinates, @NotNull d<? super k0> dVar) {
        Object objF = p0.f(new AnonymousClass2(layoutCoordinates, rect, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<BringIntoViewParent> getKey() {
        return BringIntoViewKt.getModifierLocalBringIntoViewParent();
    }

    @NotNull
    public final BringIntoViewResponder getResponder() {
        BringIntoViewResponder bringIntoViewResponder = this.responder;
        if (bringIntoViewResponder != null) {
            return bringIntoViewResponder;
        }
        t.A("responder");
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    /* JADX INFO: renamed from: getValue */
    public BringIntoViewParent getValue2() {
        return this;
    }

    public final void setResponder(@NotNull BringIntoViewResponder bringIntoViewResponder) {
        t.i(bringIntoViewResponder, "<set-?>");
        this.responder = bringIntoViewResponder;
    }
}
