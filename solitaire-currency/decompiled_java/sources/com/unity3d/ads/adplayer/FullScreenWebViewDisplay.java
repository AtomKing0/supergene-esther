package com.unity3d.ads.adplayer;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.unity3d.ads.adplayer.DisplayMessage;
import com.unity3d.ads.core.extensions.JSONObjectExtensionsKt;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import h9.p;
import java.util.Map;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import s9.h;
import s9.i;
import s9.j;
import s9.x;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: FullScreenWebViewDisplay.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FullScreenWebViewDisplay extends ComponentActivity {

    @NotNull
    private String opportunityId = "";

    @Nullable
    private Map<String, ? extends Object> showOptions;

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$2, reason: invalid class name */
    /* JADX INFO: compiled from: FullScreenWebViewDisplay.kt */
    @f(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$2", f = "FullScreenWebViewDisplay.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<DisplayMessage, z8.d<? super k0>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = FullScreenWebViewDisplay.this.new AnonymousClass2(dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull DisplayMessage displayMessage, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(displayMessage, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            DisplayMessage displayMessage = (DisplayMessage) this.L$0;
            if (displayMessage instanceof DisplayMessage.DisplayFinishRequest) {
                FullScreenWebViewDisplay.this.finish();
            } else if (displayMessage instanceof DisplayMessage.WebViewInstanceResponse) {
                FullScreenWebViewDisplay.this.loadWebView(((DisplayMessage.WebViewInstanceResponse) displayMessage).getWebView());
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1, reason: invalid class name */
    /* JADX INFO: compiled from: FullScreenWebViewDisplay.kt */
    @f(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1", f = "FullScreenWebViewDisplay.kt", l = {62}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ WebView $webView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WebView webView, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$webView = webView;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return FullScreenWebViewDisplay.this.new AnonymousClass1(this.$webView, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                FullScreenWebViewDisplay.this.setContentView(this.$webView);
                x<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.DisplayReady displayReady = new DisplayMessage.DisplayReady(FullScreenWebViewDisplay.this.opportunityId, FullScreenWebViewDisplay.this.showOptions);
                this.label = 1;
                if (displayMessages.emit(displayReady, this) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$5, reason: invalid class name */
    /* JADX INFO: compiled from: FullScreenWebViewDisplay.kt */
    @f(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$5", f = "FullScreenWebViewDisplay.kt", l = {42}, m = "invokeSuspend")
    static final class AnonymousClass5 extends l implements p<o0, z8.d<? super k0>, Object> {
        int label;

        AnonymousClass5(z8.d<? super AnonymousClass5> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return FullScreenWebViewDisplay.this.new AnonymousClass5(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                x<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.WebViewInstanceRequest webViewInstanceRequest = new DisplayMessage.WebViewInstanceRequest(FullScreenWebViewDisplay.this.opportunityId);
                this.label = 1;
                if (displayMessages.emit(webViewInstanceRequest, this) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass5) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FullScreenWebViewDisplay.kt */
    @f(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onDestroy$1", f = "FullScreenWebViewDisplay.kt", l = {90}, m = "invokeSuspend")
    static final class C31491 extends l implements p<o0, z8.d<? super k0>, Object> {
        int label;

        C31491(z8.d<? super C31491> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return FullScreenWebViewDisplay.this.new C31491(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                x<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.DisplayDestroyed displayDestroyed = new DisplayMessage.DisplayDestroyed(FullScreenWebViewDisplay.this.opportunityId);
                this.label = 1;
                if (displayMessages.emit(displayDestroyed, this) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C31491) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onPause$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FullScreenWebViewDisplay.kt */
    @f(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onPause$1", f = "FullScreenWebViewDisplay.kt", l = {82}, m = "invokeSuspend")
    static final class C31501 extends l implements p<o0, z8.d<? super k0>, Object> {
        int label;

        C31501(z8.d<? super C31501> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return FullScreenWebViewDisplay.this.new C31501(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                x<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.VisibilityChanged visibilityChanged = new DisplayMessage.VisibilityChanged(FullScreenWebViewDisplay.this.opportunityId, false);
                this.label = 1;
                if (displayMessages.emit(visibilityChanged, this) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C31501) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FullScreenWebViewDisplay.kt */
    @f(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onResume$1", f = "FullScreenWebViewDisplay.kt", l = {74}, m = "invokeSuspend")
    static final class C31511 extends l implements p<o0, z8.d<? super k0>, Object> {
        int label;

        C31511(z8.d<? super C31511> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return FullScreenWebViewDisplay.this.new C31511(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                x<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.VisibilityChanged visibilityChanged = new DisplayMessage.VisibilityChanged(FullScreenWebViewDisplay.this.opportunityId, true);
                this.label = 1;
                if (displayMessages.emit(visibilityChanged, this) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C31511) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onWindowFocusChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FullScreenWebViewDisplay.kt */
    @f(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onWindowFocusChanged$1", f = "FullScreenWebViewDisplay.kt", l = {98}, m = "invokeSuspend")
    static final class C31521 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ boolean $hasFocus;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31521(boolean z10, z8.d<? super C31521> dVar) {
            super(2, dVar);
            this.$hasFocus = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return FullScreenWebViewDisplay.this.new C31521(this.$hasFocus, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                x<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.FocusChanged focusChanged = new DisplayMessage.FocusChanged(FullScreenWebViewDisplay.this.opportunityId, this.$hasFocus);
                this.label = 1;
                if (displayMessages.emit(focusChanged, this) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C31521) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    private final void listenToAdPlayerEvents() {
        final x<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
        j.D(j.G(new h<DisplayMessage>() { // from class: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1

            /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;
                final /* synthetic */ FullScreenWebViewDisplay this$0;

                /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2", f = "FullScreenWebViewDisplay.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar, FullScreenWebViewDisplay fullScreenWebViewDisplay) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = fullScreenWebViewDisplay;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull z8.d r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2$1 r0 = (com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2$1 r0 = new com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        v8.u.b(r7)
                        goto L52
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        v8.u.b(r7)
                        s9.i r7 = r5.$this_unsafeFlow
                        r2 = r6
                        com.unity3d.ads.adplayer.DisplayMessage r2 = (com.unity3d.ads.adplayer.DisplayMessage) r2
                        java.lang.String r2 = r2.getOpportunityId()
                        com.unity3d.ads.adplayer.FullScreenWebViewDisplay r4 = r5.this$0
                        java.lang.String r4 = com.unity3d.ads.adplayer.FullScreenWebViewDisplay.access$getOpportunityId$p(r4)
                        boolean r2 = kotlin.jvm.internal.t.d(r2, r4)
                        if (r2 == 0) goto L52
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L52
                        return r1
                    L52:
                        v8.k0 r6 = v8.k0.f35197a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super DisplayMessage> iVar, @NotNull z8.d dVar) {
                Object objCollect = displayMessages.collect(new AnonymousClass2(iVar, this), dVar);
                return objCollect == a9.d.e() ? objCollect : k0.f35197a;
            }
        }, new AnonymousClass2(null)), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadWebView(WebView webView) {
        k.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(webView, null), 3, null);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("opportunityId");
        if (stringExtra == null) {
            setResult(0);
            finish();
            k.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new FullScreenWebViewDisplay$onCreate$1$1(this, null), 3, null);
            return;
        }
        this.opportunityId = stringExtra;
        Integer numValueOf = Integer.valueOf(getIntent().getIntExtra("orientation", -1));
        if (!(numValueOf.intValue() != 1)) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            setRequestedOrientation(numValueOf.intValue());
        }
        String stringExtra2 = getIntent().getStringExtra("showOptions");
        this.showOptions = stringExtra2 != null ? JSONObjectExtensionsKt.toBuiltInMap(new JSONObject(stringExtra2)) : null;
        listenToAdPlayerEvents();
        k.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass5(null), 3, null);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        k.d(p0.a(e1.c()), null, null, new C31491(null), 3, null);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, @Nullable KeyEvent keyEvent) {
        return i10 == 4;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        k.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C31501(null), 3, null);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        k.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C31511(null), 3, null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        k.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C31521(z10, null), 3, null);
    }
}
