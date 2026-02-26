package com.braze.ui.inappmessage.utils;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazeViewBounds;
import com.braze.enums.inappmessage.MessageType;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageWithImage;
import com.braze.models.inappmessage.IInAppMessageZippedAssetHtml;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.support.BrazeLogger;
import com.braze.support.WebContentUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import h9.a;
import h9.p;
import java.io.File;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BackgroundInAppMessagePreparer {

    @NotNull
    public static final BackgroundInAppMessagePreparer INSTANCE = new BackgroundInAppMessagePreparer();

    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageType.values().length];
            try {
                iArr[MessageType.HTML_FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageType.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageType.SLIDEUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageType.MODAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2, reason: invalid class name */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    @f(c = "com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2", f = "BackgroundInAppMessagePreparer.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ IInAppMessage $inAppMessage;
        int label;

        /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
        static final class AnonymousClass1 extends v implements a<String> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            public final String invoke() {
                return "Displaying in-app message.";
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(IInAppMessage iInAppMessage, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$inAppMessage = iInAppMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return BackgroundInAppMessagePreparer.this.new AnonymousClass2(this.$inAppMessage, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) BackgroundInAppMessagePreparer.this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 7, (Object) null);
            BrazeInAppMessageManager.Companion.getInstance().displayInAppMessage(this.$inAppMessage, false);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$handleLocalImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ String $localImageUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str) {
            super(0);
            this.$localImageUrl = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Passing in-app message local image url to image loader: " + this.$localImageUrl;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$handleLocalImage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12442 extends v implements a<String> {
        final /* synthetic */ String $localImageUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12442(String str) {
            super(0);
            this.$localImageUrl = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Removing local image url from IAM since it could not be loaded. URL: " + this.$localImageUrl;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12451 extends v implements a<String> {
        public static final C12451 INSTANCE = new C12451();

        C12451() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Skipping in-app message preparation for control in-app message.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12462 extends v implements a<String> {
        public static final C12462 INSTANCE = new C12462();

        C12462() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Starting asynchronous in-app message preparation for message.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessage$3, reason: invalid class name */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Html in-app message zip asset download failed. Cannot display in-app message.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessage$4, reason: invalid class name */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "In-app message image download failed. Cannot display in-app message.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    @f(c = "com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1", f = "BackgroundInAppMessagePreparer.kt", l = {42}, m = "invokeSuspend")
    static final class C12471 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ IInAppMessage $inAppMessageToPrepare;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
        static final class C01861 extends v implements a<String> {
            public static final C01861 INSTANCE = new C01861();

            C01861() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            public final String invoke() {
                return "Cannot display the in-app message because the in-app message was null.";
            }
        }

        /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageForDisplay$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
        static final class AnonymousClass2 extends v implements a<String> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            AnonymousClass2() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            public final String invoke() {
                return "Caught error while preparing in app message in background";
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12471(IInAppMessage iInAppMessage, d<? super C12471> dVar) {
            super(2, dVar);
            this.$inAppMessageToPrepare = iInAppMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C12471 c12471 = new C12471(this.$inAppMessageToPrepare, dVar);
            c12471.L$0 = obj;
            return c12471;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2;
            Exception exc;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                Object objDisplayPreparedInAppMessage = (o0) this.L$0;
                try {
                    BackgroundInAppMessagePreparer backgroundInAppMessagePreparer = BackgroundInAppMessagePreparer.INSTANCE;
                    IInAppMessage iInAppMessagePrepareInAppMessage = backgroundInAppMessagePreparer.prepareInAppMessage(this.$inAppMessageToPrepare);
                    if (iInAppMessagePrepareInAppMessage == null) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, objDisplayPreparedInAppMessage, BrazeLogger.Priority.W, (Throwable) null, false, (a) C01861.INSTANCE, 6, (Object) null);
                    } else {
                        this.L$0 = objDisplayPreparedInAppMessage;
                        this.label = 1;
                        objDisplayPreparedInAppMessage = backgroundInAppMessagePreparer.displayPreparedInAppMessage(iInAppMessagePrepareInAppMessage, this);
                        if (objDisplayPreparedInAppMessage == objE) {
                            return objE;
                        }
                    }
                } catch (Exception e10) {
                    obj2 = objDisplayPreparedInAppMessage;
                    exc = e10;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, obj2, BrazeLogger.Priority.E, (Throwable) exc, false, (a) AnonymousClass2.INSTANCE, 4, (Object) null);
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o0 o0Var = (o0) this.L$0;
                try {
                    u.b(obj);
                } catch (Exception e11) {
                    exc = e11;
                    obj2 = o0Var;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, obj2, BrazeLogger.Priority.E, (Throwable) exc, false, (a) AnonymousClass2.INSTANCE, 4, (Object) null);
                }
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C12471) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12481 extends v implements a<String> {
        public static final C12481 INSTANCE = new C12481();

        C12481() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot prepare non IInAppMessageWithImage object with bitmap download.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12492 extends v implements a<String> {
        public static final C12492 INSTANCE = new C12492();

        C12492() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "In-app message already contains image bitmap. Not downloading image from URL.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12503 extends v implements a<String> {
        public static final C12503 INSTANCE = new C12503();

        C12503() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "BrazeInAppMessageManager applicationContext is null. Not downloading image.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12514 extends v implements a<String> {
        final /* synthetic */ String $remoteImageUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12514(String str) {
            super(0);
            this.$remoteImageUrl = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "In-app message has remote image url. Downloading image at url: " + this.$remoteImageUrl;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$5, reason: invalid class name */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class AnonymousClass5 extends v implements a<String> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        AnonymousClass5() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "In-app message has no remote image url. Not downloading image.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithBitmapDownload$6, reason: invalid class name */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class AnonymousClass6 extends v implements a<String> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        AnonymousClass6() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "In-app message full has no remote image url yet is required to have an image. Failing message display.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithHtml$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12521 extends v implements a<String> {
        public static final C12521 INSTANCE = new C12521();

        C12521() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "HTML in-app message does not have prefetched assets. Not performing any substitutions.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithHtml$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12532 extends v implements a<String> {
        public static final C12532 INSTANCE = new C12532();

        C12532() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "HTML in-app message does not have message. Not performing any substitutions.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12541 extends v implements a<String> {
        final /* synthetic */ String $localAssets;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12541(String str) {
            super(0);
            this.$localAssets = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Local assets for html in-app message are already populated. Not downloading assets. Location = " + this.$localAssets;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12552 extends v implements a<String> {
        public static final C12552 INSTANCE = new C12552();

        C12552() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Html in-app message has no remote asset zip. Continuing with in-app message preparation.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12563 extends v implements a<String> {
        public static final C12563 INSTANCE = new C12563();

        C12563() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "BrazeInAppMessageManager applicationContext is null. Not downloading image.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12574 extends v implements a<String> {
        final /* synthetic */ String $localWebContentUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12574(String str) {
            super(0);
            this.$localWebContentUrl = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Local url for html in-app message assets is " + this.$localWebContentUrl;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackgroundInAppMessagePreparer.kt */
    static final class C12585 extends v implements a<String> {
        final /* synthetic */ IInAppMessageZippedAssetHtml $inAppMessageHtml;
        final /* synthetic */ String $localWebContentUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12585(IInAppMessageZippedAssetHtml iInAppMessageZippedAssetHtml, String str) {
            super(0);
            this.$inAppMessageHtml = iInAppMessageZippedAssetHtml;
            this.$localWebContentUrl = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Download of html content to local directory failed for remote url: " + this.$inAppMessageHtml.getAssetsZipRemoteUrl() + " . Returned local url is: " + this.$localWebContentUrl;
        }
    }

    private BackgroundInAppMessagePreparer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object displayPreparedInAppMessage(IInAppMessage iInAppMessage, d<? super k0> dVar) {
        Object objG = i.g(e1.c(), new AnonymousClass2(iInAppMessage, null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }

    private final BrazeViewBounds getViewBoundsByType(IInAppMessage iInAppMessage) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[iInAppMessage.getMessageType().ordinal()];
        return i10 != 3 ? i10 != 4 ? BrazeViewBounds.NO_BOUNDS : BrazeViewBounds.IN_APP_MESSAGE_MODAL : BrazeViewBounds.IN_APP_MESSAGE_SLIDEUP;
    }

    private final boolean handleLocalImage(String str, IInAppMessageWithImage iInAppMessageWithImage, IBrazeImageLoader iBrazeImageLoader, Context context, IInAppMessage iInAppMessage, BrazeViewBounds brazeViewBounds) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) new AnonymousClass1(str), 6, (Object) null);
        iInAppMessageWithImage.setBitmap(iBrazeImageLoader.getInAppMessageBitmapFromUrl(context, iInAppMessage, str, brazeViewBounds));
        if (iInAppMessageWithImage.getBitmap() != null) {
            iInAppMessageWithImage.setImageDownloadSuccessful(true);
            return true;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C12442(str), 7, (Object) null);
        iInAppMessageWithImage.setLocalImageUrl(null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IInAppMessage prepareInAppMessage(IInAppMessage iInAppMessage) {
        if (iInAppMessage.isControl()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12451.INSTANCE, 7, (Object) null);
            return iInAppMessage;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12462.INSTANCE, 7, (Object) null);
        int i10 = WhenMappings.$EnumSwitchMapping$0[iInAppMessage.getMessageType().ordinal()];
        if (i10 == 1) {
            t.g(iInAppMessage, "null cannot be cast to non-null type com.braze.models.inappmessage.IInAppMessageZippedAssetHtml");
            if (!prepareInAppMessageWithZippedAssetHtml((IInAppMessageZippedAssetHtml) iInAppMessage)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) AnonymousClass3.INSTANCE, 6, (Object) null);
                return null;
            }
        } else if (i10 == 2) {
            t.g(iInAppMessage, "null cannot be cast to non-null type com.braze.models.inappmessage.InAppMessageHtml");
            prepareInAppMessageWithHtml((InAppMessageHtml) iInAppMessage);
        } else if (!prepareInAppMessageWithBitmapDownload(iInAppMessage)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) AnonymousClass4.INSTANCE, 6, (Object) null);
            return null;
        }
        return iInAppMessage;
    }

    public static final void prepareInAppMessageForDisplay(@NotNull IInAppMessage inAppMessageToPrepare) {
        t.i(inAppMessageToPrepare, "inAppMessageToPrepare");
        k.d(BrazeCoroutineScope.INSTANCE, null, null, new C12471(inAppMessageToPrepare, null), 3, null);
    }

    @VisibleForTesting
    public static final boolean prepareInAppMessageWithBitmapDownload(@Nullable IInAppMessage iInAppMessage) {
        if (!(iInAppMessage instanceof IInAppMessageWithImage)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12481.INSTANCE, 7, (Object) null);
            return false;
        }
        IInAppMessageWithImage iInAppMessageWithImage = (IInAppMessageWithImage) iInAppMessage;
        if (iInAppMessageWithImage.getBitmap() != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (a) C12492.INSTANCE, 6, (Object) null);
            iInAppMessageWithImage.setImageDownloadSuccessful(true);
            return true;
        }
        BackgroundInAppMessagePreparer backgroundInAppMessagePreparer = INSTANCE;
        BrazeViewBounds viewBoundsByType = backgroundInAppMessagePreparer.getViewBoundsByType(iInAppMessage);
        Context applicationContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext();
        if (applicationContext == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) backgroundInAppMessagePreparer, BrazeLogger.Priority.W, (Throwable) null, false, (a) C12503.INSTANCE, 6, (Object) null);
            return false;
        }
        IBrazeImageLoader imageLoader = Braze.Companion.getInstance(applicationContext).getImageLoader();
        String localImageUrl = iInAppMessageWithImage.getLocalImageUrl();
        if (!(localImageUrl == null || q.z(localImageUrl)) && backgroundInAppMessagePreparer.handleLocalImage(localImageUrl, iInAppMessageWithImage, imageLoader, applicationContext, iInAppMessage, viewBoundsByType)) {
            return true;
        }
        String remoteImageUrl = iInAppMessageWithImage.getRemoteImageUrl();
        if (!(remoteImageUrl == null || q.z(remoteImageUrl))) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) backgroundInAppMessagePreparer, BrazeLogger.Priority.I, (Throwable) null, false, (a) new C12514(remoteImageUrl), 6, (Object) null);
            iInAppMessageWithImage.setBitmap(imageLoader.getInAppMessageBitmapFromUrl(applicationContext, iInAppMessage, remoteImageUrl, viewBoundsByType));
            if (iInAppMessageWithImage.getBitmap() == null) {
                return false;
            }
            iInAppMessageWithImage.setImageDownloadSuccessful(true);
            return true;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.W;
        BrazeLogger.brazelog$default(brazeLogger, (Object) backgroundInAppMessagePreparer, priority, (Throwable) null, false, (a) AnonymousClass5.INSTANCE, 6, (Object) null);
        if (!(iInAppMessageWithImage instanceof InAppMessageFull)) {
            return true;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) backgroundInAppMessagePreparer, priority, (Throwable) null, false, (a) AnonymousClass6.INSTANCE, 6, (Object) null);
        return false;
    }

    @VisibleForTesting
    public static final boolean prepareInAppMessageWithZippedAssetHtml(@NotNull IInAppMessageZippedAssetHtml inAppMessageHtml) {
        t.i(inAppMessageHtml, "inAppMessageHtml");
        String localAssetsDirectoryUrl = inAppMessageHtml.getLocalAssetsDirectoryUrl();
        if (!(localAssetsDirectoryUrl == null || q.z(localAssetsDirectoryUrl)) && new File(localAssetsDirectoryUrl).exists()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (a) new C12541(localAssetsDirectoryUrl), 6, (Object) null);
            return true;
        }
        String assetsZipRemoteUrl = inAppMessageHtml.getAssetsZipRemoteUrl();
        if (assetsZipRemoteUrl == null || q.z(assetsZipRemoteUrl)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (a) C12552.INSTANCE, 6, (Object) null);
            return true;
        }
        Context applicationContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext();
        if (applicationContext == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) C12563.INSTANCE, 6, (Object) null);
            return false;
        }
        String localHtmlUrlFromRemoteUrl = WebContentUtils.getLocalHtmlUrlFromRemoteUrl(WebContentUtils.getHtmlInAppMessageAssetCacheDirectory(applicationContext), assetsZipRemoteUrl);
        if (localHtmlUrlFromRemoteUrl == null || q.z(localHtmlUrlFromRemoteUrl)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new C12585(inAppMessageHtml, localHtmlUrlFromRemoteUrl), 6, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C12574(localHtmlUrlFromRemoteUrl), 7, (Object) null);
        inAppMessageHtml.setLocalAssetsDirectoryUrl(localHtmlUrlFromRemoteUrl);
        return true;
    }

    @VisibleForTesting
    public final void prepareInAppMessageWithHtml(@NotNull InAppMessageHtml inAppMessage) {
        t.i(inAppMessage, "inAppMessage");
        if (inAppMessage.getLocalPrefetchedAssetPaths().isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12521.INSTANCE, 7, (Object) null);
            return;
        }
        String message = inAppMessage.getMessage();
        if (message == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12532.INSTANCE, 7, (Object) null);
        } else {
            inAppMessage.setMessage(WebContentUtils.replacePrefetchedUrlsWithLocalAssets(message, inAppMessage.getLocalPrefetchedAssetPaths()));
        }
    }
}
