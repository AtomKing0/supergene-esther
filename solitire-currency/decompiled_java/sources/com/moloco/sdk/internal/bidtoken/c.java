package com.moloco.sdk.internal.bidtoken;

import android.util.Base64;
import com.moloco.sdk.internal.t;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p9.q;
import p9.r;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements b {

    @f(c = "com.moloco.sdk.internal.bidtoken.VersionPrefixedJWTokenParser$invoke$2", f = "VersionPrefixedJWTokenParser.kt", l = {}, m = "invokeSuspend")
    public static final class a extends l implements p<o0, z8.d<? super t<com.moloco.sdk.internal.bidtoken.a, com.moloco.sdk.internal.l>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17531j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f17532k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f17532k = str;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super t<com.moloco.sdk.internal.bidtoken.a, com.moloco.sdk.internal.l>> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new a(this.f17532k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f17531j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            try {
                byte[] bArrDecode = Base64.decode((String) r.C0((String) r.B0(this.f17532k, new char[]{':'}, false, 0, 6, null).get(1), new String[]{"."}, false, 0, 6, null).get(1), 0);
                kotlin.jvm.internal.t.h(bArrDecode, "decode(jwTokenChunks[1], Base64.DEFAULT)");
                return new t.b(new com.moloco.sdk.internal.bidtoken.a(new JSONObject(q.t(bArrDecode)).getLong("exp")));
            } catch (Exception e10) {
                return new t.a(new com.moloco.sdk.internal.l(e10.toString(), -1));
            }
        }
    }

    @Override // com.moloco.sdk.internal.bidtoken.b
    @Nullable
    public Object b(@NotNull String str, @NotNull z8.d<? super t<com.moloco.sdk.internal.bidtoken.a, com.moloco.sdk.internal.l>> dVar) {
        return i.g(d.f17533a, new a(str, null), dVar);
    }
}
