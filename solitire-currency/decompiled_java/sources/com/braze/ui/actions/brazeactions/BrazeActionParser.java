package com.braze.ui.actions.brazeactions;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import androidx.media3.extractor.text.ttml.TtmlNode;
import c9.c;
import com.braze.enums.Channel;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.braze.ui.actions.brazeactions.steps.AddToCustomAttributeArrayStep;
import com.braze.ui.actions.brazeactions.steps.AddToSubscriptionGroupStep;
import com.braze.ui.actions.brazeactions.steps.ContainerStep;
import com.braze.ui.actions.brazeactions.steps.IBrazeActionStep;
import com.braze.ui.actions.brazeactions.steps.LogCustomEventStep;
import com.braze.ui.actions.brazeactions.steps.NoOpStep;
import com.braze.ui.actions.brazeactions.steps.OpenLinkExternallyStep;
import com.braze.ui.actions.brazeactions.steps.OpenLinkInWebViewStep;
import com.braze.ui.actions.brazeactions.steps.RemoveFromCustomAttributeArrayStep;
import com.braze.ui.actions.brazeactions.steps.RemoveFromSubscriptionGroupStep;
import com.braze.ui.actions.brazeactions.steps.RequestPushPermissionStep;
import com.braze.ui.actions.brazeactions.steps.SetCustomUserAttributeStep;
import com.braze.ui.actions.brazeactions.steps.SetEmailSubscriptionStep;
import com.braze.ui.actions.brazeactions.steps.SetPushNotificationSubscriptionStep;
import com.braze.ui.actions.brazeactions.steps.StepData;
import h9.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import v8.s;

