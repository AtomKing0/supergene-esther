package com.unity3d.ads.core.domain.attribution;

import a9.c;
import android.adservices.AdServicesState;
import android.adservices.measurement.MeasurementManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.os.ext.SdkExtensions;
import android.view.InputEvent;
import androidx.media3.common.PlaybackException;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.WebViewContainer;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.s1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;
import v8.l;
import v8.n;
import v8.t;
import z8.d;
import z8.i;

/* JADX INFO: compiled from: AndroidAttribution.kt */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"NewApi", "MissingPermission"})
public final class AndroidAttribution {

    @NotNull
    private final ISDKDispatchers dispatchers;

    @NotNull
    private final l measurementManager$delegate;

    @NotNull
    private final SessionRepository sessionRepository;

    public AndroidAttribution(@NotNull Context context, @NotNull ISDKDispatchers dispatchers, @NotNull SessionRepository sessionRepository) {
        t.i(context, "context");
        t.i(dispatchers, "dispatchers");
        t.i(sessionRepository, "sessionRepository");
        this.dispatchers = dispatchers;
        this.sessionRepository = sessionRepository;
        this.measurementManager$delegate = n.a(new AndroidAttribution$measurementManager$2(this, context));
    }

    private final MeasurementManager getMeasurementManager() {
        return (MeasurementManager) this.measurementManager$delegate.getValue();
    }

    private final Uri getUri(String str, AdObject adObject) {
        Uri uri = Uri.parse(str);
        t.h(uri, "parse(this)");
        Uri uriBuild = uri.buildUpon().appendQueryParameter("sessionToken", ProtobufExtensionsKt.toBase64(this.sessionRepository.getSessionToken())).appendQueryParameter(HandleInvocationsFromAdViewer.KEY_TRACKING_TOKEN, ProtobufExtensionsKt.toBase64(adObject.getTrackingToken())).build();
        t.h(uriBuild, "baseUrl.toUri()\n        …4())\n            .build()");
        return uriBuild;
    }

    @Nullable
    public final Object isAvailable(@NotNull d<? super Boolean> dVar) throws Throwable {
        k0 k0Var;
        if (Device.getApiLevel() < 33) {
            return b.a(false);
        }
        if (SdkExtensions.getExtensionVersion(PlaybackException.CUSTOM_ERROR_CODE_BASE) < 4) {
            return b.a(false);
        }
        if (getMeasurementManager() == null) {
            return b.a(false);
        }
        if (!AdServicesState.isAdServicesStateEnabled()) {
            return b.a(false);
        }
        final i iVar = new i(c.c(dVar));
        MeasurementManager measurementManager = getMeasurementManager();
        if (measurementManager != null) {
            measurementManager.getMeasurementApiStatus(s1.a(this.dispatchers.getDefault()), new OutcomeReceiver<Integer, Exception>() { // from class: com.unity3d.ads.core.domain.attribution.AndroidAttribution$isAvailable$2$1
                @Override // android.os.OutcomeReceiver
                public /* bridge */ /* synthetic */ void onResult(Integer num) {
                    onResult(num.intValue());
                }

                @Override // android.os.OutcomeReceiver
                public void onError(@NotNull Exception error) {
                    t.i(error, "error");
                    d<Boolean> dVar2 = iVar;
                    t.a aVar = v8.t.f35208b;
                    dVar2.resumeWith(v8.t.b(Boolean.FALSE));
                }

                public void onResult(int i10) {
                    d<Boolean> dVar2 = iVar;
                    t.a aVar = v8.t.f35208b;
                    dVar2.resumeWith(v8.t.b(Boolean.valueOf(i10 == 1)));
                }
            });
            k0Var = k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var == null) {
            t.a aVar = v8.t.f35208b;
            iVar.resumeWith(v8.t.b(b.a(false)));
        }
        Object objA = iVar.a();
        if (objA == a9.d.e()) {
            h.c(dVar);
        }
        return objA;
    }

