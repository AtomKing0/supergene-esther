package com.braze.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import com.braze.BrazeInternal;
import com.braze.enums.GeofenceTransitionType;
import com.braze.models.outgoing.BrazeLocation;
import com.braze.support.BrazeLogger;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import h9.a;
import h9.p;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: BrazeActionReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class BrazeActionReceiver extends BroadcastReceiver {

    /* JADX INFO: compiled from: BrazeActionReceiver.kt */
    @VisibleForTesting
    public static final class ActionReceiver {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @Nullable
        private final String action;

        @NotNull
        private final Context applicationContext;

        @NotNull
        private final Intent intent;

        /* JADX INFO: compiled from: BrazeActionReceiver.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final boolean handleSingleLocationUpdate(Context context, Location location) {
                try {
                    BrazeInternal.logLocationRecordedEvent(context, new BrazeLocation(location));
                    return true;
                } catch (Exception e10) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) BrazeActionReceiver$ActionReceiver$Companion$handleSingleLocationUpdate$1.INSTANCE, 4, (Object) null);
                    return false;
                }
            }

            @VisibleForTesting
            public final boolean handleGeofenceEvent(@NotNull Context applicationContext, @NotNull GeofencingEvent geofenceEvent) {
                t.i(applicationContext, "applicationContext");
                t.i(geofenceEvent, "geofenceEvent");
                if (geofenceEvent.hasError()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new BrazeActionReceiver$ActionReceiver$Companion$handleGeofenceEvent$1(geofenceEvent.getErrorCode()), 6, (Object) null);
                    return false;
                }
                int geofenceTransition = geofenceEvent.getGeofenceTransition();
                List<Geofence> triggeringGeofences = geofenceEvent.getTriggeringGeofences();
                if (1 == geofenceTransition) {
                    if (triggeringGeofences != null) {
                        Iterator<T> it = triggeringGeofences.iterator();
                        while (it.hasNext()) {
                            String requestId = ((Geofence) it.next()).getRequestId();
                            t.h(requestId, "geofence.requestId");
                            BrazeInternal.recordGeofenceTransition(applicationContext, requestId, GeofenceTransitionType.ENTER);
                        }
                    }
                } else {
                    if (2 != geofenceTransition) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new BrazeActionReceiver$ActionReceiver$Companion$handleGeofenceEvent$4(geofenceTransition), 6, (Object) null);
                        return false;
                    }
                    if (triggeringGeofences != null) {
                        Iterator<T> it2 = triggeringGeofences.iterator();
                        while (it2.hasNext()) {
                            String requestId2 = ((Geofence) it2.next()).getRequestId();
                            t.h(requestId2, "geofence.requestId");
                            BrazeInternal.recordGeofenceTransition(applicationContext, requestId2, GeofenceTransitionType.EXIT);
                        }
                    }
                }
                return true;
            }
        }

        public ActionReceiver(@NotNull Context applicationContext, @NotNull Intent intent) {
            t.i(applicationContext, "applicationContext");
            t.i(intent, "intent");
            this.applicationContext = applicationContext;
            this.intent = intent;
            this.action = intent.getAction();
        }

        @VisibleForTesting
        public final void performWork() {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeActionReceiver$ActionReceiver$performWork$1(this), 7, (Object) null);
            String str = this.action;
            if (str == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeActionReceiver$ActionReceiver$performWork$2.INSTANCE, 7, (Object) null);
                return;
            }
            if (t.d(str, "com.braze.action.receiver.BRAZE_GEOFENCE_UPDATE")) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeActionReceiver$ActionReceiver$performWork$3(this), 7, (Object) null);
                GeofencingEvent geofencingEventFromIntent = GeofencingEvent.fromIntent(this.intent);
                if (geofencingEventFromIntent != null) {
                    Companion.handleGeofenceEvent(this.applicationContext, geofencingEventFromIntent);
                    return;
                }
                return;
            }
            if (!t.d(str, "com.braze.action.receiver.SINGLE_LOCATION_UPDATE")) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new BrazeActionReceiver$ActionReceiver$performWork$7(this), 6, (Object) null);
                return;
            }
            Location location = null;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeActionReceiver$ActionReceiver$performWork$5(this), 7, (Object) null);
            if (Build.VERSION.SDK_INT >= 33) {
                Bundle extras = this.intent.getExtras();
                if (extras != null) {
                    location = (Location) extras.getParcelable("location", Location.class);
                }
            } else {
                Bundle extras2 = this.intent.getExtras();
                location = (Location) (extras2 != null ? extras2.get("location") : null);
            }
            if (location != null) {
                Companion.handleSingleLocationUpdate(this.applicationContext, location);
            }
        }

        public final void run() {
            try {
                performWork();
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new BrazeActionReceiver$ActionReceiver$run$1(this), 4, (Object) null);
            }
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeActionReceiver$onReceive$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeActionReceiver.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "BrazeActionReceiver received null intent. Doing nothing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeActionReceiver$onReceive$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeActionReceiver.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "BrazeActionReceiver received null context. Doing nothing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeActionReceiver$onReceive$3, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeActionReceiver.kt */
    @f(c = "com.braze.location.BrazeActionReceiver$onReceive$3", f = "BrazeActionReceiver.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ ActionReceiver $actionReceiver;
        final /* synthetic */ BroadcastReceiver.PendingResult $pendingResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ActionReceiver actionReceiver, BroadcastReceiver.PendingResult pendingResult, d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$actionReceiver = actionReceiver;
            this.$pendingResult = pendingResult;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass3(this.$actionReceiver, this.$pendingResult, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.$actionReceiver.run();
            this.$pendingResult.finish();
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass3) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (intent == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 6, (Object) null);
            return;
        }
        if (context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) AnonymousClass2.INSTANCE, 6, (Object) null);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        t.h(applicationContext, "applicationContext");
        kotlinx.coroutines.k.d(t1.f29982a, e1.b(), null, new AnonymousClass3(new ActionReceiver(applicationContext, intent), pendingResultGoAsync, null), 2, null);
    }
}
