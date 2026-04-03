package com.unity3d.ads.core.domain;

import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CommonGetHeaderBiddingToken.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonGetHeaderBiddingToken implements GetHeaderBiddingToken {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String HB_TOKEN_VERSION = "2";

    @NotNull
    private final BuildHeaderBiddingToken buildHeaderBiddingToken;

    /* JADX INFO: compiled from: CommonGetHeaderBiddingToken.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommonGetHeaderBiddingToken.kt */
    @f(c = "com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken", f = "CommonGetHeaderBiddingToken.kt", l = {9}, m = "invoke")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
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
            return CommonGetHeaderBiddingToken.this.invoke(this);
        }
    }

    public CommonGetHeaderBiddingToken(@NotNull BuildHeaderBiddingToken buildHeaderBiddingToken) {
        t.i(buildHeaderBiddingToken, "buildHeaderBiddingToken");
        this.buildHeaderBiddingToken = buildHeaderBiddingToken;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.GetHeaderBiddingToken
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull z8.d<? super java.lang.String> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken$invoke$1 r0 = (com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken$invoke$1 r0 = new com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken$invoke$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            v8.u.b(r5)
            com.unity3d.ads.core.domain.BuildHeaderBiddingToken r5 = r4.buildHeaderBiddingToken
            r0.label = r3
            java.lang.Object r5 = r5.invoke(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            gatewayprotocol.v1.HeaderBiddingTokenOuterClass$HeaderBiddingToken r5 = (gatewayprotocol.v1.HeaderBiddingTokenOuterClass.HeaderBiddingToken) r5
            com.google.protobuf.ByteString r5 = r5.toByteString()
            java.lang.String r0 = "rawToken.toByteString()"
            kotlin.jvm.internal.t.h(r5, r0)
            java.lang.String r5 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "2:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken.invoke(z8.d):java.lang.Object");
    }
}