/* JADX INFO: compiled from: BrazeActionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BrazeActionParser {

    @NotNull
    public static final BrazeActionParser INSTANCE = new BrazeActionParser();

    /* JADX INFO: compiled from: BrazeActionParser.kt */
    public enum ActionType {
        CONTAINER(TtmlNode.RUBY_CONTAINER, ContainerStep.INSTANCE),
        LOG_CUSTOM_EVENT("logCustomEvent", LogCustomEventStep.INSTANCE),
        SET_CUSTOM_ATTRIBUTE("setCustomUserAttribute", SetCustomUserAttributeStep.INSTANCE),
        REQUEST_PUSH_PERMISSION("requestPushPermission", RequestPushPermissionStep.INSTANCE),
        ADD_TO_SUBSCRIPTION_GROUP("addToSubscriptionGroup", AddToSubscriptionGroupStep.INSTANCE),
        REMOVE_FROM_SUBSCRIPTION_GROUP("removeFromSubscriptionGroup", RemoveFromSubscriptionGroupStep.INSTANCE),
        ADD_TO_CUSTOM_ATTRIBUTE_ARRAY("addToCustomAttributeArray", AddToCustomAttributeArrayStep.INSTANCE),
        REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY("removeFromCustomAttributeArray", RemoveFromCustomAttributeArrayStep.INSTANCE),
        SET_EMAIL_SUBSCRIPTION("setEmailNotificationSubscriptionType", SetEmailSubscriptionStep.INSTANCE),
        SET_PUSH_NOTIFICATION_SUBSCRIPTION("setPushNotificationSubscriptionType", SetPushNotificationSubscriptionStep.INSTANCE),
        OPEN_LINK_IN_WEBVIEW("openLinkInWebview", OpenLinkInWebViewStep.INSTANCE),
        OPEN_LINK_EXTERNALLY("openLink", OpenLinkExternallyStep.INSTANCE),
        INVALID("", NoOpStep.INSTANCE);


        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static final Map<String, ActionType> map;

        @NotNull
        private final IBrazeActionStep impl;

        @NotNull
        private final String key;

        /* JADX INFO: compiled from: BrazeActionParser.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            @NotNull
            public final ActionType fromValue(@Nullable String str) {
                Map map = ActionType.map;
                if (str == null) {
                    str = "";
                }
                Object obj = map.get(str);
                if (obj == null) {
                    obj = ActionType.INVALID;
                }
                return (ActionType) obj;
            }
        }

        static {
            ActionType[] actionTypeArrValues = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(o.e(q0.d(actionTypeArrValues.length), 16));
            for (ActionType actionType : actionTypeArrValues) {
                linkedHashMap.put(actionType.key, actionType);
            }
            map = linkedHashMap;
        }

        ActionType(String str, IBrazeActionStep iBrazeActionStep) {
            this.key = str;
            this.impl = iBrazeActionStep;
        }

        @NotNull
        public final IBrazeActionStep getImpl() {
            return this.impl;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.BrazeActionParser$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeActionParser.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ Channel $channel;
        final /* synthetic */ Uri $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Channel channel, Uri uri) {
            super(0);
            this.$channel = channel;
            this.$uri = uri;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Attempting to parse Braze Action with channel " + this.$channel + " and uri:\n'" + this.$uri + '\'';
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.BrazeActionParser$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeActionParser.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to decode Braze Action into both version and json components. Doing nothing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.BrazeActionParser$execute$3, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeActionParser.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        final /* synthetic */ String $version;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str) {
            super(0);
            this.$version = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Braze Actions version " + this.$version + " is unsupported. Version must be v1";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.BrazeActionParser$execute$4, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeActionParser.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        final /* synthetic */ Uri $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Uri uri) {
            super(0);
            this.$uri = uri;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to parse uri as a Braze Action.\n'" + this.$uri + '\'';
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.BrazeActionParser$execute$5, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeActionParser.kt */
    static final class AnonymousClass5 extends v implements a<String> {
        final /* synthetic */ Uri $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Uri uri) {
            super(0);
            this.$uri = uri;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Done handling Braze uri\n'" + this.$uri + '\'';
        }
    }

    private BrazeActionParser() {
    }

    public final void execute(@NotNull Context context, @NotNull Uri uri, @NotNull Channel channel) {
        s brazeActionVersionAndJson$android_sdk_ui_release;
        t.i(context, "context");
        t.i(uri, "uri");
        t.i(channel, "channel");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass1(channel, uri), 6, (Object) null);
        try {
            brazeActionVersionAndJson$android_sdk_ui_release = getBrazeActionVersionAndJson$android_sdk_ui_release(uri);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new AnonymousClass4(uri), 4, (Object) null);
        }
        if (brazeActionVersionAndJson$android_sdk_ui_release == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) AnonymousClass2.INSTANCE, 6, (Object) null);
            return;
        }
        String str = (String) brazeActionVersionAndJson$android_sdk_ui_release.a();
        JSONObject jSONObject = (JSONObject) brazeActionVersionAndJson$android_sdk_ui_release.b();
        if (!t.d(str, "v1")) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass3(str), 7, (Object) null);
        } else {
            parse$android_sdk_ui_release(context, new StepData(jSONObject, channel));
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass5(uri), 6, (Object) null);
        }
    }

    public final /* synthetic */ ActionType getActionType$android_sdk_ui_release(StepData data) {
        t.i(data, "data");
        ActionType actionTypeFromValue = ActionType.Companion.fromValue(JsonUtils.getOptionalString(data.getSrcJson(), "type"));
        if (actionTypeFromValue.getImpl().isValid(data)) {
            return actionTypeFromValue;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeActionParser$getActionType$1(actionTypeFromValue, data), 7, (Object) null);
        return ActionType.INVALID;
    }

    public final /* synthetic */ s getBrazeActionVersionAndJson$android_sdk_ui_release(Uri uri) {
        JSONObject encodedActionToJson$android_sdk_ui_release;
        t.i(uri, "<this>");
        String host = uri.getHost();
        String lastPathSegment = uri.getLastPathSegment();
        if (host == null || lastPathSegment == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) uri, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeActionParser$getBrazeActionVersionAndJson$1(uri), 7, (Object) null);
            return null;
        }
        try {
            encodedActionToJson$android_sdk_ui_release = parseEncodedActionToJson$android_sdk_ui_release(lastPathSegment);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) uri, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new BrazeActionParser$getBrazeActionVersionAndJson$json$1(lastPathSegment), 4, (Object) null);
            encodedActionToJson$android_sdk_ui_release = null;
        }
        if (encodedActionToJson$android_sdk_ui_release == null) {
            return null;
        }
        return new s(host, encodedActionToJson$android_sdk_ui_release);
    }

    public final boolean isBrazeActionUri(@Nullable Uri uri) {
        return t.d(uri != null ? uri.getScheme() : null, "brazeActions");
    }

    public final /* synthetic */ void parse$android_sdk_ui_release(Context context, StepData data) {
        t.i(context, "context");
        t.i(data, "data");
        try {
            ActionType actionType$android_sdk_ui_release = getActionType$android_sdk_ui_release(data);
            if (actionType$android_sdk_ui_release == ActionType.INVALID) {
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new BrazeActionParser$parse$1(actionType$android_sdk_ui_release, data), 6, (Object) null);
            actionType$android_sdk_ui_release.getImpl().run(context, data);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new BrazeActionParser$parse$2(data), 4, (Object) null);
        }
    }

    public final /* synthetic */ JSONObject parseEncodedActionToJson$android_sdk_ui_release(String action) {
        t.i(action, "action");
        byte[] bArrDecode = Base64.decode(action, 8);
        t.h(bArrDecode, "decode(action, Base64.URL_SAFE)");
        int length = bArrDecode.length / 2;
        int[] iArr = new int[length];
        int iC = c.c(0, bArrDecode.length - 1, 2);
        if (iC >= 0) {
            int i10 = 0;
            while (true) {
                iArr[i10 / 2] = (bArrDecode[i10] & 255) | ((bArrDecode[i10 + 1] & 255) << 8);
                if (i10 == iC) {
                    break;
                }
                i10 += 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = iArr[i11];
            if (i12 < 0 || i12 > 65535) {
                throw new IllegalArgumentException("Invalid Char code: " + i12);
            }
            sb.append((char) i12);
        }
        return new JSONObject(sb.toString());
    }
}
