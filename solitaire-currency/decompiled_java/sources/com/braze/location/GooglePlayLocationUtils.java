package com.braze.location;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import com.braze.location.GooglePlayLocationUtils;
import com.braze.managers.BrazeGeofenceManager;
import com.braze.models.BrazeGeofence;
import com.braze.support.BrazeLogger;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import h9.a;
import h9.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.q0;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"MissingPermission"})
public final class GooglePlayLocationUtils {

    @NotNull
    public static final GooglePlayLocationUtils INSTANCE = new GooglePlayLocationUtils();

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGeofencingClient$1, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class AnonymousClass1 extends v implements l<Void, k0> {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<BrazeGeofence> $newGeofencesToRegister;

        /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGeofencingClient$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
        static final class C01831 extends v implements a<String> {
            public static final C01831 INSTANCE = new C01831();

            C01831() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            public final String invoke() {
                return "Geofences successfully registered with Google Play Services.";
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, List<BrazeGeofence> list) {
            super(1);
            this.$context = context;
            this.$newGeofencesToRegister = list;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Void r12) {
            invoke2(r12);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r92) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            GooglePlayLocationUtils googlePlayLocationUtils = GooglePlayLocationUtils.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) googlePlayLocationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C01831.INSTANCE, 7, (Object) null);
            googlePlayLocationUtils.storeGeofencesToSharedPrefs$android_sdk_location_release(this.$context, this.$newGeofencesToRegister);
        }
    }

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGooglePlayIfNecessary$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class C10741 extends v implements l<List<? extends String>, k0> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10741(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<String> it) {
            t.i(it, "it");
            GooglePlayLocationUtils.INSTANCE.removeGeofencesRegisteredWithGeofencingClient$android_sdk_location_release(this.$context, it);
        }
    }

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGooglePlayIfNecessary$2, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class AnonymousClass2 extends v implements l<List<? extends BrazeGeofence>, k0> {
        final /* synthetic */ Context $context;
        final /* synthetic */ PendingIntent $geofenceRequestIntent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, PendingIntent pendingIntent) {
            super(1);
            this.$context = context;
            this.$geofenceRequestIntent = pendingIntent;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(List<? extends BrazeGeofence> list) {
            invoke2((List<BrazeGeofence>) list);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<BrazeGeofence> it) {
            t.i(it, "it");
            GooglePlayLocationUtils.INSTANCE.registerGeofencesWithGeofencingClient(this.$context, it, this.$geofenceRequestIntent);
        }
    }

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGooglePlayIfNecessary$3, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        final /* synthetic */ List<BrazeGeofence> $desiredGeofencesToRegister;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(List<BrazeGeofence> list) {
            super(0);
            this.$desiredGeofencesToRegister = list;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "registerGeofencesWithGooglePlayIfNecessary called with " + this.$desiredGeofencesToRegister;
        }
    }

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGooglePlayIfNecessary$4, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        final /* synthetic */ BrazeGeofence $desiredGeofence;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(BrazeGeofence brazeGeofence) {
            super(0);
            this.$desiredGeofence = brazeGeofence;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Geofence with id: " + this.$desiredGeofence.getId() + " is new or has been updated.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGooglePlayIfNecessary$5, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class AnonymousClass5 extends v implements a<String> {
        final /* synthetic */ List<String> $obsoleteGeofenceIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(List<String> list) {
            super(0);
            this.$obsoleteGeofenceIds = list;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Un-registering " + this.$obsoleteGeofenceIds + " obsolete geofences from Google Play Services.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGooglePlayIfNecessary$6, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class AnonymousClass6 extends v implements a<String> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        AnonymousClass6() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "No obsolete geofences need to be unregistered from Google Play Services.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGooglePlayIfNecessary$7, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class AnonymousClass7 extends v implements a<String> {
        final /* synthetic */ List<BrazeGeofence> $newGeofencesToRegister;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(List<BrazeGeofence> list) {
            super(0);
            this.$newGeofencesToRegister = list;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Registering " + this.$newGeofencesToRegister + " new geofences with Google Play Services.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGooglePlayIfNecessary$8, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class AnonymousClass8 extends v implements a<String> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        AnonymousClass8() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "No new geofences need to be registered with Google Play Services.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$registerGeofencesWithGooglePlayIfNecessary$9, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class AnonymousClass9 extends v implements a<String> {
        public static final AnonymousClass9 INSTANCE = new AnonymousClass9();

        AnonymousClass9() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Exception while adding geofences.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$removeGeofencesFromSharedPrefs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class C10751 extends v implements a<String> {
        final /* synthetic */ String $id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10751(String str) {
            super(0);
            this.$id = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Geofence with id: " + this.$id + " removed from shared preferences.";
        }
    }

    private GooglePlayLocationUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerGeofencesWithGeofencingClient(Context context, List<BrazeGeofence> list, PendingIntent pendingIntent) {
        List<BrazeGeofence> list2 = list;
        ArrayList arrayList = new ArrayList(w.v(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(GooglePlayLocationUtilsKt.toGeofence((BrazeGeofence) it.next()));
        }
        GeofencingRequest geofencingRequestBuild = new GeofencingRequest.Builder().addGeofences(arrayList).setInitialTrigger(0).build();
        t.h(geofencingRequestBuild, "Builder()\n            .a…r(0)\n            .build()");
        Task<Void> taskAddGeofences = LocationServices.getGeofencingClient(context).addGeofences(geofencingRequestBuild, pendingIntent);
        final AnonymousClass1 anonymousClass1 = new AnonymousClass1(context, list);
        taskAddGeofences.addOnSuccessListener(new OnSuccessListener() { // from class: f0.b
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GooglePlayLocationUtils.registerGeofencesWithGeofencingClient$lambda$7(anonymousClass1, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: f0.c
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GooglePlayLocationUtils.registerGeofencesWithGeofencingClient$lambda$8(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerGeofencesWithGeofencingClient$lambda$7(l tmp0, Object obj) {
        t.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerGeofencesWithGeofencingClient$lambda$8(Exception exc) {
        if (!(exc instanceof ApiException)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) exc, false, (a) GooglePlayLocationUtils$registerGeofencesWithGeofencingClient$2$6.INSTANCE, 4, (Object) null);
        }
        int statusCode = ((ApiException) exc).getStatusCode();
        if (statusCode == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) GooglePlayLocationUtils$registerGeofencesWithGeofencingClient$2$4.INSTANCE, 7, (Object) null);
            return;
        }
        switch (statusCode) {
            case 1000:
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new GooglePlayLocationUtils$registerGeofencesWithGeofencingClient$2$3(statusCode), 6, (Object) null);
                break;
            case 1001:
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new GooglePlayLocationUtils$registerGeofencesWithGeofencingClient$2$1(statusCode), 6, (Object) null);
                break;
            case 1002:
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new GooglePlayLocationUtils$registerGeofencesWithGeofencingClient$2$2(statusCode), 6, (Object) null);
                break;
            default:
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new GooglePlayLocationUtils$registerGeofencesWithGeofencingClient$2$5(statusCode), 6, (Object) null);
                break;
        }
    }

    public static final void registerGeofencesWithGooglePlayIfNecessary(@NotNull Context context, @NotNull List<BrazeGeofence> desiredGeofencesToRegister, @NotNull PendingIntent geofenceRequestIntent, @NotNull l<? super List<String>, k0> removalFunction, @NotNull l<? super List<BrazeGeofence>, k0> registerFunction) {
        t.i(context, "context");
        t.i(desiredGeofencesToRegister, "desiredGeofencesToRegister");
        t.i(geofenceRequestIntent, "geofenceRequestIntent");
        t.i(removalFunction, "removalFunction");
        t.i(registerFunction, "registerFunction");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        GooglePlayLocationUtils googlePlayLocationUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) googlePlayLocationUtils, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass3(desiredGeofencesToRegister), 6, (Object) null);
        try {
            List<BrazeGeofence> listRetrieveBrazeGeofencesFromLocalStorage = BrazeGeofenceManager.Companion.retrieveBrazeGeofencesFromLocalStorage(googlePlayLocationUtils.getRegisteredGeofenceSharedPrefs$android_sdk_location_release(context));
            List<BrazeGeofence> list = listRetrieveBrazeGeofencesFromLocalStorage;
            LinkedHashMap linkedHashMap = new LinkedHashMap(o.e(q0.d(w.v(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(((BrazeGeofence) obj).getId(), obj);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listRetrieveBrazeGeofencesFromLocalStorage.iterator();
            while (true) {
                boolean z10 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                BrazeGeofence brazeGeofence = (BrazeGeofence) next;
                List<BrazeGeofence> list2 = desiredGeofencesToRegister;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it2 = list2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (t.d(((BrazeGeofence) it2.next()).getId(), brazeGeofence.getId())) {
                                z10 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z10) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(w.v(arrayList, 10));
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                arrayList2.add(((BrazeGeofence) it3.next()).getId());
            }
            ArrayList arrayList3 = new ArrayList();
            for (BrazeGeofence brazeGeofence2 : desiredGeofencesToRegister) {
                BrazeGeofence brazeGeofence3 = (BrazeGeofence) linkedHashMap.get(brazeGeofence2.getId());
                if (brazeGeofence3 == null || !brazeGeofence2.equivalentServerData(brazeGeofence3)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass4(brazeGeofence2), 7, (Object) null);
                    arrayList3.add(brazeGeofence2);
                }
            }
            if (!arrayList2.isEmpty()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass5(arrayList2), 7, (Object) null);
                removalFunction.invoke(arrayList2);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass6.INSTANCE, 7, (Object) null);
            }
            if (!(!arrayList3.isEmpty())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass8.INSTANCE, 7, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass7(arrayList3), 7, (Object) null);
                registerFunction.invoke(arrayList3);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) AnonymousClass9.INSTANCE, 4, (Object) null);
        }
    }

    public static /* synthetic */ void registerGeofencesWithGooglePlayIfNecessary$default(Context context, List list, PendingIntent pendingIntent, l lVar, l lVar2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            lVar = new C10741(context);
        }
        if ((i10 & 16) != 0) {
            lVar2 = new AnonymousClass2(context, pendingIntent);
        }
        registerGeofencesWithGooglePlayIfNecessary(context, list, pendingIntent, lVar, lVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeGeofencesFromSharedPrefs(Context context, List<String> list) {
        SharedPreferences.Editor editorEdit = getRegisteredGeofenceSharedPrefs$android_sdk_location_release(context).edit();
        for (String str : list) {
            editorEdit.remove(str);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new C10751(str), 6, (Object) null);
        }
        editorEdit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeGeofencesRegisteredWithGeofencingClient$lambda$10(Exception exc) {
        if (!(exc instanceof ApiException)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) exc, false, (a) GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$2$6.INSTANCE, 4, (Object) null);
        }
        int statusCode = ((ApiException) exc).getStatusCode();
        if (statusCode == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$2$4.INSTANCE, 7, (Object) null);
            return;
        }
        switch (statusCode) {
            case 1000:
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$2$3(statusCode), 6, (Object) null);
                break;
            case 1001:
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$2$1(statusCode), 6, (Object) null);
                break;
            case 1002:
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$2$2(statusCode), 6, (Object) null);
                break;
            default:
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$2$5(statusCode), 6, (Object) null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeGeofencesRegisteredWithGeofencingClient$lambda$9(l tmp0, Object obj) {
        t.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @VisibleForTesting
    @NotNull
    public final SharedPreferences getRegisteredGeofenceSharedPrefs$android_sdk_location_release(@NotNull Context context) {
        t.i(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.support.geofences", 0);
        t.h(sharedPreferences, "context.getSharedPrefere…ON, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    @VisibleForTesting
    public final void removeGeofencesRegisteredWithGeofencingClient$android_sdk_location_release(@NotNull Context context, @NotNull List<String> obsoleteGeofenceIds) {
        t.i(context, "context");
        t.i(obsoleteGeofenceIds, "obsoleteGeofenceIds");
        Task<Void> taskRemoveGeofences = LocationServices.getGeofencingClient(context).removeGeofences(obsoleteGeofenceIds);
        final GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$1 googlePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$1 = new GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$1(context, obsoleteGeofenceIds);
        taskRemoveGeofences.addOnSuccessListener(new OnSuccessListener() { // from class: f0.d
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GooglePlayLocationUtils.removeGeofencesRegisteredWithGeofencingClient$lambda$9(googlePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$1, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: f0.e
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GooglePlayLocationUtils.removeGeofencesRegisteredWithGeofencingClient$lambda$10(exc);
            }
        });
    }

    @VisibleForTesting
    public final void storeGeofencesToSharedPrefs$android_sdk_location_release(@NotNull Context context, @NotNull List<BrazeGeofence> newGeofencesToRegister) {
        t.i(context, "context");
        t.i(newGeofencesToRegister, "newGeofencesToRegister");
        SharedPreferences.Editor editorEdit = getRegisteredGeofenceSharedPrefs$android_sdk_location_release(context).edit();
        for (BrazeGeofence brazeGeofence : newGeofencesToRegister) {
            editorEdit.putString(brazeGeofence.getId(), brazeGeofence.forJsonPut().toString());
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new GooglePlayLocationUtils$storeGeofencesToSharedPrefs$1(brazeGeofence), 6, (Object) null);
        }
        editorEdit.apply();
    }
}