    @Nullable
    public final Object registerClick(@NotNull String str, @NotNull AdObject adObject, @NotNull d<? super Boolean> dVar) throws Throwable {
        WebViewContainer webViewContainer;
        m0<InputEvent> lastInputEvent;
        InputEvent value;
        k0 k0Var;
        if (getMeasurementManager() == null) {
            return b.a(false);
        }
        AdPlayer adPlayer = adObject.getAdPlayer();
        if (adPlayer == null || (webViewContainer = adPlayer.getWebViewContainer()) == null || (lastInputEvent = webViewContainer.getLastInputEvent()) == null || (value = lastInputEvent.getValue()) == null) {
            return b.a(false);
        }
        final i iVar = new i(c.c(dVar));
        MeasurementManager measurementManager = getMeasurementManager();
        if (measurementManager != null) {
            measurementManager.registerSource(getUri(str, adObject), value, s1.a(this.dispatchers.getDefault()), new OutcomeReceiver<Object, Exception>() { // from class: com.unity3d.ads.core.domain.attribution.AndroidAttribution$registerClick$2$1
                @Override // android.os.OutcomeReceiver
                public void onResult(@NotNull Object p02) {
                    kotlin.jvm.internal.t.i(p02, "p0");
                    d<Boolean> dVar2 = iVar;
                    t.a aVar = v8.t.f35208b;
                    dVar2.resumeWith(v8.t.b(Boolean.TRUE));
                }

                @Override // android.os.OutcomeReceiver
                public void onError(@NotNull Exception error) {
                    kotlin.jvm.internal.t.i(error, "error");
                    d<Boolean> dVar2 = iVar;
                    t.a aVar = v8.t.f35208b;
                    dVar2.resumeWith(v8.t.b(Boolean.FALSE));
                }
            });
            k0Var = k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var == null) {
            t.a aVar = v8.t.f35208b;
            iVar.resumeWith(v8.t.b(b.a(false)));
        }
        Object objA = iVar.a();
        if (objA == a9.d.e()) {
            h.c(dVar);
        }
        return objA;
    }

    @Nullable
    public final Object registerView(@NotNull String str, @NotNull AdObject adObject, @NotNull d<? super Boolean> dVar) throws Throwable {
        if (getMeasurementManager() == null) {
            return b.a(false);
        }
        final i iVar = new i(c.c(dVar));
        MeasurementManager measurementManager = getMeasurementManager();
        k0 k0Var = null;
        if (measurementManager != null) {
            measurementManager.registerSource(getUri(str, adObject), null, s1.a(this.dispatchers.getDefault()), new OutcomeReceiver<Object, Exception>() { // from class: com.unity3d.ads.core.domain.attribution.AndroidAttribution$registerView$2$1
                @Override // android.os.OutcomeReceiver
                public void onResult(@NotNull Object p02) {
                    kotlin.jvm.internal.t.i(p02, "p0");
                    d<Boolean> dVar2 = iVar;
                    t.a aVar = v8.t.f35208b;
                    dVar2.resumeWith(v8.t.b(Boolean.TRUE));
                }

                @Override // android.os.OutcomeReceiver
                public void onError(@NotNull Exception error) {
                    kotlin.jvm.internal.t.i(error, "error");
                    d<Boolean> dVar2 = iVar;
                    t.a aVar = v8.t.f35208b;
                    dVar2.resumeWith(v8.t.b(Boolean.FALSE));
                }
            });
            k0Var = k0.f35197a;
        }
        if (k0Var == null) {
            t.a aVar = v8.t.f35208b;
            iVar.resumeWith(v8.t.b(b.a(false)));
        }
        Object objA = iVar.a();
        if (objA == a9.d.e()) {
            h.c(dVar);
        }
        return objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MeasurementManager getMeasurementManager(Context context) {
        if (Device.getApiLevel() >= 33 && SdkExtensions.getExtensionVersion(PlaybackException.CUSTOM_ERROR_CODE_BASE) >= 4) {
            return (MeasurementManager) context.getSystemService(MeasurementManager.class);
        }
        return null;
    }
}
