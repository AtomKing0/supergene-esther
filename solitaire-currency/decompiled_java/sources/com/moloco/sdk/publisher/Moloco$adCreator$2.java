package com.moloco.sdk.publisher;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.moloco.sdk.internal.b;
import com.moloco.sdk.internal.publisher.c;
import com.moloco.sdk.internal.publisher.e;
import com.moloco.sdk.internal.publisher.e0;
import com.moloco.sdk.service_locator.a;
import h9.a;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: loaded from: classes4.dex */
public final class Moloco$adCreator$2 extends v implements a<c> {
    public static final Moloco$adCreator$2 INSTANCE = new Moloco$adCreator$2();

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$adCreator$2$1, reason: invalid class name */
    @f(c = "com.moloco.sdk.publisher.Moloco$adCreator$2$1", f = "Moloco.kt", l = {TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements h9.l<d<? super b>, Object> {
        int label;

        public AnonymousClass1(d<? super AnonymousClass1> dVar) {
            super(1, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@NotNull d<?> dVar) {
            return new AnonymousClass1(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                e0 initializationHandler = Moloco.INSTANCE.getInitializationHandler();
                this.label = 1;
                obj = initializationHandler.e(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return obj;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable d<? super b> dVar) {
            return ((AnonymousClass1) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public Moloco$adCreator$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final c invoke() {
        return new c(Moloco.INSTANCE.getInitializationHandler().j(), a.h.f18920a.f(), new e(null, 0L, 3, null), new AnonymousClass1(null));
    }
}
