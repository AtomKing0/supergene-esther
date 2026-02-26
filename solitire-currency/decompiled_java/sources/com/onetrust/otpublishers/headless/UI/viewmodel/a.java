package com.onetrust.otpublishers.headless.UI.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.n;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.UIProperty.f;
import com.onetrust.otpublishers.headless.UI.UIProperty.u;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends AndroidViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final OTPublishersHeadlessSDK f23668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final SharedPreferences f23669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<com.onetrust.otpublishers.headless.UI.DataModels.a> f23670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final MutableLiveData f23671d;

    /* JADX INFO: renamed from: com.onetrust.otpublishers.headless.UI.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0487a implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final Application f23672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final OTPublishersHeadlessSDK f23673b;

        public C0487a(@NotNull Application application, @Nullable OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
            t.i(application, "application");
            this.f23672a = application;
            this.f23673b = oTPublishersHeadlessSDK;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return n.b(this, cls, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public final <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            h hVar;
            t.i(modelClass, "modelClass");
            Application application = this.f23672a;
            boolean z10 = false;
            SharedPreferences sharedPreferences = application.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (new com.onetrust.otpublishers.headless.Internal.profile.d(application).t()) {
                hVar = new h(application, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            t.h(sharedPreferences, "OTSharedPreference(\n    …      ).sharedPreferences");
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f23673b;
            Application application2 = this.f23672a;
            if (oTPublishersHeadlessSDK == null) {
                oTPublishersHeadlessSDK = new OTPublishersHeadlessSDK(application2);
            }
            return new a(this.f23672a, oTPublishersHeadlessSDK, sharedPreferences);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Application application, @NotNull OTPublishersHeadlessSDK otPublishersHeadlessSDK, @NotNull SharedPreferences otSharedPreference) {
        super(application);
        t.i(application, "application");
        t.i(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        t.i(otSharedPreference, "otSharedPreference");
        this.f23668a = otPublishersHeadlessSDK;
        this.f23669b = otSharedPreference;
        MutableLiveData<com.onetrust.otpublishers.headless.UI.DataModels.a> mutableLiveData = new MutableLiveData<>();
        this.f23670c = mutableLiveData;
        this.f23671d = mutableLiveData;
    }

    @Nullable
    public final String a() {
        u uVar;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar;
        com.onetrust.otpublishers.headless.UI.DataModels.a value = this.f23670c.getValue();
        String str = (value == null || (uVar = value.f22057t) == null || (cVar = uVar.f22822g) == null) ? null : cVar.f22722c;
        if (!(true ^ (str == null || str.length() == 0))) {
            str = null;
        }
        if (str != null) {
            return str;
        }
        com.onetrust.otpublishers.headless.UI.DataModels.a value2 = this.f23670c.getValue();
        if (value2 != null) {
            return value2.f22045h;
        }
        return null;
    }

    @Nullable
    public final String b() {
        u uVar;
        f fVar;
        com.onetrust.otpublishers.headless.UI.DataModels.a value = this.f23670c.getValue();
        String strC = (value == null || (uVar = value.f22057t) == null || (fVar = uVar.f22826k) == null) ? null : fVar.c();
        if (!(true ^ (strC == null || strC.length() == 0))) {
            strC = null;
        }
        if (strC != null) {
            return strC;
        }
        com.onetrust.otpublishers.headless.UI.DataModels.a value2 = this.f23670c.getValue();
        if (value2 != null) {
            return value2.f22044g;
        }
        return null;
    }
}
