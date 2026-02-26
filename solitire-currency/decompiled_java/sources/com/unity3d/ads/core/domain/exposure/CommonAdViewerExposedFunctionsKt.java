package com.unity3d.ads.core.domain.exposure;

import a9.c;
import android.util.Base64;
import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.CacheFile;
import com.unity3d.ads.core.domain.GetAndroidAdPlayerContext;
import com.unity3d.ads.core.domain.GetIsFileCache;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.HandleOpenUrl;
import com.unity3d.ads.core.domain.Refresh;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.SendPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.attribution.AndroidAttribution;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.domain.om.AndroidOmStartSession;
import com.unity3d.ads.core.domain.om.GetOmData;
import com.unity3d.ads.core.domain.om.IsOMActivated;
import com.unity3d.ads.core.domain.om.OmFinishSession;
import com.unity3d.ads.core.domain.om.OmImpressionOccurred;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.ads.core.utils.ContinuationFromCallback;
import com.unity3d.services.core.api.Storage;
import gatewayprotocol.v1.AllowedPiiKt;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.p;
import kotlin.collections.q0;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import s9.y;
import v8.k0;
import z8.d;
import z8.i;

/* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonAdViewerExposedFunctionsKt {

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C31931 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ CacheFile $cacheFile;

        C31931(CacheFile cacheFile, AdObject adObject) {
            this.$cacheFile = cacheFile;
            this.$adObject = adObject;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<Object>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r9, @org.jetbrains.annotations.NotNull z8.d<java.lang.Object> r10) throws org.json.JSONException {
            /*
                r8 = this;
                boolean r0 = r10 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r10
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1$invoke$1
                r0.<init>(r8, r10)
            L18:
                r6 = r0
                java.lang.Object r10 = r6.result
                java.lang.Object r0 = a9.b.e()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L36
                if (r1 != r2) goto L2e
                java.lang.Object r9 = r6.L$0
                java.lang.String r9 = (java.lang.String) r9
                v8.u.b(r10)
                goto L6b
            L2e:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L36:
                v8.u.b(r10)
                r10 = 0
                r1 = r9[r10]
                java.lang.String r3 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.t.g(r1, r3)
                org.json.JSONObject r1 = (org.json.JSONObject) r1
                java.lang.String r3 = "url"
                java.lang.String r7 = r1.getString(r3)
                r4 = 2
                java.lang.Object r9 = kotlin.collections.l.T(r9, r4)
                r4 = r9
                org.json.JSONArray r4 = (org.json.JSONArray) r4
                java.lang.String r9 = "priority"
                int r5 = r1.optInt(r9, r10)
                com.unity3d.ads.core.domain.CacheFile r1 = r8.$cacheFile
                kotlin.jvm.internal.t.h(r7, r3)
                com.unity3d.ads.core.data.model.AdObject r3 = r8.$adObject
                r6.L$0 = r7
                r6.label = r2
                r2 = r7
                java.lang.Object r10 = r1.invoke(r2, r3, r4, r5, r6)
                if (r10 != r0) goto L6a
                return r0
            L6a:
                r9 = r7
            L6b:
                com.unity3d.ads.core.data.model.CacheResult r10 = (com.unity3d.ads.core.data.model.CacheResult) r10
                boolean r0 = r10 instanceof com.unity3d.ads.core.data.model.CacheResult.Success
                if (r0 == 0) goto L9d
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r0 = "unity-ads-cache://unity.ads.cache/"
                r9.append(r0)
                com.unity3d.ads.core.data.model.CacheResult$Success r10 = (com.unity3d.ads.core.data.model.CacheResult.Success) r10
                com.unity3d.ads.core.data.model.CachedFile r0 = r10.getCachedFile()
                java.lang.String r0 = r0.getName()
                r9.append(r0)
                r0 = 46
                r9.append(r0)
                com.unity3d.ads.core.data.model.CachedFile r10 = r10.getCachedFile()
                java.lang.String r10 = r10.getExtension()
                r9.append(r10)
                java.lang.String r9 = r9.toString()
                goto La1
            L9d:
                boolean r10 = r10 instanceof com.unity3d.ads.core.data.model.CacheResult.Failure
                if (r10 == 0) goto La7
            La1:
                java.lang.String r10 = "when (result) {\n        …sult.Failure -> url\n    }"
                kotlin.jvm.internal.t.h(r9, r10)
                return r9
            La7:
                v8.q r9 = new v8.q
                r9.<init>()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C31931.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C31991 implements ExposedFunction {
        final /* synthetic */ SessionRepository $sessionRepository;

        C31991(SessionRepository sessionRepository) {
            this.$sessionRepository = sessionRepository;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<Object>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r4, @org.jetbrains.annotations.NotNull z8.d<java.lang.Object> r5) {
            /*
                r3 = this;
                boolean r4 = r5 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1
                if (r4 == 0) goto L13
                r4 = r5
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1 r4 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1) r4
                int r0 = r4.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r4.label = r0
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1 r4 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacy$1$invoke$1
                r4.<init>(r3, r5)
            L18:
                java.lang.Object r5 = r4.result
                java.lang.Object r0 = a9.b.e()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L31
                if (r1 != r2) goto L29
                v8.u.b(r5)
                goto L3f
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                v8.u.b(r5)
                com.unity3d.ads.core.data.repository.SessionRepository r5 = r3.$sessionRepository
                r4.label = r2
                java.lang.Object r5 = r5.getPrivacy(r4)
                if (r5 != r0) goto L3f
                return r0
            L3f:
                com.google.protobuf.ByteString r5 = (com.google.protobuf.ByteString) r5
                java.lang.String r4 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C31991.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C32001 implements ExposedFunction {
        final /* synthetic */ SessionRepository $sessionRepository;

        C32001(SessionRepository sessionRepository) {
            this.$sessionRepository = sessionRepository;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<Object>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r4, @org.jetbrains.annotations.NotNull z8.d<java.lang.Object> r5) {
            /*
                r3 = this;
                boolean r4 = r5 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1
                if (r4 == 0) goto L13
                r4 = r5
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1 r4 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1) r4
                int r0 = r4.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r4.label = r0
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1 r4 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$getPrivacyFsm$1$invoke$1
                r4.<init>(r3, r5)
            L18:
                java.lang.Object r5 = r4.result
                java.lang.Object r0 = a9.b.e()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L31
                if (r1 != r2) goto L29
                v8.u.b(r5)
                goto L3f
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                v8.u.b(r5)
                com.unity3d.ads.core.data.repository.SessionRepository r5 = r3.$sessionRepository
                r4.label = r2
                java.lang.Object r5 = r5.getPrivacyFsm(r4)
                if (r5 != r0) goto L3f
                return r0
            L3f:
                com.google.protobuf.ByteString r5 = (com.google.protobuf.ByteString) r5
                java.lang.String r4 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C32001.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C32091 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ OmFinishSession $omFinishSession;

        C32091(OmFinishSession omFinishSession, AdObject adObject) {
            this.$omFinishSession = omFinishSession;
            this.$adObject = adObject;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<? super k0>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r4, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r5) {
            /*
                r3 = this;
                boolean r4 = r5 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1
                if (r4 == 0) goto L13
                r4 = r5
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1 r4 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1) r4
                int r0 = r4.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r4.label = r0
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1 r4 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omFinishSession$1$invoke$1
                r4.<init>(r3, r5)
            L18:
                java.lang.Object r5 = r4.result
                java.lang.Object r0 = a9.b.e()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L31
                if (r1 != r2) goto L29
                v8.u.b(r5)
                goto L41
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                v8.u.b(r5)
                com.unity3d.ads.core.domain.om.OmFinishSession r5 = r3.$omFinishSession
                com.unity3d.ads.core.data.model.AdObject r1 = r3.$adObject
                r4.label = r2
                java.lang.Object r4 = r5.invoke(r1, r4)
                if (r4 != r0) goto L41
                return r0
            L41:
                v8.k0 r4 = v8.k0.f35197a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C32091.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C32101 implements ExposedFunction {
        final /* synthetic */ GetOmData $getOmData;

        C32101(GetOmData getOmData) {
            this.$getOmData = getOmData;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<Object>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r4, @org.jetbrains.annotations.NotNull z8.d<java.lang.Object> r5) {
            /*
                r3 = this;
                boolean r4 = r5 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1
                if (r4 == 0) goto L13
                r4 = r5
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1 r4 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1) r4
                int r0 = r4.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r4.label = r0
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1 r4 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1
                r4.<init>(r3, r5)
            L18:
                java.lang.Object r5 = r4.result
                java.lang.Object r0 = a9.b.e()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L31
                if (r1 != r2) goto L29
                v8.u.b(r5)
                goto L3f
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                v8.u.b(r5)
                com.unity3d.ads.core.domain.om.GetOmData r5 = r3.$getOmData
                r4.label = r2
                java.lang.Object r5 = r5.invoke(r4)
                if (r5 != r0) goto L3f
                return r0
            L3f:
                com.unity3d.ads.core.data.model.OMData r5 = (com.unity3d.ads.core.data.model.OMData) r5
                java.util.Map r4 = kotlin.collections.o0.c()
                java.lang.String r0 = r5.getVersion()
                java.lang.String r1 = "version"
                r4.put(r1, r0)
                java.lang.String r0 = "partnerName"
                java.lang.String r1 = r5.getPartnerName()
                r4.put(r0, r1)
                java.lang.String r0 = "partnerVersion"
                java.lang.String r5 = r5.getPartnerVersion()
                r4.put(r0, r5)
                java.util.Map r4 = kotlin.collections.o0.b(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C32101.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C32111 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ OmImpressionOccurred $omImpressionOccurred;

        C32111(OmImpressionOccurred omImpressionOccurred, AdObject adObject) {
            this.$omImpressionOccurred = omImpressionOccurred;
            this.$adObject = adObject;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<? super k0>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r6
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omImpression$1$invoke$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                v8.u.b(r6)
                goto L4f
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                v8.u.b(r6)
                r6 = 0
                r5 = r5[r6]
                java.lang.String r6 = "null cannot be cast to non-null type kotlin.Boolean"
                kotlin.jvm.internal.t.g(r5, r6)
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                com.unity3d.ads.core.domain.om.OmImpressionOccurred r6 = r4.$omImpressionOccurred
                com.unity3d.ads.core.data.model.AdObject r2 = r4.$adObject
                r0.label = r3
                java.lang.Object r5 = r6.invoke(r2, r5, r0)
                if (r5 != r1) goto L4f
                return r1
            L4f:
                v8.k0 r5 = v8.k0.f35197a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C32111.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C32121 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ AndroidOmStartSession $omStartSession;

        C32121(AndroidOmStartSession androidOmStartSession, AdObject adObject) {
            this.$omStartSession = androidOmStartSession;
            this.$adObject = adObject;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<? super k0>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r6
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                v8.u.b(r6)
                goto L4b
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                v8.u.b(r6)
                r6 = 0
                r5 = r5[r6]
                java.lang.String r6 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.t.g(r5, r6)
                org.json.JSONObject r5 = (org.json.JSONObject) r5
                com.unity3d.ads.core.domain.om.AndroidOmStartSession r6 = r4.$omStartSession
                com.unity3d.ads.core.data.model.AdObject r2 = r4.$adObject
                r0.label = r3
                java.lang.Object r5 = r6.invoke(r2, r5, r0)
                if (r5 != r1) goto L4b
                return r1
            L4b:
                v8.k0 r5 = v8.k0.f35197a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C32121.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C32151 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ Refresh $refresh;

        C32151(Refresh refresh, AdObject adObject) {
            this.$refresh = refresh;
            this.$adObject = adObject;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<Object>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r6, @org.jetbrains.annotations.NotNull z8.d<java.lang.Object> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r7
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                java.lang.String r3 = "adDataRefreshToken"
                r4 = 1
                if (r2 == 0) goto L33
                if (r2 != r4) goto L2b
                v8.u.b(r7)
                goto L6e
            L2b:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L33:
                v8.u.b(r7)
                int r7 = r6.length
                r2 = 0
                if (r7 != 0) goto L3c
                r7 = r4
                goto L3d
            L3c:
                r7 = r2
            L3d:
                if (r7 == 0) goto L42
                com.google.protobuf.ByteString r6 = com.google.protobuf.ByteString.EMPTY
                goto L58
            L42:
                r6 = r6[r2]
                java.lang.String r7 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.t.g(r6, r7)
                org.json.JSONObject r6 = (org.json.JSONObject) r6
                java.lang.String r6 = r6.optString(r3)
                java.lang.String r7 = "refreshToken"
                kotlin.jvm.internal.t.h(r6, r7)
                com.google.protobuf.ByteString r6 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.fromBase64(r6)
            L58:
                com.unity3d.ads.core.domain.Refresh r7 = r5.$refresh
                java.lang.String r2 = "refreshTokenByteString"
                kotlin.jvm.internal.t.h(r6, r2)
                com.unity3d.ads.core.data.model.AdObject r2 = r5.$adObject
                com.google.protobuf.ByteString r2 = r2.getOpportunityId()
                r0.label = r4
                java.lang.Object r7 = r7.invoke(r6, r2, r0)
                if (r7 != r1) goto L6e
                return r1
            L6e:
                gatewayprotocol.v1.AdDataRefreshResponseOuterClass$AdDataRefreshResponse r7 = (gatewayprotocol.v1.AdDataRefreshResponseOuterClass.AdDataRefreshResponse) r7
                boolean r6 = r7.hasError()
                if (r6 != 0) goto Lb3
                java.util.Map r6 = kotlin.collections.o0.c()
                com.google.protobuf.ByteString r0 = r7.getAdData()
                java.lang.String r1 = "adRefreshResponse.adData"
                kotlin.jvm.internal.t.h(r0, r1)
                java.lang.String r0 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r0)
                java.lang.String r1 = "adData"
                r6.put(r1, r0)
                com.google.protobuf.ByteString r0 = r7.getAdDataRefreshToken()
                java.lang.String r1 = "adRefreshResponse.adDataRefreshToken"
                kotlin.jvm.internal.t.h(r0, r1)
                java.lang.String r0 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r0)
                r6.put(r3, r0)
                com.google.protobuf.ByteString r7 = r7.getTrackingToken()
                java.lang.String r0 = "adRefreshResponse.trackingToken"
                kotlin.jvm.internal.t.h(r7, r0)
                java.lang.String r7 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r7)
                java.lang.String r0 = "trackingToken"
                r6.put(r0, r7)
                java.util.Map r6 = kotlin.collections.o0.b(r6)
                return r6
            Lb3:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "Refresh failed"
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C32151.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C32171 implements ExposedFunction {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ GetOperativeEventApi $getOperativeEventApi;

        C32171(GetOperativeEventApi getOperativeEventApi, AdObject adObject) {
            this.$getOperativeEventApi = getOperativeEventApi;
            this.$adObject = adObject;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<? super k0>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r6, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r7
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendOperativeEvent$1$invoke$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                v8.u.b(r7)
                goto L5b
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                v8.u.b(r7)
                gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventType r7 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_SPECIFIED_BY_AD_PLAYER
                r2 = 0
                r6 = r6[r2]
                java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
                kotlin.jvm.internal.t.g(r6, r2)
                java.lang.String r6 = (java.lang.String) r6
                r2 = 2
                byte[] r6 = android.util.Base64.decode(r6, r2)
                java.lang.String r2 = "decode(it[0] as String, Base64.NO_WRAP)"
                kotlin.jvm.internal.t.h(r6, r2)
                com.google.protobuf.ByteString r6 = com.google.protobuf.kotlin.ByteStringsKt.toByteString(r6)
                com.unity3d.ads.core.domain.events.GetOperativeEventApi r2 = r5.$getOperativeEventApi
                com.unity3d.ads.core.data.model.AdObject r4 = r5.$adObject
                r0.label = r3
                java.lang.Object r6 = r2.invoke(r7, r4, r6, r0)
                if (r6 != r1) goto L5b
                return r1
            L5b:
                v8.k0 r6 = v8.k0.f35197a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C32171.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C32181 implements ExposedFunction {
        final /* synthetic */ SendPrivacyUpdateRequest $sendPrivacyUpdateRequest;

        C32181(SendPrivacyUpdateRequest sendPrivacyUpdateRequest) {
            this.$sendPrivacyUpdateRequest = sendPrivacyUpdateRequest;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<Object>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r8, @org.jetbrains.annotations.NotNull z8.d<java.lang.Object> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r9
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                java.lang.String r3 = "version"
                java.lang.String r4 = "content"
                r5 = 1
                if (r2 == 0) goto L35
                if (r2 != r5) goto L2d
                v8.u.b(r9)
                goto L5e
            L2d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L35:
                v8.u.b(r9)
                r9 = 0
                r8 = r8[r9]
                java.lang.String r9 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.t.g(r8, r9)
                org.json.JSONObject r8 = (org.json.JSONObject) r8
                java.lang.String r9 = r8.optString(r4)
                int r8 = r8.optInt(r3)
                com.unity3d.ads.core.domain.SendPrivacyUpdateRequest r2 = r7.$sendPrivacyUpdateRequest
                java.lang.String r6 = "privacyUpdateContentBase64"
                kotlin.jvm.internal.t.h(r9, r6)
                com.google.protobuf.ByteString r9 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.fromBase64(r9)
                r0.label = r5
                java.lang.Object r9 = r2.invoke(r8, r9, r0)
                if (r9 != r1) goto L5e
                return r1
            L5e:
                gatewayprotocol.v1.PrivacyUpdateResponseOuterClass$PrivacyUpdateResponse r9 = (gatewayprotocol.v1.PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse) r9
                java.util.Map r8 = kotlin.collections.o0.c()
                int r0 = r9.getVersion()
                java.lang.Integer r0 = kotlin.coroutines.jvm.internal.b.d(r0)
                r8.put(r3, r0)
                com.google.protobuf.ByteString r9 = r9.getContent()
                java.lang.String r0 = "response.content"
                kotlin.jvm.internal.t.h(r9, r0)
                java.lang.String r9 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r9)
                r8.put(r4, r9)
                java.util.Map r8 = kotlin.collections.o0.b(r8)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C32181.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C32201 implements ExposedFunction {
        final /* synthetic */ SessionRepository $sessionRepository;

        C32201(SessionRepository sessionRepository) {
            this.$sessionRepository = sessionRepository;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<? super k0>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r6
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                v8.u.b(r6)
                goto L57
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                v8.u.b(r6)
                com.unity3d.ads.core.data.repository.SessionRepository r6 = r4.$sessionRepository
                r2 = 0
                r5 = r5[r2]
                java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
                kotlin.jvm.internal.t.g(r5, r2)
                java.lang.String r5 = (java.lang.String) r5
                r2 = 2
                byte[] r5 = android.util.Base64.decode(r5, r2)
                java.lang.String r2 = "decode(it[0] as String, Base64.NO_WRAP)"
                kotlin.jvm.internal.t.h(r5, r2)
                com.google.protobuf.ByteString r5 = com.google.protobuf.kotlin.ByteStringsKt.toByteString(r5)
                r0.label = r3
                java.lang.Object r5 = r6.setPrivacy(r5, r0)
                if (r5 != r1) goto L57
                return r1
            L57:
                v8.k0 r5 = v8.k0.f35197a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C32201.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
    static final class C32211 implements ExposedFunction {
        final /* synthetic */ SessionRepository $sessionRepository;

        C32211(SessionRepository sessionRepository) {
            this.$sessionRepository = sessionRepository;
        }

        @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
            return invoke2(objArr, (d<? super k0>) dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @org.jetbrains.annotations.Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke2(@org.jetbrains.annotations.NotNull java.lang.Object[] r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1
                if (r0 == 0) goto L13
                r0 = r6
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1 r0 = (com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1 r0 = new com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                v8.u.b(r6)
                goto L57
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                v8.u.b(r6)
                com.unity3d.ads.core.data.repository.SessionRepository r6 = r4.$sessionRepository
                r2 = 0
                r5 = r5[r2]
                java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
                kotlin.jvm.internal.t.g(r5, r2)
                java.lang.String r5 = (java.lang.String) r5
                r2 = 2
                byte[] r5 = android.util.Base64.decode(r5, r2)
                java.lang.String r2 = "decode(it[0] as String, Base64.NO_WRAP)"
                kotlin.jvm.internal.t.h(r5, r2)
                com.google.protobuf.ByteString r5 = com.google.protobuf.kotlin.ByteStringsKt.toByteString(r5)
                r0.label = r3
                java.lang.Object r5 = r6.setPrivacyFsm(r5, r0)
                if (r5 != r1) goto L57
                return r1
            L57:
                v8.k0 r5 = v8.k0.f35197a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.C32211.invoke2(java.lang.Object[], z8.d):java.lang.Object");
        }
    }

    @NotNull
    public static final ExposedFunction attributionRegisterClick(@NotNull final AndroidAttribution androidAttribution, @NotNull final AdObject adObject) {
        t.i(androidAttribution, "androidAttribution");
        t.i(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.attributionRegisterClick.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                AndroidAttribution androidAttribution2 = androidAttribution;
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                return androidAttribution2.registerClick((String) obj, adObject, dVar);
            }
        };
    }

    @NotNull
    public static final ExposedFunction attributionRegisterView(@NotNull final AndroidAttribution androidAttribution, @NotNull final AdObject adObject) {
        t.i(androidAttribution, "androidAttribution");
        t.i(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.attributionRegisterView.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                AndroidAttribution androidAttribution2 = androidAttribution;
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                return androidAttribution2.registerView((String) obj, adObject, dVar);
            }
        };
    }

    @NotNull
    public static final ExposedFunction clearStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.clearStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) throws Throwable {
                i iVar = new i(c.c(dVar));
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                Storage.clear((String) obj, new ContinuationFromCallback(iVar));
                Object objA = iVar.a();
                if (objA == a9.d.e()) {
                    h.c(dVar);
                }
                return objA;
            }
        };
    }

    @NotNull
    public static final ExposedFunction deleteStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.deleteStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) throws Throwable {
                i iVar = new i(c.c(dVar));
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = objArr[1];
                t.g(obj2, "null cannot be cast to non-null type kotlin.String");
                Storage.delete((String) obj, (String) obj2, new ContinuationFromCallback(iVar));
                Object objA = iVar.a();
                if (objA == a9.d.e()) {
                    h.c(dVar);
                }
                return objA;
            }
        };
    }

    @NotNull
    public static final ExposedFunction download(@NotNull CacheFile cacheFile, @NotNull AdObject adObject) {
        t.i(cacheFile, "cacheFile");
        t.i(adObject, "adObject");
        return new C31931(cacheFile, adObject);
    }

    @NotNull
    /* JADX INFO: renamed from: getAdContext-yLuu4LI, reason: not valid java name */
    public static final ExposedFunction m3996getAdContextyLuu4LI(@NotNull GetAndroidAdPlayerContext getAndroidAdPlayerContext, @NotNull String adData, @NotNull String impressionConfig, @NotNull String adDataRefreshToken, @NotNull IsOMActivated isOMActivated, @NotNull AdObject adObject) {
        t.i(getAndroidAdPlayerContext, "getAndroidAdPlayerContext");
        t.i(adData, "adData");
        t.i(impressionConfig, "impressionConfig");
        t.i(adDataRefreshToken, "adDataRefreshToken");
        t.i(isOMActivated, "isOMActivated");
        t.i(adObject, "adObject");
        return new CommonAdViewerExposedFunctionsKt$getAdContext$1(adData, impressionConfig, adDataRefreshToken, getAndroidAdPlayerContext, adObject, isOMActivated);
    }

    @NotNull
    public static final ExposedFunction getAllowedPii(@NotNull final DeviceInfoRepository deviceInfoRepository) {
        t.i(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getAllowedPii.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                String strEncodeToString = Base64.encodeToString(deviceInfoRepository.getAllowedPii().getValue().toByteArray(), 2);
                t.h(strEncodeToString, "encodeToString(deviceInf…eArray(), Base64.NO_WRAP)");
                return strEncodeToString;
            }
        };
    }

    @NotNull
    public static final ExposedFunction getConnectionType(@NotNull final DeviceInfoRepository deviceInfoRepository) {
        t.i(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getConnectionType.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                DynamicDeviceInfoOuterClass.ConnectionType connectionType = deviceInfoRepository.getDynamicDeviceInfo().getConnectionType();
                t.h(connectionType, "deviceInfoRepository.dyn…DeviceInfo.connectionType");
                return connectionType;
            }
        };
    }

    @NotNull
    public static final ExposedFunction getDeviceMaxVolume(@NotNull final DeviceInfoRepository deviceInfoRepository) {
        t.i(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getDeviceMaxVolume.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                return b.b(deviceInfoRepository.getDynamicDeviceInfo().getAndroid().getMaxVolume());
            }
        };
    }

    @NotNull
    public static final ExposedFunction getDeviceVolume(@NotNull final DeviceInfoRepository deviceInfoRepository) {
        t.i(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getDeviceVolume.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                return b.b(deviceInfoRepository.getDynamicDeviceInfo().getAndroid().getVolume());
            }
        };
    }

    @NotNull
    public static final ExposedFunction getKeysStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getKeysStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) throws Throwable {
                i iVar = new i(c.c(dVar));
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = objArr[1];
                t.g(obj2, "null cannot be cast to non-null type kotlin.String");
                Object obj3 = objArr[2];
                t.g(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                Storage.getKeys((String) obj, (String) obj2, (Boolean) obj3, new ContinuationFromCallback(iVar));
                Object objA = iVar.a();
                if (objA == a9.d.e()) {
                    h.c(dVar);
                }
                return objA;
            }
        };
    }

    @NotNull
    public static final ExposedFunction getPrivacy(@NotNull SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        return new C31991(sessionRepository);
    }

    @NotNull
    public static final ExposedFunction getPrivacyFsm(@NotNull SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        return new C32001(sessionRepository);
    }

    @NotNull
    public static final ExposedFunction getScreenHeight(@NotNull final DeviceInfoRepository deviceInfoRepository) {
        t.i(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getScreenHeight.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                return b.d(deviceInfoRepository.getDynamicDeviceInfo().getScreenHeight());
            }
        };
    }

    @NotNull
    public static final ExposedFunction getScreenWidth(@NotNull final DeviceInfoRepository deviceInfoRepository) {
        t.i(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getScreenWidth.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                return b.d(deviceInfoRepository.getDynamicDeviceInfo().getScreenWidth());
            }
        };
    }

    @NotNull
    public static final ExposedFunction getSessionToken(@NotNull final SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getSessionToken.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                return ProtobufExtensionsKt.toBase64(sessionRepository.getSessionToken());
            }
        };
    }

    @NotNull
    public static final ExposedFunction getStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.getStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) throws Throwable {
                i iVar = new i(c.c(dVar));
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = objArr[1];
                t.g(obj2, "null cannot be cast to non-null type kotlin.String");
                Storage.get((String) obj, (String) obj2, new ContinuationFromCallback(iVar));
                Object objA = iVar.a();
                if (objA == a9.d.e()) {
                    h.c(dVar);
                }
                return objA;
            }
        };
    }

    @NotNull
    public static final ExposedFunction incrementBannerImpressionCount(@NotNull final SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.incrementBannerImpressionCount.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<? super k0>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<? super k0> dVar) {
                sessionRepository.incrementBannerImpressionCount();
                return k0.f35197a;
            }
        };
    }

    @NotNull
    public static final ExposedFunction isAttributionAvailable(@NotNull final AndroidAttribution androidAttribution) {
        t.i(androidAttribution, "androidAttribution");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.isAttributionAvailable.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                return androidAttribution.isAvailable(dVar);
            }
        };
    }

    @NotNull
    public static final ExposedFunction isFileCached(@NotNull final GetIsFileCache getIfFileCache) {
        t.i(getIfFileCache, "getIfFileCache");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.isFileCached.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) {
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                return getIfFileCache.invoke((String) obj, dVar);
            }
        };
    }

    @NotNull
    public static final ExposedFunction markCampaignStateShown(@NotNull final CampaignRepository campaignRepository, @NotNull final AdObject adObject) {
        t.i(campaignRepository, "campaignRepository");
        t.i(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.markCampaignStateShown.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<? super k0>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<? super k0> dVar) {
                campaignRepository.setShowTimestamp(adObject.getOpportunityId());
                return k0.f35197a;
            }
        };
    }

    @NotNull
    public static final ExposedFunction omFinishSession(@NotNull OmFinishSession omFinishSession, @NotNull AdObject adObject) {
        t.i(omFinishSession, "omFinishSession");
        t.i(adObject, "adObject");
        return new C32091(omFinishSession, adObject);
    }

    @NotNull
    public static final ExposedFunction omGetData(@NotNull GetOmData getOmData) {
        t.i(getOmData, "getOmData");
        return new C32101(getOmData);
    }

    @NotNull
    public static final ExposedFunction omImpression(@NotNull OmImpressionOccurred omImpressionOccurred, @NotNull AdObject adObject) {
        t.i(omImpressionOccurred, "omImpressionOccurred");
        t.i(adObject, "adObject");
        return new C32111(omImpressionOccurred, adObject);
    }

    @NotNull
    public static final ExposedFunction omStartSession(@NotNull AndroidOmStartSession omStartSession, @NotNull AdObject adObject) {
        t.i(omStartSession, "omStartSession");
        t.i(adObject, "adObject");
        return new C32121(omStartSession, adObject);
    }

    @NotNull
    public static final ExposedFunction openUrl(@NotNull final HandleOpenUrl handleOpenUrl) {
        t.i(handleOpenUrl, "handleOpenUrl");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.openUrl.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<? super k0>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<? super k0> dVar) {
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj;
                Object objT = p.T(objArr, 1);
                JSONObject jSONObject = objT instanceof JSONObject ? (JSONObject) objT : null;
                handleOpenUrl.invoke(str, jSONObject != null ? jSONObject.optString(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME) : null);
                return k0.f35197a;
            }
        };
    }

    @NotNull
    public static final ExposedFunction readStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.readStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) throws Throwable {
                i iVar = new i(c.c(dVar));
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                Storage.read((String) obj, new ContinuationFromCallback(iVar));
                Object objA = iVar.a();
                if (objA == a9.d.e()) {
                    h.c(dVar);
                }
                return objA;
            }
        };
    }

    @NotNull
    public static final ExposedFunction refreshAdData(@NotNull Refresh refresh, @NotNull AdObject adObject) {
        t.i(refresh, "refresh");
        t.i(adObject, "adObject");
        return new C32151(refresh, adObject);
    }

    @NotNull
    public static final ExposedFunction sendDiagnosticEvent(@NotNull final SendDiagnosticEvent sendDiagnosticEvent, @NotNull final AdObject adObject) {
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        t.i(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.sendDiagnosticEvent.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<? super k0>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<? super k0> dVar) {
                String string;
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj;
                Object obj2 = objArr[1];
                t.g(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject = (JSONObject) obj2;
                Map mapC = q0.c();
                Iterator<String> itKeys = jSONObject.keys();
                t.h(itKeys, "tags.keys()");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    mapC.put(next, jSONObject.getString(next));
                }
                Map mapB = q0.b(mapC);
                Object objT = p.T(objArr, 2);
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, str, (objT == null || (string = objT.toString()) == null) ? null : b.b(Double.parseDouble(string)), mapB, null, adObject, 8, null);
                return k0.f35197a;
            }
        };
    }

    @NotNull
    public static final ExposedFunction sendOperativeEvent(@NotNull GetOperativeEventApi getOperativeEventApi, @NotNull AdObject adObject) {
        t.i(getOperativeEventApi, "getOperativeEventApi");
        t.i(adObject, "adObject");
        return new C32171(getOperativeEventApi, adObject);
    }

    @NotNull
    public static final ExposedFunction sendPrivacyUpdateRequest(@NotNull SendPrivacyUpdateRequest sendPrivacyUpdateRequest) {
        t.i(sendPrivacyUpdateRequest, "sendPrivacyUpdateRequest");
        return new C32181(sendPrivacyUpdateRequest);
    }

    @NotNull
    public static final ExposedFunction setAllowedPii(@NotNull final DeviceInfoRepository deviceInfoRepository) {
        t.i(deviceInfoRepository, "deviceInfoRepository");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.setAllowedPii.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<? super k0>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<? super k0> dVar) {
                AllowedPiiOuterClass.AllowedPii value;
                final AllowedPiiKt.Dsl dsl_create;
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject = (JSONObject) obj;
                y<AllowedPiiOuterClass.AllowedPii> allowedPii = deviceInfoRepository.getAllowedPii();
                do {
                    value = allowedPii.getValue();
                    AllowedPiiKt.Dsl.Companion companion = AllowedPiiKt.Dsl.Companion;
                    AllowedPiiOuterClass.AllowedPii.Builder builder = value.toBuilder();
                    t.h(builder, "this.toBuilder()");
                    dsl_create = companion._create(builder);
                    new kotlin.jvm.internal.y(dsl_create) { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setAllowedPii$1$1$1$2
                        @Override // kotlin.jvm.internal.y, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return Boolean.valueOf(((AllowedPiiKt.Dsl) this.receiver).getIdfa());
                        }

                        @Override // kotlin.jvm.internal.y, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj2) {
                            ((AllowedPiiKt.Dsl) this.receiver).setIdfa(((Boolean) obj2).booleanValue());
                        }
                    }.set(b.a(jSONObject.optBoolean("idfa")));
                    new kotlin.jvm.internal.y(dsl_create) { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setAllowedPii$1$1$1$4
                        @Override // kotlin.jvm.internal.y, kotlin.reflect.KProperty0
                        @Nullable
                        public Object get() {
                            return Boolean.valueOf(((AllowedPiiKt.Dsl) this.receiver).getIdfv());
                        }

                        @Override // kotlin.jvm.internal.y, kotlin.reflect.KMutableProperty0
                        public void set(@Nullable Object obj2) {
                            ((AllowedPiiKt.Dsl) this.receiver).setIdfv(((Boolean) obj2).booleanValue());
                        }
                    }.set(b.a(jSONObject.optBoolean("idfv")));
                } while (!allowedPii.d(value, dsl_create._build()));
                return k0.f35197a;
            }
        };
    }

    @NotNull
    public static final ExposedFunction setPrivacy(@NotNull SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        return new C32201(sessionRepository);
    }

    @NotNull
    public static final ExposedFunction setPrivacyFsm(@NotNull SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        return new C32211(sessionRepository);
    }

    @NotNull
    public static final ExposedFunction setStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.setStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) throws Throwable {
                i iVar = new i(c.c(dVar));
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = objArr[1];
                t.g(obj2, "null cannot be cast to non-null type kotlin.String");
                Storage.set((String) obj, (String) obj2, objArr[2], new ContinuationFromCallback(iVar));
                Object objA = iVar.a();
                if (objA == a9.d.e()) {
                    h.c(dVar);
                }
                return objA;
            }
        };
    }

    @NotNull
    public static final ExposedFunction updateTrackingToken(@NotNull final AdObject adObject) {
        t.i(adObject, "adObject");
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.updateTrackingToken.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<? super k0>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<? super k0> dVar) {
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type org.json.JSONObject");
                String token = ((JSONObject) obj).optString(HandleInvocationsFromAdViewer.KEY_TRACKING_TOKEN);
                if (!(token == null || token.length() == 0)) {
                    AdObject adObject2 = adObject;
                    t.h(token, "token");
                    adObject2.setTrackingToken(ProtobufExtensionsKt.fromBase64(token));
                }
                return k0.f35197a;
            }
        };
    }

    @NotNull
    public static final ExposedFunction writeStorage() {
        return new ExposedFunction() { // from class: com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt.writeStorage.1
            @Override // com.unity3d.ads.adplayer.ExposedFunction, h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Object[] objArr, d<? super Object> dVar) {
                return invoke2(objArr, (d<Object>) dVar);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull Object[] objArr, @NotNull d<Object> dVar) throws Throwable {
                i iVar = new i(c.c(dVar));
                Object obj = objArr[0];
                t.g(obj, "null cannot be cast to non-null type kotlin.String");
                Storage.write((String) obj, new ContinuationFromCallback(iVar));
                Object objA = iVar.a();
                if (objA == a9.d.e()) {
                    h.c(dVar);
                }
                return objA;
            }
        };
    }
}
