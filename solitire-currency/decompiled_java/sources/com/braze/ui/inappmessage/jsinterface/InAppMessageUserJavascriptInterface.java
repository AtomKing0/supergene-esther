package com.braze.ui.inappmessage.jsinterface;

import android.content.Context;
import android.webkit.JavascriptInterface;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.enums.Gender;
import com.braze.enums.Month;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.events.IValueCallback;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface;
import h9.a;
import h9.l;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import v8.k0;

/* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InAppMessageUserJavascriptInterface {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Context context;

    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void runOnUser(Braze braze, final l<? super BrazeUser, k0> lVar) {
            braze.getCurrentUser(new IValueCallback() { // from class: n0.a
                @Override // com.braze.events.IValueCallback
                public /* synthetic */ void onError() {
                    e0.a.a(this);
                }

                @Override // com.braze.events.IValueCallback
                public final void onSuccess(Object obj) {
                    InAppMessageUserJavascriptInterface.Companion.runOnUser$lambda$0(lVar, (BrazeUser) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void runOnUser$lambda$0(l block, BrazeUser it) {
            t.i(block, "$block");
            t.i(it, "it");
            block.invoke(it);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$addAlias$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class AnonymousClass1 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $alias;
        final /* synthetic */ String $label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2) {
            super(1);
            this.$alias = str;
            this.$label = str2;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.addAlias(this.$alias, this.$label);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$addToCustomAttributeArray$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12041 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12041(String str, String str2) {
            super(1);
            this.$key = str;
            this.$value = str2;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.addToCustomAttributeArray(this.$key, this.$value);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$addToSubscriptionGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12051 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $subscriptionGroupId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12051(String str) {
            super(1);
            this.$subscriptionGroupId = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.addToSubscriptionGroup(this.$subscriptionGroupId);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$incrementCustomUserAttribute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12061 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $attribute;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12061(String str) {
            super(1);
            this.$attribute = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            BrazeUser.incrementCustomUserAttribute$default(it, this.$attribute, 0, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$parseStringArrayFromJsonString$2, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to parse custom attribute array";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$removeFromCustomAttributeArray$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12071 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12071(String str, String str2) {
            super(1);
            this.$key = str;
            this.$value = str2;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.removeFromCustomAttributeArray(this.$key, this.$value);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$removeFromSubscriptionGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12081 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $subscriptionGroupId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12081(String str) {
            super(1);
            this.$subscriptionGroupId = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.removeFromSubscriptionGroup(this.$subscriptionGroupId);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setCountry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12091 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $country;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12091(String str) {
            super(1);
            this.$country = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setCountry(this.$country);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setCustomAttribute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12101 extends v implements a<String> {
        final /* synthetic */ String $jsonStringValue;
        final /* synthetic */ String $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12101(String str, String str2) {
            super(0);
            this.$key = str;
            this.$jsonStringValue = str2;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to parse custom attribute type for key: " + this.$key + " and json string value: " + this.$jsonStringValue;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setCustomAttribute$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12112 extends v implements a<String> {
        final /* synthetic */ String $jsonStringValue;
        final /* synthetic */ String $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12112(String str, String str2) {
            super(0);
            this.$key = str;
            this.$jsonStringValue = str2;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to parse custom attribute type for key: " + this.$key + " and json string value: " + this.$jsonStringValue;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setCustomLocationAttribute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12121 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $attribute;
        final /* synthetic */ double $latitude;
        final /* synthetic */ double $longitude;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12121(String str, double d10, double d11) {
            super(1);
            this.$attribute = str;
            this.$latitude = d10;
            this.$longitude = d11;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setLocationCustomAttribute(this.$attribute, this.$latitude, this.$longitude);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setCustomUserAttributeArray$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12131 extends v implements a<String> {
        final /* synthetic */ String $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12131(String str) {
            super(0);
            this.$key = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to set custom attribute array for key " + this.$key;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setCustomUserAttributeArray$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12142 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String[] $arrayValue;
        final /* synthetic */ String $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12142(String str, String[] strArr) {
            super(1);
            this.$key = str;
            this.$arrayValue = strArr;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setCustomAttributeArray(this.$key, this.$arrayValue);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setCustomUserAttributeJSON$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12151 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $jsonStringValue;
        final /* synthetic */ String $key;
        final /* synthetic */ boolean $merge;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12151(String str, String str2, boolean z10) {
            super(1);
            this.$key = str;
            this.$jsonStringValue = str2;
            this.$merge = z10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            InAppMessageUserJavascriptInterface.this.setCustomAttribute(it, this.$key, this.$jsonStringValue, this.$merge);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setDateOfBirth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12161 extends v implements a<String> {
        final /* synthetic */ int $monthInt;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12161(int i10) {
            super(0);
            this.$monthInt = i10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to parse month for value " + this.$monthInt;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setDateOfBirth$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12172 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ int $day;
        final /* synthetic */ Month $month;
        final /* synthetic */ int $year;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12172(int i10, Month month, int i11) {
            super(1);
            this.$year = i10;
            this.$month = month;
            this.$day = i11;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setDateOfBirth(this.$year, this.$month, this.$day);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setEmail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12181 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $email;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12181(String str) {
            super(1);
            this.$email = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setEmail(this.$email);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setEmailNotificationSubscriptionType$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12191 extends v implements a<String> {
        final /* synthetic */ String $subscriptionType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12191(String str) {
            super(0);
            this.$subscriptionType = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to parse email subscription type in Braze HTML in-app message javascript interface with subscription " + this.$subscriptionType;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setEmailNotificationSubscriptionType$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12202 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ NotificationSubscriptionType $subscriptionTypeEnum;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12202(NotificationSubscriptionType notificationSubscriptionType) {
            super(1);
            this.$subscriptionTypeEnum = notificationSubscriptionType;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setEmailNotificationSubscriptionType(this.$subscriptionTypeEnum);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setFirstName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12211 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $firstName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12211(String str) {
            super(1);
            this.$firstName = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setFirstName(this.$firstName);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setGender$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12221 extends v implements a<String> {
        final /* synthetic */ String $genderString;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12221(String str) {
            super(0);
            this.$genderString = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to parse gender in Braze HTML in-app message javascript interface with gender: " + this.$genderString;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setGender$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12232 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ Gender $gender;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12232(Gender gender) {
            super(1);
            this.$gender = gender;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setGender(this.$gender);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setHomeCity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12241 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $homeCity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12241(String str) {
            super(1);
            this.$homeCity = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setHomeCity(this.$homeCity);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setLanguage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12251 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $language;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12251(String str) {
            super(1);
            this.$language = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setLanguage(this.$language);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setLastName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12261 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $lastName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12261(String str) {
            super(1);
            this.$lastName = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setLastName(this.$lastName);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setPhoneNumber$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12271 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $phoneNumber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12271(String str) {
            super(1);
            this.$phoneNumber = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setPhoneNumber(this.$phoneNumber);
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setPushNotificationSubscriptionType$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12281 extends v implements a<String> {
        final /* synthetic */ String $subscriptionType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12281(String str) {
            super(0);
            this.$subscriptionType = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to parse push subscription type in Braze HTML in-app message javascript interface with subscription: " + this.$subscriptionType;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface$setPushNotificationSubscriptionType$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageUserJavascriptInterface.kt */
    static final class C12292 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ NotificationSubscriptionType $subscriptionTypeEnum;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12292(NotificationSubscriptionType notificationSubscriptionType) {
            super(1);
            this.$subscriptionTypeEnum = notificationSubscriptionType;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.setPushNotificationSubscriptionType(this.$subscriptionTypeEnum);
        }
    }

    public InAppMessageUserJavascriptInterface(@NotNull Context context) {
        t.i(context, "context");
        this.context = context;
    }

    @JavascriptInterface
    public final void addAlias(@NotNull String alias, @NotNull String label) {
        t.i(alias, "alias");
        t.i(label, "label");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new AnonymousClass1(alias, label));
    }

    @JavascriptInterface
    public final void addToCustomAttributeArray(@NotNull String key, @NotNull String value) {
        t.i(key, "key");
        t.i(value, "value");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12041(key, value));
    }

    @JavascriptInterface
    public final void addToSubscriptionGroup(@NotNull String subscriptionGroupId) {
        t.i(subscriptionGroupId, "subscriptionGroupId");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12051(subscriptionGroupId));
    }

    @JavascriptInterface
    public final void incrementCustomUserAttribute(@NotNull String attribute) {
        t.i(attribute, "attribute");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12061(attribute));
    }

    @VisibleForTesting
    @Nullable
    public final Month monthFromInt(int i10) {
        if (i10 < 1 || i10 > 12) {
            return null;
        }
        return Month.Companion.getMonth(i10 - 1);
    }

    @VisibleForTesting
    @Nullable
    public final Gender parseGender(@NotNull String genderString) {
        t.i(genderString, "genderString");
        Locale US = Locale.US;
        t.h(US, "US");
        String lowerCase = genderString.toLowerCase(US);
        t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Gender gender = Gender.MALE;
        if (t.d(lowerCase, gender.forJsonPut())) {
            return gender;
        }
        Gender gender2 = Gender.FEMALE;
        if (t.d(lowerCase, gender2.forJsonPut())) {
            return gender2;
        }
        Gender gender3 = Gender.OTHER;
        if (t.d(lowerCase, gender3.forJsonPut())) {
            return gender3;
        }
        Gender gender4 = Gender.UNKNOWN;
        if (t.d(lowerCase, gender4.forJsonPut())) {
            return gender4;
        }
        Gender gender5 = Gender.NOT_APPLICABLE;
        if (t.d(lowerCase, gender5.forJsonPut())) {
            return gender5;
        }
        Gender gender6 = Gender.PREFER_NOT_TO_SAY;
        if (t.d(lowerCase, gender6.forJsonPut())) {
            return gender6;
        }
        return null;
    }

    @VisibleForTesting
    @Nullable
    public final String[] parseStringArrayFromJsonString(@Nullable String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(jSONArray.getString(i10));
            }
            return (String[]) arrayList.toArray(new String[0]);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) AnonymousClass2.INSTANCE, 4, (Object) null);
            return null;
        }
    }

    @JavascriptInterface
    public final void removeFromCustomAttributeArray(@NotNull String key, @NotNull String value) {
        t.i(key, "key");
        t.i(value, "value");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12071(key, value));
    }

    @JavascriptInterface
    public final void removeFromSubscriptionGroup(@NotNull String subscriptionGroupId) {
        t.i(subscriptionGroupId, "subscriptionGroupId");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12081(subscriptionGroupId));
    }

    @JavascriptInterface
    public final void setCountry(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12091(str));
    }

    @VisibleForTesting
    public final void setCustomAttribute(@NotNull BrazeUser user, @NotNull String key, @NotNull String jsonStringValue, boolean z10) {
        t.i(user, "user");
        t.i(key, "key");
        t.i(jsonStringValue, "jsonStringValue");
        try {
            Object obj = new JSONObject(jsonStringValue).get("value");
            if (obj instanceof String) {
                user.setCustomUserAttribute(key, (String) obj);
            } else if (obj instanceof Boolean) {
                user.setCustomUserAttribute(key, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                user.setCustomUserAttribute(key, ((Number) obj).intValue());
            } else if (obj instanceof Double) {
                user.setCustomUserAttribute(key, ((Number) obj).doubleValue());
            } else if (obj instanceof JSONObject) {
                user.setCustomUserAttribute(key, (JSONObject) obj, z10);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new C12101(key, jsonStringValue), 6, (Object) null);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new C12112(key, jsonStringValue), 4, (Object) null);
        }
    }

    @JavascriptInterface
    public final void setCustomLocationAttribute(@NotNull String attribute, double d10, double d11) {
        t.i(attribute, "attribute");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12121(attribute, d10, d11));
    }

    @JavascriptInterface
    public final void setCustomUserAttributeArray(@NotNull String key, @Nullable String str) {
        t.i(key, "key");
        String[] stringArrayFromJsonString = parseStringArrayFromJsonString(str);
        if (stringArrayFromJsonString == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new C12131(key), 6, (Object) null);
        } else {
            Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12142(key, stringArrayFromJsonString));
        }
    }

    @JavascriptInterface
    public final void setCustomUserAttributeJSON(@NotNull String key, @NotNull String jsonStringValue, boolean z10) {
        t.i(key, "key");
        t.i(jsonStringValue, "jsonStringValue");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12151(key, jsonStringValue, z10));
    }

    @JavascriptInterface
    public final void setDateOfBirth(int i10, int i11, int i12) {
        Month monthMonthFromInt = monthFromInt(i11);
        if (monthMonthFromInt == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new C12161(i11), 6, (Object) null);
        } else {
            Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12172(i10, monthMonthFromInt, i12));
        }
    }

    @JavascriptInterface
    public final void setEmail(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12181(str));
    }

    @JavascriptInterface
    public final void setEmailNotificationSubscriptionType(@NotNull String subscriptionType) {
        t.i(subscriptionType, "subscriptionType");
        NotificationSubscriptionType notificationSubscriptionTypeSubscriptionTypeFromJavascriptString = subscriptionTypeFromJavascriptString(subscriptionType);
        if (notificationSubscriptionTypeSubscriptionTypeFromJavascriptString == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new C12191(subscriptionType), 6, (Object) null);
        } else {
            Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12202(notificationSubscriptionTypeSubscriptionTypeFromJavascriptString));
        }
    }

    @JavascriptInterface
    public final void setFirstName(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12211(str));
    }

    @JavascriptInterface
    public final void setGender(@NotNull String genderString) {
        t.i(genderString, "genderString");
        Gender gender = parseGender(genderString);
        if (gender == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new C12221(genderString), 6, (Object) null);
        } else {
            Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12232(gender));
        }
    }

    @JavascriptInterface
    public final void setHomeCity(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12241(str));
    }

    @JavascriptInterface
    public final void setLanguage(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12251(str));
    }

    @JavascriptInterface
    public final void setLastName(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12261(str));
    }

    @JavascriptInterface
    public final void setPhoneNumber(@Nullable String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12271(str));
    }

    @JavascriptInterface
    public final void setPushNotificationSubscriptionType(@NotNull String subscriptionType) {
        t.i(subscriptionType, "subscriptionType");
        NotificationSubscriptionType notificationSubscriptionTypeSubscriptionTypeFromJavascriptString = subscriptionTypeFromJavascriptString(subscriptionType);
        if (notificationSubscriptionTypeSubscriptionTypeFromJavascriptString == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new C12281(subscriptionType), 6, (Object) null);
        } else {
            Companion.runOnUser(Braze.Companion.getInstance(this.context), new C12292(notificationSubscriptionTypeSubscriptionTypeFromJavascriptString));
        }
    }

    @VisibleForTesting
    @Nullable
    public final NotificationSubscriptionType subscriptionTypeFromJavascriptString(@Nullable String str) {
        return NotificationSubscriptionType.Companion.fromValue(str);
    }
}
