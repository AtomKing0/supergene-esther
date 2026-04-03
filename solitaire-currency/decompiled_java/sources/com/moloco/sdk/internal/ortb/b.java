package com.moloco.sdk.internal.ortb;

import com.moloco.sdk.internal.ortb.model.e;
import com.moloco.sdk.internal.t;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.moloco.sdk.internal.ortb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final kotlinx.serialization.json.a f17670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.scheduling.a f17671b;

    @f(c = "com.moloco.sdk.internal.ortb.BidResponseParserImpl$invoke$2", f = "BidResponseParser.kt", l = {}, m = "invokeSuspend")
    public static final class a extends l implements p<o0, z8.d<? super t<e, Exception>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17672j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f17674l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f17674l = str;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super t<e, Exception>> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return b.this.new a(this.f17674l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f17672j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            try {
                kotlinx.serialization.json.a aVar = b.this.f17670a;
                String str = this.f17674l;
                KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), kotlin.jvm.internal.o0.j(e.class));
                kotlin.jvm.internal.t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                return new t.b(d.a((e) aVar.b(kSerializerB, str)));
            } catch (Exception e10) {
                return new t.a(e10);
            }
        }
    }

    public b(@NotNull kotlinx.serialization.json.a json) {
        kotlin.jvm.internal.t.i(json, "json");
        this.f17670a = json;
        this.f17671b = com.moloco.sdk.internal.scheduling.c.a();
    }

    @Override // com.moloco.sdk.internal.ortb.a
    @Nullable
    public Object b(@NotNull String str, @NotNull z8.d<? super t<e, Exception>> dVar) {
        return i.g(this.f17671b.getIo(), new a(str, null), dVar);
    }
}
